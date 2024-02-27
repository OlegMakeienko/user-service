package com.makeienko.userservice.service;

import com.makeienko.userservice.dto.CommunalTransportDto;
import com.makeienko.userservice.model.User;
import com.makeienko.userservice.model.UserFavoriteRoute;
import com.makeienko.userservice.repository.UserFavoriteRouteRepository;
import com.makeienko.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserFavoriteRouteRepository userFavoriteRouteRepository;

    public boolean login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return true;
        } else return false;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addFavoriteRoute(Long userId, CommunalTransportDto route) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));

        boolean exists = userFavoriteRouteRepository.existsByUserIdAndRouteId(userId, route.getId());
        if (exists) {
            throw new RuntimeException("Route with id: " + route.getId() + " is already a favorite");
        }

        UserFavoriteRoute userFavoriteRoute = new UserFavoriteRoute();
        userFavoriteRoute.setUser(user);
        userFavoriteRoute.setRouteId(route.getId());

        userFavoriteRouteRepository.save(userFavoriteRoute);
    }
}

