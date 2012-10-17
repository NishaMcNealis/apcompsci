class PokerHand extends Deck {
  public void print() {
    for (int i=0; i<cards.length; i++) {
      cards[i].print();
    }
    System.out.print("\n");
  }

  public boolean hasFlush() {
    int suit = cards[0].suit;
    for (int i = 0; i < cards.length; i++) {
      if (cards[i].suit != suit) {
        return false;
      }
    }
    return true;
  }

  public boolean hasThreeKind() {
    int[] ranks = new int[15];
    for (int i = 0; i < ranks.length; i++) {
      ranks[i] = 0;
    }
    for (int i = 0; i < cards.length; i++) {
      ranks[card.rank]++;
    }
    for (int i = 0; i < ranks.length; i++) {
      if (ranks[i] >= 3) {
        return true;
      }
    }
    return false;
  }
}