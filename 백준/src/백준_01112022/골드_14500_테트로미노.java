package 백준_01112022;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

/**
 * 
 * @author June Park
 * Gold 5
 * 구현 문제: 모든 가짓수를 생각했을 때 가장 쉽게 이해됬다.
 *
 */
public class 골드_14500_테트로미노 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		max = -1 ;
		
		bw.write(Integer.toString(solution(board, N, M)));
		bw.flush();
	}

	static int poly[][][] = { { { 0, 0, 0, 0 }, { 0, 1, 2, 3 } }, // 1v
			{ { 0, 0, 0, 1 }, { 0, 1, 2, 2 } }, // 2vv
			{ { 0, 1, 1, 1 }, { 2, 0, 1, 2 } }, // 3vv
			{ { 0, 0, 0, 1 }, { 0, 1, 2, 0 } }, // 4vv
			{ { 0, 1, 1, 1 }, { 0, 0, 1, 2 } }, // 5vv
			{ { 0, 0, 1, 1 }, { 0, 1, 0, 1 } }, // 6vv
			{ { 0, 0, 1, 2 }, { 0, 1, 0, 0 } }, // 7vv
			{ { 0, 0, 1, 2 }, { 0, 1, 1, 1 } }, // 8vv
			{ { 0, 1, 1, 2 }, { 0, 0, 1, 0 } }, // 9vv
			{ { 0, 1, 1, 1 }, { 1, 0, 1, 2 } }, // 10vv
			{ { 0, 1, 1, 2 }, { 1, 0, 1, 1 } }, // 11vv
			{ { 0, 0, 0, 1 }, { 0, 1, 2, 1 } }, // 12vv
			{ { 0, 1, 2, 2 }, { 0, 0, 0, 1 } }, // 13vv
			{ { 0, 1, 2, 2 }, { 1, 1, 1, 0 } }, // 14vv
			{ { 0, 1, 2, 3 }, { 0, 0, 0, 0 } }, // 15vv
			{ { 0, 1, 1, 2 }, { 0, 0, 1, 1 } }, // 16vv
			{ { 0, 1, 1, 2 }, { 1, 0, 1, 0 } }, // 17vv
			{ { 0, 0, 1, 1 }, { 0, 1, 1, 2 } }, // 18v
			{ { 0, 0, 1, 1 }, { 1, 2, 0, 1 } }, // 19v
	};

	static int max;
	private static int solution(int[][] board, int N, int M) {
		int sum;
		for (int i = 0; i < N; i++) {// 높이 가로
			for (int j = 0; j < M; j++) {// 열
		back: 	for (int t = 0; t < 19; t++) { //총 19가지 폴리오미노가 있다
					sum = 0;
					try {
						for (int d = 0; d < 4; d++) {
							sum += (board[i + poly[t][0][d]][j + poly[t][1][d]]);//테트로미노
						}
					} catch (ArrayIndexOutOfBoundsException e) { continue back;}//범위 벗어나면 다음 폴리오미노로 넘어간다
					max = sum>max?sum:max;										//max 갱신
				}//end of 19
			}
		}
		return max;
	}

}
