package edu.sliit.service.impl;

import edu.sliit.dto.User;
import edu.sliit.entity.UserEntity;
import edu.sliit.repository.UserRepository;
import edu.sliit.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

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
    public User searchUserByEmail(String userEmail) {


        return mapper.map(repository.findByuserEmail(userEmail), User.class);


    }
}
