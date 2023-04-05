package com.zym;

import com.zym.domain.User;
import com.zym.http.domain.Result;
import org.springframework.stereotype.Component;

@Component
public class UserFallbackService implements UserService{
    @Override
    public Result<User> findById(Integer id) {
        return Result.success(User.builder().id(-1).age(0).name("default").build());
    }
}
