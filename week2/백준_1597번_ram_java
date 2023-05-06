//package breaktime;
import java.util.*;
import java.io.*;

// 숨바꼭질 문제 실버1
public class BoJ1697 {
	// N: 수빈이의 위치, K: 동생의 위치, check: 방문 여부를 저장할 배열
	static int N, K;
	static int[] check = new int[100001];
	
	// 메인 함수
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		
		// 수빈이와 동생이 같은 위치에 있다면, 이동할 필요가 없다.
		if (N == K) {
			System.out.println(0);
		} else {
			// 수빈이와 동생의 위치가 다르다면 bfs 함수를 호출
			bfs(N);
		}
	}
	
	// 너비 우선 탐색
	static void bfs(int n) {
		Queue<Integer> q = new LinkedList<>();
		q.add(n);
		check[n] = 1;
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			
			// 현재 위치에서 갈 수 있는 경우의 수는 총 3가지입
			for (int i = 0; i < 3; i++) {
				int next;
				
				// 1. 한 칸 앞으로 이동
				if (i == 0) {
					next = tmp + 1;
				}
					// 2. 한 칸 뒤로 이동
				else if (i == 1) {
					next = tmp - 1;
				}
					// 3. 순간이동
				else {
					next = tmp * 2;
				}
				
					// 동생을 찾았다면 결과를 출력하고 종료
				if (next == K) {
					System.out.println(check[tmp]);
					return;
				}
				
					// 다음 위치가 범위 내에 있고, 방문하지 않았다면 큐에 추가
				if (next >= 0 && next < check.length && check[next] == 0) {
					q.add(next);
					check[next] = check[tmp] + 1;
				}
				
			}
		}
		
	}
}
