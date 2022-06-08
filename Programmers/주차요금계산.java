import java.util.*;


public class Solution {

	public static int[] solution(int[] fees, String[] records) {
        int[] answer = {};
       
        Map<String, Integer> startTime = new HashMap<>();
        Map<String, Integer> totalTime = new HashMap<>();
        
        Set<String> carNum = new HashSet<>();
        
        for (String s : records) {
        	String[] str = s.split(" ");
            String[] times = str[0].split(":");
            int min = (Integer.parseInt(times[0]) * 60) + Integer.parseInt(times[1]);
            String num = str[1];
            
            if(str[2].equals("IN")) {
            	startTime.put(num, min);
            	carNum.add(num);
            } else {
            	
            	if(totalTime.containsKey(num)) {
            		totalTime.put(num, totalTime.get(num) + (min-startTime.get(num)));
            	} else {
            		totalTime.put(num, min-startTime.get(num));
            	}

            	startTime.put(num, -1);
            	
            }    
		}
        
        
        
        // 출차가 안된 자동차를 출차처리
        startTime.forEach((key, value) -> {
        	if(startTime.get(key) != -1) {
        		if(totalTime.containsKey(key)) {
        			totalTime.put(key, totalTime.get(key)+(1439-startTime.get(key)));
            	} else {
            		totalTime.put(key, 1439-startTime.get(key));
            	}
        	}
        });
        
        
        // 자동차넘버 정렬
        List<String> list = new ArrayList<>(carNum);
        Collections.sort(list);
        
        answer = new int[carNum.size()];
        
        int cnt = 0;
        for (String num : list) {   	
        	if (totalTime.get(num) <= fees[0]) {
        		answer[cnt] = fees[1];
			} else {
				int temp = (int) Math.ceil((double)(totalTime.get(num)-fees[0])/fees[2]);
				answer[cnt] = fees[1] + (temp*fees[3]);
			}
        	cnt++;
		}

        return answer;
    }
	
	public static void main(String[] args) {
		
		int[] fees = {1, 461, 1, 10};
		String[] records = {"00:00 1234 IN"};
		
		int[] a = solution(fees, records);

		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}

	}

}
