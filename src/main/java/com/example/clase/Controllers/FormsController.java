package com.example.clase.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/Formularios")
public class FormsController {

    @GetMapping(value = {"", "/"})
    public String indexForms(){
        return "indexForms";
    }

    @GetMapping("/GetRequestParam")
    public String receiveParamGet(@RequestParam(value = "name") String name,
                                  @RequestParam(value = "surname", required = false) String surname,
                                  @RequestParam(value = "dni") String dni,
                                  Model model){
        System.out.println("APELLIDO RequestParam: "+surname);
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("dni", dni);
        return "receiveParamGet";
    }

    @PostMapping("/PostRequestParam")
    public String receiveParamPost(@RequestParam("name") String name,
                                   @RequestParam(value = "surname", required = false) String surname,
                                   @RequestParam("dni") String dni){
        return "receiveParamPost";
    }
}