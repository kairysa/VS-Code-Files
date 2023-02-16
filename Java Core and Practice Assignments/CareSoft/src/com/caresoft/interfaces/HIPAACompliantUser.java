package com.caresoft.interfaces;

public interface HIPAACompliantUser {
    abstract boolean assignPin(int pin);
    abstract boolean accessAuthorized(Integer confirmedAuthID);
}

