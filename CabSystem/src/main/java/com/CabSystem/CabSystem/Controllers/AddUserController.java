package com.CabSystem.CabSystem.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.CabSystem.CabSystem.entityes.AddUser;
import com.CabSystem.CabSystem.services.AddUserServ;
@CrossOrigin("http://localhost:3000/")
@RestController
@RequestMapping("/api")

public class AddUserController {
	@Autowired
	AddUserServ addUserServ;
	
	@PostMapping("/user")
	public ResponseEntity<AddUser> addUser(@RequestBody AddUser user) {
		return addUserServ.addUser(user);

	}
//my name is ambresh iam from pune
	
	@GetMapping("/user")
	public ResponseEntity<List<AddUser>> getalluser() {
		return addUserServ.getAllUser();

	}
	
//	get use by id
	
	@GetMapping("/{id}")
	public ResponseEntity<AddUser> getuserByid(@PathVariable Long id){
		return addUserServ.getuserByid(id);
		
	}
	
//	delete user by id
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUserByid(@PathVariable Long id){
		return addUserServ.deleteUserByid(id);
		
	}




	//update user
	
	@PutMapping("/{id}")
	public ResponseEntity<AddUser> updateUserByid(@RequestBody AddUser user,@PathVariable Long id){
		return addUserServ.updateUserByid(user,id);
	}
	
	

}
