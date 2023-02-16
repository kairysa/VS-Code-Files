package com.caresoft.models;

import java.util.ArrayList;
import java.util.Date;

import com.caresoft.interfaces.HIPAACompliantAdmin;
import com.caresoft.interfaces.HIPAACompliantUser;

public class AdminUser extends User implements HIPAACompliantUser, HIPAACompliantAdmin {
	private String role;
    private ArrayList<String> securityIncidents = new ArrayList<String>();

	public AdminUser(Integer id, String role) {
		super(id);
		this.role = role;
	}
	public ArrayList<String> reportSecurityIncidents() {
		return securityIncidents;
	}
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		if(length != 6) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(this.id != confirmedAuthID) {
			authIncident();
			return false;
		}
		else {
			return true;
		}
	}
	public void newIncident(String notes) {
        String report = String.format(
            "Datetime Submitted: %s \n,  Reported By ID: %s\n Notes: %s \n", 
            new Date(), this.id, notes
        );
        securityIncidents.add(report);
    }
	public void authIncident() {
        String report = String.format(
            "Datetime Submitted: %s \n,  ID: %s\n Notes: %s \n", 
            new Date(), this.id, "AUTHORIZATION ATTEMPT FAILED FOR THIS USER"
        );
        securityIncidents.add(report);
    }
	
	
	public String getRole() {
		return role;
	}
	public ArrayList<String> getSecurityIncidents() {
		return securityIncidents;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setSecurityIncidents(ArrayList<String> securityIncidents) {
		this.securityIncidents = securityIncidents;
	}

}
