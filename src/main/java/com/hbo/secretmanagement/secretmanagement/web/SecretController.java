package com.hbo.secretmanagement.secretmanagement.web;

import com.hbo.secretmanagement.secretmanagement.dto.SecretDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SecretController {

    @Value("${secret.management.value}") private String secret;

    @ResponseBody
    @RequestMapping(value = "secret", method= RequestMethod.GET, produces = "application/json")
    public SecretDto secret() {
        return new SecretDto(secret);
    }
}
