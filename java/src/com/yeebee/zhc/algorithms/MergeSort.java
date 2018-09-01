package com.yeebee.zhc.algorithms;

import java.util.Arrays;

/**
 * �鲢����
 * @author yeebee
 *
 */
public class MergeSort {

	/**
	 * �ϲ��㷨
	 * ��A�а����������Ѿ�����õ�����������ϲ������ú�õ�����һ���ϲ��������������������������A
	 * Ϊ�˱�����ÿ����������������Ƿ���������Ϊ�գ���ÿ�����������һλ�����ڱ�
	 * �����ڱ�Ϊ�������ֵ����ȡ���ڱ�ʱ��������Ϊ��С��ֵ�������������鶼��ʾ�ڱ�
	 * ����p<=q<r
	 * �����ʱ���(n)
	 * @param A �������У�����A[p..q]��A[q+1..r]���������
	 * @param p ��һ����������ʼλ��
	 * @param q ��һ�����������λ��
	 * @param r �ڶ������������λ��
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
	 * �ϲ��㷨����ʹ���ڱ�
	 * һ��һ�������Ԫ�ؾ������ƻ�A֮���ֹͣ������һ�������ʣ�ಿ�ָ��ƻ�����A
	 * @param A �������У�����A[p..q]��A[q+1..r]���������
	 * @param p ��һ����������ʼλ��
	 * @param q ��һ�����������λ��
	 * @param r �ڶ������������λ��
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
	 * ���η��鲢����
	 * ����������A�ֽ�ݹ����ֱ������Ϊ1
	 * ֮�����merge�����ϲ�
	 * �����ʱ���(nlgn)
	 * @param A ��������
	 * @param p ������Ҫ�������ʼλ�ã�����������������0
	 * @param r ������Ҫ����Ľ���Ϊֹ������������Ҫ��������A.length-1
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
	 * ���η��鲢����,merge������ʹ���ڱ�
	 * @param A ��������
	 * @param p ������Ҫ�������ʼλ�ã�����������������0
	 * @param r ������Ҫ����Ľ���Ϊֹ������������Ҫ��������A.length-1
	 */ 
	public static void sortNoFlag(Integer[] A,Integer p,Integer r) {
		if(p<r) {
			Integer q=(p+r)/2;
			MergeSort.sortNoFlag(A, p, q);
			MergeSort.sortNoFlag(A, q+1, r);
			MergeSort.mergeNoFlag(A,p,q,r);
			System.out.println(Arrays.toString(A));
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
//		System.out.println(Arrays.toString(a2));
	}
}
