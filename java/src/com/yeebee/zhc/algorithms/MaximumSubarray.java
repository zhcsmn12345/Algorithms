package com.yeebee.zhc.algorithms;
/**
 * 最大子数组问题(maximum subarray):
 * 寻找A的和最大的非连续子数组
 * @author ZHC
 *
 */
public class MaximumSubarray {
	
	/**
	 * 内部类用来存储结果
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
	 * 找出跨越中点的最大子数组
	 * 花费时间:θ(n)
	 * @param A 查找的数组A
	 * @param low 数组A的开始处
	 * @param mid 数组A的中点
	 * @param high 数组A的结束处
	 * @return 返回下标元组划定跨越重点的最大子数组的边界，并返回最大子数组中值的和
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
	 * 分治算法求解最大子数组问题
	 * 运行时间θ(nlgn)
	 * @param A 查找的数组A
	 * @param low 数组A的开始处
	 * @param high 数组A的结束处
	 * @return 返回下标元组划定跨越重点的最大子数组的边界，并返回最大子数组中值的和
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
	 * 暴力求解最大数组问题
	 * 隐形时间θ(n^2)
	 * @param A 查找的数组A
	 * @return 返回下标元组划定跨越重点的最大子数组的边界，并返回最大子数组中值的和
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
	 * 非递归线性算法求解最大子数组问题
	 * 从数组左边界开始，由左至右处理，记录目前为止已经处理过的最大子数组
	 * 若已知A[1..j]的最大子数组，A[1..j+1]的最大子数组要么是A[1..j]的最大子数组，
	 * 要么是某个子数组A[i..j+1](1<=i<=j+1)
	 * 在已知A[1..j]的最大子数组的情况下，可以在线性时间内找出形如A[i..j+1]的最大子数组
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
