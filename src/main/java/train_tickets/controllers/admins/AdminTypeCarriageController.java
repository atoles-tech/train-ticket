package train_tickets.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import train_tickets.model.TypeTrainCarriage;
import train_tickets.services.TypeCarriageService;

@Controller
@RequestMapping("/admin/type-carriage")
public class AdminTypeCarriageController {

    private TypeCarriageService typeCarriageService;

    public AdminTypeCarriageController(TypeCarriageService typeCarriageService) {
        this.typeCarriageService = typeCarriageService;
    }

    @GetMapping
    public String listTypeCarriages(Model model){
        model.addAttribute("typeCarriage", typeCarriageService.findAll());
        return "admin/type-carriage";
    }

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        typeCarriageService.deleteById(id);
        return "redirect:/admin/type-carriage";
    }
    
    @PostMapping("/add-new")
    public String addTypeCarriage(@RequestParam String name){
        typeCarriageService.save(new TypeTrainCarriage(name));
        return "redirect:/admin/type-carriage";
    }

}
