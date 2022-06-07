import java.util.*;

class Solution {

    int minSearch(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0 , right = distance;
        while(left <= right){
            int mid = (left+right)/2;
            int removeRocks = 0;
            int prev = 0;

            for(int i = 0; i < rocks.length ; i++){
                if((rocks[i]-prev) < mid)
                    removeRocks++;
                else
                    prev = rocks[i];
            }

            if(distance - prev < mid)
                removeRocks++;

            if(removeRocks <= n) {
                answer = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;

        }
        return answer;
    }

    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);

        return minSearch(distance, rocks, n);    

    }
}
