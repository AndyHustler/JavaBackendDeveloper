package backend.developer.progectjbd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import backend.developer.progectjbd.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
