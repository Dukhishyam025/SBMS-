package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import in.ashokit.entity.User;
import in.ashokit.service.UserService;


@Controller
public class UserController {
    @Autowired
   private UserService userService;

    // Open user form
    @GetMapping("/")
    public String loadForm(Model model) {
        User userObj = new User();
        model.addAttribute("user", userObj);
        return "index";
    }

    // Handle form submission
    @PostMapping("/user")
    public String handleSubmit(User user, Model model) {
        boolean isSaved = userService.saveUser(user); // Assuming saveUser is implemented in UserService
        if(isSaved)
        {
        	model.addAttribute("smsg","User saved");
        }
        else
        {
        	model.addAttribute("emsg","User Not Saved");
        }
        return "index"; // Redirect to the users list page
    }

    // Handle view-users page display
    @GetMapping("/users")
    public String getUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers()); // Assuming getAllUsers is implemented
        return "users";
    }
}
