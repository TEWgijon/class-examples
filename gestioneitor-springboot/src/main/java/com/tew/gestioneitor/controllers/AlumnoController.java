package com.tew.gestioneitor.controllers;

import com.tew.gestioneitor.model.Alumno;
import com.tew.gestioneitor.service.AlumnosService;
import com.tew.gestioneitor.service.exceptions.EntityAlreadyExistsException;
import com.tew.gestioneitor.service.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AlumnoController {
    @Autowired
    private AlumnosService service;

    @RequestMapping(value = "/alumno/listado")
    public String listado(Model model) {
        model.addAttribute("alumnos", service.getAlumnos());

        return "alumno/listado";
    }

    @RequestMapping(value = "/alumno/alta")
    public String alta() {
        return "alumno/alta";
    }

    @RequestMapping(value = "/alumno/alta", method = RequestMethod.POST)
    public String alta(@ModelAttribute Alumno alumno) {
        try {
            service.saveAlumno(alumno);
        } catch (EntityAlreadyExistsException e) {
            System.out.println("El usuario ya existía");
        }

        return "redirect:/alumno/listado";
    }

    @RequestMapping(value = "/alumno/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        try {
            Alumno alumno = service.findById(id);
            model.addAttribute("alumno", alumno);
            return "alumno/edit";
        } catch (EntityNotFoundException e) {
            return "redirect:/alumno/listado";
        }
    }

    @RequestMapping(value = "/alumno/edit/{id}", method = RequestMethod.POST)
    public String setEdit(@ModelAttribute Alumno alumno, @PathVariable Long id) {
        try {
            service.updateAlumno(alumno);
            return "redirect:/alumno/listado";
        } catch (EntityNotFoundException e) {
            return "redirect:/alumno/edit/" + id;
        }
    }

    @RequestMapping("/alumno/delete/{id}")
    public String delete(@PathVariable Long id) {
        try {
            service.deleteAlumno(id);
        } catch (EntityNotFoundException e) {
            System.out.println("Error al eliminar el usuario");
        }
        return "redirect:/alumno/listado";
    }
}
