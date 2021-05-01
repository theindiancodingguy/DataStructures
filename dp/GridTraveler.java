import java.util.*;
/*
Say that your a traveler in a 2D grid. you begin in the top-left corner
and your goal is to travel to the bottom right corner . you may only 
move down or right.
the grid will be rectangle ,some times square may be 
*/

/*
Base case 
In 1*1 grid there is only one way to travel - 1
Consider 0*1 or 1*0 there is no way so zero - 0
*/
class GridTraveler{
// Recursive approach
long trav_rec(int x, int y ){
if(x == 1 && y == 1) return 1;
if(x <= 0 || y <= 0)return 0; 
long down = trav_rec(x-1,y); // going down
long right = trav_rec(x,y-1); // going right
return down + right;
//Time complexity O(2^n+m)
//Space complexity O(n+m)
}

// memoization approach
Long trav_mem(int x,int y , HashMap hm){
String key = x + "," + y;
String key_altr = y + ","+ x;
if(hm.containsKey(key)){ return (Long)hm.get(key);} 
if(x == 1 && y == 1){Long one = new Long(1); return one;}
if(x == 0 || y == 0){Long zero = new Long(0);return zero;}
else{ 
	hm.put(key,trav_mem(x-1,y,hm) + trav_mem(x,y-1,hm));
	// optional optimization
	hm.put(key_altr,trav_mem(x-1,y,hm) + trav_mem(x,y-1,hm));
}
return (Long)hm.get(key);
// Time complexity is :O(n * )
// Space complexity is :O(n+m)
}

public static void main(String args[]){
Scanner in = new Scanner(System.in);
HashMap<String,Long> hm = new HashMap<>(); 
System.out.print("Enter x and y co ordinates:");
int x = in.nextInt();
int y = in.nextInt(); 
System.out.println("Number of steps involved is : "+ new GridTraveler().trav_mem(x,y,hm));
System.out.println("Number of steps involved is : "+ new GridTraveler().trav_rec(x,y));
}
}
