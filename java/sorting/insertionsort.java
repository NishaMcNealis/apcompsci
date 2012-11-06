import java.util.Arrays;

class insertionsort {
  public static void main(String[] args) {
    int[] arr = new int[]{5,3,4,21,1,545,21,14};
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(insertionsort(arr)));
  }

  public static int[] insertionsort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int item = arr[i];
      int iHole = i;
      while (iHole > 0 && arr[iHole-1] > item) {
        arr[iHole] = arr[iHole - 1];
        iHole -= 1;
      }
      arr[iHole] = item;
    }
    return arr;
  }
}