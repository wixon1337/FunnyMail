package hu.flowacademy.FunnyMail.Repositories;

import hu.flowacademy.FunnyMail.Models.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class UserRepository {
    public static List<User> list = new ArrayList<>();

    public User saveUser(User user) {
        user.setId(UUID.randomUUID());
        list.add(user);
        return user;
    }

    public User getUser(UUID id) {
        return list.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }

    public List<User> getList() {
        return list;
    }

    public User updateUser(User user) {
        for (User u: list) {
            if (u.getId().equals(user.getId())) {
                u.setName(user.getName());
                u.setUsername(user.getUsername());
                u.setPassword(user.getPassword());
                u.setBirthDate(user.getBirthDate());
                return u;
            }
        }
        return null;
    }

    public void deleteUser(UUID id) { // not used
        list.removeIf(u -> u.getId().equals(id));
    }
}
