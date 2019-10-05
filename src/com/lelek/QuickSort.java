package com.lelek;

public class QuickSort {

    private static final int ARRAY_LENGTH = 10;

    public static void main(String[] args) {
        int [] array = ArrayGenerator.generate(ARRAY_LENGTH);
        print(array);
        System.out.println("Sorted " + checkIfSorted(array));
        sort(array, 0, array.length - 1);
        print(array);
        System.out.println("Sorted " + checkIfSorted(array));
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

    private static void print(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static boolean checkIfSorted(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1]) {
                return false;
            }
        }
        return true;
    }
}
