package formularioPersonaBackend.exception;

public class DuplicateIdentificationException extends RuntimeException{

    public DuplicateIdentificationException(String mensaje) {
        super(mensaje);
    }
}
