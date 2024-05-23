// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :
//This is what is confusing
/*             if(map.containsKey(rSum)){
                map.put(rSum, map.get(rSum) + 1);
            }
            else { 
                map.put(rSum, 1);
            }
*/


// Your code here along with comments explaining your approach
// We are using running sum and then subtracting the k (sum of the subarry) 
// and keeping a count of how many times we have encountered the subarray.
// Storing it in a HashMap to lower time complexity.

import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int count = 0; 
        int rSum = 0; 
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(rSum, 1); 
        for(int i = 0 ; i < nums.length ; i++){
            rSum = rSum + nums[i];
            if(map.containsKey(rSum - k)){
                count = count + map.get(rSum - k); 
            }
            if(map.containsKey(rSum)){
                map.put(rSum, map.get(rSum) + 1);
            }
            else { 
                map.put(rSum, 1);
            }
        }
        return count; 
    } 
}



// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach: 
    /*
     * 1. Check if array is empty or invalid
     * 2. Keep a running sum
     *      2.1 Add to the rSum when you encouter 1's
     *      2.2 Subtract when 0
     * 3. Add to hashmap the running sum and the index i where you encountered it.
     * 4. Update Max when encoutering a larger subaray than previous max by subtracting index from running some index; 
     * 5. Return Max
     */
class Solution {
    public int findMaxLength(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int rSum = 0; 
        int max = 0;
        map.put(rSum, -1);
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] == 1){
                rSum = rSum + 1; 
            }
            else {
                rSum = rSum - 1;
            }
            if(map.containsKey(rSum)){
                max = Math.max(max, i - map.get(rSum));
            }
            else {
                map.put(rSum, i);
            }
        }
        return max;
    }
}