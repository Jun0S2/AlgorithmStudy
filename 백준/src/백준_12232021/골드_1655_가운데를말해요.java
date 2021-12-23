package 백준_12232021;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;


/**
 * ArrayList 사용 시 시간초과 minHeap과 maxHeap 쓰기로 함 PriorityQueue를 이용한 가운데 값 찾기
 * -minHeap, maxHeap 규칙 1. maxHeap.size()>minHeap.size() 2. if(maxHeap의 top) >
 * (minHeap의 top) ? swap! 위 규칙을 따르면, maxHeap에는 중간값보다 작은 값들이 minHeap에는 중간값보다 큰
 * 값들이 정렬 -> maxHeap의 top을 가져옴
 */
public class 골드_1655_가운데를말해요 {
	static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
	static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o2 - o1;
		}
	});
	static int mid=-1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());// N개의 정수
		int max_mid=-1,min_mid=-1;
		for (int n = 1; n <= N; n++) {
			if(n==1) {
				mid = Integer.parseInt(br.readLine());
				maxHeap.offer(mid); //처음에는 무조건 maxHeap에 넣는다
				bw.write(String.valueOf(mid));
				bw.write("\n");
				continue;
			}
			else if(maxHeap.size()>minHeap.size()) {//maxHeap이 1 더 크면 minHeap에 샵입
				minHeap.offer(Integer.parseInt(br.readLine()));
			}
			else {//maxHeap에 삽입
				maxHeap.offer(Integer.parseInt(br.readLine()));
			}
			//2번 규칙 
			/*
			max_mid = maxHeap.poll();
			if(n>1) min_mid = minHeap.poll();
			if(max_mid>min_mid) {//maxHeap에는 mid보다 작은 애들이 있어야하는데 minHeap보다 크다면
				maxHeap.offer(min_mid);
				minHeap.offer(max_mid);
			}
			else {//다시 가져다 놓기
				maxHeap.offer(max_mid);
				minHeap.offer(min_mid);
			}
			*/
			
			// 위의 코드 간결화 :532ms -> 480ms 로 단축
			if(maxHeap.peek()>minHeap.peek()) { //maxHeap의 top이 minHeap의 top보다 클때 swap
				max_mid = maxHeap.poll();
				maxHeap.offer(minHeap.poll());
				minHeap.offer(max_mid);
			}
			
			mid = maxHeap.peek(); //중간값 갱신
			
			bw.write(String.valueOf(mid));
			bw.write("\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}



}
