import java.util.Arrays;

class bubblesort {
  public static void main(String[] args) {
    int[] arr = new int[]{5,3,4,21,1,545,21,14};
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(bubblesort(arr)));
  }

  public static int[] swap(int[] arr, int a, int b) {
    int c = arr[a];
    arr[a] = arr[b];
    arr[b] = c;
    return arr;
  }

  public static int[] bubblesort(int[] arr) {
    boolean swapped = true;
    do {
      swapped = false;
      for (int i = 1; i < arr.length; i++) {
        if (arr[i-1] > arr[i]) {
          arr = swap(arr, i-1, i);
          swapped = true;
        }
      }
    } while (swapped);
    return arr;
  }
}