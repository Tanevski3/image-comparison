package com.mtanevski.imagecomparison.javafx;

public class MainEntry1 {

    public static int max(int[] numbers) {
        // choosing the minimum value as a starting point so we can compare initially
        int savedMax = Integer.MIN_VALUE;
        // iterating numbers array to compare each value with the next one
        for (int i = 0; i < numbers.length; i++) {
            // get maximum number of a number in the array and his successor e.g. arr[0] , arr[1]; arr[1] , arr[2]
            int max = m(numbers[i], numbers[i + 1]);
            // compares it to the already saved maximum number and updates the maximum number
            savedMax = m(max, savedMax);
            if (i + 2 == numbers.length) {
                break;
            }
        }
        return savedMax;
    }

    public static void main(String[] args) {
        // t1
        System.out.println(max(new int[]{10123123, 12312320, 3760, -4, -50}));
        // t2
        System.out.println(max(new int[]{10, 20, 30, 40, 50}));
        // t3
        System.out.println(max(new int[]{-10, -20, -30, -40, -50}));
    }

    static int m(int a, int b){
        return a > b ? a : b;
    }
}