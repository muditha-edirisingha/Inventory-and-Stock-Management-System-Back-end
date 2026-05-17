package edu.sliit.service;

import edu.sliit.dto.User;

public interface UserService {
    void addUser(User user);

    User searchUserByEmail(String userEmail);
}
