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
		if(nums[start] % 5 == 0 ){
			// You *must* add any multiple of 5
			if(start + 1 < nums.length && nums[start + 1] == 1) {
				return (groupSum5(start + 2, nums, target - nums[start])); // Skip over 1, if it succeeds a multiple of 5
			}

			else {
				return (groupSum5(start + 1, nums, target - nums[start])); // Iterate normally if succeeding # is not 1
			}

		}
		return ( groupSum5(start + 1, nums, target) || groupSum5(start + 1, nums, target - nums[start]) );
	}

	public boolean groupNoAdj(int start, int[] nums, int target) {
	  if (start >= nums.length){
	    return (target == 0);
		}
	  return (groupNoAdj(start + 1, nums, target)) || (groupNoAdj(start + 2, nums, target - nums[start]));
	}

	public boolean splitArray(int[] nums){
	 	return splitArrayHelper(nums, 0, 0, 0);
	}

	public boolean splitArrayHelper(int[] nums, int index, int sumOne, int sumTwo){
		if(index >= nums.length){return (sumOne == sumTwo);}
		return (splitArrayHelper(nums, index + 1, sumOne + nums[index], sumTwo ) || splitArrayHelper(nums, index + 1, sumOne, sumTwo  + nums[index]));
		// Either an element is a member of sumOne, or it is a member of sumTwo, so increment sumOne and sumTwo accordingly
	}

	public boolean split53(int[] nums){
<<<<<<< HEAD
		return(nums, 0, 0, 0);
=======
		return split53Helper(nums, 0, 0, 0);
>>>>>>> 3dcf30e8bf64e4de007479fd29a038c59bdff7ee
	}

	public boolean split53Helper(int[] nums, int index, int sumOne, int sumTwo){
		if(index >= nums.length) {return (sumOne == sumTwo);}

		if(nums[index] % 5 == 0) {
			return split53Helper(nums, index + 1, sumOne, sumTwo + nums[index]);
		}

		if(nums[index] % 3 == 0) {
			return split53Helper(nums, index + 1, sumOne + nums[index], sumTwo);
			// If nums[index] wasn't already divisible by 5, only then would it go on to this - so adding a  || (nums[index] % 5 == 0) would be redundant
		}

		return (split53Helper(nums, index + 1, sumOne + nums[index], sumTwo) || split53Helper(nums, index + 1, sumOne, sumTwo + nums[index]));

	}

	public boolean splitOdd10(int[] nums) {
  	return splitOdd10Helper(nums, 0, 0, 0);
	}

	public boolean splitOdd10Helper(int[] nums, int index, int oddSum, int tenSum){
  if(index >= nums.length){return (oddSum % 2 == 1 && tenSum % 10 == 0);}
  return(splitOdd10Helper(nums, index + 1, oddSum + nums[index], tenSum) || splitOdd10Helper(nums, index + 1, oddSum, tenSum + nums[index])  );

}

	public boolean groupSumClump(int start, int[] nums, int target){
		if(start >= nums.length) {return target == 0;}
		int x = 0; // Provides Number of "bounces" required in the clump (will be 1 by default, 2 or more when there are adjacent values)
		while((x + start) < nums.length && nums[start + x] == nums[start]){
			x++;
		}
		return  (groupSumClump(start + x, nums, target - nums[start] * x) ) || (groupSumClump(start + x, nums, target) );
	}


}
