package service;

import  model.User;
import repository.UserRepository;
import model.exception.NotFoundException;
import repository.InMemoryUserRepository;

public class UserService {
    private UserRepository userRepository;
    static int counter = 0;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(String name) {
        return new User(counter++, name);
    }

    public UserRepository getUserRepository() {
        return userRepository;
    }

    public User findUserByName(String name, InMemoryUserRepository inMemoryUserRepository) throws NotFoundException {
        if (inMemoryUserRepository.getUserByName(name).isPresent()) {
            return inMemoryUserRepository.getUserByName(name).get();
        }
        throw new NotFoundException();
    }
}
