package ua.com.novykov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import twitter4j.TwitterException;
import ua.com.novykov.model.Tweets;
import ua.com.novykov.service.TweetService;

import java.util.List;
import java.util.Map;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final TweetService tweetService;

    @GetMapping("/")
    public String main(Map<String, Object> model) {
        List<Tweets> tweetsList = tweetService.getAllTweets();
        model.put("tweets", tweetsList);
        return "main";
    }
    @PostMapping("/main")
    public String search() throws TwitterException {
        tweetService.saveTweets();
        return "main";
    }
}