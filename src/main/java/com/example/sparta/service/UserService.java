package com.example.sparta.service;

import com.example.sparta.dto.UserRequestDto;
import com.example.sparta.dto.UserResponseDto;
import com.example.sparta.entity.User;
import com.example.sparta.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User(requestDto);

        User saveUser = userRepository.save(user);
        UserResponseDto userResponseDto = new UserResponseDto(user);
        return userResponseDto;

    }

    // id 로 찾기
    public User findUser(Long id) {
        return userRepository.findById(id).orElseThrow(() ->
                new NullPointerException("없음"));

    }

    // 모두 찾기
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll().stream().map(UserResponseDto::new).toList();
    }


}


