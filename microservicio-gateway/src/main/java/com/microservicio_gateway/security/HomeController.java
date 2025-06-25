package com.microservicio_gateway.security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/inicio")
    public String index() {
        return "index"; // página pública
    }

    @GetMapping("/user")
    @ResponseBody
    public String user(@AuthenticationPrincipal OAuth2User principal) {
        return "Hola, " + principal.getAttribute("name");
    }
}
