package com.app.twitterClone.service;

import com.app.twitterClone.model.Follower;
import com.app.twitterClone.model.User;
import com.app.twitterClone.repository.FollowerRepository;
import com.app.twitterClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FollowerService {

    @Autowired
    private FollowerRepository followerRepository;

    @Autowired
    private UserRepository userRepository;

    public long getFollowerCount(String username) {
        return followerRepository.getFollowerCount(username);
    }

    public long getFollowingCount(String username) {
        return followerRepository.getFollowingCount(username);
    }

    public List<User> getFollowers(String username) {
        return followerRepository.getFollowers(username);
    }

    public List<User> getFollowing(String username) {
        return followerRepository.getFollowing(username);
    }

    public Follower followUser(String followerUsername, String followingUsername) {
        // Buscar el usuario que sigue (follower) y el usuario que es seguido (following)
        User follower = userRepository.findById(followerUsername)
                .orElseThrow(() -> new RuntimeException("Follower not found"));
        User following = userRepository.findById(followingUsername)
                .orElseThrow(() -> new RuntimeException("User to follow not found"));

        // Crear la relación de seguimiento
        Follower followerEntity = new Follower(follower, following);

        // Guardar la relación en la base de datos
        return followerRepository.save(followerEntity);
    }
}
