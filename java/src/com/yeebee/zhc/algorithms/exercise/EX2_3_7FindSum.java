package com.yeebee.zhc.algorithms.exercise;

import com.yeebee.zhc.algorithms.MergeSort;

/**
 * 给定一个集合S和整数x
 * 确定S中是否存在两个和刚好为x的元素
 * @author yeebee
 *
 */
public class EX2_3_7FindSum {

	/**
	 * 实现:先对A进行归并排序，然后进行线性查找
	 * 运行时间为 θ(nlgn)
	 * @param A 查询的数组
	 * @param sum 查询的两个数的和
	 * @return 数组A中是否含有两个数和为sum
	 */
	public static Boolean find(Integer[] A,Integer sum) {
		MergeSort.sort(A, 0, A.length-1);
		int i=0,j=A.length-1;
		while(i<j) {
			if((A[i]+A[j])==sum)
				return true;
			else if((A[i]+A[j])>sum)
				i++;
			else
				j--;
		}
		return false;
	}
	
	public static void main(String[] args) {
		Integer[] a1= new Integer[]{1,2,3,4,5,6,7,8,9,10};
		Integer[] a2= new Integer[]{1,2,3,4,5,6,7,8,9,10};
		System.out.println(EX2_3_7FindSum.find(a1, 11));
		System.out.println(EX2_3_7FindSum.find(a2, 100));
	}

}
