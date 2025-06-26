package formularioPersonaBackend.dto;

import formularioPersonaBackend.model.Persona;

public class PersonaResponseDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private String tipoDocumento;
    private String identificacion;
    private String email;
    private String fechaNacimiento;

    public PersonaResponseDTO() {
    }

    public PersonaResponseDTO(Long id, String nombre, String apellido, String tipoDocumento, String identificacion, String email, String fechaNacimiento) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoDocumento = tipoDocumento;
        this.identificacion = identificacion;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
    }

    public PersonaResponseDTO(Persona persona) {
        this.id = persona.getId();
        this.nombre = persona.getNombre();
        this.apellido = persona.getApellido();
        this.tipoDocumento = persona.getTipoDocumento();
        this.identificacion = persona.getIdentificacion();
        this.email = persona.getEmail();
        this.fechaNacimiento = persona.getFechaNacimiento().toString();
    }

    // Getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
}
