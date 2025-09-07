package train_tickets.controllers.admins;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import train_tickets.model.util.Role;
import train_tickets.services.UserService;

@Controller
@RequestMapping("/admin/users")
public class AdminUsersController {
    
    private final UserService userService;

    public AdminUsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles", Role.values());
        return "admin/users";
    }

    @PostMapping("/toggle-active/{id}")
    public String toggleActive(@PathVariable Long id) {
        userService.toggleUserActive(id);
        return "redirect:/admin/users";
    }

    @PostMapping("/change-role/{id}")
    public String changeRole(
        @PathVariable Long id,
        @RequestParam Role newRole
    ) {
        userService.changeUserRole(id, newRole);
        return "redirect:/admin/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/users";
    }

}
