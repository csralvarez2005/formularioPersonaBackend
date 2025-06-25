package formularioPersonaBackend.controller;

import formularioPersonaBackend.dto.PagedResponseDTO;
import formularioPersonaBackend.dto.PersonaRequestDTO;
import formularioPersonaBackend.dto.PersonaResponseDTO;
import formularioPersonaBackend.service.PersonaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    @Autowired
    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @PostMapping("/batch")
    public List<PersonaResponseDTO> crearMultiples(@RequestBody List<@Valid PersonaRequestDTO> dtos) {
        return dtos.stream()
                .map(personaService::crear)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public PersonaResponseDTO obtener(@PathVariable Long id) {
        return personaService.obtenerPorId(id);
    }

    @GetMapping
    public List<PersonaResponseDTO> listar() {
        return personaService.listar();
    }

    @PutMapping("/{id}")
    public PersonaResponseDTO actualizar(@PathVariable Long id, @Valid @RequestBody PersonaRequestDTO dto) {
        return personaService.actualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        personaService.eliminar(id);
    }

    @GetMapping("/paginado")
    public PagedResponseDTO<PersonaResponseDTO> listarPaginado(Pageable pageable) {
        return personaService.listarPaginado(pageable);
    }
}
