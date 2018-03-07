package com.yeebee.zhc.algorithms.exercise;
/**
 * 
 * @author yeebee
 * 查找问题,线性查找
 */
public class EX2_3LinearSearch{
	
	public static Integer find(int a[],Integer v) {
		for(int i=0;i<a.length;i++) {
			if(a[i]==v) 
				return i;
		}
		return null;
	}
	
	public static void main(String[] args) {
		int[] a=new int[]{5,2,4,6,1,3};
		System.out.println(EX2_3LinearSearch.find(a, 4));
		System.out.println(EX2_3LinearSearch.find(a, 10));
	}
	

}
