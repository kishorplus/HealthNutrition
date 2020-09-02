package com.health;

import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.health.controller.ControllerHealth;
import com.health.controller.controllerContributer;
import com.health.domain.security.Role;
import com.health.domain.security.UserRole;
import com.health.model.User;
import com.health.service.UserService;
import com.health.utility.SecurityUtility;

@SpringBootApplication
public class HealthNutrition implements CommandLineRunner {
	
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		
		
		
		SpringApplication.run(HealthNutrition.class, args);

		
		new File(ControllerHealth.uploadDirectory).mkdir();
		new File(ControllerHealth.uploadDirectoryConsaltant).mkdir();
		new File(ControllerHealth.uploadDirectorOutLine).mkdir();
		new File(ControllerHealth.uploadDirectorScript).mkdir();
		new File(ControllerHealth.uploadDirectorTimeScript).mkdir();
		new File(ControllerHealth.uploadDirectorVideo).mkdir();
		
		new File(ControllerHealth.uploadMasterTrainer).mkdir();
		new File(ControllerHealth.uploadMasterTrainerPhoto).mkdir();
		new File(ControllerHealth.uploadQusetion).mkdir();
		new File(controllerContributer.uploadDirectoryCreation).mkdirs();
		new File(controllerContributer.uploadDirectoryCreationScripts).mkdirs();
		new File(controllerContributer.uploadDirectoryCreationVideo).mkdirs();
		new File(ControllerHealth.uploadDirectoryFeedback).mkdirs();
		
		
		
		
		
	
	}
	@Override
	public void run(String... args) throws Exception {
		
		/*
		 * 
		 * 
		 * User user1 = new User();
		 * 
		 * user1.setFirstName("John"); user1.setLastName("Adams");
		 * user1.setUsername("kishor");
		 * user1.setPassword(SecurityUtility.passwordEncoder().encode("kishor"));
		 * user1.setEmail("JAdams@gmail.com"); Set<UserRole> userRoles = new
		 * HashSet<>();
		 * 
		 * 
		 * 
		 * Role role1= new Role(); role1.setRoleId(1); role1.setName("ROLE_USER");
		 * 
		 * userRoles.add(new UserRole(user1, role1));
		 * 
		 * userService.createUser(user1, userRoles);
		 * 
		 */
		 
		
		
	}
}
