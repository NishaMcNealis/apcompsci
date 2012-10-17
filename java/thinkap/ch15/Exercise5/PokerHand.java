class PokerHand extends Deck {
  public void print() {
    for (int i=0; i<cards.length; i++) {
      cards[i].print();
    }
    System.out.print("\n");
  }

  public boolean hasFlush() {
    
  }
}