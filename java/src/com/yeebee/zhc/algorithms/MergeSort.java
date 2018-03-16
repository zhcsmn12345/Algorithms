package com.yeebee.zhc.algorithms;

import java.util.Arrays;

/**
 * 归并排序
 * @author yeebee
 *
 */
public class MergeSort {

	/**
	 * 合并算法
	 * 将A中包含的两个已经排序好的连续子数组合并。调用后得到包含一个合并后的完整已排序的子数组的数组A
	 * 为了避免在每个基本步骤必须检查是否有子数组为空，在每个子数组最后一位放置哨兵
	 * 这里哨兵为整数最大值。当取得哨兵时，不可能为较小的值，除非两个数组都显示哨兵
	 * 满足p<=q<r
	 * 最坏运行时间θ(n)
	 * @param A 输入序列，其中A[p..q]和A[q+1..r]都已排序好
	 * @param p 第一个子数组起始位置
	 * @param q 第一个子数组结束位置
	 * @param r 第二个子数组结束位置
	 */
	private static void merge(Integer[] A,Integer p,Integer q,Integer r) {
		if(p>q||q>=r)
			throw new RuntimeException();
		Integer n1=q-p+1;
		Integer n2=r-q;
		Integer[] L=new Integer[n1+1];
		Integer[] R=new Integer[n2+1];
		for(int i=0;i<n1;i++)
			L[i]=A[p+i];
		for(int i=0;i<n2;i++)
			R[i]=A[q+1+i];
		L[n1]=Integer.MAX_VALUE;
		R[n2]=Integer.MAX_VALUE;
		for(int i=0,j=0,k=p;k<=r;k++) {
			if(L[i]<=R[j]) {
				A[k]=L[i];
				i++;
			}
			else {
				A[k]=R[j];
				j++;
			}
		}
	}
	/**
	 * 合并算法，不使用哨兵
	 * 一旦一个数组的元素均被复制回A之后就停止，把另一个数组的剩余部分复制回数组A
	 * @param A 输入序列，其中A[p..q]和A[q+1..r]都已排序好
	 * @param p 第一个子数组起始位置
	 * @param q 第一个子数组结束位置
	 * @param r 第二个子数组结束位置
	 */
	private static void mergeNoFlag(Integer[] A,Integer p,Integer q,Integer r) {
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
				if(j==R.length) {
					while(i!=L.length)
						A[k++]=L[i++];
					break;
				}
			}
		}
		
	}
	
	/**
	 * 分治法归并排序
	 * 将整个序列A分解递归调用直到长度为1
	 * 之后调用merge方法合并
	 * 最坏运行时间θ(nlgn)
	 * @param A 输入序列
	 * @param p 数组需要排序的起始位置，整个数组排序输入0
	 * @param r 数组需要排序的结束为止，整个数组需要排序输入A.length-1
	 */ 
	public static void sort(Integer[] A,Integer p,Integer r) {
		if(p<r) {
			Integer q=(p+r)/2;
			MergeSort.sort(A, p, q);
			MergeSort.sort(A, q+1, r);
			MergeSort.merge(A,p,q,r);
		}
	}
	
	/**
	 * 分治法归并排序,merge方法不使用哨兵
	 * @param A 输入序列
	 * @param p 数组需要排序的起始位置，整个数组排序输入0
	 * @param r 数组需要排序的结束为止，整个数组需要排序输入A.length-1
	 */ 
	public static void sortNoFlag(Integer[] A,Integer p,Integer r) {
		if(p<r) {
			Integer q=(p+r)/2;
			MergeSort.sort(A, p, q);
			MergeSort.sort(A, q+1, r);
			MergeSort.mergeNoFlag(A,p,q,r);
		}
	}
	
	public static void main(String[] args) {
//		Integer[] a=new Integer[20];
//		for(int i=0;i<a.length;i++)
//			a[i]=0;
//		a[8]=2;
//		a[9]=4;
//		a[10]=5;
//		a[11]=7;
//		a[12]=1;
//		a[13]=2;
//		a[14]=3;
//		a[15]=6;
//		System.out.println(Arrays.toString(a));
//		MergeSort.merge(a, 8, 11, 15);
//		System.out.println(Arrays.toString(a));
		Integer[] a=new Integer[] {5,2,4,7,1,3,2,6};
		MergeSort.sort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
		Integer[] a1=new Integer[] {3,41,52,26,38,57,9,49};
		MergeSort.sort(a1, 0, a1.length-1);
		System.out.println(Arrays.toString(a1));
		Integer[] a2=new Integer[] {3,41,52,26,38,57,9,49};
		MergeSort.sortNoFlag(a2, 0, a2.length-1);
		System.out.println(Arrays.toString(a2));
	}
}
