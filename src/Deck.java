import java.util.Random;
public class Deck 
{
	private static final int NUMSHUF = 1000;
	private CardHolder ch;
	private char suits[] = {'C', 'D', 'H', 'S'};
		 
	public Deck()
	{
		ch = new CardHolder(52);
		for (int i = 0; i < 52; i++)
		{
			int val = (i % 13) + 1;
			char suit = suits[i / 13];
			ch.insertCard(new Card(val, suit));
		 }
     }

	public String toString()
	{
		return ch.toString();
	}

	public Card giveCard()
	{
		 return ch.giveCard();
	}

	public void insertCard(Card c)
	{
		 ch.insertCard(c);
	}

	public int getNumCards()
	{
		 return ch.getNumCards();
	}

	public boolean isEmpty()
	{
		 return ch.isEmpty();
	}

	 public boolean isFull()
	{
		 return ch.isFull();
	}

	public void shuffle()
	{
		 Random ran = new Random();
		 for (int i = 0; i < NUMSHUF; i++)
		 {
		    int where = ran.nextInt(52);
		    ch.swap(0, where);
		  }
	}

	public static void main(String args[])
	{
		 Deck d = new Deck();
		 System.out.println(d);
		 d.shuffle();
		 System.out.println(d);
	}
} 

