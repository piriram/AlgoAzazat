import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int test = 0; test < T; test++) {
            int n = Integer.parseInt(br.readLine());

            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int j = 2; j <= n; j++) {
                for (int i = 0; i < 2; i++) {
                    dp[i][j] = Math.max(dp[(i + 1) % 2][j - 1], dp[(i + 1) % 2][j - 2]) + dp[i][j];
                }
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append("\n");
        }
        System.out.print(sb);
    }
}
