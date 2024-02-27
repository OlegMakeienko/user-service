package com.makeienko.userservice.controller;

import com.makeienko.userservice.dto.CommunalTransportDto;
import com.makeienko.userservice.model.TransportServiceClient;
import com.makeienko.userservice.model.User;
import com.makeienko.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TransportServiceClient transportServiceClient;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/show-users")
    public ResponseEntity<List<User>> showAllUsers() {
        List<User> users = userService.getAllUsers();
        if(users != null && !users.isEmpty()) {
            return ResponseEntity.ok(users);
        } else return ResponseEntity.noContent().build();
    }

    @PostMapping("/{userId}/favorite-routes/{routeId}")
    public ResponseEntity<?> addFavoriteRoute(@PathVariable Long userId, @PathVariable Long routeId) {
        CommunalTransportDto route = transportServiceClient.getRoute(routeId);
        if (route == null) {
            return ResponseEntity.notFound().build();
        }

        userService.addFavoriteRoute(userId, route);

        return ResponseEntity.ok("Route added to favorite routes");
    }
}

