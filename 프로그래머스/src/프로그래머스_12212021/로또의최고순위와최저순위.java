package 프로그래머스_12212021;
/** @author June Park
 *  알고리즘 스터디 - 12/21/2021
 *  프로그래머스 LV 1 문제
 * */


import java.util.Arrays;


public class 로또의최고순위와최저순위 {

static int[] rank = {6,6,5,4,3,2,1}; //rank[맞은개수] = 순위 rank[1개맞음]=6 rank[6]=1위
	
	public static void main(String[] args) {
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		solution(lottos,win_nums);
	}
	// 출력 형식 : 최저등수 최고 등수
	public static void solution(int[] lottos, int[] win_nums) {
	
		
		int possibilities = 0;
		for(int i = 0 ; i<lottos.length ; i++) {
			if(lottos[i]==0) {possibilities++;} 
		}//0의 개수를 구함
		
		int same = 0;
		//일치 여부 확인
		for(int i = 0 ; i<lottos.length;i++) {
			if(lottos[i]<=0)continue;
			for(int j = 0  ; j<win_nums.length; j++) {
				if (win_nums[j]<0) continue;
				else if(lottos[i]==win_nums[j]) {
					same ++;
					lottos[i]=win_nums[j]=-1;
					break;
				}
			}
		}
	//	System.out.printf(" same : %d poss+same : %d",same, (same+possibilities));
	//	System.out.printf("\nrank: %d highest %d", rank[same],rank[same+possibilities]);
		int[] answer = { rank[same+possibilities],rank[same]};
		System.out.println(Arrays.toString(answer));
	}

}

