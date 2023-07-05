package uz.mohirdev.lesson.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.mohirdev.lesson.entity.User;
import uz.mohirdev.lesson.service.UserService;

@RestController
@RequestMapping("/api")
public class UserResource {
    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity create(@RequestBody User user) {
        if (userService.existsByLogin(user.getLogin())) {
            return new ResponseEntity("Bu login mavjud", HttpStatus.BAD_REQUEST);
        }
        if (checkPasswordLenght(user.getPassword())){
            return new ResponseEntity("Password uzunligi 4 dan kam", HttpStatus.BAD_REQUEST);
        }
        User result = userService.save(user);
        return ResponseEntity.ok(result);
    }
    private Boolean checkPasswordLenght(String password){
        return password.length() <= 4;
    }
}
