package backend.developer.progectjbd.service;

import java.util.List;

import backend.developer.progectjbd.model.Task;

public interface TaskService {

    List<Task> listAll();

    List<Task> listAllByUserId();

    List<Task> listAllByGroupId();

    void save(Task task);

    void delete(Task task);
}
