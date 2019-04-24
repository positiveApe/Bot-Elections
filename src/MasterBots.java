import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MasterBots {
	static int roundCount;
	static List<Bot> allBots = new ArrayList<Bot>();
	static List<Bot> candidateBots = new ArrayList<Bot>();
	static final List<String> bigNameList = Arrays.asList("Krista","Allen", "Amee", "tina", "Miles", "Drexel", "Archie","Craig", "Arron", "Kevin", "Dustin", "Bird", "Florida", "Brock", "Rosita", "Reed", "Eleanore", "Fincham", "Yanni", "Chump");
	public static void main(String[] args) {
		roundCount = 0;
		
		//Create bots
		List<Bot> electedBots = new ArrayList<Bot>();
		Scanner myObj = new Scanner(System.in);  // Create a Scanner object
	    System.out.println("Enter number of candidates to be generated");

	    int botNumber = myObj.nextInt();  // Read user input
	    myObj.close();
	    
	    boolean listsDone = createLists(botNumber);
	    for (Bot temp : allBots) {
			System.out.println(temp.getName());
		}
	    
	  //Vote on candidates against all bots
	    if (listsDone) {
	    	System.out.println("Voting processes is beginning");
	    	electedBots = candidateBots;
	    	List<Bot> newListBot = new ArrayList<Bot>();
	    	
	    	
	    	//Repeat process until you only have one left
	    	while (electedBots.size() > 1 && electedBots.size() != 0) {
	    		newListBot = electTheBot(electedBots);
	    		//If none are passed, then run vote again
	    		while (newListBot.isEmpty()) {
	    			newListBot = electTheBot(electedBots);
	    		}
	    		electedBots = newListBot;	
	    	}
	    	//Present the victor
	    	System.out.println("The Victor of this election is: " + electedBots.get(0).getName());
	    	System.out.println("It took " + roundCount + " rounds to get to this point");
	    	
	    }
	    
	    
	
	}
	
	private static boolean createLists(int botNumber) {
		int random;
		System.out.println("Generating Candidates.....");
		try {
			for (int i=0; i<botNumber; i++) {
				random = getRandomNumberInRange(0, 19);
		    	Bot bot = new Bot();
		    	bot.setId(i);
		    	bot.setName(bigNameList.get(random));
		    	//Create list of all bots
		    	allBots.add(bot);
		    	//Create a candidate list with all bots
		    	candidateBots.add(bot);
		    }
		return true;
		}
		catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	private static List<Bot> electTheBot(List<Bot> electedBots) {
		roundCount++;
		List<Bot> newCans = new ArrayList<Bot>();	
		for(Bot canBot : electedBots) {
    		for (Bot voteBot : allBots) {
    			boolean theVote = voteBot.vote();
    			if (theVote) {
    				canBot.setVoteCount(theVote);
    			}
    			else {
    				canBot.setVoteCount(theVote);
    			}
    		}
    	}
		// Create new list with all elected
    	for (Bot canBot : electedBots) {
    		if(canBot.getVoteCount() > 0) {
    			newCans.add(canBot);
    		}
    		
    	}
		
		return newCans;
		
	}
	
	private static int getRandomNumberInRange(int min, int max) {

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}

}
