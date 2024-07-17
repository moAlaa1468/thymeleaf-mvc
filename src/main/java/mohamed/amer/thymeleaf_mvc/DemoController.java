package mohamed.amer.thymeleaf_mvc;


import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class DemoController {


    // we need to make some mapping here uaaemr
    @GetMapping("/hello")
    public String sayHello(Model model) {
        model.addAttribute("theData", java.time.LocalDateTime.now());
        return "helloworld.html.backup";
        // this function will return the html page name hello world
    }


}
