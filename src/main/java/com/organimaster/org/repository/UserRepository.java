package com.organimaster.org.repository;

import com.organimaster.org.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "CALL sp_insert_user(:input_first_name, :input_last_name, :input_username, :input_password, :input_email)", nativeQuery = true)
    int registerUser(
            @Param("input_first_name") String firstName,
            @Param("input_last_name") String lastName,
            @Param("input_username") String username,
            @Param("input_password") String password,
            @Param("input_email") String email
    );
}
