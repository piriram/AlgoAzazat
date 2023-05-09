import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj1697 {
    static int n;
    static int k;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k){
            System.out.println(0);
        }else{
            bfs(n);
        }

    }

    static void bfs(int now){
        Queue<Integer> q = new LinkedList<>(); // 자바에서 큐 구현할 때 사용
        q.add(now); // 큐에 넣기
        visited[now] = 1;

        while(!q.isEmpty()){
            int tmp = q.poll(); // 가장 먼저 들어간 원소를 꺼내고 리턴

            for(int i = 0; i < 3; i++){ // 3번 반복 (+1, -1, *2)
                int next;
                if (i == 0){
                    next = tmp + 1;
                } else if (i == 1) {
                    next = tmp -1;
                }else {
                    next = tmp * 2;
                }

                if (next == k){ //다음 노드가 동생이 있는 위치라면 
                    System.out.println(visited[tmp]);
                    return;
                }

                // 다음 노드 값이 0과 100000 사이에 있고, 방문하지 않은 노드라면 방문하자
                if (next >= 0 && next <= 100000 && visited[next] == 0){

                    q.add(next);
                    visited[next] = visited[tmp] + 1;
                }
            }

        }


    }
}
