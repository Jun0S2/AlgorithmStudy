package 백준_01102022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
/**
 * silver3
 * 풀이 시간 : 40분
 * @author June Park
 * 처음 풀이 : stringbuilder 로 string fcn을 사용하였지만 시간초과가 남
 * 구글링 후, stack을 왼쪽 오른쪽으로 사용하는 방식을 찾음 :https://minhamina.tistory.com/17 참고*
 * 스택은 push 와 pop 이 각 각 O(n)이기 때문에 시간초과를 피할 수 있었음
 */
public class 실버_에디터 {
public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
	Stack<Character> left = new Stack<>();
	Stack<Character> right = new Stack<>();
	
	String str = br.readLine();
	for(int i = 0; i<str.length() ;i ++) left.push(str.charAt(i));
	
	int N = Integer.parseInt(br.readLine());
	for(int i = 0 ; i < N ;i++) {
		String[] command = br.readLine().split(" ");
		switch (command[0]) {
		case "L": //커서를 왼쪽으로 한 칸 옮김 -> 문장의 맨 앞이면 무시
			if(!left.isEmpty())right.push(left.pop()); //오른 칸에 하나 옮김
			break;
		case "D": //커서를 오른쪽으로 한 칸 옮김 -> 문장의 맨 뒤면 무시
			if(!right.isEmpty())left.push(right.pop());//왼쪽 칸에 한칸 옮김
			break;
		case "B" : //커서 왼쪽의 문자 삭제 ( 커서가 문장의 맨 앞이면 무시). 커서 인덱스는 그대로
			if(!left.isEmpty())left.pop();
			break;
		case "P": //커서 왼쪽에 command[1]을 추가한다
			left.push(command[1].toCharArray()[0]);
			break;
		}
		//System.out.println("left : "+left.toString());
		//System.out.println("right: "+right.toString());
	}
	br.close();
	//sb에 옮겨 담기
	while(!left.isEmpty()) {right.push(left.pop());}
	while(!right.isEmpty()) {bw.write(right.pop());}
	bw.flush();
	bw.close();
}
}
/* 시간 초과 코드 : 
switch (command[0]) {
case "L": //커서를 왼쪽으로 한 칸 옮김 -> 문장의 맨 앞이면 무시
	if(cursor!=0)cursor--;
	break;
case "D": //커서를 오른쪽으로 한 칸 옮김 -> 문장의 맨 뒤면 무시
	if(cursor!=sb.length())cursor++;
	break;
case "B" : //커서 왼쪽의 문자 삭제 ( 커서가 문장의 맨 앞이면 무시). 커서 인덱스는 그대로
	if(cursor==0)break;//맨 왼쪽이면 지울 문자가 없음
	sb.deleteCharAt(cursor-1);//커서 왼쪽에 있는 애 줄임
	cursor--;
	break;
case "P": //커서 왼쪽에 command[1]을 추가한다
	sb.insert(cursor, command[1]);
	if(cursor!=sb.length())cursor++;
	break;
}*/
