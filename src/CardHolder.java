public class CardHolder 
	{
	  Card cards[];
	  int size;
	  int numCards;

	  public CardHolder(int num)
	  {
	    this.size = num;
	    this.numCards = 0;
	    cards = new Card[num];
	  }

	  public int getNumCards()
	  {
	    return this.numCards;
	  }

	  public void insertCard(Card c)
	  {
	    if(numCards >= size)
	    {
	      System.err.println("CardHolder is full");
	      System.exit(1);
	    }
	    else
	    {
	      cards[numCards] = c;
	      numCards++;
	    }
	  }

	  public Card giveCard()
	  {
	    Card retval = null;
	    if (numCards == 0)
	    {
	      System.err.println("CardHolder already empty");
	      System.exit(1);
	    }
	    else
	    {
	      numCards--;
	      retval = cards[0];
	      for (int i = 0; i < numCards; i++)
	      {
	        cards[i] = cards[i+1];
	      }
	    }
	    return retval;
	  }

	  public boolean isEmpty()
	  {
	    return numCards == 0;
	  }

	  public boolean isFull()
	  {
	    return numCards >= size;
	  }

	  public String toString()
	  {
	    String retval = "";
	    for (int i = 0; i < this.numCards; i++)
	    {
	      retval += cards[i] + "\n";
	    }
	    return retval;
	  }

	  public void swap(int m, int n)
	  {
	    Card temp = cards[m];
	    cards[m] = cards[n];
	    cards[n] = temp;
	  }
	  


	  public static void main(String args[])
	  {

	    if(args.length != 1)
	    {
	      System.err.println("Usage: java CardHolder <suit>");
	      System.exit(1);
	    }
	    
	    char suit = args[0].charAt(0);

	    CardHolder ch = new CardHolder(5);
	    for (int i = 1; i <= 5; i++)
	    {
	      ch.insertCard(new Card(i, suit));
	    }

	    System.out.println(ch);

	    while (!ch.isEmpty())
	    {
	      System.out.println(ch.giveCard());
	  }
   }
} 


