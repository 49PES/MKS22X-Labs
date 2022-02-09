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
	public static void main(String[] args){

	}
}
