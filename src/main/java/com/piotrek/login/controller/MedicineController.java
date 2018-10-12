package com.piotrek.login.controller;

import com.piotrek.login.model.Medicine;
import com.piotrek.login.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@Controller
public class MedicineController {

    @Autowired
    MedicineRepository medicineRepository;

    @RequestMapping(value="/admin/addMedicine", method = RequestMethod.GET)
    public ModelAndView addMedicine() {
        ModelAndView modelAndView = new ModelAndView();
        Medicine medicine = new Medicine();
        modelAndView.addObject("medicine", medicine);
        modelAndView.setViewName("/admin/addMedicine");

        return modelAndView;
    }


    @RequestMapping(value = "admin/addMedicine", method = RequestMethod.POST)
        public ModelAndView addMedicine(@Valid Medicine medicine, BindingResult bindingResult) {
        ModelAndView modelAndView = new ModelAndView();
        Medicine medicineExists = medicineRepository.findByName(medicine.getName());
        if (medicineExists != null) {
            bindingResult
                    .rejectValue("name", "error.medicine",
                            "There is already a medicine registered with the name provided");
        }
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("admin/addMedicine");
        }else {
            medicineRepository.save(medicine);
            modelAndView.addObject("successMessage", "Medicine has been added successfully");
            modelAndView.addObject("medicine", new Medicine());
            modelAndView.setViewName("admin/addMedicine");
        }

        return modelAndView;
    }

    @RequestMapping(value="allMedicine", method = RequestMethod.GET)
    public ModelAndView allMedicine() {
        ModelAndView modelAndView = new ModelAndView();
        List<Medicine> medicineList = new ArrayList<>();
        medicineList = medicineRepository.findAll();
        modelAndView.addObject("medicineList", medicineList);
        modelAndView.setViewName("allMedicine");

        return modelAndView;
    }
    @ResponseBody
    @RequestMapping (value="/admin/delete{name}/", method = RequestMethod.GET)
    public String deleteMedicine(@PathVariable String name) {
        Medicine medicineToDelete  =  medicineRepository.findByName(name);
      medicineRepository.delete(medicineToDelete);
        return "medicine delete";
    }



}
