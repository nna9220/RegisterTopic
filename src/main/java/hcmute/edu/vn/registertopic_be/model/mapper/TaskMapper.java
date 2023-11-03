package hcmute.edu.vn.registertopic_be.model.mapper;

import hcmute.edu.vn.registertopic_be.model.entity.Task;
import hcmute.edu.vn.registertopic_be.model.request.TaskRequest;
import hcmute.edu.vn.registertopic_be.model.response.TaskResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    @Mapping(source = "task.taskId", target = "taskId")
    @Mapping(source = "task.requirement", target = "requirement")
    @Mapping(source = "task.timeStart", target = "timeStart")
    @Mapping(source = "task.timeEnd", target = "timeEnd")
    TaskResponse toResponse(Task task);

    List<TaskResponse> toTaskListDTO(List<Task> tasks);

    Task toEntity(TaskRequest taskRequest);
}
