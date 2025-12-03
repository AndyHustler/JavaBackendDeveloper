package backend.developer.progectjbd.service;

import java.util.List;
import java.util.Optional;

import backend.developer.progectjbd.domain.model.User;

public interface UserService {

    List<User> listUsers();

    Optional<User> findUser(Long id);

    User createUser(User user);

    void deleteUser(User user);

    User findByUserName(String username);
}
