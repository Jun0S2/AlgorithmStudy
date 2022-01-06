package 백준_01072022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 실버_10773_제로 {
/**
 * @author June Park
 * 실버 4
 * 0: 가장 최근수를 지움 -> 스택을 사용 하여 pop
 */
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		Stack<Integer> num = new Stack<>();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i<t; i++) {
			int input = Integer.parseInt(br.readLine());
			if(input == 0 && !num.isEmpty()) num.pop();
			else num.add(input);
		}

		int answer = 0;
		
		while(!num.isEmpty()) {
			answer +=num.pop();
		}
		
		System.out.println(answer);
	}

}
