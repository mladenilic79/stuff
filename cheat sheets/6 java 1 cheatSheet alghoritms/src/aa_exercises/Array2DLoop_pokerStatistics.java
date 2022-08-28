package aa_exercises;

public class Array2DLoop_pokerStatistics {

	public static void main(String[] args) {

		/*
		 * 2.2.26 Poker analysis. Write a StdRandom and StdStats client (with
		 * appropriate static methods of its own) to estimate the probabilities of
		 * getting one pair, two pair, three of a kind, a full house, and a flush in a
		 * five-card poker hand via simulation. Divide your program into appropriate
		 * static methods and defend your design decisions. Extra credit : Add straight
		 * and straight flush to the list of possibilities.
		 */

		String[] RANKS = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
		String[] deck = new String[RANKS.length * 4];
		for (int i = 0; i < RANKS.length; i++) {
			for (int j = 0; j < 4; j++) {
				deck[4 * i + j] = RANKS[i];
//				System.out.println(RANKS[i]);
			}
		}

		float total = 0;
		float counter = 0;

		while (true) {

			// shuffling
			for (int i = 0; i < 5; i++) {
				int r = i + (int) (Math.random() * (deck.length - i));
				String temp = deck[r];
				deck[r] = deck[i];
				deck[i] = temp;
			}

			// pair
//			total++;
//			for(int i=0; i<4; i++) {
//				for(int j=i+1; j<5; j++) {
//					if(deck[i]==deck[j]) {
//						counter++;
//					}
//				}
//			}

			// triling
//			total++;
//			for (int i = 0; i < 3; i++) {
//				for (int j = i + 1; j < 4; j++) {
//					for (int k = i + 2; k < 5; k++) {
//						if (deck[i] == deck[j] && deck[i] == deck[k]) {
//							counter++;
//						}
//					}
//				}
//			}

			// poker
			total++;
			for (int i = 0; i < 2; i++) {
				for (int j = i + 1; j < 3; j++) {
					for (int k = i + 2; k < 4; k++) {
						for (int l = i + 3; l < 5; l++) {
							if (deck[i] == deck[j] && deck[i] == deck[k] && deck[i] == deck[l]) {
								counter++;
							}
						}
					}
				}
			}

			float verovatnoca = counter / total;
			System.out.println("total " + total + "\tcounter " + counter + "\tverovatnoca " + verovatnoca);

		}

	}

}
