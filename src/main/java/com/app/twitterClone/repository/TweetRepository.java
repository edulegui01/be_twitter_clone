package com.app.twitterClone.repository;

import com.app.twitterClone.model.Tweet;
import com.app.twitterClone.model.dto.TweetDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

    @Query("SELECT new com.app.twitterClone.model.dto.TweetDTO(t.id,t.tweet, t.userId)" +
            "FROM Tweet t WHERE t.userId = :username ORDER BY t.fecha DESC")
    List<TweetDTO> listarTweets(@Param("username") String username);
}
