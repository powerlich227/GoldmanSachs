/* Problem Name is &&& Deque &&& PLEASE DO NOT REMOVE THIS LINE. */
/**
* Instructions:
*
*  1) Implement a double-ended queue (abbreviated to deque) that stores strings. 
*  A deque is a data structure that has characteristics of both a queue and a stack. 
*  Elements can be added or removed from either the front or back.
* 
*  2) Consider adding some additional tests in doTestsPass()
*/

public class DesignDeque {
	  
	static class Deque {
	    ListNode front, rear;
	    int size;
	    Deque() {
	    	front = rear = null;
	    	size = 0;
	    }
	    public void addFirst(String data) {
	    	ListNode newNode = new ListNode(data);
	    	newNode.pre = newNode.next = null;
	    	if (front == null) {
	    		front = rear = newNode;
	    	}
	    	else {
	    		newNode.next = front;
	    		front.pre = newNode;
	    		front = newNode;
	    	}
	    	size++;
	    	// throw new RuntimeException("method not implemented");
	    }

	    public void addLast(String data) {
	    	ListNode newNode = new ListNode(data);
	    	newNode.pre = newNode.next = null;
	    	if (rear == null)
	    		rear = front = newNode;
	    	else {
	    		newNode.pre = rear;
	    		rear.next = newNode;
	    		rear = newNode;
	    	}
	    	size++;
	    	// throw new RuntimeException("method not implemented");
	    }

	    public String removeFirst() {
	    	if (front == null) {
	    		System.out.println("The deque is empty");
	    		return null;
	    	}
	    	String res = front.data;
	    	front = front.next;
	    	
	    	if (front == null)
	    		rear = null;
	    	else
	    		front.pre = null;
	    	
	    	size--;
		    return res;
		    // throw new RuntimeException("method not implemented");
	    }

	    public String removeLast() {
	    	if (rear == null) {
	    		System.out.println("The deque is empty");
	    		return null;
	    	}
	    	String res = rear.data;
	    	rear = rear.pre;
	    	
	    	if (rear == null)
	    		front = null;
	    	else
	    		rear.next = null;
	    	
	    	size--;
		    return res;
		    // throw new RuntimeException("method not implemented");
	    }

	    public String peekFirst() {
	    	if (front == null) {
	    		System.out.println("The deque is empty");
	    		return null;
	    	}
	    	return front.data;
	    	// throw new RuntimeException("method not implemented");
	    }

	    public String peekLast() {
	    	if (rear == null) {
	    		System.out.println("The deque is empty");
	    		return null;
	    	}
	    	return rear.data;
	    	// throw new RuntimeException("method not implemented");
	    }

	    public int size() {
	    	return size;
	    	// throw new RuntimeException("method not implemented");
	    }
	    
	}
	private static class ListNode {
		String data;
		ListNode pre, next;
		ListNode(String data) {
			this.data = data;
		}
	}
	public static void main(String[] args) {
		try {
			doTestsPass();
		    System.out.println("All tests passed");
		} catch (Exception ex) {
		    System.out.println("Test failed");
		    ex.printStackTrace();
		}
	}

	private static void doTestsPass() throws Exception {

		final Deque deque = new Deque();

		// enqueue
		deque.addFirst("a");
		deque.addFirst("a");
		deque.addLast("b");

		assertTrue("b".equals(deque.removeLast()), "RemoveLast should return b");
		assertTrue("a".equals(deque.removeFirst()), "RemoveFirst should return a");
		assertTrue(deque.size() == 1, "Test failed, size should be 1");
		assertTrue("a".equals(deque.peekFirst()), "First element should be 'a'");
		assertTrue("a".equals(deque.peekLast()), "Last element should be 'a'");
	};

	private static void assertTrue(boolean condition, String message) throws Exception {
		if (!condition)
			throw new Exception(message);
	}
}
