public class PriorityQueue<E> extends AbstractQueue<E> {
  private static final int DEFAULT_CAPACITY = 11;

  int used;
 
  E[] storage;
 
  Comparator<? super E> comparator;
 
  public PriorityQueue() {
    this(DEFAULT_CAPACITY, null);
  }

  public PriorityQueue(Collection<? extends E> c) {
    this(Math.max(1, (int) (1.1 * c.size())), null);

    if (c instanceof SortedSet)	{
      SortedSet<? extends E> ss = (SortedSet<? extends E>) c;
      this.comparator = (Comparator<? super E>) ss.comparator();
      int i = 0;
      for (E val : ss)	{
	if (val == null)
       	  throw new NullPointerException();
	storage[i++] = val;
      }
    }
    else if (c instanceof PriorityQueue) {
      PriorityQueue<? extends E> pq = (PriorityQueue<? extends E>) c;
      this.comparator = (Comparator<? super E>)pq.comparator();
      System.arraycopy(pq.storage, 0, storage, 0, pq.storage.length);
    }
 
    addAll(c);
  }

  public PriorityQueue(int cap){
    this(cap, null);
  }

  public PriorityQueue(int cap, Comparator<? super E> comp){
    this.used = 0;
    this.storage = (E[]) new Object[cap];
    this.comparator = comp;
  }

  public PriorityQueue(PriorityQueue<? extends E> c){
    this(Math.max(1, (int) (1.1 * c.size())), (Comparator<? super E>)c.comparator());

    System.arraycopy(c.storage, 0, storage, 0, c.storage.length);
  }

  public PriorityQueue(SortedSet<? extends E> c){
    this(Math.max(1, (int) (1.1 * c.size())), (Comparator<? super E>)c.comparator());
    int i = 0;
    for (E val : c)
      {
	if (val == null)
	  throw new NullPointerException();
	storage[i++] = val;
      }
  }

  public void clear(){
    Arrays.fill(storage, null);
    used = 0;
  }

  public Comparator<? super E> comparator(){
    return comparator;
  }

  public Iterator<E> iterator(){
    return new Iterator<E>(){
      int index = -1;
      int count = 0;

      public boolean hasNext()	{
	return count < used;
      }

      public E next()	{
	while (storage[++index] == null;
 
	       ++count;
	       return storage[index];
	       }

	public void remove() {
	  PriorityQueue.this.remove(index);
	}
      };
    }

    public boolean offer(E o){
      if (o == null)
	throw new NullPointerException();
 
      int slot = findSlot(-1);
 
      storage[slot] = o;
      used++;
      bubbleUp(slot);
 
      return true;
    }

    public E peek(){
      return used == 0 ? null : storage[0];
    }

    public E poll(){
      if (used == 0)
	return null;
      E result = storage[0];
      remove(0);
      return result;
    }
    public boolean remove(Object o){
      if (o != null){
	for (int i = 0; i < storage.length; ++i)	{
	  if (o.equals(storage[i]))	{
	    remove(i);
	    return true;
	  }
	}
      }
      return false;
    }

    public int size(){
      return used;
    }

    public boolean addAll(Collection<? extends E> c){
      if (c == this)
	throw new IllegalArgumentException();
 
      int newSlot = -1;
      int save = used;
      for (E val : c){
	if (val == null)
	  throw new NullPointerException();
	newSlot = findSlot(newSlot);
	storage[newSlot] = val;
	used++;
	bubbleUp(newSlot);
      }
      return save != used;
    }

    int findSlot(int start){
      int slot;
      if (used == storage.length){
	resize();
	slot = used;
      }
      else{
	for (slot = start + 1; slot < storage.length; slot++)	{
	  if (storage[slot] == null)
	    break;
	}
	
      }
      return slot;
    }

    void remove(int index){
      while (storage[index] != null){
	int child = 2 * index + 1;
 
	if (child >= storage.length) {
	  storage[index] = null;
	  break;
	}
 
	if (child + 1 >= storage.length || storage[child + 1] == null){
	} else if (storage[child] == null || (Collections.compare(storage[child], storage[child + 1], comparator) > 0)) {
	  child++;
	}
	storage[index] = storage[child];
	index = child;
      }
      used--;
    }

    void bubbleUp(int index){
      while (index > 0) {
	int parent = (index - 1) / 2;
	if (Collections.compare(storage[parent], storage[index], comparator) <= 0) {
	  break;
	}
 
	E temp = storage[index];
	storage[index] = storage[parent];
	storage[parent] = temp;
 
	index = parent;
      }
    }

    void resize(){
      E[] new_data = (E[]) new Object[2 * storage.length];
      System.arraycopy(storage, 0, new_data, 0, storage.length);
      storage = new_data;
    }
  }