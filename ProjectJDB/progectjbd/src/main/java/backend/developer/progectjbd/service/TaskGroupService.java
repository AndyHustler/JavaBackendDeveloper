package backend.developer.progectjbd.service;

import java.util.List;

import backend.developer.progectjbd.model.TaskGroup;

public interface TaskGroupService {

    List<TaskGroup> listAll();

    List<TaskGroup> listAllByUserId();

    void save(TaskGroup taskGroup);

    void delete(TaskGroup taskGroup);
}
