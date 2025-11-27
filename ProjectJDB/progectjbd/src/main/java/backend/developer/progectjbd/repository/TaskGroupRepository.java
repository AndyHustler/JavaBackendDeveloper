package backend.developer.progectjbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.developer.progectjbd.model.TaskGroup;

@Repository
public interface TaskGroupRepository extends JpaRepository<TaskGroup, Long> {

}
