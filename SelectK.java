import java.util.Random;

public class SelectK {
    //给出一个无序数组，找到第k小的元素
    private static <E extends Comparable<E>> int partition(int[]arr,int l,int r,Random rnd){
        //生成【l,r】之间的随机索引
        int p=l+new Random().nextInt(r-l+1);
        swap(arr,l,p);
        //arr[l+1...j]<=v;arr[j+1...i]>=v
        int i=l+1,j=r;
        while(true){
            while (i<=j&&arr[i]<arr[l])
                i++;
            while(j>=i&&arr[j]>arr[l])
                j--;
            if(i>=j) break;
            swap(arr,i,j);
            i++;
            j--;
        }
        swap(arr,l,j);
        return j;
    }
    private static  void swap(int[]arr,int i,int j){
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
    private int SelectK(int[] arr,int l,int r,int k,Random rnd){
        int p=partition(arr,l,r,rnd);
        if(k==p) return arr[p];
        if(k<p) return SelectK(arr,l,p-1,k,rnd);
        return SelectK(arr,p+1,r,k,rnd);
    }
}
