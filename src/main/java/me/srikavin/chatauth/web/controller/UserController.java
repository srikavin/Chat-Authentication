package me.srikavin.chatauth.web.controller;

import me.srikavin.chatauth.dao.UserRepository;
import me.srikavin.chatauth.domain.RegistrationAttempt;
import me.srikavin.chatauth.domain.User;
import me.srikavin.chatauth.service.UserService;
import me.srikavin.chatauth.web.dto.RegistrationDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/register", consumes = "application/json", method = RequestMethod.POST)
    public User register(@RequestBody RegistrationDTO registrationDTO) {
        RegistrationAttempt attempt = modelMapper.map(registrationDTO, RegistrationAttempt.class);
        userService.register(attempt);
        return userService.register(attempt).orElse(null);
    }

    @GetMapping("/users")
    public Iterable<User> users() {
        return userRepository.findAll();
    }
}
