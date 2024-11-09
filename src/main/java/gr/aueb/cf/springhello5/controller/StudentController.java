package gr.aueb.cf.springhello5.controller;

import gr.aueb.cf.springhello5.dto.StudentInsertDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("/student/add")
    public String getStudentForm(Model model) {
        model.addAttribute("studentInsertDTO", new StudentInsertDTO());
        return "students/insert";
    }
    @PostMapping("/student/add")
    public String addStudent(@ModelAttribute StudentInsertDTO dto, Model model) {
        model.addAttribute("dto", dto);
        return "students/success";
    }
}
