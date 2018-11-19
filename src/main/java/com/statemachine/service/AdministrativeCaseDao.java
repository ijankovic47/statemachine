package com.statemachine.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class AdministrativeCaseDao {

	private AdministrativeCase ac1=new AdministrativeCase();
	private AdministrativeCase ac2=new AdministrativeCase();
	private AdministrativeCase ac3=new AdministrativeCase();
	public AdministrativeCase getCase(Long adminCaseId) {
		if(adminCaseId==1) {
			System.out.println("Citamo ac1, trenutno stanje = "+ac1.getS().name());
			return ac1;
		}
		if(adminCaseId==2) {
			System.out.println("Citamo ac2, trenutno stanje = "+ac2.getS().name());
			return ac2;
		}
		else {
			System.out.println("Citamo ac3, trenutno stanje = "+ac3.getS().name());
			return ac3;
		}
	}
	public List<AdministrativeCase> getAll(){
		return Arrays.asList(ac1, ac2, ac3);
	}
	
}
