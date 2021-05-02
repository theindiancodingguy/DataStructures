/* Write a function howSum(targetSum,numbers) that takes ina targetsum
and an array of numbers as arguments

The function should return an array containing any combination of 
elements that add up to exactly the targetSum,if there is no 
combination that adds up to the targget sum then return null


If there are multiple combinations possible , you may return any 
single one*/

import java.util.*;

class HowSum{

//recursive approach 
ArrayList howSum_rec(int sum,int [] a,ArrayList num){
if (sum == 0) return num;
if(sum < 0) return null;
 for(int i=0;i<a.length;i++){
 int rem = sum - a[i];
 ArrayList res = howSum_rec(rem,a,num);
 if(res != null){
   res.add(a[i]);
   return res;
   }
 }
return null;
// m = target sum
//n = array length
//Time complexity O(n^m * m ) m*m for the purpose of adding elements to the auxilary array.
//Space complexity O(m)
}


//memoization approach
ArrayList howSum_mem(int sum,int [] a ,ArrayList num,HashMap hm){
if(hm.containsKey(sum)) return (ArrayList)hm.get(sum);
if(sum == 0) return num;
if(sum < 0) return null;
 for(int i=0;i<a.length;i++){
 int rem = sum - a[i];
 ArrayList res = howSum_mem(sum,a,num,hm);
 if(res != null){
   res.add(a[i]);
   hm.put(sum,res);
   return num;
 }
}
return null;
}

public static void main(String args[]){
Scanner in = new Scanner(System.in);
ArrayList<Integer> num = new  ArrayList<>();
HashMap<Integer,ArrayList<Integer>> hm = new HashMap<>();
System.out.print("Enter the array size: ");
int n = in.nextInt();
int [] a = new int [n];
System.out.print("Enter the array elements: ");
 for(int i=0;i<n;i++)
 a[i] = in.nextInt();
System.out.print("Enter the sum: ");
int sum = in.nextInt();
ArrayList<Integer> res_mem = new HowSum().howSum_mem(sum,a,num,hm);
ArrayList<Integer> res_rec = new HowSum().howSum_rec(sum,a,num);
if(res_mem == null )System.out.println("Sum not possible");
else{
 System.out.print("Suming elements are: ");
 for(Integer number : res_mem)
 System.out.print(number + " ");
System.out.println();
 System.out.print("Suming elements are: ");
 for(Integer number : res_rec)
 System.out.print(number + " ");
System.out.println();
}
}
}
