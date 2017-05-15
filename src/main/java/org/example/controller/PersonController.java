package org.example.controller;

import org.example.domain.Person;
import org.example.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by palevo on 12.05.2017.
 */
@Controller
@Scope("singleton")
public class PersonController {

    @Autowired
    private IPersonService personService;

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public String index(Model model){
        model.addAttribute("people", personService.getAll());
        return "index";
    }

    @RequestMapping(value = "deletePerson", method = RequestMethod.POST)
    public @ResponseBody boolean deletePerson(@NotNull @RequestBody Integer data) {

        personService.deletePerson(data);
        return true;
    }

    @RequestMapping(value = "savePerson", method = RequestMethod.POST)
    public @ResponseBody boolean updateOrSavePerson(@Valid @RequestBody Person data) {
        personService.updatePerson(data);
        return true;
    }

}
