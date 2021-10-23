package math;
import java.util.Scanner;

public class MakePyramid {
    public static void main(String[] args) {

        //   Implement a large Pyramid of stars in the screen with java.
        //
        //                    *
        //                   * *
        //                  * * *
        //                 * * * *
        //                * * * * *
        //               * * * * * *


        //implementation here...
        int i, space, rows, k=0;
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter number of rows :");
        rows = scan.nextInt();
        pyramidFunc(rows);

    }

    public static int pyramidFunc(int rows) {
        int total = 0;
        int i, space, k=0;
        for(i=1; i<=rows; i++)
        {
            for(space=1; space<=(rows-i); space++)
            {
                System.out.print("");
            }
            while(k != (2*i-1))
            {
                System.out.print("*");
                k++;
                total ++;
            }
            k = 0;
            System.out.println();
        }
        return total;
    }
}