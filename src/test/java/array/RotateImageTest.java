package array;

public class RotateImageTest {
    public static void main(String[] args) {
        RotateImage ri = new RotateImage();
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        ri.rotate(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}
