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

    @GetMapping("/RequestParam")
    public String receiveRequestParam(@RequestParam(value = "name") String name,
                                      @RequestParam(value = "surname", required = false) String surname,
                                      @RequestParam(value = "dni") String dni,
                                      Model model){
        System.out.println("APELLIDO RequestParam: "+surname);
        model.addAttribute("name", name);
        model.addAttribute("surname", surname);
        model.addAttribute("dni", dni);
        return "receiveRequestParam";
    }

    @GetMapping("/PathVariable/{name}/{surname}/{dni}")
    @ResponseBody
    public String receivePathVariable(@PathVariable(value = "surname", required = false) String surname,
                                      @PathVariable(value = "name") String name,
                                      @PathVariable(value = "dni") String dni){
        System.out.println("APELLIDO PathVariable: "+surname);
        return "NOMBRE: "+name+"|  APELLIDO: "+surname+"|  DNI: "+dni;
    }
}