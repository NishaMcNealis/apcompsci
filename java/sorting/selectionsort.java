import java.util.Arrays;

class selectionsort {
  public static void main(String[] args) {
    int[] arr = new int[]{5,3,4,21,1,545,21,14};
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(selectionsort(arr)));
  }

  public static int[] swap(int[] arr, int a, int b) {
    int c = arr[a];
    arr[a] = arr[b];
    arr[b] = c;
    return arr;
  }

  public static int[] selectionsort(int[] arr) {
    int min;
    for (int j = 0; j < arr.length-1; j++) {
      min = j;
      for (int i = j+1; i < arr.length; i++) {
        if (arr[i] < arr[min]) {
          min = i;
        }
      }
      if (min != j) {
        arr = swap(arr, j, min);
      }
    }
    return arr;
  }
}