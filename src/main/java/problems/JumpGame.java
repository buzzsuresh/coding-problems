package problems;

/**
 * Given an array of non-negative integers, you are initially positioned at the
 * first index of the array. Each element in the array represents your maximum
 * jump length at that position. Determine if you are able to reach the last
 * index. For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return
 * false.
 * 
 * @author lucas
 *
 */
public class JumpGame {

	public static boolean solve(int[] a) {
		int maxReachableIndex = a[0];
		for (int i = 0; i < a.length; i++) {
			if (maxReachableIndex <= i && a[i] == 0) {
				return false;
			}

			if (i + a[i] > maxReachableIndex) {
				maxReachableIndex = i + a[i];
			}

			if (maxReachableIndex >= a.length - 1) {
				return true;
			}
		}

		return true;
	}

	public static boolean solve(int[] a, int pos, int end) {
		if (pos == end) {
			return true;
		} else {
			int max = a[pos];
			for (int i = 1; i <= max; i++) {
				if (solve(a, pos + i, end)) {
					return true;
				}
			}

			return false;
		}
	}

	public static void main(String[] args) {
		int[] a = { 3, 2, 1, 0, 4 };
		int end = a.length - 1;
		System.out.println(solve(a, 0, end));
		System.out.println(solve(a));
	}

}
