package org.leon.algo;

import org.junit.jupiter.api.Test;

import java.util.Random;

class FindKthLargestAlgoTest {
    private FindKthLargestAlgo algo = new FindKthLargestAlgo();

    @Test
    public void FindKth(){
        int[] nums = {9,5,4,7,0,1,6,2,8,3};
        int res = algo.FindKthLargest(nums, 3);
        System.out.println(res + "from find");
    }

    @Test
    public void randTest(){
        Random rn = new Random();
        for(int i =0;i<10; i++){
            int p = rn.nextInt( 9);
            System.out.println(p);
        }

    }
}