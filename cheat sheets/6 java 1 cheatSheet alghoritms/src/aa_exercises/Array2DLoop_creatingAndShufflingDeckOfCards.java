package aa_exercises;

public class Array2DLoop_creatingAndShufflingDeckOfCards {

	public static void main(String[] args) {

		String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
		String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

		// creating deck of cards

		String[] deck = new String[RANKS.length * SUITS.length];

		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < SUITS.length; j++) {
				deck[SUITS.length * i + j] = RANKS[i] + " of " + SUITS[j];
				System.out.println(RANKS[i] + " of " + SUITS[j]);
			}
		}

		// shuffling

		int n = deck.length;
		for (int i = 0; i < n; i++) {
			int r = i + (int) (Math.random() * (n - i));
			String temp = deck[r];
			deck[r] = deck[i];
			deck[i] = temp;
		}

	}

}
