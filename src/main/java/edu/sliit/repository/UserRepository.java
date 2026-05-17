package edu.sliit.repository;


import edu.sliit.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity,Integer>{

    List<UserEntity> findByuserEmail(String userEmail);

    @Modifying
    @Transactional
    @Query("UPDATE UserEntity u SET u.password = :newPassword WHERE u.userEmail = :userEmail")
    void updatePasswordByUserEmail(String userEmail, String newPassword);
}
