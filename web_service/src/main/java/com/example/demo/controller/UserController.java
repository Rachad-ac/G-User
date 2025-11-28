package com.example.demo.controller;

import com.example.demo.model.Responses;
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
    public Responses create(@RequestBody User user) {
        try {
            User payload = userService.create(user);
            return new Responses(
                    "success",
                    "Utilisateur créé avec succès",
                    payload
            );
        } catch (Exception e) {

            System.err.println("Erreur : "+ e.getMessage());

            return new Responses(
                    "error",
                    "Erreur lors de la création de l'utilisateur",
                    null
            );
        }
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Responses update(@PathVariable("id") Long id, @RequestBody User user) {
        try {
            user.setId(id);
            User payload = userService.update(user);
            return new Responses(
                    "success",
                    "Utilisateur mis à jour avec succès",
                    payload
            );
        } catch (Exception e) {

            System.err.println("Erreur : "+ e.getMessage());

            return new Responses(
                    "error",
                    "Erreur lors de la mise à jour",
                    null
            );
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Responses get(@PathVariable Long id) {
        try {
            User payload = userService.get(id);
            return new Responses(
                    "success",
                    "Utilisateur récupéré avec succès",
                    payload
            );
        } catch (Exception e) {

            System.err.println("Erreur : "+ e.getMessage());

            return new Responses(
                    "error",
                    "Erreur lors de la récupération",
                    null
            );
        }
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public Responses getAll() {
        try {
            List<User> payload = userService.getAll();
            return new Responses(
                    "success",
                    payload.size() + " utilisateurs trouvés",
                    payload
            );
        } catch (Exception e) {

            System.err.println("Erreur : "+ e.getMessage());

            return new Responses(
                    "error",
                    "Erreur lors de la récupération de la liste",
                    null
            );
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Responses delete(@PathVariable("id") Long id) {
        try {
            userService.delete(id);
            return new Responses(
                    "success",
                    "Utilisateur supprimé avec succès",
                    null
            );
        } catch (Exception e) {

            System.err.println("Erreur : "+ e.getMessage());

            return new Responses(
                    "error",
                    "Erreur lors de la suppression",
                    null
            );
        }
    }
}
