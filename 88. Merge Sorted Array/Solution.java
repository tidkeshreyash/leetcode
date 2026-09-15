class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left=0,right=0,idx=0;
        int[] arr2 = Arrays.copyOf(nums1, nums1.length);
        while(left<m && right <n){
            if(arr2[left] > nums2[right]){
                nums1[idx++] = nums2[right++];
            }else{
                nums1[idx++] = arr2[left++];
            }
        }

        while(left<m){
            nums1[idx++] = arr2[left++];
        }

        while(right<n){
            nums1[idx++] = nums2[right++];
        }
        
    }
}