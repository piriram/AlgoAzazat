import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int k;
    static boolean[] visited = new boolean[100001];
    static int ans = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        if (n >= k ){
            System.out.println(n-k);
            return;
        }

        bfs();
        System.out.println(ans);

    }

    static void bfs(){
        PriorityQueue<Point> q = new PriorityQueue<>();
        q.offer(new Point(n,0));

        while(!(q.isEmpty())){
            Point point = q.remove();
            visited[point.pos] = true;

            if (point.pos == k){
                ans =  point.time;
                return;
            }

            int[] nx = {point.pos, -1, 1};

            for (int i = 0; i<3; i++){
                int nxPos = point.pos + nx[i];
                if (nxPos >= 0 && nxPos < 100001 && !visited[nxPos]) {
                        if (i == 0) {
                            q.offer(new Point(nxPos, point.time));
                        } else {
                            q.offer(new Point(nxPos, point.time + 1));
                        }
                    }
            }
        }

    }

    static class Point implements Comparable<Point>{
        int pos;
        int time;

        public Point(int pos, int time) {
            this.pos = pos;
            this.time = time;
        }

        @Override
        public int compareTo(Point p){
            return time - p.time;
        }
    }
}
