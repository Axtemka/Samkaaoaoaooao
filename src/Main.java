// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int[] data;

        data = random_fill(10000, 1000);
        System.out.println(Arrays.toString(data));

        final long start_time = System.currentTimeMillis();
        //bubble_sort(data);
        //insertionSort(data);
        //quickSort(data, 0, data.length-1);
        final long end_time = System.currentTimeMillis();
        System.out.println(Arrays.toString(data));
        System.out.println(end_time-start_time);

    }

    public static void bubble_sort(int[] data) {
        for (int i = data.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (data[j] > data[j + 1]) {
                    int tmp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = tmp;
                }
            }
        }
    }

    public static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int currElem = a[i];
            int prevKey = i - 1;
            while (prevKey >= 0 && a[prevKey] > currElem) {
                a[prevKey + 1] = a[prevKey];
                prevKey--;
            }
            a[prevKey+1] = currElem;
        }
    }

    public static void quickSort(int[] a, int low, int high) {
        if (a.length == 0)
            return; // завершение выполнение алгоритма, если длина массива равна 0
        if (low >= high)
            return; // завершение выполнение алгоритма, если уже нечего делить
        // выбор опорного элемента
        int middle = low + (high - low) / 2;
        int op = a[middle];
        // разделить на подмассивы, который больше и меньше опорного элемента
        int i = low, j = high;
        while (i <= j) {
            while (a[i] < op) {
                i++;
            }
            while (a[j] > op) {
                j--;
            }                if (i <= j) { // меняем элементы местами
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        // вызов рекурсии для сортировки левой и правой части
        if (low < j)
            quickSort(a, low, j);
        if (high > i)
            quickSort(a, i, high);
    }

    public static int[] random_fill(int size, int dp) {
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = (int) (Math.random() * dp);
        }
        return data;
    }
}