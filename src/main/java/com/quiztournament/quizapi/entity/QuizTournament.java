package com.quiztournament.quizapi.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "quiz_tournaments")
public class QuizTournament {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String category;

    @NotBlank
    private String difficulty;

    @NotNull
    private LocalDateTime startDate;

    @NotNull
    private LocalDateTime endDate;

    @NotNull
    private Integer minimumPassingScore;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private Set<QuizResult> quizResults = new HashSet<>();

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.ALL)
    private Set<TournamentLike> tournamentLikes = new HashSet<>();

    // Constructors, getters, setters
}