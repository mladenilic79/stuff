package oIteratorCustom;

import java.util.ArrayList;

public class PancakeHouseMenuIterator implements BIterator {

	ArrayList items;
	int position = 0;

	public PancakeHouseMenuIterator(ArrayList items) {
		this.items = items;
	}

	@Override
	public Object next() {
		AMenuItem menuItem = (AMenuItem) items.get(position);
		position = position + 1;
		return menuItem;
	}

	@Override
	public boolean hasNext() {
		if (position >= items.size() || items.get(position) == null) {
			return false;
		} else {
			return true;
		}
	}

}
