package com.yeebee.zhc.algorithms;
/**
 * �������������(maximum subarray):
 * Ѱ��A�ĺ����ķ�����������
 * @author ZHC
 *
 */
public class MaximumSubarray {
	
	/**
	 * �ڲ��������洢���
	 * @author ZHC
	 *
	 */
	public static class Result{
		private Integer maxLeft;
		private Integer maxRight;
		private Integer sum;
		public Integer getMaxLeft() {
			return maxLeft;
		}
		public void setMaxLeft(Integer maxLeft) {
			this.maxLeft = maxLeft;
		}
		public Integer getMaxRight() {
			return maxRight;
		}
		public void setMaxRight(Integer maxRight) {
			this.maxRight = maxRight;
		}
		public Integer getSum() {
			return sum;
		}
		public void setSum(Integer sum) {
			this.sum = sum;
		}
		public Result(Integer maxLeft, Integer maxRight, Integer sum) {
			super();
			this.maxLeft = maxLeft;
			this.maxRight = maxRight;
			this.sum = sum;
		}
		public Result() {
			super();
		}
		
	}

	/**
	 * �ҳ���Խ�е�����������
	 * ����ʱ��:��(n)
	 * @param A ���ҵ�����A
	 * @param low ����A�Ŀ�ʼ��
	 * @param mid ����A���е�
	 * @param high ����A�Ľ�����
	 * @return �����±�Ԫ�黮����Խ�ص�����������ı߽磬�����������������ֵ�ĺ�
	 */
	public static Result findMaxCrossingSubarray(Integer A[],Integer low,Integer mid,Integer high) {
		Integer leftSum=Integer.MIN_VALUE;
		Integer sum=0;
		Integer maxLeft = null;
		for(int i=mid;i>=low;i--) {
			sum=sum+A[i];
			if(sum>leftSum) {
				leftSum=sum;
				maxLeft=i;
			}
		}
		Integer rightSum=Integer.MIN_VALUE;
		sum=0;
		Integer maxRight = null;
		for(int j=mid+1;j<=high;j++) {
			sum=sum+A[j];
			if(sum>rightSum) {
				rightSum=sum;
				maxRight=j;
			}
		}
		return new Result(maxLeft,maxRight,leftSum+rightSum);
	}
	
	/**
	 * �����㷨����������������
	 * ����ʱ���(nlgn)
	 * @param A ���ҵ�����A
	 * @param low ����A�Ŀ�ʼ��
	 * @param high ����A�Ľ�����
	 * @return �����±�Ԫ�黮����Խ�ص�����������ı߽磬�����������������ֵ�ĺ�
	 */
	public static Result findMaximumSubarray(Integer A[],Integer low,Integer high) {
		if(high.equals(low)) {
			return new Result(low,high,A[low]);
		}
		else {
			Integer mid=(low+high)/2;
			Result resultLeft=MaximumSubarray.findMaximumSubarray(A, low, mid);
			Result resultRight=MaximumSubarray.findMaximumSubarray(A, mid+1, high);
			Result resultCross=MaximumSubarray.findMaxCrossingSubarray(A, low, mid, high);
			if(resultLeft.getSum()>=resultRight.getSum()&&resultLeft.getSum()>=resultCross.getSum()) {
				return  resultLeft;
			}
			else if(resultRight.getSum()>=resultLeft.getSum()&&resultRight.getSum()>=resultCross.getSum()) {
				return resultRight;
			}
			else
				return resultCross;
		}
	}
	/**
	 * ������������������
	 * ����ʱ���(n^2)
	 * @param A ���ҵ�����A
	 * @return �����±�Ԫ�黮����Խ�ص�����������ı߽磬�����������������ֵ�ĺ�
	 */
	public static Result bruteForce(Integer A[]) {
		Integer left=0;
		Integer right=1;
		Integer max=A[0];
		Integer curSum=0;
		for(int i=0;i<A.length;i++) {
			curSum=0;
			for(int j=i;j<A.length;j++) {
				curSum=curSum+A[j];
				if(curSum>max) {
					max=curSum;
					left=i;
					right=j;
				}
			}
		}
		return new Result(left,right,max);
	}
	/**
	 * �ǵݹ������㷨����������������
	 * ��������߽翪ʼ���������Ҵ�����¼ĿǰΪֹ�Ѿ�����������������
	 * ����֪A[1..j]����������飬A[1..j+1]�����������Ҫô��A[1..j]����������飬
	 * Ҫô��ĳ��������A[i..j+1](1<=i<=j+1)
	 * ����֪A[1..j]����������������£�����������ʱ�����ҳ�����A[i..j+1]�����������
	 * @param A
	 * @return
	 */
	public static Result linear(Integer A[]) {
		Integer M=Integer.MIN_VALUE;
		Integer lowM = null,highM = null;
		Integer Mr=0;
		Integer lowr=0;
		for(int i=0;i<A.length;i++) {
			Mr+=A[i];
			if(Mr>M) {
				lowM=lowr;
				highM=i;
				M=Mr;
			}
			if(Mr<0) {
				Mr=0;
				lowr=i+1;
			}
		}
		return new Result(lowM,highM,M);
	}
	
	public static void main(String[] args) {
		Integer[] array= {13,-3,-25,-2,-3,-16,-23,18,20,-7,12,-5,-22,15,-4,7};
		Result result=MaximumSubarray.findMaximumSubarray(array, 0, array.length-1);
		System.out.println(result.getSum()+","+result.getMaxLeft()+","+result.getMaxRight());
		result=MaximumSubarray.bruteForce(array);
		System.out.println(result.getSum()+","+result.getMaxLeft()+","+result.getMaxRight());
		result=MaximumSubarray.linear(array);
		System.out.println(result.getSum()+","+result.getMaxLeft()+","+result.getMaxRight());
	}

}
