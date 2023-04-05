package com.zym;

import com.zym.domain.User;
import com.zym.http.domain.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserLoadBalancerController {

    private final RestTemplate restTemplate;

    @Value("${service-url.user-service}")
    private String userServiceUrl;

    public UserLoadBalancerController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("")
    @SuppressWarnings("unchecked")
    public Result<User> findById() {
        return restTemplate.getForObject(userServiceUrl + "/user/1", Result.class);
    }

}
