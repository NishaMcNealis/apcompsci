import java.util.Random;
import java.util.ArrayList;

class quicksort {
  public static void main(String[] args) {
    ArrayList<Integer> randl = new ArrayList<Integer>();
    Random rand = new Random();

    for (int i = 0; i < 15; i++) randl.add(rand.nextInt(100));

    System.out.println(quicksort(randl, randl.size()/2));
  }

  public static int quicksort(ArrayList<Integer> a, int med) {
    if (a.size() == 1) return a.get(0);

    Random rand = new Random();
    int r = rand.nextInt(a.size());

    int p = a.get(r);
    a.remove(r);

    ArrayList<Integer> less = new ArrayList<Integer>(), greater = new ArrayList<Integer>();

    for (int i = 0; i < a.size(); i++) {
      int el = a.get(i);
      if (el <= p) less.add(el);
      else greater.add(el);
    }

    if (med <= less.size()) return quicksort(less, med);
    else if (med > less.size()-greater.size()) return quicksort(greater, med-(a.size()-greater.size()));
    else return p;
  }
}