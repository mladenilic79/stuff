package aa_exercises;

public class UnionFindQuickUnionLoop_findLargestElementsInConnectedComponentGroup {

	/*
	 * Union-find with specific canonical element. Add a method find() to the
	 * union-find data type so that find(i) returns the largest element in the
	 * connected component containing i. The operations, union(), connected(), and
	 * find() should all take logarithmic time or better. For example, if one of the
	 * connected components is {1,2,6,9}, then the find() method should return 9 for
	 * each of the four elements in the connected components.
	 * 
	 */

	private int[] id; // access to component id (site indexed)
	private int count; // number of components

	public UnionFindQuickUnionLoop_findLargestElementsInConnectedComponentGroup(int N) { // Initialize component id array.
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

	private int find(int p) { // Find component name.
		while (p != id[p])
			p = id[p];
		return p;
	}
	
	private int findLargest(int p, int[][] arr) { // Find largest element
		int largest = -999999;
		int parentP = find(p);
		System.out.println("parentP " + parentP);
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[i].length; j++) {
				int parentI = find(arr[i][j]);
				System.out.println("parentI " + parentI);
				if(parentP==parentI) {
					if(arr[i][j]>largest) {
						largest=arr[i][j];
					}
				}
			}
			
		}
		return largest;
	}

	public void union(int p, int q) { // Give p and q the same root.
		int pRoot = find(p);
		int qRoot = find(q);
		if (pRoot == qRoot)
			return;
		id[pRoot] = qRoot;
		count--;
	}
	// See page 222 (quick-find),page 224 (quick-union) andpage 228 (weighted).

	public static void main(String[] args) {

		int n = 8;
		UnionFindQuickUnionLoop_findLargestElementsInConnectedComponentGroup uf = new UnionFindQuickUnionLoop_findLargestElementsInConnectedComponentGroup(n); // Initialize N components.
		int[][] ts = { { 1, 2 }, { 3, 4 }, { 4, 5 }, { 6, 7 } };

		for (int[] i : ts) {
			int p = i[0];
			int q = i[1];

			if (uf.connected(p, q)) {
				continue; // Ignore if connected.
			}
			uf.union(p, q); // Combine components

		}
		
		int largest = uf.findLargest(3, ts);
		System.out.println(largest);

	}

}
