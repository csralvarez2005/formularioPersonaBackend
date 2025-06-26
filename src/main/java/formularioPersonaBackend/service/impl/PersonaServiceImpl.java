package formularioPersonaBackend.service.impl;

import formularioPersonaBackend.dto.PagedResponseDTO;
import formularioPersonaBackend.dto.PersonaRequestDTO;
import formularioPersonaBackend.dto.PersonaResponseDTO;
import formularioPersonaBackend.exception.DuplicateIdentificationException;
import formularioPersonaBackend.exception.PersonaNotFoundException;
import formularioPersonaBackend.model.Persona;
import formularioPersonaBackend.repository.PersonaRepository;
import formularioPersonaBackend.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonaServiceImpl implements PersonaService {
    private final PersonaRepository personaRepository;

    @Autowired
    public PersonaServiceImpl(PersonaRepository personaRepository) {
        this.personaRepository = personaRepository;
    }

    @Override
    public PersonaResponseDTO crear(PersonaRequestDTO dto) {
        if (personaRepository.findByIdentificacion(dto.getIdentificacion()).isPresent()) {
            throw new DuplicateIdentificationException("Identificación ya registrada.");
        }

        Persona persona = mapToEntity(dto);
        return mapToDTO(personaRepository.save(persona));
    }

    @Override
    public PersonaResponseDTO obtenerPorId(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada"));
        return mapToDTO(persona);
    }

    @Override
    public List<PersonaResponseDTO> listar() {
        return personaRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public PersonaResponseDTO actualizar(Long id, PersonaRequestDTO dto) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada"));

        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setEmail(dto.getEmail());
        persona.setFechaNacimiento(LocalDate.parse(dto.getFechaNacimiento()));
        persona.setIdentificacion(dto.getIdentificacion());
        persona.setTipoDocumento(dto.getTipoDocumento()); // 👈 nuevo campo

        return mapToDTO(personaRepository.save(persona));
    }

    @Override
    public void eliminar(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNotFoundException("Persona no encontrada"));
        personaRepository.delete(persona);
    }

    @Override
    public PagedResponseDTO<PersonaResponseDTO> listarPaginado(Pageable pageable) {
        Page<Persona> page = personaRepository.findAll(pageable);
        Page<PersonaResponseDTO> pageDTO = page.map(this::mapToDTO);
        return new PagedResponseDTO<>(pageDTO);
    }

    // Mapping helpers
    private PersonaResponseDTO mapToDTO(Persona persona) {
        PersonaResponseDTO dto = new PersonaResponseDTO();
        dto.setId(persona.getId());
        dto.setNombre(persona.getNombre());
        dto.setApellido(persona.getApellido());
        dto.setEmail(persona.getEmail());
        dto.setIdentificacion(persona.getIdentificacion());
        dto.setFechaNacimiento(persona.getFechaNacimiento().toString());
        dto.setTipoDocumento(persona.getTipoDocumento()); // 👈 nuevo campo
        return dto;
    }

    private Persona mapToEntity(PersonaRequestDTO dto) {
        Persona persona = new Persona();
        persona.setNombre(dto.getNombre());
        persona.setApellido(dto.getApellido());
        persona.setEmail(dto.getEmail());
        persona.setIdentificacion(dto.getIdentificacion());
        persona.setFechaNacimiento(LocalDate.parse(dto.getFechaNacimiento()));
        persona.setTipoDocumento(dto.getTipoDocumento()); // 👈 nuevo campo
        return persona;
    }
}
