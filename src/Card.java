public class Card {
	 private int value;
	  private char suit;

	  public Card(int v, char s)
	  {
	    if (v < 1 || v > 13)
	    {
	      System.err.println("Invalid card value" + v);
	      System.exit(1);
	    }
	    if (s == 'c')
	      s = 'C';
	    if (s == 'd')
	      s = 'D';
	    if (s == 'h')
	      s = 'H';
	    if (s == 's')
	      s = 'S';

	    if (s != 'C' && s != 'D' && s != 'H' && s != 'S')
	    {
	      System.err.println("Invalid card suit " + s);
	      System.exit(1);
	    }
	    
	    this.value = v;
	    this.suit = s;
	  }

	  private String value2String()
	  {
	    String sval[] = {"null", "Ace", "Two", "Three", "Four", "Five",
	                   "Six", "Seven", "Eight", "Nine", "Ten", "Jack",
	                   "Queen", "King"};
	    return sval[this.value];
	  }

	  private String suit2String()
	  {
	    String retval = "";

	    switch(this.suit)
	    {
	case 'C':
	      retval = "Clubs";
	      break;
	case 'D':
	      retval = "Diamonds";
	      break;
	case 'H':
	      retval = "Hearts";
	      break;
	case 'S':
	      retval = "Spades";
	    }
	    return retval;
	  }

	  public int getValue()
	  {
	    return this.value;
	  }
	 
	  public String getStringValue()
	   {
	     return this.value2String();
	  }
	 
	  public char getSuit()
	  {
	    return this.suit;
	  }
	 
	  public String toString()
	  {
	    return "The " + this.value2String() + " of " + suit2String();
	  }

	  public static void main(String args[])
	  {
	    Card c = new Card(10, 's');
	    System.out.println(c);
	  }
}
