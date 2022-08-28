package oIteratorCustom;

public class DinerMenuIterator implements BIterator {

	AMenuItem[] items;
	int position = 0;

	public DinerMenuIterator(AMenuItem[] items) {
		this.items = items;
	}

	@Override
	public Object next() {
		AMenuItem menuItem = items[position];
		position = position + 1;
		return menuItem;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.length || items[position] == null) {
			return false;
		} else {
			return true;
		}
	}

}
