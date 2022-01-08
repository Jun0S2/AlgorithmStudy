package 백준_01072022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 * @author June Park
 * 실버4
 * 해쉬맵을 사용하면 중복 체크가 가능 -> 해쉬맵을 덱으로 놓고 이미 카드가 잇으면 value update
 * 숫자 범위가 크기 떄문에 array를 사용하지 않고 해쉬맵을 사용했다.
 * */
public class 실버_10816_숫자카드2 {

	public static void main(String[] args) throws Exception {
		HashMap<Integer,Integer> deck = new HashMap(); //카드에 적힌 숫자, value = 개수
		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter (System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ;i ++) {
			int num = Integer.parseInt(st.nextToken());
			if(!deck.containsKey(num))deck.put(num, 1);//덱에 카드가 없을 경우
			else {
				deck.put(num, deck.get(num)+1);//덱의 카드의 숫자를 업데이트
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		br.close();
		
		for(int i = 0 ; i<K ; i++) {
			int get = Integer.parseInt(st.nextToken());
			if(deck.containsKey(get)) bw.append(deck.get(get)+" ");
			else bw.append("0 ");
		}
		bw.flush();
	}

}
