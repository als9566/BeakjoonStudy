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

/*
	[문제풀이]
	최솟값중에 최대값(mid)을 지정하고 돌을 제거한 후
	이진탐색을 사용
	- 제거한 돌이 N개보다 많을경우는 mid값이 너무 큰것이므로 right를 mid-1하여 다시 진행해본다.
	- 제거한 돌이 N개보다 적거나 같다면 조건을 충족할 가능성이 있으므로 left를 mid+1하여 진행
*/
