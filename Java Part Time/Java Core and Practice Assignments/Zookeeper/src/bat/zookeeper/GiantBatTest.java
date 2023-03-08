package bat.zookeeper;

public class GiantBatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GiantBat bat = new GiantBat();
		
		bat.displayEnergy();
		
		bat.fly();
		bat.fly();
		bat.fly();
		bat.fly();
		bat.fly();
		
		bat.attackTown();
		
		bat.eatHumans(10);
		
		bat.attackTown();
	}

}
