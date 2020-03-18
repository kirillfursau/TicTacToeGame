package repository;

import model.User;

import java.util.Optional;

public interface UserRepository {
    User saveUser(User user);

    Optional<User> getUserByName(String name);
}
