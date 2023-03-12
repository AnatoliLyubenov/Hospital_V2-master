package com.project.Hospital_V2.controllers;

import com.project.Hospital_V2.entities.Patient;
import com.project.Hospital_V2.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PatientController {

    @Autowired
    PatientRepository patientRepository;
    @GetMapping("/patients")
    public String getPatients(@RequestParam(name = "sort", defaultValue = "firstName,asc") String sort, Model model) {
        Sort.Direction direction = Sort.Direction.ASC;
        String property = sort;
        if (sort.contains(",")) {
            String[] sortParams = sort.split(",");
            property = sortParams[0];
            direction = sortParams[1].equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC;
        }
        Sort sortObj = Sort.by(direction, property);
        List<Patient> patients = patientRepository.findAll(sortObj);
        model.addAttribute("patients", patients);

        return "patients";
    }
}

