package 백준_12242021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class 실버_11651_좌표정렬하기2 {
	public static class points implements Comparable<points>{
		int x,y;
		points(int x, int y){
			this.x = x;
			this.y = y;
		}
		@Override
		public int compareTo(points o) {
			//y좌표 작은순
			if(this.y-o.y!=0) return this.y-o.y;
			else return this.x-o.x;
		}
	
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());// N개의 정수
		ArrayList<points> grid = new ArrayList<>();
	
		StringTokenizer st ;
		for(int i = 0;i<N; i ++) {
			st = new StringTokenizer(br.readLine());
			grid.add(new points(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
		}
		br.close();
		Collections.sort(grid);
		for(int i = 0 ; i< N ; i++) {
			bw.write(String.valueOf(grid.get(i).x));
			bw.write(" ");
			bw.write(String.valueOf(grid.get(i).y));
			bw.write("\n");
		}
		bw.flush();
		bw.close();
	}

}
