package 프로그래머스_02062022;

import java.util.*;

public class 입국심사 {

	public static class Node implements Comparable<Node> {
		long time; // 소요 시간
		int index;

		Node(long time, int index) {
			this.time = time;
			this.index = index;
		}

		@Override
		public int compareTo(Node o) {

			return (int) (this.time - o.time);
		}
	}

	public static void main(String[] args) {
		입국심사 s = new 입국심사();
		System.out.println(s.solution(6, new int[] { 7, 10 }));
	}

	public long solution(int n, int[] times) {
		long answer = -1;
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for (int i = 0; i < times.length; i++) {// 심사위원 전부 큐에 넣음
			pq.add(new Node((long) times[i], i));
		}
		for (int i = 0; i < n; i++) {// n명동안...가장 짧은 시간사람한테
			Node node = pq.poll();
			if(i==n-1) {
				answer = Math.max(node.time,answer);
			}
			else {
			long addTime = node.time + times[node.index];// 이전 시간 + 현재 시간
			pq.add(new Node(addTime, node.index));
			}
		}

		/*while (!pq.isEmpty()) {
			Node check = pq.poll();
			//System.out.println(check.time + "과 " + check.index);
			long hello = check.time - times[check.index];
			answer = Math.max(answer, hello);
		}*/

		return answer;
	}

}
