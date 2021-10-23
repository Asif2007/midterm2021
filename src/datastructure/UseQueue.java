package datastructure;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class UseQueue {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use Queue that includes add,peek,remove,pool elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * 
		 */

		//implementation here
		Queue<String> que=new LinkedList<String>();
		que.add("first");
		que.offer("second");
		que.offer("third");
		for(int i=0; i<10; i++) {
			que.add("que"+i);
		}
		System.out.println(que.peek());
		que.remove();
		System.out.println(que.peek());
		que.remove("que7");
		System.out.println(que.poll());
		for(String st: que) {
			System.out.println(st);
		}
		System.out.println("\n===============\n");
		Iterator<String> iterator = que.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}


	}


