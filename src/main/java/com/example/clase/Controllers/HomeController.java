package com.example.clase.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {

    @RequestMapping(value = {"/", "index", ""}, method = RequestMethod.GET)
    public String index(){
        return "index";
    }
}