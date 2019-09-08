package com.camwang.unifound.controller;

import com.camwang.unifound.entity.User;
import com.camwang.unifound.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    MongoTemplate mongoTemplate;
    @Autowired
    UserRepository userRepository;

    @RequestMapping(value = "/user/{username}", method = RequestMethod.GET)
    public User getUser(
            @PathVariable(value = "username") String username
    ) {
        User user = null;
        user = userRepository.findFirstByUsername(username);
        if(user == null) {
            throw new RuntimeException("用户未找到");
        }
        return user;
    }

    @RequestMapping(value = "/session", method = RequestMethod.POST)
    public ResponseEntity login(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password
    ) {
        User user = null;
        user = userRepository.findFirstByUsernameAndPassword(username, password);
        if(user == null) {
            return new ResponseEntity(HttpStatus.FORBIDDEN);
        }
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity register(
            @RequestParam(value = "username") String username,
            @RequestParam(value = "password") String password,
            @RequestParam(value = "nick") String nick,
            @RequestParam(value = "school") String school,
            @RequestParam(value = "wechat")
    )
}
