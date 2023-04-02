package com.example.clase.Controllers;

import com.example.clase.Entities.DB.Shipper;
import com.example.clase.Repositories.ShipperRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/BaseDeDatos")
public class DBController {
    final ShipperRepository shipperRepository;

    public DBController(ShipperRepository shipperRepository){
        this.shipperRepository = shipperRepository;
    }

    @RequestMapping(value = {"", "/", "index"})
    public String indexDB(Model model){

        List<Shipper> shipperList = shipperRepository.findAll();
        model.addAttribute("shipperList", shipperList);
        return "indexDB";
    }

}
