class Solution {
    public int countCommas(int n) {
        int result=0;
        int commas=1,start=1000;
        while(start <= n){
            long end = Math.min(n,start*1000-1);
            long count = end - start + 1;
            result += count * commas;
            start *= 1000;
            commas++;
        }
        return result;
    }
}