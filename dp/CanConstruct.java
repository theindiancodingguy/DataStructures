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
}

public static void main(String args[]){ 
Scanner in = new Scanner(System.in);
//String [] wordBank = {"ab","abc","cd","def","abcd"};
//System.out.println("Construction is: "+new CanConstruct().canConstruct_rec("abcdef",wordBank));
String [] wordBank = {"bo","rd","ate","t","ska","sk","boar"};
System.out.println("Construction is: "+new CanConstruct().canConstruct_rec("skateboard",wordBank));
}
}
