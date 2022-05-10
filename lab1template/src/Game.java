import java.util.Scanner;

public class Game {
	int cardsInDeck = 0;
	int botLvl = -1; // 0 for stupid, 1 for smart, -1 for neither
	int turn = -1; //0 for human, 1 for computer, -1 for neither
	int temp; // just an empty variable for utility
	Scanner input = new Scanner(System.in);
	Comp bot;
	
	public void setCardsInDeck(int value) {
		this.cardsInDeck = value;
	}
	public int getCardsInDeck() {
		return this.cardsInDeck;
	}
	
	public void setBotLvl(int value) {
		this.botLvl = value;
	}
	public int getBotLvl() {
		return this.botLvl;
	}
	
	public void setTurn(int value) {
		this.turn = value;
	}
	public int getTurn() {
		return this.turn;
	}
	
	
	private void setup() {
		
		System.out.println("Number of cards: ");
		this.setCardsInDeck(input.nextInt());
		while(this.getBotLvl() == -1) {
			System.out.println("Enter 0 if the computer plays in stupid mode, 1 for smart mode:");
			temp = input.nextInt();
			switch(temp) {
			case 0:
				this.setBotLvl(temp);
				System.out.println("Computer is playing in stupid mode");
				break;
			case 1:
				this.setBotLvl(temp);
				System.out.println("Computer is playing in smart mode");
				break;
			}
		}
		do {
			System.out.println("Enter 0 if the human stars,  1 if computer starts:");
			temp = input.nextInt();
			if(temp == 0 || temp == 1) {
				this.setTurn(temp);
			}
		}while(this.getTurn() == -1);
		
	}
	
	private void rmCards(int player) {
		int tobeRemoved = 0;
		if(player == 0) {
			do{
				System.out.println("Your turn.  How many you want to remove:");
				tobeRemoved = input.nextInt();
			} while(tobeRemoved <= 0 || (tobeRemoved > this.getCardsInDeck()/2));
			this.setTurn(1);
		}
		else {
			tobeRemoved = bot.play(this.getCardsInDeck());
			System.out.printf("Computer removed %d cards%n", tobeRemoved);
			this.setTurn(0);
		}
		
		this.setCardsInDeck(this.getCardsInDeck() - tobeRemoved);
	}
	
	private boolean playTurn(int player) {
		boolean gameOver = false;
		System.out.printf("There are %d cards left%n", this.getCardsInDeck());
		this.rmCards(player);
		
		//check if it is over
		if(this.getCardsInDeck() == 1)
			gameOver = true;
		return gameOver;
	}
	
	public void play() {
		this.setup();
		this.bot = new Comp(botLvl);
		boolean gameOver;
		do {
			gameOver = playTurn(turn);
		}while(gameOver != true);
		
		if(turn == 0)
			System.out.println("Computer Wins");
		else
			System.out.println("Human Wins");
	}
	


	

}
