
public class Car {
	private int gas;
	
	public Car() {
		this.gas = 10;
	}

	public int getGas() {
		return gas;
	}

	public void setGas(int gas) {
		this.gas = gas;
	}
	public void drive() {
		if(this.gas < 1) {
			System.out.println("Not enough gas!");
		}
		else {
			this.gas -= 1;
			if (this.gas == 0) {
				System.out.println("Your car reached 0 gas, game over!");
			}
			else {
			System.out.println("You drove the car. Gas is now at: " + getGas());
			}
		}
	}
	public void boost() {
		if(this.gas < 3) {
			System.out.println("Not enough gas!");
		}
		else {
			this.gas -= 3;
			if (this.gas == 0) {
				System.out.println("Your car reached 0 gas, game over!");
			}
			else {
			System.out.println("You boosted the car! Gas is now at: " + getGas());
			}
		}
	}
	
	public void refuel() {
		if(this.gas > 8) {
			System.out.println("Gas cannot go above 10!");
		}
		else {
			this.gas += 2;
			System.out.println("You refueled the car. Gas is now at: " + getGas());
		}
	}
}
