/**
* Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
* The root is the maximum number in the array.
* The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
* The right subtree is the maximum tree constructed from right part subarray divided by the maximum number 
* Difficulty: Medium
* Date: May 27, 2019
* https://leetcode.com/problems/maximum-binary-tree/
* Definition for a binary tree node.
* public class TreeNode {
*     int val;
*     TreeNode left;
*     TreeNode right;
*     TreeNode(int x) { val = x; }
* }
*/

class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    
    private TreeNode helper(int[] nums, int left, int right) {
        if (left == right) {
            return null;
        }
        int maxIdx = getMax(nums, left, right);
        TreeNode tree = new TreeNode(nums[maxIdx]);
        tree.left = helper(nums, left, maxIdx);
        tree.right = helper(nums, maxIdx + 1, right);
        return tree;
    }
    
    private int getMax(int[] nums, int left, int right) {
        
        int max = 0;
        int idx = left;
        for (int i = left; i < right; i++ ) {
            if (nums[i] > max) {
                max = nums[i];
                idx = i;
            }
        }
        return idx;
    }
}