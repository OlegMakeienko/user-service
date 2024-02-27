package com.makeienko.userservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "user_favorite_routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserFavoriteRoute {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "route_id")
    private Long routeId;
}
