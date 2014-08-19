package sort;

import java.util.Arrays;
import java.util.Collections;

public class Sorts {
    private static int lessCount = 0;
    private static int exchCount = 0;
    
    private static boolean less (Comparable c, Comparable c2) {
        lessCount++;
        return c.compareTo(c2) < 0;
    }
    
    private static void exch (Comparable[] array, int i, int j) {
        exchCount++;
        Comparable temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    private static boolean isSorted(Comparable[] c) {
        for (int i=1; i<c.length; i++) {
            if (less(c[i], c[i - 1])) {
                return false;
            }
        }
        return true;
    }
    
    private static void show (Comparable[] c) {
        System.out.println(Arrays.toString(c));
        System.out.println("Less count: " + lessCount);
        System.out.println("Exch count: " + exchCount);
        System.out.println("Is sorted: " + isSorted(c));
        resetCount();
    }
    
    private static void resetCount() {
        lessCount = 0;
        exchCount = 0;
    }
    
    public static void quickSort(Comparable[] c) {
        
    }
    
    public static void mergeSort(Comparable[] c) {
        
    }
    
    public static void insertionSort(Comparable[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (less(c[j], c[j - 1])) {
                    exch(c, j, j-1);
                } else {
                    break;
                }
            }
        }
    }
    
    public static void selectionSort(Comparable[] c) {
        for (int i = 0; i < c.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < c.length; j++) {
                if (less(c[j], c[minIndex])) {
                    minIndex = j;
                }
            }
            
            exch(c, i, minIndex);
        }
    }
    
    public static void main(String[] args) {
        Comparable[] c = {1, 5, 5, 7, 8, 23, 2, 3, 5, 3, 6, 7, 0};
        show(c);
        insertionSort(c);
        show(c);
        selectionSort(c);
        show(c);
    }
}
