package backend.developer.progectjbd.service;

import java.util.List;
import java.util.Optional;

import backend.developer.progectjbd.model.TaskGroup;

public interface TaskGroupService {

    List<TaskGroup> listAll();

    List<TaskGroup> listAllByUserId();

    Optional<TaskGroup> findById();

    void save(TaskGroup taskGroup);

    void delete(TaskGroup taskGroup);
}
