package 백준_01132022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

/**
 * 1/12/2022
 * @author JUNE PARK
 * comparable과 중복 확인 문제
 *
 */
public class 실버5_1181_단어정렬 {

	public static class Word implements Comparable<Word> {
		String str;
		int length;

		Word(String str, int length) {
			this.str = str;
			this.length = length;
		}

		@Override
		public int compareTo(Word o) {
			if (this.length != o.length)
				return this.length - o.length;
			return this.str.compareTo(o.str);
		}
	}

	static ArrayList<Word> words;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		words = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		boolean dup= false; //중복 단어인지 아닌지 체크 false: not duplicate, true :duplicate
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if(words.isEmpty()) words.add(new Word(str, str.length()));
			else {
				for(int j = 0 ; j<words.size() ; j++) {
					if(dup)break;//중복이면 리스트 그만 확인하고 나온다
					if(words.get(j).str.equals(str)) dup = true;//중복
				}
				if(dup) dup = false; //중복이면 다시 중복 변수 false로 넘기고 다음 인풋 판단
				else words.add(new Word(str,str.length())); //중복x인 경우 리스트에 더함
			}
		}

		Collections.sort(words);
	
		for(int i = 0 ; i < words.size() ; i++)bw.write(words.get(i).str+"\n");
		bw.flush();
	}

}
