package train_tickets.controllers.admins;

import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import train_tickets.model.Train;
import train_tickets.model.TrainCarriage;
import train_tickets.services.CarriageService;
import train_tickets.services.TrainService;

@Controller
@RequestMapping("/admin/train")
public class AdminTrainController {
    
    private TrainService service;
    private CarriageService carriageService;

    public AdminTrainController(TrainService service,CarriageService carriageService) {
        this.service = service;
        this.carriageService = carriageService;
    }

    @GetMapping
    public String trains(Model model){
        model.addAttribute("trains", service.findAll());
        return "/admin/trains";
    }

    @GetMapping("/{id}")
    public String train(Model model, @PathVariable Long id){
        
        model.addAttribute("train", service.getTrainByID(id));
        model.addAttribute("daysOfWeek", DayOfWeek.values());
        model.addAttribute("carriages",carriageService.findAllAvailable());

        return "/admin/train";
    }

    @PostMapping("/create")
    public String createTrain(){
        service.createTrain();
        return "redirect:/admin/train";
    }

    @PostMapping("/add-carriages/{id}")
    public String addCarriage(@PathVariable Long id,@RequestParam TrainCarriage trainCarriage){
        Train train = service.getTrainByID(id);
        
        train.addCarriage(trainCarriage);
        
        service.save(train);
        carriageService.save(trainCarriage);

        return "redirect:/admin/train/"+id;
    }

    @PostMapping("/remove-carriage/{id}/{train_id}")
    public String removeCarriage(@PathVariable Long id, @PathVariable Long train_id){   // id - carriage
        Train train = service.getTrainByID(train_id);                                   // train_id - train
        TrainCarriage carriage = carriageService.findTrainCarriageById(id);

        train.removeCarriage(carriage);
        
        service.save(train);
        carriageService.save(carriage);

        return "redirect:/admin/train/"+train_id;
    }

}
