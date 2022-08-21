public class Sortcolors {
    public  void sortcolors(int[]nums){
        int zero=-1,i=0,two=nums.length;
        while(i<two){
            if(nums[i]==0){
                zero++;
                swap(nums,zero,i);
                i++;
            }
            else if(nums[i]==2) {
                two--;
                swap(nums,i,two);
            }
            else
                i++;
        }
    }
    private void swap(int[]nums,int i,int j){
        int t=nums[i];
        nums[i]=nums[j];
        nums[j]=t;
    }
}
