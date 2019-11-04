import java.util.*;
class RandomizedSet {
    
    List<Integer> hashSet;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hashSet = new ArrayList<Integer>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!hashSet.contains(val)){
            hashSet.add(val);
            return true;
        }
        else{
            return false;
        }
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(hashSet.contains(val)){
            hashSet.remove((Object)val);
            return true;
        }
        else{
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random random =new Random();
    	int count = hashSet.size();
    	int ind = random.nextInt(count);
        
        return hashSet.get(ind);
        
    }
    public static void main(String[] args) {
    	RandomizedSet obj = new RandomizedSet();
    	boolean param_1 = obj.insert(1);
    	boolean param_2 = obj.remove(2);
    	boolean param_3 = obj.insert(2);
    	boolean param_4 = obj.remove(1);
    	boolean param_5 = obj.insert(2);
    	int param_6 = obj.getRandom();
	}
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */