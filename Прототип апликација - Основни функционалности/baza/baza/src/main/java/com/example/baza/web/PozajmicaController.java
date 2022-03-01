package com.example.baza.web;



import com.example.baza.model.*;
import com.example.baza.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/borrow")
public class PozajmicaController {
    private final InstancaOdKnigaService instancaOdKnigaService;
    private final KaznaService kaznaService;
    private final BibliotekarService bibliotekarService;
    private final ChlenService chlenService;
    private final PozajmicaService pozajmicaService;
    private final ChovekService chovekService;
    private final IzdavacService izdavacService;
    private final KategorijaService kategorijaService;
    private final AvtorService avtorService;
    private final KnigiService knigiService;

    public PozajmicaController(InstancaOdKnigaService instancaOdKnigaService, KaznaService kaznaService, BibliotekarService bibliotekarService, ChlenService chlenService, PozajmicaService pozajmicaService, ChovekService chovekService, IzdavacService izdavacService, KategorijaService kategorijaService, AvtorService avtorService, KnigiService knigiService) {
        this.instancaOdKnigaService = instancaOdKnigaService;
        this.kaznaService = kaznaService;
        this.bibliotekarService = bibliotekarService;
        this.chlenService = chlenService;
        this.pozajmicaService = pozajmicaService;
        this.chovekService = chovekService;
        this.izdavacService = izdavacService;
        this.kategorijaService = kategorijaService;
        this.avtorService = avtorService;
        this.knigiService = knigiService;
    }
    @GetMapping
    public String getProductPage(@RequestParam(required = false) String error, Model model){
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        List<Pozajmica> pozajmici=this.pozajmicaService.listAll();
        List<InstancaOdKniga> isbn=this.instancaOdKnigaService.listAll();
        List<Bibliotekar2> bibliotekar=this.bibliotekarService.findAll();
        List<Chlen2> chlen=this.chlenService.findAll();
        List<Chovek2> chovek=this.chovekService.listAll();

        model.addAttribute("pozajmici",pozajmici);
        model.addAttribute("bibliotekar",bibliotekar);
        model.addAttribute("isbn",isbn);
        model.addAttribute("chlen",chlen);
        model.addAttribute("chovek",chovek);
        return "pozajmica.html";
    }

    @GetMapping("/add-borrowed-book")
    public  String addProductPage(Model model){
        List<Pozajmica> pozajmici=this.pozajmicaService.listAll();
        List<InstancaOdKniga> isbn=this.instancaOdKnigaService.listAll();
        List<Bibliotekar2> bibliotekar=this.bibliotekarService.findAll();
        List<Chlen2> chlen=this.chlenService.findAll();
        List<Knigi> knigi=this.knigiService.listAll();
        model.addAttribute("pozajmici",pozajmici);
        model.addAttribute("bibliotekar",bibliotekar);
        model.addAttribute("isbn",isbn);
        model.addAttribute("chlen",chlen);
        model.addAttribute("knigi",knigi);
        return "add-borrow";
    }


}

