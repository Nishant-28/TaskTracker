package bio.nishant.tasks.mappers;

import bio.nishant.tasks.domain.entities.TaskList;
import bio.nishant.tasks.domain.entities.dto.TaskListDto;

public interface TaskListMapper {
    TaskList fromDto(TaskListDto taskListDto);
    TaskListDto toDto(TaskList taskList);
}
