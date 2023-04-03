package com.example.clase.Controllers;

import com.example.clase.Entities.DB.Region;
import com.example.clase.Entities.DB.Shipper;
import com.example.clase.Repositories.RegionRepository;
import com.example.clase.Repositories.ShipperRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/BaseDeDatos")
public class DBController {
    final ShipperRepository shipperRepository;
    final RegionRepository regionRepository;

    public DBController(ShipperRepository shipperRepository, RegionRepository regionRepository){
        this.shipperRepository = shipperRepository;
        this.regionRepository = regionRepository;
    }

    @RequestMapping(value = {"", "/", "index"})
    public String indexDB(Model model){

        List<Shipper> shipperList = shipperRepository.findAll();
        List<Region> regionList = regionRepository.findAll();

        model.addAttribute("shipperList", shipperList);
        model.addAttribute("regionList", regionList);
        return "indexDB";
    }

}
