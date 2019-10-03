package com.lelek;

public class QuickSort {

    private static int[] array;
    private static int arrayLength = 10;
    private static int wall;

    public static void main(String[] args) {
        array = ArrayGenerator.generate(arrayLength);
        print();
        check();
        sort(0, arrayLength - 1);
        print();
        check();
    }

    private static void sort(int startIndex, int endIndex) {
        wall = preSortAndGetWall(startIndex, endIndex);
        if (startIndex < endIndex) {
            if (wall == startIndex) {
                sort(++startIndex, endIndex);
            } else if (wall == endIndex) {
                sort(startIndex, --endIndex);
            } else {
                sort(startIndex, wall);
                sort(wall + 1, endIndex);
            }
        }
    }

    private static int preSortAndGetWall(int start, int end) {
        int pivot = array[end];
        int wall = start - 1;
        for (int i = start; i <= end; i++) {
            if (array[i] <= pivot) {
                wall++;
                int temp = array[i];
                array[i] = array[wall];
                array[wall] = temp;
            }
        }
        return wall;
    }

    private static void print() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }

    private static void check() {
        boolean sorted = false;
        for (int i = 0; i < arrayLength - 1; i++) {
            if (array[i] > array[i + 1]) {
                sorted = false;
                break;
            } else {
                sorted = true;
            }
        }
        System.out.println("Sorted " + sorted);
    }
}
