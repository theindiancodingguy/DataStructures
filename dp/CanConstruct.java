/*Write a function canConstruct(target,wordBank) that accepts a target
string and an array of strings 
The function should return a boolean indicating wether or not 'target'
can be constructed by concatenating the elements of the word bank 
array

We can reuse the lements of the word bank
*/

import java.util.*;


class CanConstruct{
// recursie approach

boolean canConstruct_rec(String word,String [] wordBank){
if(word.length() == 0) return true;
for(int i = 0;i<wordBank.length;i++){
if(word.indexOf(wordBank[i]) == 0){
 int suffix = wordBank[i].length() ;
 if(canConstruct_rec(word.substring(suffix),wordBank)){ return true;}
 }
}
return false;
/*
length of the word - m
length of the wordBank - n
Time complexity - O(n ^ m * m)
Space Complexity - O(m)
*/
}

//memoization approach
Boolean canConstruct_mem(String word,String [] wordBank,HashMap hm){
if(hm.containsKey(word)) return (Boolean)hm.get(word); 
for(int i=0;i<wordBank.length;i++){
if(word.indexOf(wordBank[i]) == 0){
  int suffix = wordBank[i].length();
  hm.put(word,canConstruct_mem(word.substring(suffix),wordBank,hm));
  if((Boolean)hm.get(word)){ Boolean True = new Boolean(true); return True;}
  }
 }
Boolean False = new Boolean(false);
return False;
/*
Time complexity - O (n * m^2)
Space complexity - O (m^2)
*/
}

public static void main(String args[]){ 
Scanner in = new Scanner(System.in);
HashMap<String,Boolean> hm = new HashMap<>();
//String [] wordBank = {"ab","abc","cd","def","abcd"};
//System.out.println("Construction is: "+new CanConstruct().canConstruct_rec("abcdef",wordBank));
String [] wordBank = {"e","ee","eee","eeee","eeeee","eeeeee","eeeeeee"};
System.out.println("Construction is: "+new CanConstruct().canConstruct_mem("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",wordBank,hm));
System.out.println("Construction is: "+new CanConstruct().canConstruct_rec("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeef",wordBank));
}
}
