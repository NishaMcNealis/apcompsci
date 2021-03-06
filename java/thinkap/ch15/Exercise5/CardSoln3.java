/* 
 * Example code for Think Java (http://thinkapjava.com)
 *
 * Copyright(c) 2011 Allen B. Downey
 * GNU General Public License v3.0 (http://www.gnu.org/copyleft/gpl.html)
 *
 * @author Allen B. Downey
 */

import java.math.BigInteger;
import java.util.ArrayList;

public class CardSoln3 {
  /*
   * Test code.
   */
  public static void main(String[] args) {
    int numberOfHands = 4;
    ArrayList<PokerHand> hands = new ArrayList<PokerHand>(); 

    Deck deck = new Deck();
    for(int i = 0; i < numberOfHands; i++) {
      PokerHand hand = deck.deal();
      deck.shuffle();
      hands.add(hand);
    }

    PokerHand[] thousand = new PokerHand[10000];
    Deck tdeck = new Deck();

    int flushes, threes;
    flushes = threes = 0;
    double flushprob, threesprob;

    for (int i = 0; i < thousand.length; i++) {
      thousand[i] = new PokerHand();
      thousand[i] = tdeck.deal();
      thousand[i].sort();

      if (thousand[i].hasFlush()) {
        flushes++;
      }
      if (thousand[i].hasThreeKind()) {
        threes++;
      }
    }

    flushprob = ((double) flushes)/10000.0;
    threesprob = ((double) threes)/10000.0;

    System.out.println(flushes+","+flushprob);
    System.out.println(threes+","+threesprob);
        
  }
    
  public void printHands(ArrayList<PokerHand> hands) {
    while(hands.iterator().hasNext()) {
      System.out.println(hands.iterator().next().toString());
    }
  }

}

  /* 
     Card card = new Card(1, 1);
     card.print();
     String s = card.toString();
     System.out.println(s);
     System.out.println(card);

     Card card2 = new Card(1, 1);
     System.out.println(card.equals(card2));	    print(hands.iterator().next());


     Deck deck = new Deck();
	
     // check sortDeck
     deck.shuffle();
     deck.sort();
     checkSorted(deck);

     // check that findBisect finds each card
     int index;
     for (int i=0; i<52; i++) {
     index = deck.findBisect(deck.cards[i], 0, 
     deck.cards.length-1);
     if (index != i) {
     System.out.println("Not found!");
     }
     }
	
     // make a subdeck
     Deck hand = deck.subdeck(8, 12);
     hand.print();

     // check that findBisect doesn't find a card that's not there
     Card badCard = new Card(1, 1);
     index = hand.findBisect(badCard, 0, hand.cards.length-1);
     if (index != -1) {
     System.out.println("Found?");
     }

     // check mergeSort
     deck.shuffle();
     deck = deck.mergeSort();
     checkSorted(deck);
     }

     /*
     * Checks that the deck is sorted.
     
     public static void checkSorted(Deck deck) {
     for (int i=0; i<51; i++) {
     int flag = deck.cards[i].compareTo(deck.cards[i+1]);
     if (flag != -1) {
     System.out.println("Not sorted!");
     }
     }
     } */
