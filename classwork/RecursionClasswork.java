public class RecursionClasswork{
	public boolean groupSum(int start, int[] nums, int target){
		if(start >= nums.length){return (target == 0);}
		return ( groupSum(start + 1, nums, target) || groupSum(start + 1, nums, target - nums[start]) );
	}

	public boolean groupSum6(int start, int[] nums, int target){
		if(start >= nums.length){return (target == 0);}
		if(nums[start] == 6){return groupSum6(start + 1, nums, target - nums[start]); } // 6 must be chosen
		return ( groupSum6(start + 1, nums, target) || groupSum6(start + 1, nums, target - nums[start]) );
	}

	public boolean groupSum5(int start, int[] nums, int target){
		if(start >= nums.length){return (target == 0);}
		if(nums[start] == 5 && start + 1 < nums.length && nums[start + 1] == 1){
			return (groupSum5(start + 2, nums, target - nums[start]) || groupSum5(start + 2, nums, target));
			// If a number is a 5, and the number immediately succeeding it is a 1, skip over the 1's index by incrementing start by 2
		}
		return ( groupSum5(start + 1, nums, target) || groupSum5(start + 1, nums, target - nums[start]) );
	}
	public static void main(String[] args){

	}
}
