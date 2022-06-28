import java.io.*;
import java.util.*;

public class BJ_12891 {
		static int checkArr[];
		static int myArr[];
		static int checkSecret;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int S = Integer.parseInt(st.nextToken());   //DNA ���ڿ� ����
		int P = Integer.parseInt(st.nextToken());   //�κй��ڿ� ���� (������ ����)
		int Result = 0;           // ��й�ȣ ������ ��		
		char A[] = new char[S];   // DNA���ڿ�
		checkArr = new int[4];    // ���Եž� �� �ּҰ��� �迭 [A,C,G,T]
		myArr = new int[4];       // �����̵� �����쿡 �ش��ϴ� ���ڿ� ���� �迭 [A,C,G,T]
		checkSecret = 0;          // �ּҰ����� �������� ��츦 ī��Ʈ�ϴ� ����
		
		A = bf.readLine().toCharArray();
		st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < 4; i++) {
			checkArr[i] = Integer.parseInt(st.nextToken());
			if (checkArr[i] == 0) {  // �ּҰ����� 0���̸� ó������ �����ϹǷ�  
				checkSecret++;       // checkSecret++;
			}
		}
		
		for (int i = 0; i < P; i++) { //ù ������ ���ڿ� ���� �迭 ó��
			Add(A[i]);
		}
		
		// ù ������ �����ϴ��� üũ
		if (checkSecret == 4) 
			Result++;	
		
		//�����̵� ������
		for (int i = P; i < S; i++) {
			int j = i - P;
			Add(A[i]);     // ��ĭ �Ű����� ���� ���� ������ �� ���ڸ� �߰�
			Remove(A[j]);  // ��ĭ �Ű����� �������� ���ڸ� ����
			if (checkSecret == 4) // ��ĭ�� �ű涧���� �����ϴ��� üũ
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
