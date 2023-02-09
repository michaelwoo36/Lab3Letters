// Michael Woo
// CS 145 Criss, Darrell
// Lab 3: Letter Inventory
// Eclipse

// This program takes inventory of each instance of each letter in a word or phrase.


public class LetterInventory {
	
	public static final int length = 26;
	
	private int [] inventory = new int[length];
	
	private int total;
	
	public LetterInventory (String data) {
		
		// adds each letter to inventory
		for(int i = 0; i < data.length(); i++) {
	
			for(int k = 10; k < 36; k++) {
				
				// if inventory element is the right spot for letter.
				if(Character.getNumericValue(Character.toLowerCase(data.charAt(i))) == k) {
					
					inventory[k - 10]++;
				}
			}
		}
	}
	
	public LetterInventory() {
	
	}
	
	// Returns count of letter
	public int get(char letter) {
		
		int count = 0;
		
		for(int i = 0; i < inventory.length; i++) {
			
			// if inventory element is the right spot for letter.
			if(Character.getNumericValue(Character.toLowerCase(letter)) == i + 10) {
			
				for(int k = 0; k < inventory[i]; k++) {
				
					count++;
				}
			}
		}
		
		return count;
	}
	
	// sets letter count to value
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
	
	// returns number of letters in inventory
	public int size() {
		
		total = 0;
		
		for(int i = 0; i < inventory.length; i++) {
			
			total += inventory[i];
		}
	
		return total;
	}
	
	// checks if inventory is empty
	public boolean isEmpty() {
		
		if(size() > 0) {
		
			return false;
		
		}
		
		else {
		
			return true;
		}
	}
	
	// adds two inventories' letters together
	public LetterInventory add (LetterInventory other) {
		
		LetterInventory added = new LetterInventory();
		
		for(int i = 0; i < length; i++) {
		
			added.inventory[i] += inventory[i];
			added.inventory [i] += other.inventory[i];
		}
		
		return added;
	}
	
	// subtracts one inventory's letters from another
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
	
	// Returns string with all letters in inventory. Ordered.
	public String toString() {
		
		String word = "";
		
		for(int i = 0; i < inventory.length; i++) {
			
			if(inventory[i] > 0) {
			
				for(int k = 0; k < inventory[i]; k++) {
					
					// adds string of letter
					word += "" + (char)(i + 97);
				}
			}
		}
		
		return word;
	}
}
