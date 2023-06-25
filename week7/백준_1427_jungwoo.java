import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int[] nums = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            nums[i] = str.charAt(i) - '0';
        }
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] < nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d", nums[i]);
        }
    }
}
