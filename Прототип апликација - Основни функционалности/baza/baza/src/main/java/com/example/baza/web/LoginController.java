package com.example.baza.web;

import com.example.baza.model.Chovek2;
import com.example.baza.model.exception.InvalidUserCredentialsException;
import com.example.baza.service.ChovekService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final ChovekService chovekService;

    public LoginController(ChovekService chovekService) {
        this.chovekService = chovekService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }

    @PostMapping
    public String login(HttpServletRequest request, Model model){
        Chovek2 chovek = null;
        try{
            chovek = this.chovekService.login(request.getParameter("username"),
                                                request.getParameter("password"));
            request.getSession().setAttribute("user",chovek);
            return "redirect:/home";
        }
        catch (InvalidUserCredentialsException exception)
        {
            model.addAttribute("hasError", true);
            model.addAttribute("error", exception.getMessage());
            return "login";
        }
    }

}
