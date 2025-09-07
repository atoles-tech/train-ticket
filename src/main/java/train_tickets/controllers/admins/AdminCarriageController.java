package train_tickets.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import train_tickets.model.TrainCarriage;
import train_tickets.model.TypeTrainCarriage;
import train_tickets.services.CarriageService;

@Controller
@RequestMapping("/admin/carriage")
public class AdminCarriageController {
    
    private CarriageService service;

    public AdminCarriageController(CarriageService service) {
        this.service = service;
    }

    @GetMapping
    public String listCarriage(Model model){
        model.addAttribute("carriages", service.findAll());
        model.addAttribute("types", service.findAllTypes());
        return "admin/carriage";
    }

    @PostMapping("/add-new")
    public String add(@RequestParam Integer capacity, 
                      @RequestParam Integer countRow, 
                      @RequestParam Long type){
        
        TypeTrainCarriage typeTrainCarriage = service.findById(type);

        TrainCarriage carriage = service.generateCarriage(capacity, countRow, typeTrainCarriage);
        service.save(carriage);

        return "redirect:/admin/carriage";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        service.deleteById(id);
        return "redirect:/admin/carriage";
    }

}
