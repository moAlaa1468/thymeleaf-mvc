package mohamed.amer.thymeleaf_mvc;


import mohamed.amer.thymeleaf_mvc.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StudentController {

    // we need to inject the value to the constructor
    @Value("${app.country}")
    private List<String> countries;

    @Value("${app.languages}")
    private List<String> languages;

    @Value("${app.systems}")
    private List<String> systems;

    //  هي دي نقطة انطلاق البرنامج
    @GetMapping("/studentForm")
    public String displayForm(Model model) {
        // we nee to create a student object here
        Student theStudent = new Student();

        // محتاجين نحط ال student object في الشنطة اللي هي model
        //                        name               value
        model.addAttribute("student", theStudent);
        model.addAttribute("country", countries);
        model.addAttribute("studentLanguages", languages);
        model.addAttribute("studentSystems", systems);
//        model.addAttribute("studentLanguage",)
        return "student-form";
    }

    // عاوزين نعمل شوية عمليات
    // معني كدا ان ال browser هو اللي هيرسل ليك بيانات
    @PostMapping("/student-process")
    public String process(@ModelAttribute("student") Student student) {
        System.out.println("theStudent :" + student.getFirstName() + "The student :" + student.getLastName()
                + " The studentCountry is  :" + student.getCountry()
        );

        /*
        *
        *     @PostMapping("/submit")
        public String submitForm(Employee employee) {
        // Process form data (e.g., save to database)
        System.out.println("Submitted Employee: " + employee.getName() + ", " + employee.getEmail());
        return "redirect:/form"; // Redirect back to the form page
    }
*/
        // before


        return "student-page";
    }
}
