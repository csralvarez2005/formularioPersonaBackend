package formularioPersonaBackend.config;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Component;

@Component
public class MigracionService {

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void ejecutarAlter() {
        try {
            entityManager.createNativeQuery("ALTER TABLE personas ADD COLUMN tipo_documento VARCHAR(255) DEFAULT 'CC' NOT NULL;")
                    .executeUpdate();
            System.out.println("✅ Columna tipo_documento agregada exitosamente.");
        } catch (Exception e) {
            System.out.println("⚠️ La columna tipo_documento ya existe o hubo un error: " + e.getMessage());
        }
    }
}
