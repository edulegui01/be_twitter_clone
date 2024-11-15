package com.app.twitterClone.repository;

import com.app.twitterClone.model.Follower;
import com.app.twitterClone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FollowerRepository extends JpaRepository<Follower, Long> {

    // 1. Obtener la cantidad de seguidores de un usuario
    @Query("SELECT COUNT(f) FROM Follower f WHERE f.following.username = :username")
    long getFollowerCount(@Param("username") String username);

    // 2. Obtener la cantidad de seguidos de un usuario
    @Query("SELECT COUNT(f) FROM Follower f WHERE f.follower.username = :username")
    long getFollowingCount(@Param("username") String username);

    // 3. Obtener la lista de seguidores de un usuario
    @Query("SELECT f.follower FROM Follower f WHERE f.following.username = :username")
    List<User> getFollowers(@Param("username") String username);

    // 4. Obtener la lista de usuarios que un usuario sigue
    @Query("SELECT f.following FROM Follower f WHERE f.follower.username = :username")
    List<User> getFollowing(@Param("username") String username);
}

