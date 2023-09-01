package com.example.sparta.controller;

import com.example.sparta.dto.UserRequestDto;
import com.example.sparta.dto.UserResponseDto;
import com.example.sparta.entity.User;
import com.example.sparta.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor


public class UserController {

    private final UserService userService;

    @PostMapping("/user")
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto){
        return userService.createUser(requestDto);
    }

    /**
     * 한 회원의 userId가 주었을때 회원 정보를 조회하는 API
     * //@param id
     */
    @GetMapping("/user/{id}")
    public User getUserInfo(@PathVariable Long id) {
        return userService.findUser(id);
    }

    /**
     * 회원의 전체 목록을 조회하는 API
     */
    @GetMapping("/user")
    public List<UserResponseDto> getUserList() {
       return userService.findAllUser();
    }

}