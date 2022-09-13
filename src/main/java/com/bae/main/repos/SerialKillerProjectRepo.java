package com.bae.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.main.entities.SerialKillerProject.SerialKiller;

@Repository
public interface SerialKillerProjectRepo extends JpaRepository<SerialKiller, Long> {
	
	List<SerialKiller> findSerialKillerByFirstName(String firstName);
	
	List<SerialKiller> findSerialKillerByLastName(String lastName);
	
	List<SerialKiller> findSerialKillerByPlace(String place);
	
	SerialKiller findSerialKillerByConfirmedKills(int confirmedKills);
	
	List<SerialKiller> findSerialKillerByZodiacSign(String zodiacSign);
}
