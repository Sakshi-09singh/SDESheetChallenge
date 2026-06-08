package Day8;

import java.util.HashMap;

public class LargestSubarray {
    public int longestSubarray(int[] nums, int k) {
       HashMap<Long, Integer> map = new HashMap<>();
        
        long sum = 0;
        int maxLen = 0;
        
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) {
                maxLen = i + 1;
            }
            
            if(map.containsKey(sum - k)) {
                int len = i - map.get(sum - k);
                maxLen = Math.max(maxLen, len);
            }
            
            if(!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        
        return maxLen;
    }
}
