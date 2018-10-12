package com.piotrek.login.repository;

import com.piotrek.login.model.Medicine;
import com.piotrek.login.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MedicineRepository extends JpaRepository<Medicine, Long> {

   Medicine findByName(String name);




}


