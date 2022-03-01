package com.example.baza.web;

import com.example.baza.model.Chlen2;
import com.example.baza.model.Chovek2;
import com.example.baza.service.ChlenService;
import com.example.baza.service.ChovekService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;

@Controller
@RequestMapping("/members")
public class MembersController {

    private final ChlenService chlenService;
    private final ChovekService chovekService;

    public MembersController(ChlenService chlenService, ChovekService chovekService) {
        this.chlenService = chlenService;
        this.chovekService = chovekService;
    }

    @GetMapping
    public String getMembers(@RequestParam(required = false) String error, Model model)
    {
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        List<Chlen2> chlenovi = this.chlenService.findAll();
        List<Chovek2> lugje = this.chovekService.listAll();
        model.addAttribute("chlenovi", chlenovi);
        model.addAttribute("lugje", lugje);


        return "chlenovi";
    }
    @GetMapping("/add")
    public String showAdd() {
        return "chlenovi-form";
    }
}
