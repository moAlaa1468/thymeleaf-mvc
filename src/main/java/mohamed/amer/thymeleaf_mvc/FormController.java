package mohamed.amer.thymeleaf_mvc;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.model.IModel;

import java.util.Locale;

@Controller
public class FormController {
    // دي هتكون اول نقطة علشان نعرض الفورم لاول مرة نقطة انطلاق البرنامج
    @GetMapping("/form")
    public String showForm() {
        return "form";
    }

    @PostMapping("/submit")
    public String submitForm(@RequestParam("name") String name,
                             @RequestParam("email") String email,
                             Model model) {
        //making some processing of these variables
        String modifiedName = name.toUpperCase(Locale.ROOT);
        String modifiedEmail = email.toUpperCase(Locale.ROOT);
        // we need to request parameter to the model
        model.addAttribute("name", modifiedName);
        model.addAttribute("email", modifiedEmail);

        //we need to display the page
        return "result";
    }

}
