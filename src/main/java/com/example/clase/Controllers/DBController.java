package com.example.clase.Controllers;

import com.example.clase.Entities.DB.Region;
import com.example.clase.Entities.DB.Shipper;
import com.example.clase.Repositories.RegionRepository;
import com.example.clase.Repositories.ShipperRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/BaseDeDatos")
public class DBController {
    final ShipperRepository shipperRepository;
    final RegionRepository regionRepository;

    public DBController(ShipperRepository shipperRepository, RegionRepository regionRepository){
        this.shipperRepository = shipperRepository;
        this.regionRepository = regionRepository;
    }

    @GetMapping(value = {"", "/", "index"})
    public String indexDB(Model model){

        List<Shipper> shipperList = shipperRepository.findAll();
        List<Region> regionList = regionRepository.findAll();

        model.addAttribute("shipperList", shipperList);
        model.addAttribute("regionList", regionList);
        return "DB/indexDB";
    }

    @GetMapping("/CrearTransportista")
    public String createShipper(){
        return "DB/newShipper";
    }

    @PostMapping("/GuardarTransportista")
    public String saveShipper(Shipper shipper){
        shipperRepository.save(shipper);
        return "redirect:/BaseDeDatos";
    }

    @GetMapping("/Editar")
    public String editShipper(@RequestParam(value = "id") int id,
                              Model model){
        Optional<Shipper> optionalShipper = shipperRepository.findById(id);
        if (optionalShipper.isPresent()){
            Shipper shipper = optionalShipper.get();
            model.addAttribute("shipper", shipper);
            return "DB/editShipper";
        }
        else{
            return "redirect:/BaseDeDatos";
        }
    }

    @GetMapping("/Eliminar")
    public String deleteShipper(@RequestParam(value = "id") int id){
        Optional<Shipper> optionalShipper = shipperRepository.findById(id);
        if (optionalShipper.isPresent()){
            shipperRepository.deleteById(id);
        }
        return "redirect:/BaseDeDatos";
    }

}
