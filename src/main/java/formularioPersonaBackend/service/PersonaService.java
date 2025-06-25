package formularioPersonaBackend.service;

import formularioPersonaBackend.dto.PagedResponseDTO;
import formularioPersonaBackend.dto.PersonaRequestDTO;
import formularioPersonaBackend.dto.PersonaResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PersonaService {
    PersonaResponseDTO crear(PersonaRequestDTO dto);
    PersonaResponseDTO obtenerPorId(Long id);
    List<PersonaResponseDTO> listar();
    PersonaResponseDTO actualizar(Long id, PersonaRequestDTO dto);
    void eliminar(Long id);
    PagedResponseDTO<PersonaResponseDTO> listarPaginado(Pageable pageable);
}

