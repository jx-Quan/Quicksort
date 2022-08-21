import java.util.Arrays;

public class MergeSort {
    private MergeSort(){}

    public static <E extends Comparable<E>>void sort(E[] arr){
        //sort(arr,0,arr.length-1,0);
        sort(arr,0,arr.length-1);
    }
    private static <E extends Comparable<E>>void sort(E[] arr,int l,int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;//防止超出整型变量范围
        sort(arr,l,mid);
        sort(arr,mid+1,r);
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge(arr,l,mid,r);
    }


    public static <E extends Comparable<E>>void sort2(E[] arr){
        //sort(arr,0,arr.length-1,0);
        sort(arr,0,arr.length-1);
    }
    private static <E extends Comparable<E>>void sort2(E[] arr,int l,int r){
        if(l>=r) return;
        int mid=l+(r-l)/2;//防止超出整型变量范围
        sort2(arr,l,mid);
        sort2(arr,mid+1,r);
        merge(arr,l,mid,r);
    }


    public static <E extends Comparable<E>>void sort3(E[] arr){
        //sort(arr,0,arr.length-1,0);
        sort(arr,0,arr.length-1);
    }
    private static <E extends Comparable<E>>void sort3(E[] arr,int l,int r){
        //if(l>=r) return;
        if(r-l<=15){
            InsertionSort.sort2(arr,l,r);
            return;
        }
        int mid=l+(r-l)/2;//防止超出整型变量范围
        sort3(arr,l,mid);
        sort3(arr,mid+1,r);
        merge(arr,l,mid,r);
    }
    /*private static <E extends Comparable<E>>void sort(E[] arr,int l,int r,int depth){
        String depthString=generateDepthString(depth);//生成深度字符串
        System.out.println(depthString);//打印当前sort处理的数组区间信息
        System.out.println(String.format("mergesort arr[%d ,%d]",l,r));
        if(l>=r) return;
        int mid=l+(r-l)/2;//防止超出整型变量范围
        sort(arr,l,mid,depth+1);
        sort(arr,mid+1,r,depth+1);
        System.out.print(depthString);//打印这次merge要处理的区间范围
        System.out.println(String.format("merge arr[%d ,%d] and arr[%d, %d]",1,mid,mid+1,r));
        merge(arr,l,mid,r);
        System.out.print(depthString);//打印merge后数组
        System.out.println(String.format("after mergesort arr[%d ,%d]：",l,r));
        for(E e:arr)
            System.out.print(e+"--");
        System.out.println();
    }
    private static String generateDepthString(int depth){
        StringBuilder res=new StringBuilder();
        for(int i=0;i<depth;i++)
            res.append("--");
        return res.toString();
    }*/
    //合并两个有序区间arr[l,mid]和arr[mid+1,r]
    private static <E extends Comparable<E>>void merge(E[]arr,int l,int mid,int r){
        E[]temp= Arrays.copyOfRange(arr,l,r+1);
        int i=l,j=mid+1;
        //每轮循环为arr[k]赋值
        for(int k=l;k<=r;k++){
            if(i>mid){
                arr[k]=temp[j-l];
                j++;
            }
            else if(j>r){
                arr[k]=temp[i-l];
            }
            else if(temp[i-l].compareTo(temp[j-l])<=0){
                arr[k]=temp[i-l];
                i++;
            }
            else{
                arr[k]=temp[j-l];
                j++;
            }
        }
    }


    public static <E extends Comparable<E>>void sort4(E[] arr){
        //sort(arr,0,arr.length-1,0);
        E []temp=Arrays.copyOf(arr,arr.length);
        sort4(arr,0,arr.length-1,temp);
    }
    private static <E extends Comparable<E>>void sort4(E[] arr,int l,int r,E[]temp){
        if(l>=r) return;
        int mid=l+(r-l)/2;//防止超出整型变量范围
        sort4(arr,l,mid,temp);
        sort4(arr,mid+1,r,temp);
        if(arr[mid].compareTo(arr[mid+1])>0)
            merge4(arr,l,mid,r,temp);
    }
    private static <E extends Comparable<E>>void merge4(E[]arr,int l,int mid,int r,E[]temp){
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
        Integer []arr3=Arrays.copyOf(arr1,arr1.length);
        Integer []arr4=Arrays.copyOf(arr1,arr1.length);
          //Integer[] arr1={7,1,4,2,8,3,6,5};
        SortingHelper.sortTest("MergeSort",arr1);
        SortingHelper.sortTest("MergeSort2",arr2);//对有序数组，优化为o(n)算法
        SortingHelper.sortTest("MergeSort3",arr3);//插入排序优化
        SortingHelper.sortTest("MergeSort4",arr3);//内存优化
        //SortingHelper.sortTest("InsertionSort",arr2);
        //SortingHelper.sortTest("SelectionSort",arr3);
    }
}
