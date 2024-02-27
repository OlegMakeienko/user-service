package com.makeienko.userservice.repository;

import com.makeienko.userservice.model.UserFavoriteRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserFavoriteRouteRepository extends JpaRepository<UserFavoriteRoute, Long> {
    boolean existsByUserIdAndRouteId(Long userId, Long id);
}
