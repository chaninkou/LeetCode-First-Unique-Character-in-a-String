package unique;

import java.util.HashMap;
import java.util.Map;

public class FindFirstUniqueLetterFunction {
	// Faster way in leetcode, similar to my way, but without using hashmap
	// O(n + n) since we go over the whole string once and then worst case we find the unique item at the last element when we go through it the second time
    public int firstUniqChar(String s) {
    	// Since its only lowercase, 26 spaces will be enough
        int freq [] = new int[26];
        
        // count the nummber of times appear with this method
        for(int i = 0; i < s.length(); i++){
            freq [s.charAt(i) - 'a'] ++;
        }
        
        for(int i = 0; i < s.length(); i++){
        	// Whichever one appear first
            if(freq [s.charAt(i) - 'a'] == 1){
                return i;
            }
        }
        
        return -1;
    }
    
	// A way to use hashmap and store the index as value, then go through the whole keyset and compare which index is the minimum
    public int firstUniqChar1(String s) {
    	// Store the variable as key 
        HashMap<Character, Integer> map = new HashMap<>();
        
       // Put -1 for the not unique letters, put the index of the element if its unique
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            
            if(!map.containsKey(current)){
            	// Saving the index as the value
                map.put(current, i);
            } else {
                // Using -1 as marking this is not the one (It could be anything like -2,-3,-4 ...)
                map.put(current, -1);
            }
        }
        
        // Since we trying to get the min, set it to the biggest number first
        int min = Integer.MAX_VALUE;
        
        // For each key, check which value is not -1 and get the min of it
        // This is faster than going through the whole string again and check which one is 1
        for(char c : map.keySet()){
            if(map.get(c) > -1 && map.get(c) < min){
            	// Min will the be minimum index
                min = map.get(c);
            }
        }
        
        // If it does not exist, return -1
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    
    // Easy to understand way, but pretty slow
    public int firstUniqChar2(String s){
        Map<Character, Integer> map = new HashMap<>();
        
        // Count all the character first
        for(int i = 0; i < s.length(); i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0) + 1);
        }
        
        // Go through the whole string again, whoever have only one, return that right away
        for(int j = 0; j < s.length(); j++){
            if(map.get(s.charAt(j)) == 1){
                return j;
            }
        }
        
        return -1;
    }
    
    
    // Brute force way, O(N^2)
    public int firstUniqChar3(String s){
    	
    	for(int i = 0; i < s.length(); i++){
    		// Set it to false every time we use a new element
    		boolean uniqueCheck = false;
    		
    		for(int j = 0; j < s.length(); j++){
    			// If they are the same, mark it true and stop the inner loop
    			if(s.charAt(i) == s.charAt(j) && (i != j)){
    				uniqueCheck = true;
    				break;
    			}
    		}
    		
    		// If this is false, that means there was no duplicates
    		if(!uniqueCheck){
    			return i;
    		}
    	}
    	
		return -1;
    }
    
    // Another way using built in function
    // This is short, but doesn't make it faster
    public int firstUniqChar4(String s){
    	for(int i = 0; i < s.length(); i++){
    		// If the first index and equal to last index of this element, which mean there is only one
    		if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i))){
    			return i;
    		}
    	}
    	
		return -1;
    }
}
