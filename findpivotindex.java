
public class findpivotindex {
    public int pivotIndex(int[] nums) {
        int[] prefix = new int[nums.length];
        if(nums == null) {
            return -1;
        }
        if(nums.length==0) {
            return -1;   
        }
        
        prefix[0]=nums[0];
        
        for(int i=1; i<nums.length; i++) {
            prefix[i]=(nums[i]+prefix[i-1]);
        }
        if(prefix[0]==prefix[nums.length-1]) {
            return 0;
        }
        
        for(int i=1; i<nums.length; i++) {
            if(prefix[i-1]==prefix[nums.length-1]-prefix[i]) {
                return i;
            }
        }
        if(prefix[nums.length-2]==0 && nums.length-2>=0) {
            return nums.length-1;
        }
         return -1;
    }
   
}