public class Arrays {
    public static void main(String[] args) {
        int[] x;
        x = new int[3];
        int[] y;
        y = new int[]{1,2,3,4,5};
        int[] z = {9, 10, 11, 12, 13};
        printArray(x);
        printArray(y);
        printArray(z);
    }
    public static void printArray(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}