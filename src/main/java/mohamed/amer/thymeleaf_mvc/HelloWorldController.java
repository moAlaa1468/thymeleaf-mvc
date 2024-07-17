package mohamed.amer.thymeleaf_mvc;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Locale;

@Controller
public class HelloWorldController {
    // method to show the initial form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    //method to process the Html form
    @RequestMapping("/processForm")
    public String processedForm() {
        System.out.println("the student name is : ");
        return "helloworld";
    }

    @GetMapping("/processFormVersionTwo")
    public String shoutOut(HttpServletRequest request, Model model) {
        //read data from html page
        String output = request.getParameter("studentName");
        //processing step
        String result = " [ Yo welcome : " + output.toUpperCase(Locale.ROOT) + " ]";
        //we need to display this output
        model.addAttribute("message", result);
        return "helloworld";
    }
}
