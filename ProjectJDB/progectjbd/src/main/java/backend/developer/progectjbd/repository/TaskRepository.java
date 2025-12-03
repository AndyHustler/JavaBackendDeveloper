package backend.developer.progectjbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.developer.progectjbd.domain.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
