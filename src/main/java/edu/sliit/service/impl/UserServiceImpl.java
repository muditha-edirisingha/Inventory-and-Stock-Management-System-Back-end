package edu.sliit.service.impl;

import edu.sliit.dto.Product;
import edu.sliit.dto.User;
import edu.sliit.entity.UserEntity;
import edu.sliit.repository.UserRepository;
import edu.sliit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;

import java.util.ArrayList;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    final ModelMapper mapper;
    final UserRepository repository;
    @Override
    public void addUser(User user) {
        repository.save(mapper.map(user, UserEntity.class));
    }

    @Override
    public List<User> searchUserByEmail(String userEmail) {
        List<User> userList = new ArrayList<>();
        repository.findByuserEmail(userEmail).forEach(user -> {
            userList.add(mapper.map(user, User.class));
        });
        return userList;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(user->{
            users.add(mapper.map(user, User.class));

        });
        return users;
    }

    @Override
    public void updatePassword(String userEmail, String newPassword) {
        List<UserEntity> users = repository.findByuserEmail(userEmail);
        if (!users.isEmpty()) {
            repository.updatePasswordByUserEmail(userEmail, newPassword);
        }
    }

}
