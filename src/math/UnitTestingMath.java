package math;

import org.testng.Assert;

public class UnitTestingMath {
    public static void main(String[] args) {
        //Apply Unit testing into each classes and methods in this package.

        //Factorial
        Factorial fact = new Factorial();
        try {
            Assert.assertEquals(fact.factFunc(5), 120);
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            Assert.assertEquals(fact.factFunc(6), 720);
        }catch(Exception ex){
            ex.getMessage();
        }
        //Fibonacci
        Fibonacci fibo = new Fibonacci();
        try {
            Assert.assertEquals(fibo.fibonacciFunc(40), 102334155);
        }catch(Exception ex){
            ex.getMessage();
        }


        //Find missing number
        FindMissingNumber missing = new FindMissingNumber();
        try {
            int[] numbers = {1,2,3,4,5,6,7,8,10};
            Assert.assertEquals(missing.missingFunc(numbers), 9);
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            int[] numbers = {1,2,4,5,6,7,8,9,10};
            Assert.assertEquals(missing.missingFunc(numbers), 3);
        }catch(Exception ex){
            ex.getMessage();
        }
        //Lowest number
        LowestNumber low = new LowestNumber();

        try {
            int[] num = {2,4,6,7,8,3,24,85,17, 3};
            Assert.assertEquals(low.lowFunc(num), 2);
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            int[] num = {29,4,6,7,8,3,24,85,17, 3};
            Assert.assertEquals(low.lowFunc(num), 3);
        }catch(Exception ex){
            ex.getMessage();
        }
        //Pyramid
        MakePyramid pyr = new MakePyramid();
        try {
            Assert.assertEquals(pyr.pyramidFunc(5), 25);
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            Assert.assertEquals(pyr.pyramidFunc(6), 36);
        }catch(Exception ex){
            ex.getMessage();
        }

        //Pattern
        Pattern pat = new Pattern();
        int[] arr = {100,99,98,97,96,95,94,93,92,91,90,88,86,84,82,80,78,76,74,72,70,67,64,61,58,55,52,49,46,43,40,36,32, 28, 24, 20, 16, 12, 8, 4,0};
        try {
            Assert.assertEquals(pat.patternFunc(), arr);
        }catch(Exception ex){
            ex.getMessage();
        }

        //Prime number
        PrimeNumber prime = new PrimeNumber();
        try {
            int[] arr1 = {3,5,7};
            Assert.assertEquals(prime.primeFunc(10), arr1);
        }catch(Exception ex){
            ex.getMessage();
        }
        try {
            int[] arr1 = {3,5,7,11,13};
            Assert.assertEquals(prime.primeFunc(15), arr1);
        }catch(Exception ex){
            ex.getMessage();
        }
    }
}
