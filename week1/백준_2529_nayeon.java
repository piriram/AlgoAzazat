import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//static 사용 이유 -> 클래스 접근 없이 (ex. (boj).~ 이렇게 점 안 붙이고 사용하기 위해서

public class Boj2529nayeon {
    static int[] comp;
    static int k;
    static List<String> nums = new ArrayList<>();
    static boolean[] visited = new boolean[10];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine()); // 입력 받은 것을 정수로 바꾸기
        comp = new int[k];

        StringTokenizer st = new StringTokenizer(br.readLine()); //디폴트 값이 공백으로 나눔

        for (int i = 0 ; i < k; i++){
            comp[i] = st.nextToken().charAt(0);
        }

        dfs("");

        System.out.println(nums.get(nums.size()-1));
        System.out.println(nums.get(0));

    }

    static void dfs(String input){
        if (input.length() == k + 1){
            nums.add(input);
            return;
        }

        for (int i = 0 ; i<10; i++){
            if (!visited[i]){

                if (input.length() == 0){
                    visited[i] = true;
                    dfs(input + i);
                    visited[i] = false;
                }

                else{
                    //부등호 < > 뭔지 찾기
                    if (comp[input.length()-1] == '<'){
                        if (input.charAt(input.length()-1) - '0' < i){
                            visited[i] = true;
                            dfs(input + i);
                            visited[i] = false;
                        }
                    }
                    else{
                        if (input.charAt(input.length()-1) - '0' > i){
                            visited[i] = true;
                            dfs(input + i);
                            visited[i] = false;
                        }
                    }
                }
            }
        }
    }
}
