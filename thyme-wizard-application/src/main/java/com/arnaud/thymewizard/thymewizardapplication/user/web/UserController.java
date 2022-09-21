package com.arnaud.thymewizard.thymewizardapplication.user.web;

import com.arnaud.thymewizard.thymewizardapplication.user.Gender;
import com.arnaud.thymewizard.thymewizardapplication.user.UserService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public String index(Model model,
                        @SortDefault.SortDefaults({
                                @SortDefault("userName.lastName"),
                                @SortDefault("userName.firstName")}) Pageable pageable) { //<.>
        model.addAttribute("users", service.getUsers(pageable)); //<.>
        return "users/list";
    }


    @GetMapping("/create") //<.>
    public String createUserForm(Model model) { //<.>
        model.addAttribute("user", new CreateUserFormData()); //<.>
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER)); //<.>
        return "users/edit"; //<.>
    }

    @PostMapping("/create") //<.>
    public String doCreateUser(@Valid @ModelAttribute("user") CreateUserFormData formData, //<.>
                               BindingResult bindingResult, Model model) { //<.>
        if (bindingResult.hasErrors()) { //<.>
            model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER)); //<.>
            return "users/edit"; //<.>
        }

        service.createUser(formData.toParameters()); //<.>

        return "redirect:/users"; //<.>
    }
}
