class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        while (m > 0 && n > 0){
            if (nums1[m-1] >= nums2[n-1]){
                nums1[m+n-1] = nums1[m-1];
                m--;
            } else{
                nums1[m+n-1] = nums2[n-1];
                n--;
            }
        }
        while (n > 0){
            n--;
            nums1[n--] = nums2[n--];
        }
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1){
            nums1[k--] = (nums1[i] >= nums2[j]) ? nums1[i--] : nums2[j--];
        }
        while (j > -1){
            nums1[k--] = nums2[j--];
        }
    }
}