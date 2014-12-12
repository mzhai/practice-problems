import java.util.*;

//http://leetcode.com/2010/04/finding-all-unique-triplets-that-sums.html
//https://oj.leetcode.com/problems/3sum/

public class ThreeSum
{
	public static void main (String args[])
	{
		ThreeSum test = new ThreeSum();

		int [] arg = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> solution = test.threeSum(arg);

		for (List<Integer> triplet : solution)
		{
			for (Integer i : triplet)
			{
				System.out.print(i + " ");
			}
			System.out.println();
		}

	}

	public List<List<Integer>> threeSum(int[] num)
	{
		ArrayList<List<Integer>> sumList = new ArrayList<List<Integer>>();
		if (num.length < 3)
		{
			return sumList;
		}

		Integer[] newNum = new Integer[num.length];

		for (int i = 0; i < num.length; i++)
		{
			newNum[i] = num[i];
		}

		ArrayList <Integer>numList = new ArrayList <Integer>(Arrays.asList(newNum));
		Collections.sort(numList);
		System.out.println(numList);

		Set <List<Integer>> set = new HashSet <List<Integer>>();

		for (int i = 0 ; i < numList.size(); i++)
		{
			int j = i+1;
			int k = numList.size()-1;
			int sum2;

			while (j < k)
			{
				sum2 = numList.get(j) + numList.get(k);
				if (numList.get(i) + sum2 == 0)
				{
					List<Integer> triplet = new ArrayList <Integer> ();
					triplet.add(numList.get(i));
					triplet.add(numList.get(j));
					triplet.add(numList.get(k));
					set.add(triplet);
					j++;
					k--;
				}
				else if (sum2 < -numList.get(i))
				{
					//smaller than what we're looking for
					j++;
				}
				else //if (sum2 > -numList.get(i))
				{
					//bigger than what we're looking for
					k--;
				}
			}

		}
		sumList = new ArrayList <List<Integer>>(set);
		return sumList;
	}
}