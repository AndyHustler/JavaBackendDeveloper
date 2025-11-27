package backend.developer.progectjbd.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import backend.developer.progectjbd.model.User;
import backend.developer.progectjbd.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<User> listUsers() {
        return repository.findAll();
    }

    @Override
    public Optional<User> findUser(Long id) {
        return repository.findById(id);
    }

    @Override
    public User createUser(User user) {
        return repository.save(user);
    }

    @Override
    public void deleteUser(User user) {
        repository.delete(user);
    }

}
