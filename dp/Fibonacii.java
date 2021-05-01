import java.util.*;
class Fibonacii{

/* Pattern of over lapping sub problems is called as dynamic 
programming*/

// recursive approach
long fib_rec(int n){
if( n <= 2 ) return 1;	
return fib_rec(n-1) + fib_rec(n-2);
// Time complexity O(2^n)
// Space commplexity O(n)
}


// memoization approach
// Here hash map keys are argument to the function
// values are the return value from the function
Long fib_mem(int n, HashMap hm){
if(n <= 2){Long one = new Long(1); return one;}
if(hm.containsKey(n)) return (Long)hm.get(n); 
else hm.put(n,fib_mem(n-1,hm) + fib_mem(n-2,hm));
return (Long)hm.get(n);
// Time complexity is O(n)
//Space Complexity is O(n)
}


public static void main(String args[]){
Scanner sc = new Scanner(System.in);
HashMap<Integer,Long> hm = new HashMap<>();

System.out.print("Enter a number: ");
int n = sc.nextInt();
System.out.println("The " + n + " fib element is : "+new Fibonacii().fib_mem(n,hm));

System.out.println("The " + n + "fib  element is : " + new Fibonacii().fib_rec(n));
}
}
