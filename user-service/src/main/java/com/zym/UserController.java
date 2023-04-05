package com.zym;

import com.zym.domain.User;
import com.zym.http.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/{id}")
    public Result<User> findById(@PathVariable("id") Integer id) {
        log.info("请求到达");
        return Result.success(User.builder().id(id).name("zym").age(27).build());
    }

    @GetMapping("/getByUsername")
    public Result<User> getUserByName(@RequestParam String name) {
        log.info("请求到达");
        return Result.success(User.builder().id(2).name(name).age(88).build());
    }

}
