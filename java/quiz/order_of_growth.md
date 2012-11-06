#Topic: Order of Growth
(Marco)

## Question Four
### Given the insertion sort below, what is its worst case efficiency in big O notation?

<pre>public static void insertion_srt(int array[], int n){
  for (int i = 1; i < n; i++){
  int j = i;
  int B = array[i];
  while ((j > 0) && (array[j-1] > B)){
  array[j] = array[j-1];
  j--;
  }
  array[j] = B;
  }
} </pre>

* 1) O(n)
* 2) O(2^n)
* 3) O(n^2)
* 4) O(nlog(n))
