
package sort;

import java.util.Arrays;
import java.util.List;

public class Sorts {

    // 回合比较次数
    private static int lessCount = 0;

    // 回合交换次数
    private static int exchCount = 0;

    /**
     * 比较.
     */
    private static <T extends Comparable<? super T>> boolean less(T element, T element2) {
        lessCount++;
        return element.compareTo(element2) < 0;
    }

    /**
     * 交换.
     */
    private static <T extends Comparable<? super T>> void exch(List<T> l, int i, int j) {
        exchCount++;
        T temp = l.get(i);
        l.set(i, l.get(j));
        l.set(j, temp);
    }

    /**
     * 是否已排序. 
     */
    private static <T extends Comparable<? super T>> boolean isSorted(List<? extends T> c) {
        for (int i = 1; i < c.size(); i++) {
            if (c.get(i).compareTo(c.get(i - 1)) < 0) {
                return false;
            }
        }
        return true;
    }


    private static void resetCount() {
        lessCount = 0;
        exchCount = 0;
    }

    public static <T extends Comparable<? super T>> void quickSort(List<? extends T> c) {

    }

    public static <T extends Comparable<? super T>> void mergeSort(List<? extends T> c) {

    }

    /**
     * <pre>
     * 插入排序.（扑克）
     * 
     * date: 2014年8月20日
     * </pre>
     * @author yandeli
     * @param l         待排序集合
     * @param inPro     每轮排序过后的信息处理器
     */
    public static <T extends Comparable<? super T>> void insertionSort(List<? extends T> l, InfoProducer inPro) {
        for (int i = 1; i < l.size(); i++) {
            for (int j = i; j > 0 && less(l.get(j), l.get(j - 1)); j--) {
                exch(l, j, j - 1);
            }
        }
    }

    /**
     * <pre>
     * 选择排序.（轮选）
     * 
     * date: 2014年8月20日
     * </pre>
     * @author yandeli
     * @param l         待排序集合
     * @param inPro     每轮排序过后的信息处理器
     */
    public static <T extends Comparable<? super T>> void selectionSort(List<? extends T> l, InfoProducer inPro) {
        
        // 排序之前输出一下信息.
        inPro.show(l);
        
        for (int i = 0; i < l.size(); i++) {
            int minIndex = i;
            for (int j = i + 1; j < l.size(); j++) {
                if (less(l.get(j), l.get(minIndex))) {
                    minIndex = j;
                }
            }
            exch(l, i, minIndex);
            
            // 每轮排序后输出一下信息.
            inPro.show(l);
        }
    }

    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(1, 3, 2, 4);
        selectionSort(l, new ConsoleInfo());
        
        //        insertionSort(l, new ConsoleInfo());
    }

    private static class ConsoleInfo implements InfoProducer {
        @Override
        public <T extends Comparable<? super T>> void show(List<? extends T> l) {
            System.out.println(l);
            System.out.println("Less count: " + lessCount);
            System.out.println("Exch count: " + exchCount);
            System.out.println("Is sorted: " + isSorted(l));
        }

    }

}
