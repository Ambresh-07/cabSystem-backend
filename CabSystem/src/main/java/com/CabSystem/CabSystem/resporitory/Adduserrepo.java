package com.CabSystem.CabSystem.resporitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CabSystem.CabSystem.entityes.AddUser;

@Repository
public interface Adduserrepo extends JpaRepository<AddUser,Long>{

}
