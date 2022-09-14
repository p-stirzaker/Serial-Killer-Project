package com.bae.main.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bae.main.entities.SerialKillerProject;

@Repository
public interface SerialKillerProjectRepo extends JpaRepository<SerialKillerProject, Long> {
	
	List<SerialKillerProject> findSerialKillerByFirstName(String firstName);
	
	List<SerialKillerProject> findSerialKillerByLastName(String lastName);
	
	List<SerialKillerProject> findSerialKillerByPlace(String place);
	
	SerialKillerProject findSerialKillerByConfirmedKills(int confirmedKills);
	
	List<SerialKillerProject> findSerialKillerByZodiacSign(String zodiacSign);
}
