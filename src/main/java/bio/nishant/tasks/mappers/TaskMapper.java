package bio.nishant.tasks.mappers;

import bio.nishant.tasks.domain.entities.Task;
import bio.nishant.tasks.domain.entities.dto.TaskDto;

public interface TaskMapper {
    Task fromDto(TaskDto taskDto);
    TaskDto toDto(Task task);
}
