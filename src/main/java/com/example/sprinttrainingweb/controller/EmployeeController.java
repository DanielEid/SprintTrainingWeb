package com.example.sprinttrainingweb.controller;

import com.example.sprinttrainingweb.model.Employee;
import com.example.sprinttrainingweb.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EmployeeController {

    @GetMapping("/")
    public String home(Model model) {
        //Iterable<Employee> listEmployee = service.getEmployees();  //TODO autowire dosn't works
        Iterable<Employee> listEmployee = new EmployeeService().getEmployees();  // Tmp fix
        model.addAttribute("employees", listEmployee); //Value that contains listEmployee in html

        return "home";

        //Dans le corps de la méthode, j’utilise une méthode addAttribute qui permet d’ajouter à mon Model un objet. Le premier paramètre spécifie le nom (de mon choix) et le deuxième l’objet (ici, la liste des employés en Iterable).
    }

    @GetMapping("/deleteEmployee/{id}")
    public ModelAndView deleteEmployee(@PathVariable("id") final int id) {
        new EmployeeService().deleteEmployee(id);
        return new ModelAndView("redirect:/");
    }


    @GetMapping("/createEmployee")
    public String createEmployee(Model model){
        Employee e = new Employee();
        model.addAttribute("employee", e);
        return "add";
    }

    @PostMapping("/saveEmployee")
    public ModelAndView saveEmployee(@ModelAttribute Employee employee) {
        new EmployeeService().saveEmployee(employee);
        return new ModelAndView("redirect:/");

    }
}
