package algorithm;

import databases.ConnectDB;

import java.util.List;
import java.util.Random;

import java.util.List;
import java.util.Random;
public class Numbers {

	/*
	 * Show all the different kind of sorting algorithm by applying into (num array).
	 * Display the execution time for each sorting. Example in below.
	 *
	 * Use any databases[MongoDB, Oracle, MySql] to store data and retrieve data.
	 *
	 * At the end. After running all the sorting algorithm, come to a conclusion which one is suitable on given data set.
	 *
	 */

	public static void main(String[] args) throws Exception {
		
		int [] num = new int[10];
		storeRandomNumbers(num);
		ConnectDB connectDB = new ConnectDB();
		//Selection Sort
		Sort algo = new Sort();
		algo.selectionSort(num);
		long selectionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of "+ num.length + " numbers in Selection Sort take: " + selectionSortExecutionTime + " milli sec");
        connectDB.insertDataFromArrayToMySql(num, "selection_sort", "SortingNumbers");
        List<String> numbers = connectDB.readDataBase("selection_sort", "SortingNumbers");
        printValue(numbers);
		int n = num.length;
		randomize (num, n);
		//Insertion Sort
		algo.insertionSort(num);
		long insertionSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Insertion Sort take: " + insertionSortExecutionTime + " milli sec");

		//By following above, Continue for rest of the Sorting Algorithm....
		connectDB.insertDataFromArrayToMySql(num, "insertion_sort", "SortingNumbers");
		numbers = connectDB.readDataBase("insertion_sort", "SortingNumbers");
		printValue(numbers);
		n = num.length;
		randomize (num, n);

		// bubbleSort
		algo.bubbleSort(num);
		long bubbleSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Bubble Sort take: " + bubbleSortExecutionTime + " milli sec");
		connectDB.insertDataFromArrayToMySql(num, "bubble_sort", "SortingNumbers");
		numbers = connectDB.readDataBase("bubble_sort", "SortingNumbers");
		printValue(numbers);
		n = num.length;
		randomize (num, n);

		// mergeSort
		algo.mergeSort(num);
		long mergeSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Merge Sort take: " + mergeSortExecutionTime + " milli sec");
		connectDB.insertDataFromArrayToMySql(num, "merge_sort", "SortingNumbers");
		numbers = connectDB.readDataBase("merge_sort", "SortingNumbers");
		printValue(numbers);
		n = num.length;
		randomize (num, n);

		// quickSort
		algo.quickSort(num, 0, num.length-1);
		long quickSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Quick Sort take: " + quickSortExecutionTime + " milli sec");
		connectDB.insertDataFromArrayToMySql(num, "quick_sort", "SortingNumbers");
		numbers = connectDB.readDataBase("quick_sort", "SortingNumbers");
		printValue(numbers);
		n = num.length;
		randomize (num, n);

		// heapSort
		algo.heapSort(num);
		long heapSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Heap Sort take: " + heapSortExecutionTime + " milli sec");
		connectDB.insertDataFromArrayToMySql(num, "heap_sort", "SortingNumbers");
		numbers = connectDB.readDataBase("heap_sort", "SortingNumbers");
		printValue(numbers);
		n = num.length;
		randomize (num, n);

		// bucketSort
		algo.bucketSort(num);
		long bucketSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Bucket Sort take: " + bucketSortExecutionTime + " milli sec");
		connectDB.insertDataFromArrayToMySql(num, "bucket_sort", "SortingNumbers");
		numbers = connectDB.readDataBase("bucket_sort", "SortingNumbers");
		printValue(numbers);
		n = num.length;
		randomize (num, n);

		// shellSort
		algo.shellSort(num);
		long shellSortExecutionTime = algo.executionTime;
		System.out.println("Total Execution Time of " + num.length + " numbers in Shell Sort take: " + shellSortExecutionTime + " milli sec");
		connectDB.insertDataFromArrayToMySql(num, "shell_sort", "SortingNumbers");
		numbers = connectDB.readDataBase("shell_sort", "SortingNumbers");
		printValue(numbers);
		n = num.length;
		randomize (num, n);


		//Come to conclusion about which Sorting Algo is better in given data set.
       /*
       The bubble sort.
        */
	}

	public static void storeRandomNumbers(int [] num){
		Random rand = new Random();
		for(int i=0; i<num.length; i++){
			num[i] = rand.nextInt(10);
		}
	}

	public static void randomize( int arr[], int n)
	{
		Random r = new Random();
		// Start from the last element and swap one by one. We don't
		// need to run for the first element that's why i > 0
		for (int i = n-1; i > 0; i--) {
			int j = r.nextInt(i);
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}
	public static void printValue(List<String> array){
		for(String st:array){
			System.out.println(st);
		}
	}
}
