package com.yeebee.zhc.algorithms.problem;

import java.util.Arrays;

/**
 * 冒泡排序
 * 反复交换相邻的未按照持续排列的元素
 * @author yeebee
 *
 */
public class P2_2BubbleSort {
	
	/**
	 * 冒泡排序
	 * 最好、最坏运行时间都是θ(n^2)
	 * @param A 需要排序的数组
	 */
	public static void sort(Integer[] A) {
		if(A.length<2)
			return;
		for(int i=0;i<A.length-1;i++)
			for(int j=A.length-1;i<j;j--)
				if(A[j]<A[j-1])
				{
					int t=A[j];
					A[j]=A[j-1];
					A[j-1]=t;
				}
	}
	
	public static void main(String[] args) {
		Integer[] a=new Integer[] {5,2,4,7,1,3,2,6};
		P2_2BubbleSort.sort(a);
		System.out.println(Arrays.toString(a));
	}
			

}
