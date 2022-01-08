package 백준_01072022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 
 * @author June Park
 * 실버4
 * 큐 자료구조 구현
 */
public class 실버_10845_큐 {

	static ArrayList<Integer> queue = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter (new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		for(int i = 0 ; i<N ;i ++) {
			String commands[] = br.readLine().split(" ");
			if(commands.length==1) {
				switch (commands[0]) {
				case "front":
					bw.append(Integer.toString(front()));
					break;
				case "back":
					bw.append(Integer.toString(back()));
					break;
				case "size":
					bw.append(Integer.toString(size()));
					break;
				case "empty":
					if(queue.isEmpty())bw.append("1");
					else bw.append("0");
					break;
				case "pop":
					bw.append(Integer.toString(pop()));
					break;
				}
				bw.append("\n");
			}
			else {
				push(Integer.parseInt(commands[1]));
			}
		
		}
		br.close();
		bw.flush();
		bw.close();
	}
	
	//push
	private static void push(int num) {
		queue.add(num);
	}
	
	//size
	private static int size() {
		return queue.size();
	}
	
	//peek
	private static int front() {
		if(!queue.isEmpty())return queue.get(0);
		else return -1;
	}
	
	private static int back() {
		if(!queue.isEmpty())return queue.get(queue.size()-1);
		else return -1;
		
	}
	//pop
	private static int pop() {
		if(!queue.isEmpty()) {int ans = queue.remove(0); return ans;}
		return -1;
	}
}
