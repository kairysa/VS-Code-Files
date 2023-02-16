package com.demo.models;
import com.demo.interfaces.ACPowerable;

public class Heater implements ACPowerable {
 
 public Integer fanSpeedPercent = 0;
 public Integer heatSettingPercent = 0;
 public Boolean isPluggedIn = false;
 public Integer maxWattage;
 
 public Heater(Integer maxWattage) {
     this.maxWattage = maxWattage;
 }
 
 public void applySettings(Integer fanSpeedPercent, Integer heatSettingPercent) {
     this.fanSpeedPercent = fanSpeedPercent;
     this.heatSettingPercent = heatSettingPercent;
 }
 
 public void plugIn() {
     isPluggedIn = true;
 }
 
 public void unPlug() {
     isPluggedIn = false;
 }
 
 public boolean checkPluggedIn() {
     return isPluggedIn;
 }
 
 public void checkPowerConsumption() {
     if(isPluggedIn) {
         Double power = 0.0;
         // assuming both fan and heater contribute evenly to power consumption
         power += maxWattage * 0.5 * fanSpeedPercent * 0.01;
         power += maxWattage * 0.5 * heatSettingPercent * 0.01;
         System.out.println("The heater is consuming " + power + " Watts!");
     } else {
         System.out.println("The heater isn't plugged in!");
     }
 }
}

