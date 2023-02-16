package com.caresoft.models;

import com.caresoft.interfaces.HIPAACompliantUser;
import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
	private ArrayList<String> patientNotes;
	
	// CONSTRUCTOR //
	public Physician(Integer id) {
		super(id);
	}
	
	// INTERFACE METHODS //
	public boolean assignPin(int pin) {
		int length = String.valueOf(pin).length();
		if(length != 4) {
			return false;
		}
		else {
			return true;
		}
	}
	public boolean accessAuthorized(Integer confirmedAuthID) {
		if(confirmedAuthID == id) {
			return true;
		}
		else {
			return false;
		}
	}
	
	// GETTERS AND SETTERS //
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }
	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}

}
