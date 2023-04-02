package com.example.clase.Controllers;

import com.example.clase.Entities.Persona;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;

@Controller
@RequestMapping("/Formularios")
public class FormsController {

    @GetMapping(value = {"", "/", "/index"})
    public String indexForms(Model model){

        ArrayList<String> nacionalities = new ArrayList<>();
        nacionalities.add("Perú");
        nacionalities.add("Alemania");
        nacionalities.add("Escocia");
        model.addAttribute("nacionalities", nacionalities);

        return "indexForms";
    }

    @GetMapping("/Get")
    public String receiveParamGet(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "surname", required = false) String surname,
                                  @RequestParam("nacionality") String nacionality,
                                  @RequestParam(value = "dni") String dni,
                                  Model model){
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("nacionality", nacionality);
        model.addAttribute("dni", dni);
        return "receiveParamGet";
    }

    @PostMapping("/DataBinding")
    public String receiveParamDataBinding(Persona persona,
                                          Model model){

        model.addAttribute("name", persona.getName());
        model.addAttribute("surname", persona.getSurname());
        model.addAttribute("nacionality", persona.getNacionality());
        model.addAttribute("dni", persona.getDni());

        return "receiveParamPost";
    }

    @PostMapping("/Post")
    public String receiveParamPost(@RequestParam("name") String name,
                                   @RequestParam(value = "surname", required = false) String surname,
                                   @RequestParam("nacionality") String nacionality,
                                   @RequestParam("dni") String dni,
                                   Model model){
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("nacionality", nacionality);
        model.addAttribute("dni", dni);
        return "receiveParamPost";
    }
}