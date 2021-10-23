package math;

import databases.ConnectDB;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumber {

	public static void main(String[] args) {
		/*
		 * Find list of Prime numbers from number 2 to 1 million.
		 * Try the best solution as possible.Which will take less CPU life cycle.
		 * Out put number of Prime numbers on the given range.
		 *
		 *
		 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
		 *
		 */

		//implementation here...
		int maxval = 100000;
		int[] arr = primeFunc(maxval);
		try {
			ConnectDB connectDB = new ConnectDB();
			connectDB.insertDataFromArrayToMySql(arr, "prime_tbl", "SortingNumbers");
			List<String> numbers = connectDB.readDataBase("prime_tbl", "SortingNumbers");
			for(String st:numbers){
				System.out.println(st);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public static int[] primeFunc(int maxval) {
		ArrayList<Integer> num = new ArrayList<>();
		for(int i=2; i<maxval; i++) {
			boolean flag = true;
			//check if n is a multiple of 2
			if (i % 2 == 1) {
				for (int j = 3; j * j <= i; j += 2) {
					if (i % j == 0)
						flag = false;
				}
				if (flag == true) {
					num.add(i);
				}
			}
		}
		int[] arr = new int[num.size()];
		int idx = 0;
		for(int val: num) {
			arr[idx] = val;
			idx ++;
		}
		return arr;

	}

}
