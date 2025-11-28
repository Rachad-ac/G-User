package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    User create(User user);
    User update(User user);
    User get(Long id);
    List<User> getAll();
    void delete(Long id);
}
