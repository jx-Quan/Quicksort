import java.util.Arrays;

//自底向上的归并排序算法
public class MergeSort2 {
    private MergeSort2(){}

    public static <E extends Comparable<E>>void sort(E[] arr){
        //sort(arr,0,arr.length-1,0);
        E []temp=Arrays.copyOf(arr,arr.length);
        sort(arr,0,arr.length-1,temp);
    }
    private static <E extends Comparable<E>>void sort(E[] arr,int l,int r,E[]temp){
        if(l>=r) return;

        int mid=l+(r-l)/2;//防止超出整型变量范围
        sort(arr,l,mid,temp);
        sort(arr,mid+1,r,temp);
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r,temp);
    }
    public static <E extends Comparable<E>>void sortBU(E[]arr){
        E[] temp=Arrays.copyOf(arr,arr.length);
        int n=arr.length;
        //遍历合并的区间长度
        for(int size=1;size<n;size++){
            //遍历合并的两个区间的起始位置i
            //合并[i,i+size]和[i+size,i+size+size-1]
            for(int i=0;;i+=size+size)
                if(arr[i+size-1].compareTo(arr[i+size])>0)
                    merge(arr,i,i+size-1,Math.min(i+size+size-1,n-1),temp);
        }
    }
    private static <E extends Comparable<E>>void merge(E[]arr,int l,int mid,int r,E[]temp){
        System.arraycopy(arr,l,temp,l,r-l+1);
        int i=l,j=mid+1;
        //每轮循环为arr[k]赋值
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k]=temp[j];
                j++;
            }
            else if(j>r){
                arr[k]=temp[i];
            }
            else if(temp[i].compareTo(temp[j])<=0){
                arr[k]=temp[i];
                i++;
            }
            else{
                arr[k]=temp[j];
                j++;
            }
        }
    }


    public static void main(String[] args){
        int n=100000;
        Integer[] arr1=ArrayGenerator.generateRandomArray(n,n);
        Integer []arr2=Arrays.copyOf(arr1,arr1.length);
        SortingHelper.sortTest("MergeSort",arr1);
        SortingHelper.sortTest("MergeSortBU",arr2);
    }
}
