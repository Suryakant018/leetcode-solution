
class Solution {
public static int noOfDigits(int n){
int count=0;
String str=Integer.toString(n);
for(int i=0;i<str.length();i++){
count++;
}
return count;
}
public static int pathSum(TreeNode root1,int num){
if(root1==null) return 0;
num= (int)(num * Math.pow(10,noOfDigits(root1.val)) + root1.val);
if(root1.right==null && root1.left==null) return num;
int leftSum=pathSum(root1.left,num);
int rightSum=pathSum(root1.right,num);
return leftSum+rightSum;
}
public int sumNumbers(TreeNode root) {
return pathSum(root,0);
}
}