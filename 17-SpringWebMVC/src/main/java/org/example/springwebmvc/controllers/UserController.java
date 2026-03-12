package org.example.springwebmvc.controllers;

import org.example.springwebmvc.models.User;
import org.example.springwebmvc.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    @Autowired UserService userService;

    @GetMapping("/userlogin")
    public String getLogin() {
        return "loginPage";
    }

    @PostMapping("/userlogin")
    public ModelAndView ceckLogin(@RequestParam String email, @RequestParam String password) {
//        System.out.println("email: " + email);
//        System.out.println("password: " + password);
//        return "loginPage";
        User user = userService.ceckUser(email, password);
        if(user != null) {
            ModelAndView model = new ModelAndView("detail");
            model.addObject("user", user);
            return model;
        } else {
            ModelAndView model = new ModelAndView("error");
            model.addObject("message", "Invalid username or password");
            return model;
        }

    }


}
