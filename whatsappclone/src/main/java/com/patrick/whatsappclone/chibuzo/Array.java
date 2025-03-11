package com.patrick.whatsappclone.chibuzo;

import java.util.Arrays;

public class Array {
    public static int[] evenAndOddFunction(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = (arr[i] % 2 == 0) ? 0 : 1;
        }
        return result;
    }
    public  static void main(String[] args) {
        int[] numbers = {4, 5, 8, 8, 8, 2, 9};
        int[] binaryArray = evenAndOddFunction(numbers);
        System.out.println(Arrays.toString(binaryArray));
    }

}

