package com.hastobe.ocpprest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/views/")
public class CpViewController {

    private CpRepository cpRepository;

    @Autowired
    public CpViewController(CpRepository cpRepository) {
        this.cpRepository = cpRepository;
    }

    @GetMapping("/")
    public String main(Model model) {
        Iterable<Cp> cps = cpRepository.findAll();
        model.addAttribute("cps", cps);

        return "cp"; //view
    }
}
