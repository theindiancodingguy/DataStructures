/*
Enhanced  version of how sum problem 

Write a function 'bestSum(targetSum,numbers)' that takes in a target 
sum and an array of numbers as arguments

the function should return an array containing the shortest combination
of numbers that add up to exactly the targetSum.

If there isa tie for the shortes combination you may return one of the 
shortest 
*/

import java.util.*;
class BestSum{


//recusive approach
ArrayList bestSum_rec(int targetSum,int a[]){
ArrayList<Integer> num =new ArrayList<>();
if(targetSum == 0) return num;
if(targetSum < 0) return null;
ArrayList shortestCombination = null;
 for(int i=0;i<a.length;i++){
 int rem  = targetSum - a[i];
 ArrayList res = bestSum_rec(rem,a);
 if(res != null){
 res.add(a[i]);
 ArrayList combination  = res;
 // if the combination is shorter than the current shortest then do updation
 if(shortestCombination == null || combination.size() < shortestCombination.size()){
   shortestCombination = combination;
   } 
  }
 }

 return shortestCombination;
// m =  target sum
// n = number array length
//Time Complexity O(n^m *m)
// Space Complexity O(m * m )
}

ArrayList bestSum_mem(int targetSum,int a[] , HashMap hm){
ArrayList<Integer> num = new ArrayList<>();
if(hm.containsKey(targetSum)) return (ArrayList)hm.get(targetSum);
if(targetSum == 0) return num;
if(targetSum < 0) return null;
ArrayList shortestCombination = null;
 for(int i=0;i<a.length;i++){
 int rem = targetSum - a[i];
 ArrayList res = bestSum_mem(rem,a,hm);
 if(res != null){
 res.add(a[i]);
 ArrayList combination = res;
 if(shortestCombination == null || combination.size() < shortestCombination.size())
 shortestCombination = combination;
  }
 }
hm.put(targetSum,shortestCombination); 
return shortestCombination;
}

public static void main(String args[]){
Scanner in = new Scanner(System.in);
ArrayList<Integer> number_rec;
ArrayList<Integer> number_mem;
HashMap <Integer,ArrayList<Integer>> hm = new HashMap<>();
System.out.print("Enter the array size : ");
int n = in.nextInt();
int a[] = new int[n];
System.out.print("Enter the array elements : ");
	for(int i = 0 ;i < n;i++)
	a[i] = in.nextInt();
System.out.print("Enter the sum : ");
int sum = in.nextInt();

//calling functions
number_mem  =  new BestSum().bestSum_mem(sum,a,hm);
System.out.println("Memoization approach completed");
//number_rec  =  new BestSum().bestSum_rec(sum,a);
//System.out.println("Recursion approach completed");

//result printing
if(number_mem == null)
System.out.println("Sum not possible");
else
{
System.out.print("Possible combination is : ");
for(Integer num : number_mem)
System.out.print(num + " ");
System.out.println();
/*System.out.print("Possible combination is : ");
for(Integer num : number_rec)
System.out.print(num + " ");
System.out.println();
*/}

}
}
