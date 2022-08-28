package aa_exercises;

import java.util.Stack;

public class StackLoop_pairingUpParentheses {

	public static void main(String[] args) {

		/*
		 * 4.3.6 Write a stack client Parentheses that reads a string of parentheses,
		 * square brackets, and curly braces from standard input and uses a stack to
		 * determine whether they are properly balanced. For example, your program
		 * should print true for [()]{}{[()()]()} and false for [(]).
		 */

		String string = "[()]{}{[()()]()}";

		Stack<Character> stack2 = new Stack<>();

		for(int i=0; i<string.length(); i++){
			
			char temp = string.charAt(i);
			stack2.push(temp);
			
			System.out.println();
			System.out.println(string);
			for (char j : stack2) {
				System.out.print(j);
			}System.out.println();

			if (stack2.size() > 1) {

				System.out.println("stack 2 izabran par");
				System.out.println(stack2.get(stack2.size() - 2) + " " + stack2.get(stack2.size() - 1));

				if (stack2.get(stack2.size() - 2) == '[' && stack2.get(stack2.size() - 1) == ']') {
					stack2.pop();
					stack2.pop();
				} else if (stack2.get(stack2.size() - 2) == '(' && stack2.get(stack2.size() - 1) == ')') {
					stack2.pop();
					stack2.pop();
				} else if (stack2.get(stack2.size() - 2) == '{' && stack2.get(stack2.size() - 1) == '}') {
					stack2.pop();
					stack2.pop();
				}
			}
		}
		
		boolean sol;

		if (stack2.size()==0) {
			sol = true;
		} else {
			sol = false;
		}

		System.out.println();
		System.out.println(sol);

	}

}
