package com.app.twitterClone.controller;

import com.app.twitterClone.model.Tweet;
import com.app.twitterClone.model.User;
import com.app.twitterClone.model.dto.TweetDTO;
import com.app.twitterClone.repository.TweetRepository;
import com.app.twitterClone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    private  TweetRepository tweetRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/listar")
    public List<TweetDTO> listar(@RequestParam String username){

        return tweetRepository.listarTweets(username);
    }

    @GetMapping("/total")
    public List<Tweet> getAllTweets() {
        return tweetRepository.findAll(Sort.by(Sort.Direction.DESC, "fecha"));
    }

    @PostMapping("/guardar")
    public Tweet listar(@RequestBody Tweet tweet){
        return tweetRepository.save(tweet);
    }
}
