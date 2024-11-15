package com.app.twitterClone.model;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tweets")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Tweet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 280)
    private String tweet;
    @Column(name = "user_id")
    private String userId;

    @Column(nullable = false)
    private LocalDateTime fecha = LocalDateTime.now();;

    // Relación muchos a uno con User
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false, insertable=false, updatable=false)
    private User users;


}