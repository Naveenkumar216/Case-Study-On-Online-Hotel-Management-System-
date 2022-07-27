package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;

@Service
public class ManagerService {

	@Autowired
	ManagerRepository managerRepository;
		
	public List<Manager> allManager() {
	
		return managerRepository.findAll();
	}

	public Manager addManager(Manager manager) {
		
		return managerRepository.save(manager);
	}

	public Manager updateManager(Manager manager, int code) {
		
		return managerRepository.save(manager);
	}

	public String deleteManager(int code) {
		managerRepository.deleteById(code);
		return "Delete Guest is Successfully" ;
	}
}
