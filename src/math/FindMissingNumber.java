package math;

/**
 * Created by mrahman on 04/22/17.
 */
public class FindMissingNumber {

    public static void main(String[] args) {
        /*
         * If n = 10, then array will have 9 elements in the range from 1 to 10.
         * For example {10,2,1, 4, 5, 3, 7, 8, 6}. One number will be missing in array (9 in this case).
         * Write java code to find the missing number from the array. Write static helper method to find it.
         */


        //implementation here...
int[] numbers = {1,2,3,4,5,6,7,8,10};

int N = 10;
int idealSum = (N *(N+1)) / 2;
int sum = calculateSum(numbers);

int missingNumbers = idealSum - sum;
System.out.println("The missing number: ");
System.out.println(missingNumbers);
    }

    private static int calculateSum(int[] numbers) {
int sum = 0;
for (int n: numbers) {
    sum += n;

}

return sum;

    }



}
