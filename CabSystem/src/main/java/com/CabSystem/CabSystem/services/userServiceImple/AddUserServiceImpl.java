package com.CabSystem.CabSystem.services.userServiceImple;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.CabSystem.CabSystem.entityes.AddUser;
import com.CabSystem.CabSystem.resporitory.Adduserrepo;
import com.CabSystem.CabSystem.services.AddUserServ;

@Service
public class AddUserServiceImpl implements AddUserServ {

	@Autowired
	Adduserrepo adduserrepo;

	@Override
	public ResponseEntity<AddUser> addUser(AddUser user) {

		try {
			AddUser allusers = adduserrepo.save(user);

			return ResponseEntity.of(Optional.of(allusers));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@Override
	public ResponseEntity<List<AddUser>> getAllUser() {

		try {
			List<AddUser> getallusers = adduserrepo.findAll();

			return ResponseEntity.of(Optional.of(getallusers));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	public ResponseEntity<AddUser> getuserByid(Long id) {
		AddUser user = adduserrepo.findById(id).get();
		if (user.getId() > 0) {
			return ResponseEntity.of(Optional.of(user));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@Override
	public ResponseEntity<String> deleteUserByid(Long id) {
		try {
			adduserrepo.deleteById(id);
			return ResponseEntity.ok(id + "user deleted successfully done..");

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}

	@Override
	public ResponseEntity<AddUser> updateUserByid(AddUser user, Long id) {
		AddUser olduser=adduserrepo.findById(id).get();
		
		if(!olduser.getFirstname().isEmpty()) {
			olduser.setFirstname(user.getFirstname());
		}else if(!olduser.getLastname().isEmpty()) {
			olduser.setLastname(user.getLastname());
		}else if(!olduser.getAddress().isEmpty()) {
			olduser.setAddress(user.getAddress());
		}else if(!olduser.getEmail().isEmpty()) {
			olduser.setEmail(user.getEmail());
		}else if(!olduser.getContcact().isEmpty()) {
			olduser.setContcact(user.getContcact());
		}else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					
		}
		
		AddUser updateduser=adduserrepo.save(olduser);
		
		return ResponseEntity.of(Optional.of(updateduser));
		
	}

}
