public class SelectionSort {
    private SelectionSort(){}
    public static <E extends Comparable<E>>void sort(E[]arr){
        for(int i=0;i<arr.length;i++){
            int minIndex=i;//选择最小值的索引
            for(int j=i;j<arr.length;j++){
                if (arr[j].compareTo(arr[minIndex])<0)
                    minIndex=j;
                }
            swap(arr,i,minIndex);
            }
        }
        private static <E>void swap(E []arr,int i,int j) {
            E t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
    }
    public static void main(String[]args){
        Integer[]arr={1,4,2,3,6,5};
        SelectionSort.sort(arr);
        for(int e: arr)
            System.out.print(e+" ");
        System.out.println();

        Student [] students={new Student("Alice",98),
                             new Student ("Bobo",100),
                             new Student( "Charles",66)};
        SelectionSort.sort(students);
        for(Student student:students)
            System.out.print(student+" ");
        System.out.println();

        int n=10000;
        Integer[]arr1=ArrayGenerator.generateRandomArray(n,n);
        SortingHelper.sortTest("SelectionSort",arr1);

        int[] dataSize={10000,100000};
        for(int i :dataSize){
            Integer[]arr2=ArrayGenerator.generateRandomArray(i,i);
            SortingHelper.sortTest("SelectionSort",arr2);
        }
    }
}
