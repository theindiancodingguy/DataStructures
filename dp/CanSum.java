/*Write a function 'canSum(targetSum,numbers)' that takes in targetSum 
 and an array of numbers as argumnet

The function should return a boolean indicating whether or not it is 
possible to generate the targetsum using numbers from the array

you may use an element of the array as many times as needed 
all input numbers are non negative */

import java.util.*;

class CanSum{

boolean canSum_rec(int sum, int a[]){
if(sum == 0) return true;
if(sum < 0 ) return false;
	for(int i=0;i<a.length;i++){
	int rem = sum - a[i];
 	if(canSum_rec(rem, a))
	return true;
	}
return false; // try all possiblity in for loop else return false
}

public static void main(String args[]){
Scanner in = new Scanner(System.in);
System.out.print("Enter the array size : ");
int n = in.nextInt();
System.out.print("Enter the array elements : ");
int a[] =  new int [n];
	for(int i=0;i<n;i++)
	a[i] = in.nextInt();
System.out.print("Enter the sum:");
int sum = in.nextInt();
System.out.println("Getting the required sum with the array elements is " + new CanSum().canSum_rec(sum,a));
}
}
