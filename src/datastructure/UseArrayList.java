package datastructure;

import databases.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class UseArrayList {

	public static void main(String[] args) {
		/*
		 * Demonstrate how to use ArrayList that includes add,peek,remove,retrieve elements.
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 * Store all the sorted data into one of the databases.
		 *
		 */

		//implementation here
		ArrayList<String> list = new ArrayList<>();
		for(int i=0; i<10; i++) {
			list.add("word_" + i);
		}
		System.out.println(list.contains("word_7"));
		System.out.println(list.contains("word_17"));
		list.remove("word_8");
		System.out.println(list.get(3));

		for(String st: list) {
			System.out.println(st);
		}

		//connect to db
		try	{
			ConnectDB connectDB = new ConnectDB();
			Connection connect = connectDB.connectToMySql();
			PreparedStatement ps = connect.prepareStatement("DROP TABLE IF EXISTS `word_arraylist`;");
			ps.executeUpdate();
			ps = connect.prepareStatement("CREATE TABLE `word_arraylist` (`word` varchar (255));");
			ps.executeUpdate();
			// store into mysql db
			for(String st: list) {
				connectDB.insertDataFromStringToMySql(st, "word_arraylist", "word");
			}
			// Retrieve the db table data
			List<String> db_words = connectDB.readDataBase("word_arraylist", "word");
			for(String st:db_words){
				System.out.println(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
