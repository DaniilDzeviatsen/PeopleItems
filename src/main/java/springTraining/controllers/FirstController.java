package springTraining.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {

       //System.out.println("Hello" + " " + name + " " + surname);
        model.addAttribute("message", "Hello" + " " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage() {
        return "first/goodbye";
    }
    @GetMapping("/calculator")
    public String calculator(@RequestParam (value="a")int a,
            @RequestParam(value = "b")int b,
            @RequestParam(value = "action")String action,
            Model model){
        double result=0;
        switch (action){
            case "multiplication":
                result=a * b;
                break;
            case "addition":
                result=a+b;
                break;
            case "division":
                result=a/(double)b;
                break;
            case "subtraction":
                result=a-b;
                break;
            default:
                result=0;
                break;
        }
        model.addAttribute("result", result);
        return "first/calculator";

    }

}
