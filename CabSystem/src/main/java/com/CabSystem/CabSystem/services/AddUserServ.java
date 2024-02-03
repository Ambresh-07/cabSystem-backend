package com.CabSystem.CabSystem.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.CabSystem.CabSystem.entityes.AddUser;

public interface AddUserServ {
	
	public ResponseEntity<AddUser> addUser(AddUser user);
	public ResponseEntity<List<AddUser>> getAllUser();
	public ResponseEntity<AddUser> getuserByid(@PathVariable Long id);
	public ResponseEntity<String> deleteUserByid(@PathVariable Long id);
	public ResponseEntity<AddUser> updateUserByid(@RequestBody AddUser user,@PathVariable Long id);



}
