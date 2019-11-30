package unique;

import java.util.HashMap;

public class FindFirstUniqueLetterFunction {
	// Faster way in leetcode, 
//    public static int firstUniqChar(String s) {
//        int freq [] = new int[26];
//        
//        for(int i = 0; i < s.length(); i++){
//            freq [s.charAt(i) - 'a'] ++;
//        }
//        
//        for(int i = 0; i < s.length(); i++){
//            if(freq [s.charAt(i) - 'a'] == 1){
//                return i;
//            }
//        }
//        return -1;
//    }
//    
	
    public int firstUniqChar(String s) {
    	// Store the variable as key 
        HashMap<Character, Integer> map = new HashMap<>();
        
       // Put -1 for the not unique letters, put the index of the element if its unique
        for(int i = 0; i < s.length(); i++){
            char current = s.charAt(i);
            
            if(!map.containsKey(current)){
                map.put(current, i);
            } else {
                // Contains
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
}
