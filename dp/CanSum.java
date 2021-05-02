/*Write a function 'canSum(targetSum,numbers)' that takes in targetSum 
 and an array of numbers as argumnet

The function should return a boolean indicating whether or not it is 
possible to generate the targetsum using numbers from the array

you may use an element of the array as many times as needed 
all input numbers are non negative */

import java.util.*;

class CanSum{

// Recursie Approach
boolean canSum_rec(int sum, int a[]){
if(sum == 0) return true;
if(sum < 0 ) return false;
	for(int i=0;i<a.length;i++){
	int rem = sum - a[i];
 	if(canSum_rec(rem, a))
	return true;
	}
return false; // try all possiblity in for loop else return false
//  Time complexity O(n ^ m)
// Space Complexity O(m)
}

//memoization approach
Boolean canSum_mem(int sum,int a[],HashMap hm){
if(sum == 0){Boolean True = new Boolean(true); return True;}
if(sum <0){Boolean False = new Boolean(false);return False;}
if(hm.containsKey(sum)) return (Boolean)hm.get(sum);
for(int i=0;i<a.length;i++){
	int rem = sum - a[i];
        hm.put(sum,canSum_mem(rem,a,hm));
	if((Boolean)hm.get(sum) ==  true)   
	{Boolean True = new Boolean(true); return True;}
	}
Boolean False = new Boolean(false);return False;
// Time complexity O(n + m)
//Space complexity O(m) 
}

public static void main(String args[]){
HashMap<Integer,Boolean> hm  = new HashMap<>();
Scanner in = new Scanner(System.in);
System.out.print("Enter the array size : ");
int n = in.nextInt();
System.out.print("Enter the array elements : ");
int a[] =  new int [n];
	for(int i=0;i<n;i++)
	a[i] = in.nextInt();
System.out.print("Enter the sum:");
int sum = in.nextInt();
System.out.println("Getting the required sum with the array elements is " + new CanSum().canSum_mem(sum,a,hm));
System.out.println("Getting the required sum with the array elements is " + new CanSum().canSum_rec(sum,a));
}
}
