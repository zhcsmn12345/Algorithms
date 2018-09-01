package com.yeebee.zhc.algorithms.problem;

import java.util.Arrays;

/**
 * �����
 * ����A[1..n]��һ����n����ͬ��������.��i<j,��A[i]>A[j],
 * ��(i,j)��ΪA��һ�������
 * һ����n����ͬԪ�ص����������n(n-1)/2�������(���併������ʱ)
 * ʵ��:
 * �޸Ĺ鲢����ĺϲ�����
 * ÿ�ƶ�һ���ұߵ������鿴��������黹ʣ��������Ȼ�����������
 * @see com.yeebee.zhc.algorithms.MergeSort
 * @author yeebee
 *
 */
public class P2_4Inversions {
	
	/**
	 * �޸Ĺ鲢����ĺϲ�����
	 * �������ͬʱ��ÿ�ƶ�һ���ұߵ������鿴��������黹ʣ��������Ȼ�����������
	 * ���õ�����Ե���Ŀ
	 * @param A �������У�����A[p..q]��A[q+1..r]���������
	 * @param p ��һ����������ʼλ��
	 * @param q ��һ�����������λ��
	 * @param r �ڶ������������λ��
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
	 * �޸Ĺ鲢�����㷨�������������Ŀ
	 * ����������A�ֽ�ݹ����ֱ������Ϊ1
	 * ֮�����merge�����ϲ�
	 * �����ʱ���(nlgn)
	 * @param A ��������
	 * @param p ������Ҫ�������ʼλ�ã�����������������0
	 * @param r ������Ҫ����Ľ���Ϊֹ������������Ҫ��������A.length-1
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
