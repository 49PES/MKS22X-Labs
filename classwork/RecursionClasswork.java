public class RecursionClasswork{
	public static boolean groupSum(int start, int[] nums, int target){
		if(start >= nums.length){return (target == 0);}
		return ( groupSum(start + 1, nums, target) || groupSum(start + 1, nums, target - nums[start]) );
	}

	public static boolean groupSum6(int start, int[] nums, int target){
		if(start >= nums.length){return (target == 0);}
		if(nums[start] == 6){return groupSum6(start + 1, nums, target - nums[start]); } // 6 must be chosen
		return ( groupSum6(start + 1, nums, target) || groupSum6(start + 1, nums, target - nums[start]) );
	}

	public static boolean groupSum5(int start, int[] nums, int target){
		if(start >= nums.length){ System.out.println("Start: " + start + ", Target = " + target); return (target == 0);}
		if(nums[start] % 5 == 0 && start + 1 < nums.length && nums[start + 1] == 1){
			System.out.println("Start: " + start + ", Target = " + target);
			return (groupSum5(start + 2, nums, target - nums[start]) || groupSum5(start + 2, nums, target));
			// If a number is a 5, and the number immediately succeeding it is a 1, skip over the 1's index by incrementing start by 2
		}
		System.out.println("Start: " + start + ", Target = " + target);
		return ( groupSum5(start + 1, nums, target) || groupSum5(start + 1, nums, target - nums[start]) );
	}

	public static boolean groupSumClump(int start, int[] nums, int target) {
  if(start >= nums.length) {return (target == 0);}

  if(start + 1 < nums.length && nums[start] == nums[start + 1]){
    int newIndex = start;
    while(newIndex + 1 < nums.length && nums[start] == nums[newIndex]) newIndex++;
    return (groupSumClump(newIndex + 1, nums, target - ((newIndex - start) * nums[start])) || groupSumClump(newIndex + 1, nums, target)  );

  }

  return (groupSumClump(start + 1, nums, target - nums[start] ) || groupSumClump(start + 1, nums, target  ));
}

	public static boolean groupNoAdj(int start, int[] nums, int target) {
	  if (start >= nums.length){
	    return (target == 0);
		}
	  return (groupNoAdj(start + 1, nums, target)) || (groupNoAdj(start + 2, nums, target - nums[start]));
	}

	public static boolean splitArray(int[] nums){
	 	return splitArrayHelper(nums, 0, 0, 0);
	}

	public static boolean splitArrayHelper(int[] nums, int index, int sumOne, int sumTwo){
		if(index >= nums.length){return (sumOne == sumTwo);}
		return (splitArrayHelper(nums, index + 1, sumOne + nums[index], sumTwo ) || splitArrayHelper(nums, index + 1, sumOne, sumTwo  + nums[index]));
		// Either an element is a member of sumOne, or it is a member of sumTwo, so increment sumOne and sumTwo accordingly
	}

	public static boolean split53(int[] nums){
		return split53Helper(nums, 0, 0, 0);
	}

	public static boolean split53Helper(int[] nums, int index, int sumOne, int sumTwo){
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

	public static boolean splitOdd10(int[] nums) {
  return splitOdd10Helper(nums, 0, 0, 0);
	}

	public static boolean splitOdd10Helper(int[] nums, int index, int oddSum, int tenSum){
  if(index >= nums.length){return (oddSum % 2 == 1 && tenSum % 10 == 0);}
  return(splitOdd10Helper(nums, index + 1, oddSum + nums[index], tenSum) || splitOdd10Helper(nums, index + 1, oddSum, tenSum + nums[index])  );

}

	public static void main(String[] args){
		System.out.println(groupSum5(0, new int[] {2, 5, 10, 4}, 12));
	}
}
