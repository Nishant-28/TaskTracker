package bio.nishant.tasks.controller;

import bio.nishant.tasks.domain.entities.TaskList;
import bio.nishant.tasks.domain.entities.dto.TaskListDto;
import bio.nishant.tasks.mappers.TaskListMapper;
import bio.nishant.tasks.services.TaskListService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/task-lists")
public class TaskListController {

    private final TaskListService taskListService;
    private final TaskListMapper taskListMapper;

    public TaskListController(TaskListService taskListService, TaskListMapper taskListMapper) {
        this.taskListService = taskListService;
        this.taskListMapper = taskListMapper;
    }

    @GetMapping
    public List<TaskListDto> listTaskLists() {
        return taskListService.listTaskLists()
                .stream()
                .map(taskList -> taskListMapper.toDto(taskList))
                .toList();

//        List<TaskList> taskLists = taskListService.listTaskLists();
//        List<TaskListDto> dtos = new ArrayList<>();
//        for (int i = 0; i < taskLists.size(); i++) {
//            TaskList taskList = taskLists.get(i);
//            dtos.add(taskListMapper.toDto(taskList));
//        }
//        return dtos;

    }

    @PostMapping
    public TaskListDto createTaskList(@RequestBody TaskListDto taskListDto) {
        TaskList createdTaskList = taskListService.createTaskList(
                taskListMapper.fromDto(taskListDto)
        );
        return taskListMapper.toDto(createdTaskList);
    }

    @GetMapping(path = "/{task_list_id}")
    public Optional<TaskListDto> getTaskList(@PathVariable("task_list_id") UUID task_list_id) {
        return taskListService.getTaskList(task_list_id)
                .map(taskListMapper::toDto);
    }

    @PutMapping(path = "/{task_list_id}")
    public TaskListDto updateTaskList(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskListDto taskListDto
    ) {
        TaskList updatedTaskList = taskListService.updateTaskList(taskListId, taskListMapper.fromDto(taskListDto));
        return taskListMapper.toDto(updatedTaskList);
    }

    @DeleteMapping(path = "/{task_list_id}")
    public void deleteTaskList(@PathVariable("task_list_id") UUID taskListId)  {
        taskListService.deleteTaskList(taskListId);
    }

}
