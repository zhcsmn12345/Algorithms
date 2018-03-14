package com.yeebee.zhc.algorithms.exercise;
/**
 * 查找问题,线性查找
 * 从一个序列中查找一个值，返回它在序列中的位置，如果不在序列中返回null
 * @author yeebee
 * 
 */
public class EX2_1_3LinearSearch{
	
	/**
	 * 线性查找
	 * 扫描整个序列a来查找值v
	 * @param a 查找的序列
	 * @param v 查找的值v
	 * @return
	 */
	public static Integer find(int a[],Integer v) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==v) 
				return i;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] a=new int[]{5,2,4,6,1,3};
		System.out.println(EX2_1_3LinearSearch.find(a, 4));
		System.out.println(EX2_1_3LinearSearch.find(a, 10));
	}
	

}
