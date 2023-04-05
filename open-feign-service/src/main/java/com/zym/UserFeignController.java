package com.zym;

import com.zym.domain.User;
import com.zym.http.domain.Result;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserFeignController {

    private final UserService userService;

    @GetMapping
    public Result<User> findById() {
        return userService.findById(1);
    }

}
