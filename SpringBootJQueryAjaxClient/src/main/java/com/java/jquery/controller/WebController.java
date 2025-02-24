package com.java.jquery.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java.jquery.model.User;
import com.java.jquery.service.UserService;

@Controller
public class WebController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String showLoginForm() {
        return "login";  // Ensure there's a login.html file
    }

    @GetMapping("/home")
    public String index() {
        return "index";
    }

    @GetMapping("/showData")
    public String showData(HttpSession session, Model model) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "redirect:/"; // Redirect to login if not logged in
        }
        model.addAttribute("user", user);
        return "showData";
    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        User user = userService.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("user", user);
            return "redirect:/home"; // Redirect to data page after login
        }
        return "redirect:/?error=true"; // Redirect to login with error
    }

    @GetMapping("/signup")
    public String showSignUpForm(Model model) {
        model.addAttribute("user", new User());
        return "signup"; // Make sure signup.html exists
    }

    @PostMapping("/signup")
    public String registerUser(@ModelAttribute User user) {
        userService.registerUser(user);
        return "redirect:/"; // Redirect to login after successful sign-up
    }
}
