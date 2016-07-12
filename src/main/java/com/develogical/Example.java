package com.develogical;

import java.util.ArrayList;

public class Example {

	public ArrayList<Integer> RecentlyUsedItems = null;

	public Example(){
		RecentlyUsedItems = new ArrayList<Integer>();
	}

	public int ListSize()
	{
		return RecentlyUsedItems.size();
	}

	public int AddItem(int item){

		Integer existingIndex = RecentlyUsedItems.lastIndexOf(item);
		if(existingIndex == 0)
			return RecentlyUsedItems.size();

		if(existingIndex>0) {
			RecentlyUsedItems.remove(existingIndex);
			RecentlyUsedItems.add(0, item);
		}
		else
		RecentlyUsedItems.add(0, item);

		return RecentlyUsedItems.size();
	}

	public Integer RetrieveItem(){

		if(RecentlyUsedItems.size() == 0)
			throw new IllegalStateException("List is Empty");

		return RecentlyUsedItems.remove(0);
	}
}
