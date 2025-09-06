# Sistema de Gestión Académica - Base (Spring Boot + PostgreSQL)

Proyecto listo para abrir en VS Code / IntelliJ / STS.

## Requisitos
- Java 17
- Maven 3.9+
- PostgreSQL 13+
- (Opcional) Extensiones de VS Code: Extension Pack for Java, Spring Boot Extension Pack

## Cómo ejecutar
1. Ajusta `src/main/resources/application.properties` con tu usuario/clave/URL de PostgreSQL.
2. Crea la base de datos `academica` en PostgreSQL (o cambia el nombre en la URL).
3. Ejecuta:
   ```bash
   mvn spring-boot:run
   ```
4. Prueba el healthcheck: `GET http://localhost:8080/ping` (debe responder `ok`).

## Estructura
- `model/` Entidades JPA: `Profesor`, `Curso`, `Estudiante`, `Inscripcion`.
- `repository/` Repositorios JPA.
- `controller/HealthController` endpoint simple `/ping`.

> Listo para continuar con la **API de Reportes** (DTOs de proyección + @Query + endpoints).
