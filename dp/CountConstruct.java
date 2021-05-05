/* Improvised approach of can construct code but want to ensure if we can count the number of possibilities*/
import java.util.*;
class CountConstruct{

//recursive approach
int countConstruct_rec(String word,String [] wordBank){
if(word.length() == 0) return 1;
int totalCount = 0;
for(int i=0;i<wordBank.length;i++){
 if(word.indexOf(wordBank[i]) == 0){
 int suffix = wordBank[i].length();
  int res = countConstruct_rec(word.substring(suffix),wordBank); 
  totalCount += res;
  }
 } 
return totalCount;
}


//memoization appraoch
Integer countConstruct_mem(String word,String [] wordBank,HashMap hm){
if(hm.containsKey(word))  return (Integer)hm.get(word);
if(word.length() == 0){ Integer one = new Integer(1) ; return one; }
int totalCount = 0;
for(int i=0;i<wordBank.length;i++){
 if(word.indexOf(wordBank[i]) == 0){
 int suffix = wordBank[i].length();
  int res = countConstruct_mem(word.substring(suffix),wordBank,hm); 
  totalCount += res;
  hm.put(word.substring(suffix),totalCount);
  }
 } 
Integer total = new Integer(totalCount);
return total;
}

public static void main(String args[]){
Scanner in = new Scanner(System.in);
HashMap<String,Integer> hm = new HashMap<>();
String wordBank [] = {"purp","p","ur","le","purpl"};
System.out.println("Number of ways is : "+new CountConstruct().countConstruct_rec("purple",wordBank));
System.out.println("Number of ways is : "+new CountConstruct().countConstruct_mem("purple",wordBank,hm));
}
}
