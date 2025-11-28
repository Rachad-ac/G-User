package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin("*")
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User user) {
        try {
            return userService.create(user);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la création de user : " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User update(@PathVariable("id") Long id, @RequestBody User user) {
        user.setId(id);
        try {
            return userService.update(user);
        }catch (Exception e){
            throw new RuntimeException("Erreur lors de la mise a jour de user : " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User get(@PathVariable Long id){
        try {
           return userService.get(id);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la recuperation de user" + e.getMessage());
        }
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getAll(User user){
        try {
            return userService.getAll(user);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la recuperation des users" + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id){
        try {
            userService.delete(id);
        } catch (Exception e) {
            throw new RuntimeException("Erreur lors de la recuperation de user" + e.getMessage());
        }
    }

}
