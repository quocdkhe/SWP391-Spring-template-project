package com.example.swp391.service.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.swp391.domain.User;
import com.example.swp391.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

@Service
public class UserValidator implements ConstraintValidator<ValidUser, User> {

    private UserService userService;

    public UserValidator(){}

    @Autowired
    public UserValidator(UserService userService){
        this.userService = userService;
    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        boolean valid = true;
        // Kiểm tra username đó đã tồn tại hay chưa
        if (userService != null && userService.checkExistedUsername(user.getUsername())) {
            // Hiển thị thông báo lỗi phía View
            context.buildConstraintViolationWithTemplate("Username existed")
                    // Chỉ định trường nào bị lỗi ?
                    .addPropertyNode("username")
                    .addConstraintViolation()
                    .disableDefaultConstraintViolation();
            valid = false;
        }

        // Additional validations can be added here

        return valid;
    }

}
