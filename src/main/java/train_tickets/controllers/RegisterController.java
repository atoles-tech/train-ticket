package train_tickets.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import train_tickets.services.UserService;


@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String register(Model model){

        model.addAttribute("username", "");
        model.addAttribute("password", "");
        model.addAttribute("confirmPassword", "");

        return "register";
    } 

    @PostMapping("/register")
    public String tryReg(
        @RequestParam String username,
        @RequestParam String password,
        @RequestParam String confirmPassword
    ){
        
        if(!password.equals(confirmPassword)){
            return "register";
        }

        try{
            userService.register(username, password);
            return "redirect:/login?success";
        }catch(RuntimeException ignored){}

        return "register";
    }   

}
