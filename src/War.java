public class War 
{
    static void moveFromTable(CardHolder table, CardHolder hand)
    {
        while(!table.isEmpty())
            hand.insertCard(table.giveCard());
    }
    
    static int compareCards(Card c1, Card c2)
    {
        int val1 = c1.getValue();
        int val2 = c2.getValue();
       
        if(val1 < val2)
            return -1;
        if(val1 > val2)
            return 1;
        return 0;
    }
    
    public static void main(String args[]) {
        int count = 0;
        while(!game()) 
        {
            count++;
            System.err.println("Game # "+count);
        }
      
        
    }
    
    
	public static boolean game()
	  {
		int countTurn = 0;
		int countWar = 0;
		for(int k = 0; k < 10000; k++)
		{
			Deck d = new Deck();
		    d.shuffle();
		    CardHolder hand1 = new CardHolder(52);
		    CardHolder hand2 = new CardHolder(52);
		    CardHolder table = new CardHolder(52);
		  
		    //deal cards
		    for(int i = 0; i < 26; i++)
		    {
		        hand1.insertCard(d.giveCard());
	    		hand2.insertCard(d.giveCard());
		    }
		
		    //game
		    while((!hand1.isEmpty()) && (!hand2.isEmpty()))
		    {
		    	Card c1 = hand1.giveCard();
		    	table.insertCard(c1); 
		    	
		    	Card c2 = hand2.giveCard();
		    	table.insertCard(c2); 
		    	
		    	int val = compareCards(c1, c2);
		    	
		    	if(val == 1)
		    	{
		    	    moveFromTable(table, hand1);

		    	}
		    	else if(val == -1)
		    	{
                    moveFromTable(table, hand2);
		    	}
		    	
		    	//war
		    	else 
		    	{	
		    		while(true)
		    		{
                        
		    		    if(hand1.getNumCards() < 3 || hand2.getNumCards() < 3)
		    			{
		    			    break;
		    			}
		    		    for(int j = 0; j < 2; j++)
			    		{
			    			table.insertCard(hand1.giveCard());
			    			table.insertCard(hand2.giveCard());
			    		}
		    			c1 = hand1.giveCard();
		    			c2 = hand2.giveCard();
			    		table.insertCard(c1);
			    		table.insertCard(c2);
			    		val = compareCards(c1, c2);
			    
			    		
			    		if(val == 0)
			    		{
			    		    continue;
			    		}
			    		    
			    		if(val == 1)
		                {
		                    moveFromTable(table, hand1);
		                }
		                else 
		                {
		                    moveFromTable(table, hand2);
				    	}
			    		countWar++;
			    		
			    		
		    		}
		    		System.out.println("Hand 1 " + hand1.getNumCards());
		    		System.out.println("Hand 2 " + hand2.getNumCards());
			   
		    	}
		    	countTurn++;
		    
		    	if(countTurn == 100001)
		    	{
		    		System.err.println("The game is in a loop. Current game # "+ k);
		    		break;
		    	} 
		
		    	
		     }
		    int avgTurn = countTurn/k;
		    System.out.println(avgTurn);
		    
		} 
		
		return true;
		   
		
	  }
	
}

