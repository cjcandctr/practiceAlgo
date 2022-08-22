package org.leon.algo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FindKthLargestAlgo {
    public FindKthLargestAlgo(){}
    private Random rand = new Random();
    public int FindKthLargest(int[] nums, int k){
        if(nums == null || nums.length ==0 || k > nums.length) return 0;

        int left = 0;
        int right = nums.length-1;
        int target = nums.length -k;

        while(true){
            int p =  partition(nums, left, right);
            if(p == target){
                return nums[p];
            }else if(p > target){
                right = p-1;
            }else{
                left = p+1;
            }
        }
    }
    private int partition(int[] nums, int left, int right){
        System.out.println(String.format("left is %s, right is %s", left, right));
        if(left == right) return left;
        int rand = this.rand.nextInt(left, right);
        swap(nums, left, rand);
        int less = left +1;
        int great = right;
        int p = nums[left];

        while(true){
            while(less <= great && nums[less]<p ){
                less++;
            }
            while(less <= great && nums[great]>p){
                great--;
            }
            if(less >= great){
                break;
            }
            swap(nums,less, great);
            less++;
            great--;
        }
        swap(nums,left, great);
        return great;
    }
    private void swap(int[] nums, int left, int right){
        int tmp =nums[left];
        nums[left]= nums[right];
        nums[right] = tmp;
    }
}
