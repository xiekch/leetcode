/**
 * Definition for a binary tree TreeNode.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 */
class Solution {
public:
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        if(preorder.size()==0)return nullptr;
        return createTree(&preorder[0],&inorder[0],preorder.size());
    }
    
    TreeNode* createTree(int* preorder,int* inorder,int length){
        if(length==0)return nullptr;
        int i;
        for(i=0;i<length;i++){
            if(inorder[i]==preorder[0])break;
        }
        TreeNode* n=new TreeNode(preorder[0]);
        n->left= createTree(preorder+1,inorder,i);
        n->right= createTree(preorder+i+1,inorder+i+1,length-i-1);
        return n;
    }
};