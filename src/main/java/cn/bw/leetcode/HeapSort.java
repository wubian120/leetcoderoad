package cn.bw.leetcode;

/**
 * @description:
 * @auther: bian.wu
 * @date: 2019/4/25 23:28
 */
public class HeapSort {

    public static void heapSort(int[] data) {
        int len = data.length;
        for (int i = len / 2 - 1; i >= 0; i--) {
            heapify(data, i, len);
        }

        for (int i = len - 1; i >= 0; i--) {
            swap(data, i, 0);
            heapify(data, 0, i);
        }

    }

    private static void heapify(int[] data, int i, int len) {
        int root = i, left = 2 * i + 1, right = 2 * i + 2;

        if (left < len && data[left] > data[root])
            root = left;
        if (right < len && data[right] > data[root])
            root = right;

        if(root != i){
            swap(data,root,i);
            heapify(data,root,len);
        }

    }

    private static void swap(int[] d, int i, int j) {
        int t = d[i];
        d[i] = d[j];
        d[j] = t;
    }


    public static void main(String... args) {


        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSort.heapSort(data);

        System.out.println("end");

    }
}
