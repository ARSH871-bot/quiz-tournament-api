package com.quiztournament.quizapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(min = 3, max = 50)
    @Column(unique = true)
    private String username;

    @NotBlank
    @Size(max = 50)
    private String firstName;

    @NotBlank
    @Size(max = 50)
    private String lastName;

    @NotBlank
    @Email
    @Column(unique = true)
    private String email;

    @NotBlank
    @Size(min = 6)
    private String password;

    private String picture;

    // Additional attributes (add 3 of your choice)
    private String phoneNumber;
    private String city;
    private String occupation;

    @Enumerated(EnumType.STRING)
    private Role role = Role.PLAYER;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "reset_token")
    private String resetToken;

    @Column(name = "reset_token_expiry")
    private LocalDateTime resetTokenExpiry;

    @OneToMany(mappedBy = "player", cascade = CascadeType.ALL)
    private Set<QuizResult> quizResults = new HashSet<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private Set<TournamentLike> tournamentLikes = new HashSet<>();

    // Constructors, getters, setters
    public User() {}

    public User(String username, String firstName, String lastName, String email, String password, Role role) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    // Add all getters and setters here
}

enum Role {
    ADMIN, PLAYER
}