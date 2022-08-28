package aa_exercises;

import java.util.HashSet;

public class UnionFindQuickFindLoop_determineEarliestTimeAtWhichAllFriendsWereConnected {

	/*
	 * dynamic connectivity problem - union find
	 * Social network connectivity. Given a social network containing n members and
	 * a log file containing m time stamps at which times pairs of members formed
	 * friendships, design an algorithm to determine the earliest time at which all
	 * members are connected (i.e., every member is a friend of a friend of a friend
	 * ... of a friend).
	 * 
	 * Assume that the log file is sorted by time stamp and that friendship is an
	 * equivalence relation. The running time of your algorithm should be mlog⁡nm
	 * \log n m log n or better and use extra space proportional to n.
	 */

	private int[] id; // access to component id (site indexed)
	private int count; // number of components

	public UnionFindQuickFindLoop_determineEarliestTimeAtWhichAllFriendsWereConnected(int N) { // Initialize component id array.
		count = N;
		id = new int[N];
		for (int i = 0; i < N; i++)
			id[i] = i;
	}

	public int count() {
		return count;
	}

	public boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	public int find(int p) {
		return id[p];
	}

	public void union(int p, int q) { // Put p and q into the same component.
		int pID = find(p);
		int qID = find(q);
		// Nothing to do if p and q are already in the same component.
		if (pID == qID)
			return;
		// Rename p’s component to q’s name.
		for (int i = 0; i < id.length; i++)
			if (id[i] == pID)
				id[i] = qID;
		count--;
	}
	// See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).

	public static void main(String[] args) {

		int n = 8;
		UnionFindQuickFindLoop_determineEarliestTimeAtWhichAllFriendsWereConnected uf = new UnionFindQuickFindLoop_determineEarliestTimeAtWhichAllFriendsWereConnected(n); // Initialize N components.
		// pairs of students sorted by time at which become friends
		int[][] ts = { { 1, 2 }, { 3, 4 }, { 4, 5 }, { 6, 7 }, { 2, 4 }, { 5, 7 }, { 0, 6 }, { 0, 7 } };

		// set for checking if all elements are present
		HashSet<Integer> set = new HashSet<>();

		for (int[] i : ts) {
			int p = i[0];
			int q = i[1];

			if (uf.connected(p, q)) {
				continue; // Ignore if connected.
			}
			uf.union(p, q); // Combine components

			// add all elements to set
			set.add(p);
			set.add(q);
			// if equal that current step i a solution
			if (set.size() == n) {
				System.out.println("all elements at step " + p + " " + q);
			}

		}

	}

}
