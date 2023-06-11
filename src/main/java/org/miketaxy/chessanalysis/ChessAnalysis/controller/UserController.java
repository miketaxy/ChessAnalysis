package org.miketaxy.chessanalysis.ChessAnalysis.controller;

import org.miketaxy.chessanalysis.ChessAnalysis.entity.User;
import org.miketaxy.chessanalysis.ChessAnalysis.services.mapper.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController{
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();

    }
}
