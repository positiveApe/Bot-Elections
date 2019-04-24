

public class Bot {
	public String humanName;
	public int id;
	public int electRound = 0;
	public boolean beenElected = false;
	public int voteCount = 0;
	
	
	
	public int getVoteCount() {
		return voteCount;
	}
	public void setVoteCount(boolean vote) {
		if (vote) {
			this.voteCount += 1;
		}
		else {
			this.voteCount -= 1;
		}
		
	}
	
	public int getElectRound() {
		return electRound;
	}
	public void setElectRound(int electRound) {
		this.electRound = electRound;
	}
	
	public boolean isBeenElected() {
		return beenElected;
	}
	public void setBeenElected(boolean beenElected) {
		this.beenElected = beenElected;
	}
	
	
	public String getName() {
		return humanName;
	}
	public void setName(String name) {
		humanName = name;
	}
	
	public int getId() {
		return id;
	}
	public void setId( int iDen) {
		id = iDen;
	}
	
	public boolean vote() {
		int random = (int)(Math.random() * 50 + 1);
		int num = random % 2;
		
		if (num == 0) {
			return false;
		}
		else {
			return true;
		}
	}

}
