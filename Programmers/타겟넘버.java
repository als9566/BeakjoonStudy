class Solution {

    int answer = 0;

    public void dfs(int index, int[] number, int target, int sum) {
        if(index == number.length){
            if(sum == target){
                this.answer++;
            }
            return;
        }

        dfs(index + 1, number, target, sum+number[index]);
        dfs(index + 1, number, target, sum-number[index]);

    }

    public int solution(int[] numbers, int target) {

        dfs(0,numbers,target,0);

        return answer;
    }
}
