package gr.aueb.cf.springhello5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/cf")
    //@RequestMapping(path = "/cf", method = RequestMethod.GET)
    public String getHelloCF(Model model) {
        model.addAttribute("cf", "Coding Factory");
        model.addAttribute("pageName", "cf");
        return "index";
    }

    @GetMapping("/current-date")
    public String getCurrentDate(Model model) {
        model.addAttribute("curDate", new Date());
        model.addAttribute("pageName", "current-date");
        return "date";
    }

    @GetMapping("/greetings")
    //@RequestParam regards url string (e.g. ?name=george)
    public String getGreetings(@RequestParam(value = "name", defaultValue = "Noname") String name, Model model) {
        model.addAttribute("name", name);
        return "greetings";
    }
}
