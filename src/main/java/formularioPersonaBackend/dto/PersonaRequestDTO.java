package formularioPersonaBackend.dto;

import jakarta.validation.constraints.NotBlank;

public class PersonaRequestDTO {

    @NotBlank
    private String nombre;

    @NotBlank
    private String apellido;

    @NotBlank
    private String tipoDocumento;

    @NotBlank
    private String identificacion;

    private String email;

    private String fechaNacimiento;

    // Getters y Setters

    public @NotBlank String getNombre() {
        return nombre;
    }

    public void setNombre(@NotBlank String nombre) {
        this.nombre = nombre;
    }

    public @NotBlank String getApellido() {
        return apellido;
    }

    public void setApellido(@NotBlank String apellido) {
        this.apellido = apellido;
    }

    public @NotBlank String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(@NotBlank String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public @NotBlank String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(@NotBlank String identificacion) {
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