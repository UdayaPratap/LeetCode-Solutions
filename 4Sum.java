/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
*/
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        List<List<Integer>> ans=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                int left=j+1, right=n-1;
                while(left<right)
                {
                    long sum=(long)nums[i]+(long)nums[j]+(long)nums[left]+(long)nums[right];
                    if(sum==target){
                        List<Integer> temp=new ArrayList<>();
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[left]);
                        temp.add(nums[right]);
                        ans.add(temp);
                        while(left<right && nums[left]==temp.get(2)) left++;
                        while(left<right && nums[right]==temp.get(3)) right--;

                    }
                    else if(sum<target) left++;
                    else right--;
                }
                while(j+1<n && nums[j]==nums[j+1]) j++;
            }
            while(i+1<n && nums[i]==nums[i+1]) i++;
        }
        return ans;
    }
}
