/*
You are given two integer arrays of the same length nums1 and nums2. In one operation, you are allowed to swap nums1[i] with nums2[i].

For example, if nums1 = [1,2,3,8], and nums2 = [5,6,7,4], you can swap the element at i = 3 to obtain nums1 = [1,2,3,4] and nums2 = [5,6,7,8].
Return the minimum number of needed operations to make nums1 and nums2 strictly increasing. The test cases are generated so that the given input always makes it possible.

An array arr is strictly increasing if and only if arr[0] < arr[1] < arr[2] < ... < arr[arr.length - 1].

 

Example 1:

Input: nums1 = [1,3,5,4], nums2 = [1,2,3,7]
Output: 1
Explanation: 
Swap nums1[3] and nums2[3]. Then the sequences are:
nums1 = [1, 3, 5, 7] and nums2 = [1, 2, 3, 4]
which are both strictly increasing.
Example 2:

Input: nums1 = [0,3,5,8,9], nums2 = [2,1,4,6,9]
Output: 1
 

Constraints:

2 <= nums1.length <= 105
nums2.length == nums1.length
0 <= nums1[i], nums2[i] <= 2 * 105
*/class Solution {
    public int solveSO(int[] nums11,int[] nums12){
        int swap=0,noswap=0,currswap=0,currnoswap=0;
        for(int index=nums11.length-1;index>=1;index--){
            for(int j=1;j>=0;j--){
        int ans=Integer.MAX_VALUE;
        int prev1=nums11[index-1];
        int prev2=nums12[index-1];
        if(j==1){
        int temp=prev1;
        prev1=prev2;
        prev2=temp;    
        }
        if((prev1<nums11[index] && prev2<nums12[index])){
            ans=(int)Math.min(ans,(0+noswap));
           
        }
        if((prev2<nums11[index] && prev1<nums12[index])){
          ans=(int)Math.min(ans,(1+swap));       
            }
                if(j==0){
                    currnoswap=ans;
                }
                else{
                    currswap=ans;
                }
        }
        swap=currswap;
        noswap=currnoswap;
        
    }
        return noswap;
    }
        
    
    public int solveTab(int[] nums11,int[] nums12){
        dp=new int[nums11.length+1][2];
    
    for(int index=nums11.length-1;index>=1;index--){
        for(int j=1;j>=0;j--){
        int ans=Integer.MAX_VALUE;
        int prev1=nums11[index-1];
        int prev2=nums12[index-1];
        if(j==1){
        int temp=prev1;
        prev1=prev2;
        prev2=temp;    
        }
        if((prev1<nums11[index] && prev2<nums12[index])){
            ans=(int)Math.min(ans,(0+dp[index+1][0]));
           
        }
        if((prev2<nums11[index] && prev1<nums12[index])){
          ans=(int)Math.min(ans,(1+dp[index+1][1]));   
        }
        dp[index][j]=ans;    
        }
    }
    
    
                            

    return dp[1][0];
    }
    public int solveMem(int[] nums11,int[] nums12,int index,boolean swapped){
        if(index>=nums11.length){
            return 0;
        }
        if(dp[index][swapped==true?1:0]!=-1){
            return dp[index][swapped==true?1:0];
        }
        int ans=Integer.MAX_VALUE;
        int prev1=nums11[index-1];
        int prev2=nums12[index-1];
        if(swapped==true){
        int temp=prev1;
        prev1=prev2;
        prev2=temp;    
        }
        if((prev1<nums11[index] && prev2<nums12[index])){
            ans=(int)Math.min(ans,(0+solveMem(nums11,nums12,index+1,false)));
           
        }
        if((prev2<nums11[index] && prev1<nums12[index])){
          ans=(int)Math.min(ans,(1+solveMem(nums11,nums12,index+1,true)));   
        }
        dp[index][swapped==true?1:0]=ans;
        return ans;
        
        
        
    }
    int[][] dp;
    public int minSwap(int[] nums1, int[] nums2) {
    /*dp=new int[nums1.length+1][2];
    /*for(int i=0;i<dp.length;i++){
    for(int j=0;j<dp[0].length;j++){
    dp[i][j]=-1;    
    }
    
    }
    dp[0][0]=0;*/
   int[] nums11=new int[nums1.length+1];
  int[] nums12=new int[nums1.length+1];
int k=0;
 nums11[k]=-1;nums12[k]=-1;k++;
for(int i=0;i<nums1.length;i++){
    nums11[k]=nums1[i];
    nums12[k]=nums2[i];k++;
}

        
return solveSO(nums11,nums12);
    }
}class Solution {
    public int solveSO(int[] nums11,int[] nums12){
        int swap=0,noswap=0,currswap=0,currnoswap=0;
        for(int index=nums11.length-1;index>=1;index--){
            for(int j=1;j>=0;j--){
        int ans=Integer.MAX_VALUE;
        int prev1=nums11[index-1];
        int prev2=nums12[index-1];
        if(j==1){
        int temp=prev1;
        prev1=prev2;
        prev2=temp;    
        }
        if((prev1<nums11[index] && prev2<nums12[index])){
            ans=(int)Math.min(ans,(0+noswap));
           
        }
        if((prev2<nums11[index] && prev1<nums12[index])){
          ans=(int)Math.min(ans,(1+swap));       
            }
                if(j==0){
                    currnoswap=ans;
                }
                else{
                    currswap=ans;
                }
        }
        swap=currswap;
        noswap=currnoswap;
        
    }
        return noswap;
    }
        
    
    public int solveTab(int[] nums11,int[] nums12){
        dp=new int[nums11.length+1][2];
    
    for(int index=nums11.length-1;index>=1;index--){
        for(int j=1;j>=0;j--){
        int ans=Integer.MAX_VALUE;
        int prev1=nums11[index-1];
        int prev2=nums12[index-1];
        if(j==1){
        int temp=prev1;
        prev1=prev2;
        prev2=temp;    
        }
        if((prev1<nums11[index] && prev2<nums12[index])){
            ans=(int)Math.min(ans,(0+dp[index+1][0]));
           
        }
        if((prev2<nums11[index] && prev1<nums12[index])){
          ans=(int)Math.min(ans,(1+dp[index+1][1]));   
        }
        dp[index][j]=ans;    
        }
    }
    
    
                            

    return dp[1][0];
    }
    public int solveMem(int[] nums11,int[] nums12,int index,boolean swapped){
        if(index>=nums11.length){
            return 0;
        }
        if(dp[index][swapped==true?1:0]!=-1){
            return dp[index][swapped==true?1:0];
        }
        int ans=Integer.MAX_VALUE;
        int prev1=nums11[index-1];
        int prev2=nums12[index-1];
        if(swapped==true){
        int temp=prev1;
        prev1=prev2;
        prev2=temp;    
        }
        if((prev1<nums11[index] && prev2<nums12[index])){
            ans=(int)Math.min(ans,(0+solveMem(nums11,nums12,index+1,false)));
           
        }
        if((prev2<nums11[index] && prev1<nums12[index])){
          ans=(int)Math.min(ans,(1+solveMem(nums11,nums12,index+1,true)));   
        }
        dp[index][swapped==true?1:0]=ans;
        return ans;
        
        
        
    }
    int[][] dp;
    public int minSwap(int[] nums1, int[] nums2) {
    /*dp=new int[nums1.length+1][2];
    /*for(int i=0;i<dp.length;i++){
    for(int j=0;j<dp[0].length;j++){
    dp[i][j]=-1;    
    }
    
    }
    dp[0][0]=0;*/
   int[] nums11=new int[nums1.length+1];
  int[] nums12=new int[nums1.length+1];
int k=0;
 nums11[k]=-1;nums12[k]=-1;k++;
for(int i=0;i<nums1.length;i++){
    nums11[k]=nums1[i];
    nums12[k]=nums2[i];k++;
}

        
return solveSO(nums11,nums12);
    }
}
