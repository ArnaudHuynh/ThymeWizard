package com.arnaud.thymewizard.thymewizardapplication.user.web;

import com.arnaud.thymewizard.thymewizardapplication.user.*;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.SortDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public String editUserForm(@PathVariable("id") UserId userId,
                               Model model) {
        User user = service.getUser(userId)
                .orElseThrow(() -> new UserNotFoundException(userId));
        model.addAttribute("user", EditUserFormData.fromUser(user));
        model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER));
        model.addAttribute("editMode", EditMode.UPDATE);
        return "users/edit";
    }

    @PostMapping("/{id}")
    public String doEditUser(@PathVariable("id") UserId userId,
                             @Valid @ModelAttribute("user") EditUserFormData formData,
                             BindingResult bindingResult,
                             Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("genders", List.of(Gender.MALE, Gender.FEMALE, Gender.OTHER));
            model.addAttribute("editMode", EditMode.UPDATE);
            return "users/edit";
        }

        service.editUser(userId, formData.toParameters());

        return "redirect:/users";
    }
}
