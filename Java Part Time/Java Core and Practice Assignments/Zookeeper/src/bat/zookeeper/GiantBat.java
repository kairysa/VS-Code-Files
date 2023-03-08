package bat.zookeeper;
import mammal.zookeeper.Mammal;

public class GiantBat extends Mammal{
	public GiantBat() {
		energy = 300;
	}
	
	public void fly() {
		if(energy < 50) {
			System.out.println("Not enough energy!");
		}
		else {
			energy -= 50;
			System.out.println("50 energy used! Remaining energy: " + energy);
		}
	}
	
	public void attackTown() {
		if(energy < 100) {
			System.out.println("Not enough energy!");
		}
		else {
			energy -= 100;
			System.out.println("100 energy used! Remaining energy: " + energy);
		}
	}
	
	public void eatHumans() {
		if(energy > 275) {
			System.out.println("Cannot go over 300 energy!");
		}
		else {
			energy += 25;
			System.out.println("25 energy regained! Energy now at: " + energy);
		}
	}
	
	public void eatHumans(int count) {
		int totalEnergy = count * 25;
		if(energy + totalEnergy > 300) {
			System.out.println("Cannot go over 300 energy!");
		}
		else {
			energy += totalEnergy;
			System.out.println(totalEnergy + " energy regained! Energy now at: " + energy);
		}
	}
}
