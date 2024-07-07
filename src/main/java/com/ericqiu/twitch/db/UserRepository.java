package com.ericqiu.twitch.db;

import com.ericqiu.twitch.db.entity.UserEntity;
import java.util.List;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

public interface UserRepository extends ListCrudRepository<UserEntity, Long> { //Note: the Long type identifies whatever type the primary key is

    List<UserEntity> findByLastName(String lastName);

    List<UserEntity> findByFirstName(String firstName);

    UserEntity findByUsername(String username);

    @Modifying
    @Query("UPDATE users SET first_name = :firstName, last_name = :lastName WHERE username = :username")
    void updateNameByUsername(String username, String firstName, String lastName);
}
