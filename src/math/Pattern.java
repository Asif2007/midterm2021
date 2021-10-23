package math;

import databases.ConnectDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Pattern {

	public static void main(String[] args) {
		/* Read this numbers, find the pattern then implement the logic from this pattern.which will give you this output.
		 * 100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32............
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */

		//implementation here...
		int[] arr = patternFunc();

		try {
			ConnectDB connectDB = new ConnectDB();
			connectDB.insertDataFromArrayToMySql(arr, "pattern_tbl", "SortingNumbers");
			List<String> numbers = connectDB.readDataBase("pattern_tbl", "SortingNumbers");
			for (String st : numbers) {
				System.out.println(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int[] patternFunc() {
		int value = 100;
		ArrayList<Integer> num = new ArrayList<>();
		num.add(value);
		int idx = 0;
		for (int i = 1; i <= 10; i++) {
			for (int j = 0; j < 10; j++) {
				idx++;
				value -= i;
				if (value >= 0) {
					num.add(value);
				} else
					break;

			}
		}
		int[] arr = new int[num.size()];
		idx = 0;
		for (int val : num) {
			arr[idx] = val;
			idx++;
		}
		return arr;
	}
}
