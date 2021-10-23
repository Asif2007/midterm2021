package math;

import algorithm.Sort;
import databases.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LowestNumber {

	public static void main(String[] args) {
		/*
		 * Write java solution to find the lowest number from this array.
		 * Use one of the databases from mysql or mongodb to store and to retrieve.
		 */


		//implementation here...
		int[] num = {2,4,6,7,8,3,24,85,17, 3};
		int temp = lowFunc(num);
		try {
			ConnectDB connectDB = new ConnectDB();
			Connection connect = connectDB.connectToMySql();
			PreparedStatement ps = null;
			ps = connect.prepareStatement("DROP TABLE IF EXISTS `lowest_number`;");
			ps.executeUpdate();
			ps = connect.prepareStatement("CREATE TABLE `lowest_number` (`numbers` int (11));");
			ps.executeUpdate();
			connectDB.insertDataFromStringToMySql(String.valueOf(temp), "lowest_number", "numbers");
			List<String> numbers = connectDB.readDataBase("lowest_number", "numbers");
			for(String st:numbers){
				System.out.println(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static int lowFunc(int[] num) {

		int temp = num[0];
		for(int i=1; i<num.length; i++){
			if (temp > num[i])
				temp = num[i];
		}
		for(int st:num){
			System.out.println(st);
		}
		System.out.println(temp);
		return temp;
	}
}