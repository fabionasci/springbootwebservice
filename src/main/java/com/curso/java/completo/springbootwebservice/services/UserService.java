package com.curso.java.completo.springbootwebservice.services;

import com.curso.java.completo.springbootwebservice.dtos.UserDto;
import com.curso.java.completo.springbootwebservice.entities.User;
import com.curso.java.completo.springbootwebservice.repositories.UserRepository;
import com.curso.java.completo.springbootwebservice.services.exceptions.DataBaseException;
import com.curso.java.completo.springbootwebservice.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    //@Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User create(UserDto userDto) {
        User user = new User(null, userDto.getName(), userDto.getEmail(), userDto.getPhone(), userDto.getPassword());
        return userRepository.save(user);
    }

    public void delete(Long id) {
       try {
           userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
           userRepository.deleteById(id);
       } catch (DataIntegrityViolationException e) {
           throw new DataBaseException(e.getMessage());
       }
    }

    public User update(Long id, UserDto userDto) {
        try {
            User entity = userRepository.getReferenceById(id);
            updateData(entity, userDto);
            return userRepository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, UserDto userDto) {
        entity.setName(userDto.getName());
        entity.setEmail(userDto.getEmail());
        entity.setPhone(userDto.getPhone());
    }
}
