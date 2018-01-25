package me.srikavin.chatauth.service;

import me.srikavin.chatauth.dao.RegistrationRepository;
import me.srikavin.chatauth.dao.UserRepository;
import me.srikavin.chatauth.domain.RegistrationAttempt;
import me.srikavin.chatauth.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;

import javax.validation.Valid;
import javax.validation.Validation;
import java.util.Optional;


@Service
@Validated
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationRepository registrationRepository;

    private Validator validator = new SpringValidatorAdapter(Validation.buildDefaultValidatorFactory().getValidator());

    public Optional<User> register(@Valid RegistrationAttempt registrationAttempt) {
        Errors errors = new BindException(registrationAttempt, "registrationAttempt");
        validator.validate(registrationAttempt, errors);
        registrationRepository.save(registrationAttempt);
        return Optional.empty();
    }
}
