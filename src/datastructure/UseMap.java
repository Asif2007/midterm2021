package datastructure;

import databases.ConnectDB;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;

public class UseMap {

	public static void main(String[] args) throws SQLException, IOException, ClassNotFoundException {
		/*
		 * Demonstrate how to use Map that includes storing and retrieving elements.
		 * Add List<String> into a Map. Like, Map<String, List<string>> list = new HashMap<String, List<String>>();
		 * Use For Each loop and while loop with Iterator to retrieve data.
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 */


		//implementation here
		Map<String, List<String>> list = new HashMap<String, List<String>>();
		for(int i=0; i<5; i++) {
			List<String> sublist = new ArrayList<String>();
			for(int j=0; j<6; j++) {
				sublist.add("sub word_" + i + "_" + j);
			}
			list.put("word_" + i, sublist);
		}

		for(int i=0; i<list.keySet().size(); i++) {
			String key = list.keySet().toArray()[i].toString();
			System.out.println(key);
			System.out.println(list.get(key));
		}

		//connect to database
		try	{
			ConnectDB connectDB = new ConnectDB();
			Connection connect = connectDB.connectToMySql();
			PreparedStatement ps = connect.prepareStatement("DROP TABLE IF EXISTS `word_hashmap`;");
			ps.executeUpdate();
			ps = connect.prepareStatement("CREATE TABLE `word_hashmap` (`word` varchar (255));");
			ps.executeUpdate();
			// store into mysql db
			for(int i=0; i<list.keySet().size(); i++) {
				String key = list.keySet().toArray()[i].toString();
				System.out.println(key);
				for(String st: list.get(key)) {
					connectDB.insertDataFromStringToMySql(key+":"+st, "word_hashmap", "word");
				}
			}
			// Retrieve the db table data
			List<String> db_words = connectDB.readDataBase("word_hashmap", "word");
			for(String st:db_words){
				System.out.println(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}



