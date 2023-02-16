package gorilla.zookeeper;
import mammal.zookeeper.Mammal;

public class Gorilla extends Mammal{
	public Gorilla() {
	}
	
	public void throwItem() {
		if(energy < 5) {
			System.out.println("Not enough energy!");
		}
		else {
			energy -= 5;
			System.out.println("5 energy used! Remaining energy: " + energy);
		}
	}
	
	public void climbObject() {
		if(energy < 10) {
			System.out.println("Not enough energy!");
		}
		else {
			energy -= 10;
			System.out.println("10 energy used! Remaining energy: " + energy);
		}
	}
	
	public void eatBananas() {
		if(energy > 90) {
			System.out.println("Cannot go over 100 energy!");
		}
		else {
			energy += 10;
			System.out.println("10 energy regained! Energy now at: " + energy);
		}
	}
	
	public void eatBananas(int count) {
		int totalEnergy = count * 10;
		if(energy + totalEnergy > 100) {
			System.out.println("Cannot go over 100 energy!");
		}
		else {
			energy += totalEnergy;
			System.out.println(totalEnergy + " energy regained! Energy now at: " + energy);
		}
	}
}
