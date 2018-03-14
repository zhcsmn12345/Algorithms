package com.yeebee.zhc.algorithms;

import java.util.Arrays;
/**
 * 插入排序
 * 每次从序列中读取一个元素，放到已经排序好的序列中，
 * 直到序列读取完毕。
 * 最好情况运行时间θ(n),最坏情况运行时间都是Θ(n^2)
 * 运行时间与输入数组中的逆序对数量成常数倍关系,即O(1)
 * @see com.yeebee.zhc.algorithms.problem.P2_4Inversions
 * @author yeebee
 */

public class InsertionSort {
	
	/**
	 * 升序排序
	 * @param a 需要排序的数组
	 * @return  按升序排列好的数组
	 */
	public static int[] sort(int a[]) {
		if(a.length<2)
			return a;
		for(int j=1;j<a.length;j++) {
			int key=a[j];
			//Insert a[j] into the sorted sequence a[1...j-1].
			int i=j-1;
			while(i>=0&&a[i]>key) {
				a[i+1]=a[i];
				i--;
			}
			a[i+1]=key;
		}
		return a;
	}
	
	/**
	 * 降序排序
	 * @param a 需要排序的数组
	 * @return  按升序排序好的数组
	 */
	public static int[] sortDesc(int a[]) {
		if(a.length<2)
			return a;
		for(int j=1;j<a.length;j++) {
			int key=a[j];
			//Insert a[j] into the sorted sequence a[1...j-1].
			int i=j-1;
			while(i>=0&&a[i]<key) {
				a[i+1]=a[i];
				i--;
			}
			a[i+1]=key;
		}
		return a;
		
	}
	
	public static void main(String[] args) {
		int[] a=new int[]{5,2,4,6,1,3};
		int[] a1=new int[] {31,41,59,26,41,58};
		InsertionSort.sort(a);
		System.out.println(Arrays.toString(a));
		InsertionSort.sortDesc(a);
		System.out.println(Arrays.toString(a));
		InsertionSort.sort(a1);
		System.out.println(Arrays.toString(a1));
	}

}
