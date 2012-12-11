import java.util.Random;
import java.util.ArrayList;

class quicksort {
  public static void main(String[] args) {
    ArrayList<Integer> randl = new ArrayList<Integer>();
    Random rand = new Random();

    for (int i = 0; i < 15; i++) randl.add(rand.nextInt(100));

    System.out.println(randl.toString());
    System.out.println(quicksort(randl).toString());
  }

  public static ArrayList<Integer> quicksort(ArrayList<Integer> a) {
    if (a.size() <= 1) return a;

    int p = a.get(0);
    a.remove(0);

    ArrayList<Integer> less = new ArrayList<Integer>();
    ArrayList<Integer> greater = new ArrayList<Integer>();

    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) <= p) less.add(a.get(i));
      else greater.add(a.get(i));
    }

    less = quicksort(less);
    less.add(p);
    less.addAll(quicksort(greater));
    return less;
  }
}