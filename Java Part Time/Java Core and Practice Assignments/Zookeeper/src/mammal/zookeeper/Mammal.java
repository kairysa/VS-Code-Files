package mammal.zookeeper;

public class Mammal {
	protected int energy;
	
	public Mammal() {
		this.setEnergy(100);
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}
	
	public int displayEnergy() {
		System.out.println(energy);
		return energy;
	}
}
