package com.piotrek.login.service;

import com.piotrek.login.model.Medicine;
import com.piotrek.login.model.User;
import com.piotrek.login.repository.MedicineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("medicineService")
public class MedicineService {

    @Autowired
    MedicineRepository medicineRepository;

    public Medicine findMedicineByName(String name) {
        return medicineRepository.findByName(name);
    }
}
