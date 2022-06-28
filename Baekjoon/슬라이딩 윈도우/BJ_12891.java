import java.io.*;
import java.util.*;

public class BJ_12891 {
		static int checkArr[];
		static int myArr[];
		static int checkSecret;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());   //DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken());   //부분문자열 길이 (윈도우 범위)
		int Result = 0;           // 비밀번호 종류의 수		
		char A[] = new char[S];   // DNA문자열
		checkArr = new int[4];    // 포함돼야 할 최소개수 배열 [A,C,G,T]
		myArr = new int[4];       // 슬라이딩 윈도우에 해당하는 문자열 개수 배열 [A,C,G,T]
		checkSecret = 0;          // 최소개수가 만족했을 경우를 카운트하는 변수
		
		A = bf.readLine().toCharArray();
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0) {  // 최소개수가 0개이면 처음부터 만족하므로  
				checkSecret++;       // checkSecret++;
			}
		}
		
		for (int i = 0; i < P; i++) { //첫 윈도우 문자열 개수 배열 처리
			Add(A[i]);
		}
		
		// 첫 윈도우 만족하는지 체크
		if (checkSecret == 4) 
			Result++;	
		
		//슬라이딩 윈도우
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);     // 한칸 옮겼으니 새로 들어온 윈도우 끝 문자를 추가
			Remove(A[j]);  // 한칸 옮겼으니 빠져나간 문자를 제거
			if (checkSecret == 4) // 한칸씩 옮길때마다 만족하는지 체크
				Result++;
		}
		
		System.out.println(Result);
		bf.close();

	}
	
	private static void Add(char c) {
		switch (c) {
		case 'A':
			myArr[0]++;
			if (myArr[0] == checkArr[0]) 
				checkSecret++;
			break;
		case 'C':
			myArr[1]++;
			if (myArr[1] == checkArr[1]) 
				checkSecret++;
			break;
		case 'G':
			myArr[2]++;
			if (myArr[2] == checkArr[2]) 
				checkSecret++;
			break;
		case 'T':
			myArr[3]++;
			if (myArr[3] == checkArr[3]) 
				checkSecret++;
			break;	
		}
	}
	
	private static void Remove(char c) {
		switch (c) {
		case 'A':
			if (myArr[0] == checkArr[0]) 
				checkSecret--;
			myArr[0]--;
			break;
		case 'C':
			if (myArr[1] == checkArr[1]) 
				checkSecret--;
			myArr[1]--;
			break;
		case 'G':
			if (myArr[2] == checkArr[2]) 
				checkSecret--;
			myArr[2]--;
			break;
		case 'T':
			if (myArr[3] == checkArr[3]) 
				checkSecret--;
			myArr[3]--;
			break;				
		}
	}
}
