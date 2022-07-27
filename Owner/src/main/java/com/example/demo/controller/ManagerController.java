package com.example.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Manager;
import com.example.demo.service.ManagerService;

@RestController
@RequestMapping("managercontroller")
public class ManagerController {

	@Autowired
	ManagerService managerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/allmanager")
	public List<Manager> allManager(){
		return managerService.allManager();
		
	}
	
	@PostMapping("/addmanager")
	public Manager addManager(@RequestBody Manager manager) {
		return managerService.addManager(manager);

	}
	
	@PutMapping("/updatemanager/{code}")
	public Manager updateManager(@RequestBody Manager manager,@PathVariable int code) {
		return managerService.updateManager(manager,code);
	}
	
	@DeleteMapping("/deletemanager/{code}")
	private String deleteManager(@PathVariable int code) {
	 return managerService.deleteManager(code);	
	}
	
	@GetMapping("/searchstaff")
	 public List<Object> getSearch(){
        Object[] objects=restTemplate.getForObject("http://ManagerServices/staffcontroller/staff",Object[].class);
        return Arrays.asList(objects);
    }

}
