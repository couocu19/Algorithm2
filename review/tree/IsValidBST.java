package review.tree;

import javax.security.auth.login.CredentialNotFoundException;

public class IsValidBST {
    public static void main(String[] args) {


    }

}

class Solution {
    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if(root == null)
            return true;
        if(!isValidBST(root.left))
            return false;
        if(root.val<=pre)
            return false;
        pre = root.val;
        return isValidBST(root.right);
    }
}