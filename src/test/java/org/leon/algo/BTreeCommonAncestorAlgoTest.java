package org.leon.algo;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.*;

class BTreeCommonAncestorAlgoTest {
    BTreeCommonAncestorAlgo algo = new BTreeCommonAncestorAlgo();
    Random rand = new Random();
    Map<Integer, Integer> allVals = new HashMap<>();

    @Test
    public void FindAncestor() {

        TreeNode node = new TreeNode(90);
        FeedNode(node, 4, 0);
        PrePrintBTree(node);
        System.out.println("------------");
        LinePrintBTree(node);
    }

    public void FeedNode(TreeNode node, int level, int current) {
        if (node == null) return;
        if (current <= level) {
            int result = rand.nextInt(0, 17);
            if (result > 4) {
                int val = GetAvailbleVal();
                allVals.put(val, val);
                TreeNode l = new TreeNode(val);

                val = GetAvailbleVal();
                allVals.put(val, val);
                TreeNode r = new TreeNode(val);
                node.left = l;
                node.right = r;
            }
            if (result == 1 || result == 2) {
                int val = GetAvailbleVal();
                allVals.put(val, val);
                TreeNode l = new TreeNode(val);
                node.left = l;
            }
            if (result == 3 || result ==4) {
                int val = GetAvailbleVal();
                allVals.put(val, val);
                TreeNode r = new TreeNode(val);
                node.right = r;
            }
            current++;

            FeedNode(node.left, level, current);
            FeedNode(node.right, level, current);

        }
    }

    public void PrePrintBTree(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            PrePrintBTree(root.left);
            PrePrintBTree(root.right);
        }
    }

    public void LinePrintBTree(TreeNode root){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode node = q.poll();
                System.out.print(node.val + " ");
                if(node.left!=null) {
                    q.offer(node.left);
                    System.out.print("|l|");
                }
                if(node.right != null) {
                    q.offer(node.right);
                    System.out.print("|r|");
                }
            }
            System.out.println();
        }
    }
    private int GetAvailbleVal() {
        int val;
        do {
            val = rand.nextInt(40);
        } while (allVals.containsKey(val));
        return val;
    }
}