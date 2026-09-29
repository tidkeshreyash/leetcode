class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m*k > n){
            return -1;
        }
        int minValue=Integer.MAX_VALUE,maxValue=Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            minValue = Math.min(minValue,bloomDay[i]);
            maxValue = Math.max(maxValue,bloomDay[i]);
        }
        while(minValue<maxValue){
            int mid = minValue + (maxValue-minValue)/2;
            if(canMakeBouquets( bloomDay,m,k,mid)){
                maxValue = mid;
            }else{
                minValue = mid + 1;
            }
        }

        return minValue;
    }

    private boolean canMakeBouquets(int[] arr, int m, int k, int day){
        int count = 0, cnt=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] <= day){
                count++;
            }else{
                cnt += count/k;
                count=0;
                if(cnt >= m){
                    return true;
                }
            }
        }
        cnt += count/k;
        if(cnt >= m){
            return true;
        }

        return false;
    }
}