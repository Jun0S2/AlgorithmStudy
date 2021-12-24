package 백준_12242021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

/**
 * @author June Park silver4
 */
public class 실버_9012_괄호 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());// N개의 정수
		Stack<Character> closingBracket ;


outer:	for (int i = 0; i < N; i++) {
			String input = br.readLine();
			closingBracket=new Stack<>();
			for (int j=0;j<input.length();j++) {
				if(input.charAt(j)=='(') {//open
					closingBracket.add(')');
				}
				else {
					if(closingBracket.isEmpty()) {
						bw.write("NO\n");
						continue outer;
					}
					else {
						closingBracket.pop();
					}
				}
			}
			
			if(closingBracket.isEmpty())bw.write("YES\n");
			else bw.write("NO\n");
		}
		bw.flush();
		br.close();
	}

}
