package org.example.springwebmvc.esercizio.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.example.springwebmvc.esercizio.models.Utente;
import org.example.springwebmvc.esercizio.services.UtenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {

    @Autowired UtenteService utenteService;

    @GetMapping("/dashboard")
    public ModelAndView dashboardPage(HttpSession session){

        Utente utente = (Utente)session.getAttribute("user");
        System.out.println(utente);

        if(utente == null){
            ModelAndView model = new ModelAndView("redirect:/login");
            return model;
        }

        ModelAndView model = new ModelAndView("esercizio/dashboard");
        model.addObject("utente", utente);

        return model;
    }

    @GetMapping("/login")
    public String loginPage(){
        return "esercizio/login";
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email,
                              @RequestParam String password,
                              HttpSession session,
                              HttpServletResponse response){

        ModelAndView model = new ModelAndView("redirect:/dashboard");
        Utente utente = utenteService.authenticateUser(email, password);

        if(utente == null){
            model = new ModelAndView("esercizio/login");
            model.addObject("message", "Email and password invalid.");
            return model;
        }

        session.setAttribute("user", utente);

        Cookie cookie = new Cookie("email", utente.getEmail());
        cookie.setMaxAge(60*60*24);
        response.addCookie(cookie);

        return model;
    }

    @GetMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String registerPage(){
        return "esercizio/register";
    }

    @PostMapping("/register")
    public ModelAndView register(
                    @RequestParam(required = false) String name,
                    @RequestParam String email,
                    @RequestParam String password){

        ModelAndView model = new ModelAndView("redirect:/login");
        try {
            utenteService.registerUser(name, email, password);
        } catch (Exception e) {
            model = new ModelAndView("esercizio/register");
            model.addObject("message", e.getMessage());
        }

        return model;
    }

}
