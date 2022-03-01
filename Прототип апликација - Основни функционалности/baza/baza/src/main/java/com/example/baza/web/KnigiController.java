package com.example.baza.web;


import com.example.baza.model.Avtor;
import com.example.baza.model.Izdavac;
import com.example.baza.model.Kategorija;
import com.example.baza.model.Knigi;
import com.example.baza.model.exception.KnigaNotFoundException;
import com.example.baza.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/books")
public class KnigiController {
    private final KnigiService knigiService;
    private final AvtorService avtorService;
    private final KategorijaService kategorijaService;
    private final IzdavacService izdavacService;
    private final DobavuvacService dobavuvacService;

    public KnigiController(KnigiService knigiService, AvtorService avtorService, KategorijaService kategorijaService, IzdavacService izdavacService, DobavuvacService dobavuvacService) {
        this.knigiService = knigiService;
        this.avtorService = avtorService;
        this.kategorijaService = kategorijaService;
        this.izdavacService = izdavacService;
        this.dobavuvacService = dobavuvacService;
    }
    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error,
                                 @RequestParam(required = false) String naslov, Model model){
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        if(naslov != null)
        {
//
                List<Avtor> avtori = this.avtorService.findAll();
                List<Knigi> knigii = this.knigiService.findByNaslov(naslov);
                List<Kategorija> kategorii = this.kategorijaService.findAll();
                model.addAttribute("knigii", knigii);
                model.addAttribute("avtori", avtori);
                model.addAttribute("kategorii", kategorii);
//                model.addAttribute("list", list);
        }
        else {
            this.knigiService.listAll();
            List<Avtor> avtori = this.avtorService.findAll();
            List<Knigi> knigii = this.knigiService.listAll();
            List<Kategorija> kategorii = this.kategorijaService.findAll();
            model.addAttribute("knigii", knigii);
            model.addAttribute("avtori", avtori);
            model.addAttribute("kategorii", kategorii);
        }
        return "books";
    }
    @GetMapping("/add")
    public String showAdd() {
        return "form";
    }
//    @DeleteMapping("/delete/{id}")
//    public String deleteProduct(@PathVariable Integer id){
//        this.knigiService.delteById(id);
//        return "redirect:/products";
//    }
    @PostMapping("/books")
    public String create(@RequestParam String naslov,
                         @RequestParam String opis,
                         @RequestParam Izdavac izdavac,
                         @RequestParam Set<Kategorija> kategorijas,
                         @RequestParam Set<Avtor> avtors) {
        this.knigiService.create(naslov, opis, izdavac, kategorijas, avtors);
        return "redirect:/books";
    }
}
