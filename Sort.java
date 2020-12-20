/*
 this is uploaded to git server

Merge sort 
Time complexity O(nlogn)
Space complexity O(n)

Quick sort
Time complexity 
	best  O(nlogn)
	worst O(n^2)
space complexity ()


╦═╗  ┌─┐  ┌┬┐  ┬  ─┐ ┬
╠╦╝  ├─┤   ││  │  ┌┴┬┘
╩╚═  ┴ ┴  ─┴┘  ┴  ┴ └─
  ┌─┐┌─┐┬─┐┌┬┐        
  └─┐│ │├┬┘ │         
  └─┘└─┘┴└─ ┴   

╦ ╦┌─┐┌─┐┌─┐  ┌─┐┌─┐┬─┐┌┬┐
╠═╣├┤ ├─┤├─┘  └─┐│ │├┬┘ │ 
╩ ╩└─┘┴ ┴┴    └─┘└─┘┴└─ ┴ 

*/

import java.util.*;

class Solution{

void merge(int arr[],int helper[],int low,int mid,int high){
for(int i = low;i <= high;i++)
	helper[i] = arr[i];
int helperleft = low;
int helperright = mid + 1 ;
int current = low;
	while(helperleft<= mid && helperright <=high){
	if(helper[helperleft]<=helper[helperright]){
	arr[current] = helper[helperleft];
	helperleft++;	
	}else{
		arr[current] = helper[helperright];
		helperright++;
		
		}
	current++;	
}

int remaining = mid - helperleft;
for(int i=0;i<= remaining;i++)
arr[current + i] = helper[helperleft + i];
}

void merge_sort(int arr[],int helper[],int low,int high){
	if(low<high){
	int mid = low+(high-low)/2;
	merge_sort(arr,helper,low,mid);
	merge_sort(arr,helper,mid+1,high);
	merge(arr,helper,low,mid,high);
	}
}

void merge_sort(int arr[],int sz){
int helper[] = new int[sz];
merge_sort(arr,helper,0,sz-1);
System.out.println(" _____                    _____         _ 	");  
System.out.println("|     |___ ___ ___ ___   |   __|___ ___| |_ ");
System.out.println("| | | | -_|  _| . | -_|  |__   | . |  _|  _|");
System.out.println("|_|_|_|___|_| |_  |___|  |_____|___|_| |_|  ");
System.out.println("              |___|				"); 
}

public static void main(String args[]){
	Scanner sc = new Scanner(System.in);
	Solution s = new Solution(); 
	System.out.print("Enter the array Size:");
	int sz = sc.nextInt();
	System.out.print("Enter the array elements:");
	int arr[] = new int[sz];
		for(int i=0;i<sz;i++)
		arr[i] = sc.nextInt();
	int op;
	System.out.print("Choose a  option <1.Merge Sort 2.Quick sort 3.Insertion sort>:");
	op = sc.nextInt();	
	switch(op){
	case 1:s.merge_sort(arr,sz); break;
	case 2:s.quickSort(arr,sz);break;
	case 3:s.insertionSort(arr,sz);break;	
	default:System.out.println("Option invalid");
	}
	System.out.print("Sorted array is :");
		for(int i=0;i<arr.length;i++)
		System.out.print(arr[i] + " ");
	System.out.print("\n");		
	}

void quickSort(int  arr[],int sz){
System.out.println(" _____     _     _                  _   ");  
System.out.println("|     |_ _|_|___| |_    ___ ___ ___| |_ ");
System.out.println("|  |  | | | |  _| '_|  |_ -| . |  _|  _|");
System.out.println("|__  _|___|_|___|_,_|  |___|___|_| |_|  ");
System.out.println("   |__| 				    ");
quickSort(arr,0,sz-1);
}

void quickSort(int[] arr, int left, int right) {
		int index = partition(arr, left, right); 
		if (left < index - 1) { // Sort left half		
		quickSort(arr, left, index - 1);
		}
		if (index < right) { // Sort right half
		quickSort(arr, index + 1 , right);
		}
	}

int partition(int[] arr, int left, int right) {
		int pivot = arr[left + (right - left) / 2]; // Pick a pivot point. Can be an element			
		while (left <= right) { // Until we've gone through the whole array
			// Find element on left that should be on right
			while (arr[left] < pivot) { 
				left++;
			}
			// Find element on right that should be on left
			while (arr[right] > pivot) {
				right--;
			}
			// Swap elements, and move left and right indices
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		return left; 
}

static void swap(int[] array, int i, int j) {
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
}

void insertionSort(int [] arr,int n){
System.out.println("╦┌┐┌┌─┐┌─┐┬─┐┌┬┐┬┌─┐┌┐┌  ┌─┐┌─┐┬─┐┌┬┐");
System.out.println("║│││└─┐├┤ ├┬┘ │ ││ ││││  └─┐│ │├┬┘ │ ");
System.out.println("╩┘└┘└─┘└─┘┴└─ ┴ ┴└─┘┘└┘  └─┘└─┘┴└─ ┴ ");
for(int j=1;j<n;j++){
int i;
int item = arr[j];
for(i=j-1;i>=0;i--)
	if(item < arr[i])arr[i+1] =  arr[i];
	else break;
arr[i+1] = item;
	}
}

}


