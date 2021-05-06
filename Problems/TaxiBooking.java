/*
Problem objectives 
-There are n number of taxi’s. For simplicity, assume 4. But it should work for any number of taxi’s.
-The are 6 points(A,B,C,D,E,F)
-All the points are in a straight line, and each point is 15kms away from the adjacent points.
-It takes 60 mins to travel from one point to another
-Each taxi charges Rs.100 minimum for the first 5 kilometers and Rs.10 for the subsequent kilometers.
-For simplicity, time can be entered as absolute time. Eg: 9hrs, 15hrs etc.
-All taxi’s are initially stationed at A.
-When a customer books a Taxi, a free taxi at that point is allocated
-If no free taxi is available at that point, a free taxi at the nearest point is allocated.
-If two taxi’s are free at the same point, one with lower earning is allocated
-Note that the taxi only charges the customer from the pickup point to the drop point. Not the distance it travels from an adjacent point to pickup the customer.
-If no taxi is free at that time, booking is rejected
*/

import java.util.*;

class Customer{
private int customerId;
private char pickupPoint;
private char dropPoint;
private int pickupTime;


 Customer(int customerId,char pickupPoint,char dropPoint,int pickupTime){
this.customerId = customerId;
this.pickupPoint =  pickupPoint;
this.dropPoint = dropPoint;
this.pickupTime = pickupTime;
}

public char getdropPoint(){
return dropPoint;
}

public char getpickupPoint(){
return pickupPoint;
}

public int getpickupTime(){
return pickupTime;
}

public int getcustomerId(){
return customerId;
}


}


class Taxi{
static int id = 0;
ArrayList<ArrayList<Object>> details =  new ArrayList<>();
private char pickupLocation;
private char dropLocation;
private char currentLocation;
private int revenue;
private int pickupTime;
private int dropTime;
private int tax_id;
//ArrayList<ArrayList<Object>> al = new ArrayList<>();
ArrayList<Object> l = new ArrayList<>();
 Taxi(){
 pickupLocation = 'A';
 dropLocation = 'A';
 currentLocation = 'A';
 revenue = 0;
 pickupTime = 0;
 dropTime = 0;
 tax_id = ++id; 
}

public int gettaxid(){
return tax_id;
}

public char getcurrentLocation(){
return currentLocation;
}
public int getpickupTime(){
return pickupTime;
}

public int getdropTime(){
return dropTime;
}

public char getpickupLocation(){
return pickupLocation;
}

public char getdropLocation(){
return dropLocation;
}

public int getRevenue(){
return revenue;
} 

public void setpickupLocation(char location){
pickupLocation = location;
}

public void setdropLocation(char location){
dropLocation = location;
}

public void setcurrentLocation(char location){
currentLocation = location;
}

public void setpickupTime(int time){
pickupTime = time;
}

public void setdropTime(int time){
dropTime = time;
}

public void setRevenue(int cost){
revenue = cost;
}


public Taxi allocate(Customer c,Taxi t){

t.setpickupLocation(c.getpickupPoint());
t.setdropLocation(c.getdropPoint());
t.setpickupTime(c.getpickupTime());
int distance  = Math.abs((c.getpickupPoint() - c.getdropPoint())) * 15;
int cost = 100 + (10*(distance - 5)) ;
int time =  Math.abs((c.getpickupPoint() - c.getdropPoint())) * 1;
t.setRevenue(t.getRevenue() + cost);
t.setdropTime(c.getpickupTime() + time);
t.setcurrentLocation(c.getdropPoint());


t.l.add(c.getcustomerId());
t.l.add(t.getpickupLocation());
t.l.add(t.getdropLocation());
t.l.add(t.getpickupTime());
t.l.add(t.getdropTime());
t.l.add(t.getRevenue());

return t;
}


}



class TaxiBooking{

public static void printDetails(Taxi t []){
System.out.println("Taxi Details ");
for(int i = 0;i< t.length;i++){
System.out.println("\nTaxi id " + t[i].gettaxid());
System.out.println("Customer id \t PickUpLocation \t DropLocation \t\t PickupTime \t\tDropTime \tRevenueGenerated");
for(int j=0;j<t[i].l.size();j++){
if((j % 6) == 0 ) System.out.println("\n");
System.out.print(t[i].l.get(j)+"\t\t\t");
}
}
}



public static void main(String args[]){
//Initializing 4 taxi
Taxi t[] =  new Taxi[4];
for(int i=0;i<4;i++) t[i] = new Taxi();

Scanner  sc = new Scanner(System.in);

int choice;

do{
System.out.println("Call taxi booking \n 1.Booking \n 2.Print taxi details details \n 3.Exit \n");
choice = sc.nextInt();
switch(choice){ 
case 1:
System.out.print("Customer Id:");
int id = sc.nextInt();
System.out.println("Pickup Point:");
char p_point = sc.next().charAt(0);
System.out.println("Drop point");
char d_point = sc.next().charAt(0);
System.out.println("Pick up time");
int p_time = sc.nextInt();
Customer c = new Customer(id,p_point,d_point,p_time);
Taxi tax = booking(c,t);
if(tax == null) System.out.println("Booking is rejected");
else{
System.out.println("Booking is sucessful with taxi number :" + tax.gettaxid());
}
break;
case 2:
printDetails(t);
break; 
case 3:
System.out.println("Exiting application");
break;
}
}while(choice != 3);
}

public static Taxi booking(Customer c,Taxi[] t){
Taxi result;
List<Taxi> t_list = new ArrayList<>();
int revenue = Integer.MAX_VALUE;

for(int i=0;i<4;i++){
	if((t[i].getcurrentLocation() == c.getpickupPoint()) && ((t[i].getdropTime() <= c.getpickupTime())) )
	{
	t_list.add(t[i]);

}}

if(t_list.isEmpty()) {
boolean flag = false;
for(int k = 1;k<6;k++){
for(int i=0;i<4;i++){
	if((((char)(t[i].getcurrentLocation()+k)) == c.getpickupPoint()) && ((t[i].getdropTime()+k <= c.getpickupTime())) )
	{
	
	t_list.add(t[i]);
	flag = true;
	}
	else if((((char)(t[i].getcurrentLocation()-k)) == c.getpickupPoint()) && ((t[i].getdropTime()+k <= c.getpickupTime())) )
	{
	t_list.add(t[i]);
	flag = true;
	}
	if(flag) break;

}
if(flag) break;
}
}

if(t_list.isEmpty()) return null;

for(Taxi tx: t_list){
if(tx.getRevenue() < revenue)
revenue = tx.getRevenue();
}

for(Taxi tx: t_list){
if(tx.getRevenue() == revenue){
result = tx.allocate(c,tx);
return result;
	}
}

return null;
} 

}
