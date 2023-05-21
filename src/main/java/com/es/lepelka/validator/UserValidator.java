package com.es.lepelka.validator;

import com.es.lepelka.model.User;
import com.es.lepelka.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class UserValidator implements Validator {
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(User.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        Optional<User> userOptional = userRepository.findById(user.getPersonnelNumber());
        if (userOptional.isPresent()) {
            errors.rejectValue("personnelNumber", "", "Пользователь уже существует");
        }
    }
}
