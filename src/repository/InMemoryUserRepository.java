package repository;

import model.User;

import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {
    private static List<User> users;
    static int countId;

    public List<User> addUserToList(User user) {
        users.add(user);
        return users;
    }

    public List<User> getUsers() {
        return users;
    }

    @Override
    public User saveUser(User user) {
        user.setId(countId);
        countId++;
        return user;
    }

    @Override
    public Optional<User> getUserByName(String name) {
        Optional<User> findUserByName = users.stream()
                .filter(user -> user.getName() == name)
                .findAny();
        if (findUserByName == null) {
            return Optional.empty();
        }
        return findUserByName;
    }
}
