package rCompositeIterator;

import java.util.Iterator;
import java.util.Stack;

public class CompositeIterator implements Iterator {

	/*
	The iterator of the top level composite we’re going to iterate over is
	passed in. We throw that in a stack data structure
	*/
	Stack stack = new Stack();

	public CompositeIterator(Iterator iterator) {
		stack.push(iterator);
	}

	/*
	Okay, when the client wants to get the next element we first make sure there 
	is one by calling hasNext()
	If there is a next element, we get the current iterator off the stack and
	get its next element
	If that element is a menu, we have another composite that needs to be
	included in the iteration, so we throw it on the stack. In either case, we 
	return the component
	 */
	public Object next() {
		if (hasNext()) {
			Iterator iterator = (Iterator) stack.peek();
			AMenuComponent component = (AMenuComponent) iterator.next();
			if (component instanceof BMenu) {
				stack.push(component.createIterator());
			}
			return component;
		} else {
			return null;
		}
	}

	/*
	To see if there is a next element, we check to see if the stack is empty; if 
	so, there isn’t. Otherwise, we get the iterator off the top of the stack and 
	see if it has a next element. If it doesn’t we pop it off the stack and call 
	hasNext() recursively. Otherwise there is a next element and we return true
	 */
	public boolean hasNext() {
		if (stack.empty()) {
			return false;
		} else {
			Iterator iterator = (Iterator) stack.peek();
			if (!iterator.hasNext()) {
				stack.pop();
				return hasNext();
			} else {
				return true;
			}
		}
	}

	public void remove() {
		throw new UnsupportedOperationException();
	}

}
