/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
logic

do an inorder traversal and keep adding nodes to the list.
once your list/array has size of the K, then start comparing the first element in the list with every node
do a comparison and revomve/keep the item in list accordingly.
This solution is more efficient than the two stack method of succ / prev listed on various sites
**/
class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        List <Integer> res = new ArrayList<Integer>();
        finalorder(root,res,k,target);
        return res;
    }
    
    public void finalorder(TreeNode root, List<Integer> res, int k, double target){
        if(root == null)
            return;
        
        finalorder(root.left,res,k,target);
        if(res.size()<k){
            res.add(root.val);
        }else{
            if(Math.abs(res.get(0)-target)>Math.abs(root.val-target)){
                res.remove(0);
                res.add(root.val);
            }
        }
        finalorder(root.right,res,k,target);
    }
}
