package com.main.Usermain.Repo;

import com.main.Usermain.Entity.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepo extends JpaRepository<User, Long> {

    public List<User> findAll();

    public  User findById(long id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_db.user (user_id, user_name, user_email, user_mobno, user_address) " +
            "VALUES (:userId, :userName, :userEmail, :userMobno, :userAddress)", nativeQuery = true)
    void createUser(@Param("userId") String userId,
                    @Param("userName") String userName,
                    @Param("userEmail") String userEmail,
                    @Param("userMobno") String userMobno,
                    @Param("userAddress") String userAddress);
}
