package com.yeebee.zhc.algorithms.problem;

import java.util.Arrays;

/**
 * 逆序对
 * 假设A[1..n]是一个有n个不同数的数组.若i<j,且A[i]>A[j],
 * 则(i,j)称为A的一个逆序对
 * 一个有n个不同元素的数组最多有n(n-1)/2个逆序对(在其降序排列时)
 * 实现:
 * 修改归并排序的合并步骤
 * 每移动一个右边的数，查看他左边数组还剩多少数，然后将其总数相加
 * @see com.yeebee.zhc.algorithms.MergeSort
 * @author yeebee
 *
 */
public class P2_4Inversions {
	
	/**
	 * 修改归并排序的合并步骤
	 * 在排序的同时，每移动一个右边的数，查看他左边数组还剩多少数，然后将其总数相加
	 * 最后得到逆序对的数目
	 * @param A 输入序列，其中A[p..q]和A[q+1..r]都已排序好
	 * @param p 第一个子数组起始位置
	 * @param q 第一个子数组结束位置
	 * @param r 第二个子数组结束位置
	 */
	private static Integer merge(Integer A[],Integer p,Integer q,Integer r) {
		Integer inv=0;
		if(p>q||q>=r)
			throw new RuntimeException();
		Integer n1=q-p+1;
		Integer n2=r-q;
		Integer[] L=new Integer[n1];
		Integer[] R=new Integer[n2];
		for(int i=0;i<n1;i++)
			L[i]=A[p+i];
		for(int i=0;i<n2;i++)
			R[i]=A[q+1+i];
		for(int i=0,j=0,k=p;k<=r;k++) {
			if(L[i]<=R[j]) {
				A[k]=L[i];
				i++;
				if(i==L.length) {
					while(j!=R.length)
						A[k++]=R[j++];
					break;
				}	
			}
			else {
				A[k]=R[j];
				j++;
				inv+=n1-i;
				if(j==R.length) {
					while(i!=L.length)
						A[k++]=L[i++];
					break;
				}
			}
		}
		return inv;
	}
	
	/**
	 * 修改归并排序算法，查找逆序对数目
	 * 将整个序列A分解递归调用直到长度为1
	 * 之后调用merge方法合并
	 * 最坏运行时间θ(nlgn)
	 * @param A 输入序列
	 * @param p 数组需要排序的起始位置，整个数组排序输入0
	 * @param r 数组需要排序的结束为止，整个数组需要排序输入A.length-1
	 */ 
	public static Integer find(Integer[] A,Integer p,Integer r) {
		Integer inv=0;
		if(p<r) {
			Integer q=(p+r)/2;
			Integer left=P2_4Inversions.find(A, p, q);
			Integer right=P2_4Inversions.find(A, q+1, r);
			inv+=P2_4Inversions.merge(A, p, q, r)+left+right;
		}
		return inv;
	}
	
	public static void main(String[] args) {
		Integer[] a=new Integer[] {2,3,8,6,1};
		System.out.println(P2_4Inversions.find(a, 0, a.length-1));
		Integer[] a1=new Integer[] {1,3,6,7,2};
		System.out.println(P2_4Inversions.find(a1, 0, a1.length-1));
		System.out.println(Arrays.toString(a));
	}

}
