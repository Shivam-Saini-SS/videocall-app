package com.project.VideoCall.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
public class UserService {
    private static final List<User> USERS_LIST = new ArrayList<>();

    public void registerUser(User user) {
        user.setStatus("online");
        USERS_LIST.add(user);
    }

    public User loginUser(User user) {
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i -> USERS_LIST.get(i).getEmail().equals(user.getEmail()))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        var cUser = USERS_LIST.get(userIndex);

        if (!cUser.getPassword().equals(user.getPassword())) {
            throw new RuntimeException("Incorrect password!");
        }
        cUser.setStatus("online");
        return cUser;
    }

    public void logoutUser(String email) {
        var userIndex = IntStream.range(0, USERS_LIST.size())
                .filter(i -> USERS_LIST.get(i).getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("User not found"));

        USERS_LIST.get(userIndex).setStatus("offline");
    }

    public List<User> getAllUsers() {
        return USERS_LIST;
    }
}
