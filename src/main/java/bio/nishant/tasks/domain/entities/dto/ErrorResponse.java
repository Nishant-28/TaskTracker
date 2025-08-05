package bio.nishant.tasks.domain.entities.dto;

public record ErrorResponse(
        int status,
        String message,
        String details
) {
}
