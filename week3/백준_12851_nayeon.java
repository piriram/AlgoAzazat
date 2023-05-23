import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Boj12851 {
    static int n;
    static int k;
    static int[] visited = new int[100001];
    static int sec = Integer.MAX_VALUE;
    static int count = 0;

    static void bfs(int now){
        Queue<Integer> q= new LinkedList<>();
        q.add(now);
        visited[now] = 1;

        while(!q.isEmpty()){
            int tmp = q.poll();
            if (sec < visited[tmp]){
                return;
            }

            for(int i = 0; i < 3; i++){
                int next;
                if (i == 0){
                    next = tmp - 1;
                } else if (i == 1) {
                    next = tmp + 1;
                }else {
                    next = tmp * 2;
                }

                if (next == k){
                    sec = visited[tmp];
                    count++;
                }
                
                // 여기가 포인트!..
                if (next >= 0 && next <= 100000 && (visited[next] == 0 || visited[next] == visited[tmp] + 1)){
                    q.add(next);
                    visited[next] = visited[tmp] + 1;
                }

            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n == k){
            System.out.println(0);
            System.out.println(1);
        }else{
            bfs(n);

            System.out.println(sec);
            System.out.println(count);

        }
    }
}
