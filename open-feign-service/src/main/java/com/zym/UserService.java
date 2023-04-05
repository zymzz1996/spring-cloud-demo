package com.zym;

import com.zym.domain.User;
import com.zym.http.domain.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user-service", fallback = UserFallbackService.class)
public interface UserService {

    @GetMapping("/user/{id}")
    Result<User> findById(@PathVariable("id") Integer id);

}
