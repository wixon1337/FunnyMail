package hu.flowacademy.FunnyMail.Services;

import hu.flowacademy.FunnyMail.Exceptions.ValidationException;
import hu.flowacademy.FunnyMail.Models.User;
import hu.flowacademy.FunnyMail.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveUser(User user) {
        if (user.getId() != null) {
            throw new ValidationException("ID will be generated! (has to be null)");
        }
        checkIfDataMissing(user);
        return userRepository.saveUser(user);
    }

    public User getUser(UUID id) {
        if (isDeleted(userRepository.getUser(id))) {
            throw new ValidationException("Already deleted!");
        }
        return userRepository.getUser(id);
    }

    public List<User> getUsers() {
        return userRepository.getList().stream().filter(u -> !isDeleted(u)).collect(Collectors.toList());
    }

    public User updateUser(User user) {
        checkIfDataMissing(user);
        for (User u: userRepository.getList()) {
            if (u.getId().equals(user.getId())) {
                if (isDeleted(u)) throw new ValidationException("Already deleted");
            }
        }
        return userRepository.updateUser(user);
    }

    public void deleteUser(UUID id) {
        userRepository.getUser(id).setDeletedAt(LocalDate.now());
    }

    private void checkIfDataMissing(User user) {
        if (user.getName() == null || user.getBirthDate() == null || user.getUsername() == null || user.getPassword() == null || user.getName().equals("") || user.getUsername().equals("") || user.getPassword().equals("")) {
            throw new ValidationException("Missing data.");
        }
    }

    private boolean isDeleted(User user) {
        return user.getDeletedAt() != null;
    }
}
