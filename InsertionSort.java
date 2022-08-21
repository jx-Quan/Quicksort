import java.util.Arrays;

public class InsertionSort {

    private InsertionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {

        for (int i = 0; i < arr.length; i++) {

            //将arr[i]插入到合适的位置
 //           for (int j = i; j - 1 >= 0; j--) {
 //               if (arr[j].compareTo(arr[j - 1]) < 0)
 //                   swap(arr, j, j - 1);
 //               else break;
 //           }
            for(int j=i;j-1>=0&&arr[j].compareTo(arr[j-1])<0;j--)
                swap(arr,j,j-1); //与上述注释掉方法相同
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr,int l,int r) {

        for (int i = l; i <=r; i++) {
            //将arr[i]插入到合适的位置
            E t=arr[i];//暂存要排序数
            int j;
            for(j=i;j-1>=l&&t.compareTo(arr[j-1])<0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=t;
        }
    }
    public static <E extends Comparable<E>> void sort3(E[] arr) {

        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            E t=arr[i];//暂存要排序数
            int j;
            for(j=i;j-1>=0&&t.compareTo(arr[j-1])<0;j--){
                arr[j]=arr[j-1];
            }
            arr[j]=t;
        }
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {

        int[] dataSize = {10000, 100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            Integer[] arr2= Arrays.copyOf(arr,arr.length);
            SortingHelper.sortTest("InsertionSort", arr);
            SortingHelper.sortTest("InsertionSort2", arr2);
        }
    }
}

