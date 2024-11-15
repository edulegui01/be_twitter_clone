package com.app.twitterClone.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "followers")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Follower {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "follower_username", referencedColumnName = "username", nullable = false)
    private User follower;

    @ManyToOne
    @JoinColumn(name = "following_username", referencedColumnName = "username", nullable = false)
    private User following;

    public Follower(User follower, User following) {
        this.follower = follower;
        this.following = following;
    }




}

