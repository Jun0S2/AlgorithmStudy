package 백준_01242022;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/**
 * 어떤식으로 풀어야할지 모르겠어서고민하다가 블로그를 찾아봤는데
 * 막상 찾아보니 매우 쉬웠다..ㅠㅠ
 * 범위 잡는게 아직은 어려운것같다.
 * @author June Park
 *
 */
public class 골드_17779_게리맨더링2 {
	static int N, A[][] , total_votes;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		A = new int [N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
				total_votes += A[i][j];
			}
		}
		// 4중 for loop
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				for (int d1 = 1; d1 < N; d1++) {
					for (int d2 = 1; d2 < N; d2++) {
						if (x + d1 + d2 >= N)continue;
						if (0 > y - d1 || y + d2 >= N)continue;
						simulation(x, y, d1, d2);
					}
				}
			}
		}
		System.out.println(min);
	}
	

	/**
	 * 다음 칸은 경계선이다. 
	 * 1.  (x, y), (x+1, y-1), ..., (x+d1, y-d1)  -> x~d1, y~ d1--
	 * 2.  (x, y), (x+1, y+1), ...,(x+d2, y+d2) (x+d1, y+d2), 
	 * 3.  (x+d1+1, y-d1+1), ... (x+d1+d2, y-d1+d2) 
	 * 4.  (x+d2,y+d2), (x+d2+1, y+d2-1), ..., (x+d2+d1, y+d2-d1)
	 * 
	 * @param x
	 * @param y
	 * @param d1
	 * @param d2
	 */
	private static void simulation(int x, int y, int d1, int d2) {
		boolean border[][] = new boolean[N][N];
		// border 그리기

		for (int i = 0; i <= d1; i++) {
			border[x+i][y-i] = true;// (x+1, y-1)=>1번 조건
			border[x+d2+i][y+d2-i] = true;//[x+d1+d2][x+d2-d1] => 4번 조건
		}
		for(int i = 0; i<=d2 ; i++) {
			border[x+i][y+i] = true;//2번 조건
			border[x+d1+i][y+i+-d1] = true;//3번 조건
		}
		
		int [] votes = new int[5];//선거구 분할
		
		 //1 구역
        for (int i = 0; i < x + d1; i++) {
            for (int j = 0; j <= y; j++) {
                if (border[i][j]) break;
                votes[0] += A[i][j];
            }
        }

        //2구역
        for (int i = 0; i <= x + d2; i++) {
            for (int j = N - 1; j > y; j--) {
                if (border[i][j]) break;
                votes[1] += A[i][j];
            }
        }

        //3구역
        for (int i = x + d1; i < N; i++) {
            for (int j = 0; j < y - d1 + d2; j++) {
                if (border[i][j]) break;
                votes[2] += A[i][j];
            }
        }

        //4구역
        for (int i = x + d2 + 1; i < N; i++) {
            for (int j = N - 1; j >= y - d1 + d2; j--) {
                if (border[i][j]) break;
                votes[3] += A[i][j];
            }
        }

		//5구역
		votes[4] = total_votes;
		
		for(int i = 0 ; i<4 ; i++) {
			votes[4] -= votes[i];
		}
		
		Arrays.sort(votes);
		min = votes[4]- votes[0] < min ? votes[4]-votes[0] : min;
	}

}
