import java.util.Arrays;

public class SortArgs {
    public static void sort(String[] args) {
        int[] nums = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            nums[i] = Integer.parseInt(args[i].trim());
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length; k++) {
            if (k > 0 ) {
                System.out.print(" ");
            }
            System.out.print(nums[k]);
        }
        System.out.print("\n");
    }
}