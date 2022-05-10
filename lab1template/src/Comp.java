import java.util.Random;

public class Comp {
	Random random = new Random();
	boolean hard;
	public Comp(int compLvl) {
		if(compLvl == 0)
			hard = false;
		else
			hard = true;
	}
	
	public int play(int cardsInDeck) {
		int remove;
		int boundary;
		
		boundary = cardsInDeck/2;
		
		if(hard) {
			remove = this.searchPower(cardsInDeck, boundary);
		}
		else {
			remove = 1 + random.nextInt(boundary);
		}
		
		return remove;
	}
	
	private int searchPower(int cardsInDeck, int boundary) {
		double power = 0;
		int output;
		int n = 0;
		for(; power<=cardsInDeck ; n++) {
			power = Math.pow(2, n);
		}
		
		
		if(power-1 == cardsInDeck) {
			output = 1 + random.nextInt(boundary);
			return output;
		}
		else {
			power = Math.pow(2, n-2) - 1;
			output = (int) (cardsInDeck - power);
			return output;
		}
	}
	
}

















