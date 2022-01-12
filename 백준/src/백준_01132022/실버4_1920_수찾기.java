package 백준_01132022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.StringTokenizer;
/**
 * Silver 4
 * 612 ms <3
 * @author June Park
 * 숫자가 있는지 없는지 확인 하는건데 HashMap을 사용하면 iterations 
 * 없이contains로 바로 알 수 있기 때문에 해쉬맵을 사용했다.
 */
public class 실버4_1920_수찾기 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		HashMap<Long, Integer> numbers = new HashMap<>(); // number , 0
		/* GET NUMBERS*/
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0 ; i<N ; i++) numbers.put(Long.parseLong(st.nextToken()),0);
		/* CHECK NUMBERS*/
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		/* IF HASH CONTAINS NUBMERS -> PRINT 1 ELSE 0*/
		for(int i = 0 ; i<M ; i++) {
			if(numbers.containsKey(Long.parseLong(st.nextToken()))) bw.write("1\n");
			else bw.write("0\n");
		}
		bw.flush();
	}

}
