package com.quiztournament.quizapi.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "quiz_results")
public class QuizResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private User player;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private QuizTournament tournament;

    private Integer score;
    private Integer totalQuestions = 10;

    @Column(name = "completed_at")
    private LocalDateTime completedAt = LocalDateTime.now();

    // Constructors, getters, setters
}