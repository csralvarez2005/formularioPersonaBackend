package formularioPersonaBackend.exception;

public class PersonaNotFoundException extends RuntimeException{
    public PersonaNotFoundException(String mensaje) {
        super(mensaje);
    }
}
