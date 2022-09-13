package com.bae.main.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.main.entities.SerialKillerProject.SerialKiller;

@Repository
public interface SerialKillerProjectRepo extends JpaRepository<SerialKiller, Long> {
	

}
