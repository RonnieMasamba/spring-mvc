package com.jenkins.controller;

import com.jenkins.dao.PersonDAO;
import com.jenkins.model.Person;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/persons")
@RequiredArgsConstructor
public class PersonController {

    private  PersonDAO personDAO;

    @GetMapping
    public String getAllPersons(Model model) {
        List<Person> persons = personDAO.getAllPersons();
        model.addAttribute("persons", persons);
        return "persons/list";
    }

    @GetMapping("/{id}")
    public String getPersonById(@PathVariable Long id, Model model) {
        Person person = personDAO.getPersonById(id);
        model.addAttribute("person", person);
        return "persons/details";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("person", new Person());
        return "persons/add";
    }

    @PostMapping("/add")
    public String addPerson(@ModelAttribute Person person) {
        personDAO.addPerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Person person = personDAO.getPersonById(id);
        model.addAttribute("person", person);
        return "persons/edit";
    }

    @PostMapping("/edit")
    public String editPerson(@ModelAttribute Person person) {
        personDAO.updatePerson(person);
        return "redirect:/persons";
    }

    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable Long id) {
        personDAO.deletePerson(id);
        return "redirect:/persons";
    }
}
