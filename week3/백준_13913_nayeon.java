import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    public static void main(String[] args) throws IOException {
        int n;
        int k;
        int[] visited = new int[100001];
        int[] path = new int[100001];

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(n,0));
        visited[n] = 1;
        path[n] = -1;

        while(!q.isEmpty()) {
            Point tmp = q.remove();

            if (tmp.pos == k) {
                sb.append(tmp.time).append('\n');
                LinkedList<Integer> list = new LinkedList<>();
                list.add(k);
                while (path[k] != -1) {
                    list.addFirst(path[k]);
                    k = path[k];
                }
                for (Integer integer : list) {
                    sb.append(integer).append(' ');
                }

                System.out.println(sb);
                return;
            }

            int[] nx = {tmp.pos, -1, 1};
            for (int i = 0; i < 3; i++) {
                int next = tmp.pos + nx[i];
                if (next >= 0 && next < 100001 && visited[next] != 1) {
                    path[next] = tmp.pos;
                    visited[next] = 1;
                    q.offer(new Point(next, tmp.time + 1));
                }
            }
        }
    }
}

class Point{
    int pos;
    int time;

    public Point(int pos, int time) {
        this.pos = pos;
        this.time = time;
    }
}  

