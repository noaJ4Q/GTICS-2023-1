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

    @GetMapping("/Buscar")
    public String search(@RequestParam(value = "search") String search,
                         @RequestParam(value = "table") String table,
                         Model model){

        List<Shipper> shipperList = null;
        List<Region> regionList = null;

        switch (table){
            case "Shipper":
                shipperList = shipperRepository.findByCompanyNameGeneral(search);
                regionList = regionRepository.findAll();

                model.addAttribute("shipperList", shipperList);
                model.addAttribute("regionList", regionList);
                break;
            case "Region":
                shipperList = shipperRepository.findAll();
                regionList = regionRepository.findByDescriptionGeneral(search);

                model.addAttribute("regionList", regionList);
                model.addAttribute("shipperList", shipperList);
                break;
        }

        model.addAttribute("search", search);
        model.addAttribute("table", table);
        return "DB/indexDB";
    }

    /* SHIPPERS */
    @GetMapping("/NuevoTransportista")
    public String createShipper(){
        return "DB/newShipper";
    }

    @PostMapping("/GuardarTransportista")
    public String saveShipper(Shipper shipper){
        shipperRepository.save(shipper);
        return "redirect:/BaseDeDatos";
    }

    @GetMapping("/EditarTransp")
    public String editShipper(@RequestParam(value = "id") int id,
                              Model model){
        Optional<Shipper> optionalShipper = shipperRepository.findById(id);
        if (optionalShipper.isPresent()){
            Shipper shipper = optionalShipper.get();
            model.addAttribute("shipper", shipper);
            return "DB/editShipper";
        }
        return "redirect:/BaseDeDatos";
    }

    @GetMapping("/Eliminar")
    public String deleteShipper(@RequestParam(value = "id") int id,
                                @RequestParam(value = "t") String type){
        switch (type){
            case "transp":
                Optional<Shipper> optionalShipper = shipperRepository.findById(id);
                if (optionalShipper.isPresent()){
                    shipperRepository.deleteById(id);
                }
                break;
            case "region":
                Optional<Region> optionalRegion = regionRepository.findById(id);
                if (optionalRegion.isPresent()){
                    regionRepository.deleteById(id);
                }
                break;
        }
        return "redirect:/BaseDeDatos";
    }

    /* REGIONS */
    @GetMapping("/NuevaRegion")
    public String createRegion(Model model){
        List<Region> regionList = regionRepository.findAll();
        model.addAttribute("regionList", regionList);
        return "DB/newRegion";
    }

    @PostMapping("/GuardarRegion")
    public String saveRegion(Region region){
        regionRepository.save(region);
        return "redirect:/BaseDeDatos";
    }

    @GetMapping("EditarRegion")
    public String editRegion(@RequestParam(value = "id") int id,
                             Model model){
        Optional<Region> optionalRegion = regionRepository.findById(id);
        if (optionalRegion.isPresent()){
            Region region = optionalRegion.get();
            model.addAttribute("region", region);
            return "DB/editRegion";
        }
        return "redirect:/BaseDeDatos";
    }
}
