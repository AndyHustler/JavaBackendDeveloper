package backend.developer.progectjbd.service;

import java.util.List;
import java.util.Optional;

import backend.developer.progectjbd.domain.model.Task;

public interface TaskService {

    List<Task> listAll();

    List<Task> listAllByUserId();

    List<Task> listAllByGroupId();

    Optional<Task> findById(Long id);

    Task save(Task task);

    void delete(Task task);
}
