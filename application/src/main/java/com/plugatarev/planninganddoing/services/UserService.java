package com.plugatarev.planninganddoing.services;

import com.plugatarev.planninganddoing.entity.User;
import com.plugatarev.planninganddoing.models.UserDTO;
import com.plugatarev.planninganddoing.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void add(UserDTO dto) {
        User entity = new User();
        entity.setUsername(dto.getUsername());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setId(dto.getId());
        userRepository.save(entity);
    }

    public void delete(long id) {
        userRepository.deleteById(id);
    }

    public void update(UserDTO dto) {
        User entity = new User();
        entity.setUsername(dto.getUsername());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setId(dto.getId());
        userRepository.save(entity);
    }

    public Optional<User> getById(long id) {
        return userRepository.findById(id);
    }
}
