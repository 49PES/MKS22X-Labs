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

	// public boolean groupNoAdj(int start, int[] nums, int target){
	// 	if(start >= nums.length) {return (target == 0);}
	//
	// }

	 public boolean splitArray(int[] nums){
	 	return splitArrayHelper(nums, 0, 0, 0);
	}

	public boolean splitArrayHelper(int[] nums, int index, int sumOne, int sumTwo){
		if(index >= nums.length){return (sumOne == sumTwo);}
		return (splitArrayHelper(nums, index + 1, sumOne + nums[index], sumTwo ) || splitArrayHelper(nums, index + 1, sumOne, sumTwo  + nums[index]));
		// Either an element is a member of sumOne, or it is a member of sumTwo, so increment sumOne and sumTwo accordingly 
	}
	public static void main(String[] args){

	}
}
