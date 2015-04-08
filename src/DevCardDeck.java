import java.util.Random;

//CJ

public class DevCardDeck{
	
	private int cardsInDeck;
	private int[] cardTypes;

	// 0 = 14 Knights 
	// 1 = 5 Victory Points
	// 2 = 2 Road Building Cards
	// 3 = 2 Monopoly Cards
	// 4 = 2 Year of Plenty Cards	

	public DevCardDeck(){
		cardsInDeck = 25;
		cardTypes = new int[5];

		cardTypes[0] = 14;
		cardTypes[1] = 5;
		cardTypes[2] = 2;
		cardTypes[3] = 2;
		cardTypes[4] = 2;
	}

	public int drawDevCheck(){
		if (cardsInDeck == 0)
			return 10;
		return 0;
	}

	public int drawDevCard(){
	//returns the int of the devcard drawn as keyd above 

		//This is actually random

		Random rand = new Random();

		cardsInDeck--;

		while(true){
			int x = rand.nextInt(cardsInDeck);
			if(x<cardTypes[0]){
				cardTypes[0]--;
				return 0;
			}
			else if(x<cardTypes[0]+cardTypes[1]){
				cardTypes[1]--;
				return 1;
			}
			else if(x<cardTypes[0]+cardTypes[1]+cardTypes[2]){
				cardTypes[2]--;
				return 2;
			}
			else if(x<cardTypes[0]+cardTypes[1]+cardTypes[2]+cardTypes[3]){
				cardTypes[3]--;
				return 3;
			}
			else{
				cardTypes[4]--;
				return 4;
			}
		}

		//this is not really random because it is not based on how many of each card are in the deck but random enough
		/*Random rand = new Random();

		cardsInDeck--;

		while(true){
			int x = rand.nextInt(5);
			if (cardTypes[x]>0){
				cardTypes[x]--;
				//this is because the numbering is different here since there is not a desert
				return x;
			}
		}*/

		

	}

}