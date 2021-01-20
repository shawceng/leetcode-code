package array;

public class LongestConsecutiveTest {
    public static void main(String[] args) {
        LongestConsecutive longestConsecutive = new LongestConsecutive();
        int[] arr = new int[]{0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive.longestConsecutiveSet(arr));
    }
}
