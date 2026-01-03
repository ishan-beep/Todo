package com.ishan.todo.controller;

import com.ishan.todo.service.LoginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class LoginController {

    private final LoginService loginService ;
    public LoginController(LoginService loginService) {this.loginService=loginService;}

    @RequestMapping("/")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            RedirectAttributes redirectAttributes
    ) {
        boolean authenticated = loginService.authenticate(username,password);

        if(!authenticated){
            redirectAttributes.addFlashAttribute("loginStatus Fail","Invalid username or password");
            return "redirect:/";
        }
        redirectAttributes.addFlashAttribute("loginStatus sucessful","Success '" + username + "'");
        return "redirect:/todo";
    }


}
