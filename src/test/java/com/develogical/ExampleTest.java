package com.develogical;

import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.fail;

public class ExampleTest {

//	@beforeClass
//	public void ClassInitialzie(){
//
//	}
//
//	@before
//	void TestInitialize(){
//
//	}

	@Test
	public void ListShouldBeEmptyWhenInitialized() {

		assertThat(new Example().ListSize(), is(0));
	}

	@Test
	public void AddNewItemShouldGiveNewSizeOfTheList() {

		Example recentlyUsedList = new Example();
		assertThat(recentlyUsedList.AddItem(1), is(1));
		assertThat(recentlyUsedList.AddItem(3), is(2));
		assertThat(recentlyUsedList.AddItem(5), is(3));
		assertThat(recentlyUsedList.AddItem(7), is(4));
	}

	@Test
	public void AddingAnExisitngItemShouldBringExistingToTheFront() {

		Example recentlyUsedList = new Example();
		recentlyUsedList.AddItem(1);
		recentlyUsedList.AddItem(3);
		recentlyUsedList.AddItem(5);
		recentlyUsedList.AddItem(3);

		assertThat(recentlyUsedList.RecentlyUsedItems.get(0), is(3));
		assertThat(recentlyUsedList.ListSize(), is(3));
	}

	@Test
	public void RetrieveShouldReturnLastAddedItem()
	{
		Example recentlyUsedList = new Example();
		recentlyUsedList.AddItem(1);
		recentlyUsedList.AddItem(3);

		assertThat(recentlyUsedList.RetrieveItem(), is(3));
		assertThat(recentlyUsedList.RetrieveItem(), is(1));
	}

	@Test
	public void RetrieveOnEmptyListShouldRaiseIllegalStateException()
	{
		Example recentlyUsedList = new Example();
		try
		{
			recentlyUsedList.RetrieveItem();
			fail();
		}
		catch (IllegalStateException exception){
			assertThat( exception.getMessage(), is("List is Empty"));
		}
	}
}
