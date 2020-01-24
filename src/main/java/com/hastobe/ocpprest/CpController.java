package com.hastobe.ocpprest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cp")
public class CpController {

    private final CpRepository cpRepository;

    @Autowired
    public CpController(CpRepository cpRepository) {
        this.cpRepository = cpRepository;
    }

    @PostMapping("/update")
    public Cp update(@RequestBody @Valid Cp cp) {
        return this.cpRepository.save(cp);
    }

    @GetMapping("/")
    public Iterable<Cp> get() {
        return this.cpRepository.findAll();
    }
}
