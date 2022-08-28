
/*
Imagine an arbitrary tree of People objects like 
[{id: 2, parent_id: 3}, {id: 3, parent_id: 5}, ...]. 
Write an algorithm that will find top hierarchy layer(s)
Notes: parent_id might be other Person id or null
 */

package aa_exercises;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class TreeLoopRecursion_ReturnTopParent {

	public static void main(String[] args) {

		ArrayList<HashMap<String, Integer>> list = testData();

		solution1(list);

		System.out.println();

		solution2(list);

		System.out.println();

		solution3(list);

	}

	public static ArrayList<HashMap<String, Integer>> testData() {

		ArrayList<HashMap<String, Integer>> list = new ArrayList<>();

		HashMap<String, Integer> obj1 = new HashMap<>();
		obj1.put("id", 1);
		obj1.put("parent_id", null);
		list.add(obj1);

		HashMap<String, Integer> obj2 = new HashMap<>();
		obj2.put("id", 2);
		obj2.put("parent_id", null);
		list.add(obj2);

		HashMap<String, Integer> obj3 = new HashMap<>();
		obj3.put("id", 3);
		obj3.put("parent_id", 1);
		list.add(obj3);

		HashMap<String, Integer> obj4 = new HashMap<>();
		obj4.put("id", 4);
		obj4.put("parent_id", 2);
		list.add(obj4);

		HashMap<String, Integer> obj5 = new HashMap<>();
		obj5.put("id", 5);
		obj5.put("parent_id", 2);
		list.add(obj5);

		HashMap<String, Integer> obj6 = new HashMap<>();
		obj6.put("id", 6);
		obj6.put("parent_id", 3);
		list.add(obj6);

		HashMap<String, Integer> obj7 = new HashMap<>();
		obj7.put("id", 7);
		obj7.put("parent_id", 3);
		list.add(obj7);

		HashMap<String, Integer> obj8 = new HashMap<>();
		obj8.put("id", 8);
		obj8.put("parent_id", 4);
		list.add(obj8);

		HashMap<String, Integer> obj9 = new HashMap<>();
		obj9.put("id", 9);
		obj9.put("parent_id", 5);
		list.add(obj9);

		return list;

	}

	public static ArrayList<HashMap<String, Integer>> solution1(ArrayList<HashMap<String, Integer>> list) {

		System.out.println("Solution 1: checking for top level elements only (trivial solution)");
		ArrayList<HashMap<String, Integer>> topLevelElements = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Integer> tmpData = (HashMap<String, Integer>) list.get(i);
			if (tmpData.get("parent_id") == null) {
				topLevelElements.add(tmpData);
				System.out.println(tmpData.toString());
			}
		}
		return topLevelElements;
	}

	public static HashSet<HashMap<String, Integer>> solution2(ArrayList<HashMap<String, Integer>> list) {

		System.out.println("Solution 2: tree traversal");
		System.out.println("original\t\t\ttop parent");
		HashSet<HashMap<String, Integer>> topLevelElements2 = new HashSet<>();

		loop1: for (int i = 0; i < list.size(); i++) {
			HashMap<String, Integer> original = (HashMap<String, Integer>) list.get(i);
			HashMap<String, Integer> tmpData = original;
			loop2: while (true) {
				Integer id = tmpData.get("parent_id");
				if (id == null) {
					topLevelElements2.add(tmpData);
					if (original == tmpData) {
						System.out.println(original.toString() + "\t\t" + "null");
					} else {
						System.out.println(original.toString() + "\t\t" + tmpData.toString());
					}
					continue loop1;
				} else {
					for (int j = 0; j < list.size(); j++) {
						HashMap<String, Integer> tmpData2 = (HashMap<String, Integer>) list.get(j);
						Integer id2 = tmpData2.get("id");
						if (id2.equals(id)) {
							tmpData = tmpData2;
							continue loop2;
						}
					}
				}
			}
		}
		return topLevelElements2;
	}

	public static HashMap<String, Integer> recursion(ArrayList<HashMap<String, Integer>> list,
			HashMap<String, Integer> map) {
		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Integer> tmpData = (HashMap<String, Integer>) list.get(i);
			if (map.get("parent_id") == tmpData.get("id")) {
				return recursion(list, tmpData);
			} else if (map.get("parent_id") == null) {
				return map;
			}
		}
		return null;
	}

	public static HashSet<HashMap<String, Integer>> solution3(ArrayList<HashMap<String, Integer>> list) {

		System.out.println("Solution 3: recursion");
		System.out.println("original\t\t\ttop parent");
		HashSet<HashMap<String, Integer>> topLevelElements2 = new HashSet<>();

		for (int i = 0; i < list.size(); i++) {
			HashMap<String, Integer> tmpData = (HashMap<String, Integer>) list.get(i);
			Integer id = tmpData.get("parent_id");
			if (id == null) {
				topLevelElements2.add(tmpData);
				System.out.println(tmpData.toString() + "\t\t" + "null");
			} else {
				HashMap<String, Integer> tmpData2 = recursion(list, tmpData);
				topLevelElements2.add(tmpData2);
				System.out.println(tmpData.toString() + "\t\t" + tmpData2.toString());
			}
		}
		return topLevelElements2;
	}

}
