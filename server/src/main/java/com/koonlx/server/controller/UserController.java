package com.koonlx.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.koonlx.server.dto.UserDto;
import com.koonlx.server.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

  @Autowired
  private UserService userService;

  @PostMapping("/signup")
  public ResponseEntity<String> signUp(@RequestBody UserDto userDto) {
    try {
      userService.signUp(userDto);
      return new ResponseEntity<>("User signed up successfully", HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity<>("Failed to sign up", HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}