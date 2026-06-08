package Day8;

import java.util.HashMap;

public class CountSubarray {
    public int subarraysWithXorK(int[] nums, int k) {
      HashMap<Integer, Integer> map = new HashMap<>();
        
        int xor = 0;
        int count = 0;
        map.put(0, 1);
        
        for(int num : nums) {
            
            xor = xor ^ num;
            int x = xor ^ k;
            
            if(map.containsKey(x)) {
                count += map.get(x);
            }
            
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        
        return count;
    }
}
