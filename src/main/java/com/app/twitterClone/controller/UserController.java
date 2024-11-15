package com.app.twitterClone.controller;

import com.app.twitterClone.model.User;
import com.app.twitterClone.model.dto.FollowRequest;
import com.app.twitterClone.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private FollowerService followerService;

    @GetMapping("/followers/count")
    public ResponseEntity<Long> getFollowerCount(@RequestParam String username) {
        long count = followerService.getFollowerCount(username);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/following/count")
    public ResponseEntity<Long> getFollowingCount(@RequestParam String username) {
        long count = followerService.getFollowingCount(username);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/{username}/followers")
    public ResponseEntity<List<User>> getFollowers(@PathVariable String username) {
        List<User> followers = followerService.getFollowers(username);
        return ResponseEntity.ok(followers);
    }

    @GetMapping("/{username}/following")
    public ResponseEntity<List<User>> getFollowing(@PathVariable String username) {
        List<User> following = followerService.getFollowing(username);
        return ResponseEntity.ok(following);
    }

    // Endpoint para seguir a un usuario
    @PostMapping("/follow")
    public ResponseEntity<String> followUser(@RequestBody FollowRequest request) {

        // Llamar al servicio para guardar la relación de seguimiento
        followerService.followUser(request.getFollowerUsername(), request.getFollowingUsername());

        return ResponseEntity.ok(request.getFollowerUsername() + " is now following " + request.getFollowingUsername());
    }
}
