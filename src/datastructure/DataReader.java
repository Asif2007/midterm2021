package datastructure;
import databases.ConnectDB;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


public class DataReader {

	public static void main(String[] args) {
		/*
		 * User API to read the below textFile and print to console.
		 * Use BufferedReader class. 
		 * Use try....catch block to handle Exception.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 * After reading from file using BufferedReader API, store each word into Stack and LinkedList. So each word
		 * should construct a node in LinkedList.Then iterate/traverse through the list to retrieve as FIFO
		 * order from LinkedList and retrieve as FILO order from Stack.
		 *
		 * Demonstrate how to use Stack that includes push,peek,search,pop elements.
		 * Use For Each loop/while loop/Iterator to retrieve data.
		 */

		//implementation here
		Deque<String> stack = new ArrayDeque<String>();
		LinkedList linkedList = new LinkedList();
		String[] words;
		ConnectDB connectDB = new ConnectDB();

		try {
			Connection connect = connectDB.connectToMySql();
			PreparedStatement ps = null;
			ps = connect.prepareStatement("DROP TABLE IF EXISTS `file_word_stack`;");
			ps.executeUpdate();
			ps = connect.prepareStatement("CREATE TABLE `file_word_stack` (`word` varchar (255));");
			ps.executeUpdate();
			FileReader in = new FileReader("src/data/self-driving-car");
			BufferedReader br = new BufferedReader(in);
			String line = br.readLine();
			while (line!=null) {
				words = line.split(" ");
				int i = 0 ;
				while (i < words.length){
					// push to stack
					stack.push(words[i]);
					// add to linked list
					linkedList.add(words[i]);
					// store into mysql db
					connectDB.insertDataFromStringToMySql(words[i], "file_word_stack", "word");
					i ++;
				}
				line = br.readLine();
			}
			in.close();

			// Retrieve the db table data
			List<String> db_words = connectDB.readDataBase("file_word_stack", "word");
			for(String st:db_words){
				System.out.println(st);
			}
			// Iterate the stack
			while (stack.size() > 0) {
				String item = stack.pop();
				System.out.println(item);
			}
			// push,peek,search,pop elements of the stack
			stack.push("sample");
			System.out.println(stack.peek());
			System.out.println(stack.contains("sample"));
			System.out.println(stack.pop());

			// Iterate the linked list
			Iterator<LinkedList.Node> iterator = linkedList.iterator();
			while (iterator.hasNext()) {
				System.out.println(iterator.next().getData());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class LinkedList implements Iterable{
	private Node node;
	public void add(Object data){
		if(!Optional.ofNullable(node).isPresent()){
			node = new Node();
			node.setData(data);
		}else{
			Node node = new Node();
			node.setData(data);
			Node lastNode = getLastNode(this.node);
			lastNode.setNext(node);
		}
	}

	private Node getLastNode(Node node){
		if(node.getNext()==null){
			return node;
		}else{
			return getLastNode(node.getNext());
		}
	}

	class Node{
		private Object data;
		private Node next;
		public Object getData() {
			return data;
		}
		public void setData(Object data) {
			this.data = data;
		}
		public Node getNext() {
			return next;
		}
		public void setNext(Node next) {
			this.next = next;
		}
	}

	public Iterator iterator() {
		return new NodeIterator();
	}

	class NodeIterator implements Iterator{
		private Node current;

		public boolean hasNext() {
			if(current == null){
				current = node;
				return Optional.ofNullable(current).isPresent();
			}else{
				current = current.next;
				return Optional.ofNullable(current).isPresent();
			}
		}

		public Node next() {
			return current;
		}
	}
}

