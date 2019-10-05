package com.lelek;

import java.util.Arrays;

public class QuickSort {

    private static final int ARRAY_LENGTH = 20;
    private static final boolean UNIQUE = true;
    private static final boolean NOT_UNIQUE = false;

    public static void main(String[] args) {
        int[] uniqueNumbersArray = ArrayGenerator.generate(ARRAY_LENGTH, UNIQUE);
        int[] notUniqueNumbersArray = ArrayGenerator.generate(ARRAY_LENGTH, NOT_UNIQUE);

        printArray(uniqueNumbersArray);
        sort(uniqueNumbersArray, 0, uniqueNumbersArray.length - 1);
        printArray(uniqueNumbersArray);

        printArray(notUniqueNumbersArray);
        sort(notUniqueNumbersArray, 0, notUniqueNumbersArray.length - 1);
        printArray(notUniqueNumbersArray);
    }

    private static void sort(int[] array, int startIndex, int endIndex) {
        int divisionIndex = getDivisionIndex(array, startIndex, endIndex);
        if (startIndex < endIndex) {
            if (divisionIndex == startIndex) {
                sort(array, ++startIndex, endIndex);
            } else if (divisionIndex == endIndex) {
                sort(array, startIndex, --endIndex);
            } else {
                sort(array, startIndex, divisionIndex);
                sort(array, divisionIndex + 1, endIndex);
            }
        }
    }

    private static int getDivisionIndex(int[] array, int start, int end) {
        int pivot = array[end];
        int divisionIndex = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                divisionIndex++;
                int temp = array[i];
                array[i] = array[divisionIndex];
                array[divisionIndex] = temp;
            }
        }
        return divisionIndex;
    }

    private static void printArray(int[] array) {
        if (ifSorted(array)) {
            System.out.println("Sorted array:\n" + Arrays.toString(array) + "\n");
        } else {
            System.out.println("Unsorted array:\n" + Arrays.toString(array));
        }
    }

    // returns true if array is sorted, and false if unsorted
    private static boolean ifSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
