package edu.sliit.service;

import edu.sliit.dto.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    List<User> searchUserByEmail(String userEmail);

    List<User> getAllUsers();

    void updatePassword(String userEmail, String newPassword);
}
