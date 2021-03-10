package datastruct;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

class MyUnsortedListTest {

	private final int DEFAULT_TIMEOUT = 5000;
	

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testIsEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertTrue("new list", list.isEmpty());
		list.append(123);
		assertFalse("list after one add", list.isEmpty());
		list.pop();
		assertTrue("list after one add+remove", list.isEmpty());
	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testSize() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		assertEquals("size new list", 0, list.size());
		list.append(123);
		assertEquals("size list after one add", 1, list.size());
		list.pop();
		assertEquals("size list after one add+remove", 0, list.size());
		
		Random r = new Random(50);
		int n = r.nextInt(50);
		for(int i=0; i< n; i++) {
			list.append(123);
		}
		assertEquals("size list after n add", n, list.size());
	
	}	

	
	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testPrepend() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.prepend(4);
		assertEquals("prepend 4", (Integer) 4, list.pop());
		assertTrue("list poped of element prepended", list.isEmpty());
		list.append(1);
		list.append(2);
		list.prepend(5);
		list.append(3);
		assertEquals("prepend 5", (Integer) 5, list.pop());

	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testAppend() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(4);
		assertEquals("append 4", (Integer) 4, list.popLast());
		assertTrue("list poped of element prepended to see if append do only one element", list.isEmpty());
		list.prepend(1);
		list.prepend(2);
		list.append(5);
		list.prepend(3);
		assertEquals("append 5, see if order works", (Integer) 5, list.popLast());	
		list.append(5);
		list.append(5);
		list.append(5);
		list.append(5);
		assertEquals("size list after append", 7, list.size());
	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testInsert() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(1);
		list.append(2);
		list.append(3);
		list.insert(4, 2);
		list.popLast();
		assertEquals("insert 4", (Integer) 4, list.popLast());
	}
	
	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testInsertOutOfRange() {
		
		UnsortedList<Integer> list = MyUnsortedList.of();

		 Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			    list.insert(4, 3);
			  });
		 
	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testPop() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(1);
		assertEquals("pop 1", (Integer) 1, list.pop());
		assertTrue("list poped of element append", list.isEmpty());
		list.append(8);
		list.append(2);
		list.append(3);
		list.append(4);
		assertEquals("pop 8", (Integer) 8, list.pop());
		list.prepend(7);
		assertEquals("pop 7", (Integer) 7, list.pop());
		
	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testPopEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();

		 Assertions.assertThrows(datastruct.EmptyListException.class, () -> {
			    list.pop();
			  });
			 
	}
	
	
	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testPopLast() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(1);
		assertEquals("popLast 1", (Integer) 1, list.popLast());
		list.append(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.popLast();
		assertEquals("popLast 4", (Integer) 3, list.popLast());

	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testPopLastEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();

		 Assertions.assertThrows(datastruct.EmptyListException.class, () -> {
			    list.popLast();
			  });
			 
	}
	
	
	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testRemove() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		list.append(1);
		list.remove(0);
		assertTrue("The only element removed", list.isEmpty());

		
		Random r = new Random(50);
		int n = r.nextInt(50);
		for(int i=0; i< n; i++) {
			list.append(123);
		}
		list.remove(0);

		assertEquals("Size after 1 remove", n-1, list.size());


	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testRemoveEmpty() {
		
		UnsortedList<Integer> list = MyUnsortedList.of();

		 Assertions.assertThrows(datastruct.EmptyListException.class, () -> {
			    list.remove(0);
			  });
		 
	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testRemoveOutOfRange() {
		
		UnsortedList<Integer> list = MyUnsortedList.of();

		 Assertions.assertThrows(IndexOutOfBoundsException.class, () -> {
			    list.remove(3);
			  });
		 
	}
	

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testEqualsObjectEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of();

		assertTrue("empty List equals empty List", list.equals(list2));
	}
	
	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testEqualsObjectEmptynotEmpty() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of();

		list.append(5);
		list2.append(5);
		assertTrue("not empty List equals not empty List", list.equals(list2));
	}
	
	
	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testEqualsObject() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of();

		list2.append(5);
		assertFalse("empty List equals not empty List", list.equals(list2));
		list.append(5);
		list.append(5);
		assertFalse("not empty List not equals not empty List", list.equals(list2));
	}

	@Test
	@Timeout(DEFAULT_TIMEOUT)
	void testToString() {
		UnsortedList<Integer> list = MyUnsortedList.of();
		UnsortedList<Integer> list2 = MyUnsortedList.of();

		list.append(5);
		list2.append(5);
		
		assertTrue("not empty toString equals not empty toString", list.toString().equals(list2.toString()));

		
	}

}
