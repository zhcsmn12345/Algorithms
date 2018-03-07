package com.yeebee.zhc.algorithms;

import java.util.Arrays;
/**
 * 
 * @author yeebee
 *²åÈëÅÅĞò
 */

public class InsertionSort {
	
	/**
	 * ÉıĞò
	 * @param a
	 * @return
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
				i=i-1;
			}
			a[i+1]=key;
		}
		return a;
	}
	
	/**
	 * ½µĞò
	 * @param a
	 * @return
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
				i=i-1;
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
