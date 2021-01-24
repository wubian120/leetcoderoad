package cn.bw.leetcode.practices;

/***
 * 2019-11-22
 * Heap Sort 练习
 */
public class HeapSort {

    public static void heapSort(int[] data) {

        int len = data.length;
        for(int i=len/2-1;i>=0;i--){
            heapify(data,i,len);
        }

        for(int i=len-1;i>=0;i--){
            swap(data,0,i);
            // 这个地方容易错
            heapify(data,0,i);
        }

    }

    private static void heapify(int[] data, int i, int len) {
        int root = i, left = 2 * i + 1, right = 2 * i + 2;

        if(left < len && data[left]> data[root]){
            root = left;
        }
        if(right<len && data[right]>data[root]){
            root = right;
        }
        if(root != i){
            swap(data,i,root);
            heapify(data,root,len);
        }
    }

    private static void swap(int[] data, int i, int j) {
        int t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    public static void main(String... args) {
        int[] data = {19, 9, 90, 2, 43, 12, 92, 6, 120};
        HeapSort.heapSort(data);

        System.out.println("end");
    }

}
