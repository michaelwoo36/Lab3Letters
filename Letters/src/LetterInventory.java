
public class LetterInventory {
	
	public static final int length = 26;
	
	private int [] inventory = new int[length];
	
	private int total;
	
	public LetterInventory (String data) {
		
		for(int i = 0; i < data.length(); i++) {
	
				for(int k = 10; k < 36; k++) {
					if(Character.getNumericValue(Character.toLowerCase(data.charAt(i))) == k) {
						inventory[k-10]++;
					}
				}
		}
	
	}
	public LetterInventory() {
		
	}
	
	public int get(char letter) {
		int count = 0;
		for(int i = 0; i < inventory.length; i++) {
			if(Character.getNumericValue(Character.toLowerCase(letter)) == i + 10) {
				for(int k = 0; k < inventory[i]; k++) {
					count ++;
				}
			}
			
		}
		return count;
		
	}
	
	public void set(char letter, int value) {
		if(value < 0 || !(Character.isLetter(letter))) {
			throw new IllegalArgumentException();
		}
		else {
			for(int i = 0; i < inventory.length; i++) {
				if(Character.getNumericValue(Character.toLowerCase(letter)) == i + 10) {
						inventory[i] = value;
				}
				
			}
		}
	}
	
	public int size() {
		total = 0;
		for(int i = 0; i < inventory.length; i++) {
				total += inventory[i];
			}
		return total;
	}
	
	public boolean isEmpty() {
		if(size() > 0) {
			return false;
		}
		else {
			return true;
		}
	}
	
	

	public LetterInventory add (LetterInventory other) {
		LetterInventory added = new LetterInventory();
		for(int i = 0; i < length; i++) {
			added.inventory[i] += inventory[i];
			added.inventory [i] += other.inventory[i];
		}
		
		return added;
		
	}
	
	public LetterInventory subtract (LetterInventory other) {
		
		LetterInventory subtracted = new LetterInventory();
		for(int i = 0; i < length; i++) {
			subtracted.inventory[i] += inventory[i];
			subtracted.inventory [i] -= other.inventory[i];
			if(subtracted.inventory[i] < 0) {
				return null;
			}
		}
		
		return subtracted;
	}
	
	public String toString() {
		
		String word = "";
		
		for(int i = 0; i< inventory.length; i++) {
			if(inventory[i]>0) {
				for(int k = 0; k < inventory[i]; k++) {
					
					word += "" + (char)(i + 97);
				}
			}
		}
		
		return word;
	}
}
