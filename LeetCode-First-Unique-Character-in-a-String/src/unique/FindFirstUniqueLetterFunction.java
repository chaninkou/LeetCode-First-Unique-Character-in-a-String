package unique;

import java.util.HashMap;
import java.util.Map;

public class FindFirstUniqueLetterFunction {
	// Faster way in leetcode, similar to my way, but without using hashmap
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
                // Using -1 as marking this is not the one
                map.put(current, -1);
            }
        }
        
        // Since we trying to get the min, set it to the biggest number first
        int min = Integer.MAX_VALUE;
        
        // For each key, check which value is not -1 and get the min of it
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
}
