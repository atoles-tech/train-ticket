package train_tickets.controllers.admins;

import java.time.DayOfWeek;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import train_tickets.model.SheduleEvent;
import train_tickets.model.Train;
import train_tickets.model.TrainCarriage;
import train_tickets.services.CarriageService;
import train_tickets.services.SheduleEventService;
import train_tickets.services.SheduleService;
import train_tickets.services.TrainService;

@Controller
@RequestMapping("/admin/train")
public class AdminTrainController {
    
    private TrainService service;
    private CarriageService carriageService;
    private SheduleService sheduleService;
    private SheduleEventService sheduleEventService;

    public AdminTrainController(TrainService service,
                                CarriageService carriageService,
                                SheduleService sheduleService,
                                SheduleEventService sheduleEventService) {
        this.service = service;
        this.carriageService = carriageService;
        this.sheduleService = sheduleService;
        this.sheduleEventService = sheduleEventService;
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

    @PostMapping("/remove-shedule_event/{train_id}/{id}")
    public String removeSheduleEvent(@PathVariable Long train_id, @PathVariable Long id){
        Train train = service.getTrainByID(train_id);
        SheduleEvent event = sheduleEventService.findById(id);

        System.out.println(train.getShedule());

        train.removeEvent(event);

        sheduleService.save(train.getShedule());
        sheduleEventService.delete(event);

        return "redirect:/admin/train/"+train_id;
    }

    @PostMapping("/create-shedule_event/{train_id}")
    public String addSheduleEvent(@PathVariable Long train_id, @ModelAttribute SheduleEvent event){
        Train train = service.getTrainByID(train_id);

        train.addEvent(event);

        sheduleEventService.save(event);
        sheduleService.save(train.getShedule());
        service.save(train);

        return "redirect:/admin/train/"+train_id;
    }

}
