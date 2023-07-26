package com.organimaster.org.services;

import com.organimaster.org.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public int registerUser(
            String firstName,
            String lastName,
            String userName,
            String userPass,
            String emailAdd
    ) {
        return userRepository.registerUser(
                firstName,
                lastName,
                userName,
                userPass,
                emailAdd
        );
    }
}
