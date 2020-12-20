/* It is a fairly simple and understandable java code 
for performing some basic linked list operation like 
insertion, deletion, reversing and creation of list
TODO making the linked list to store value of different type 
*/


import java.util.*;

class SingleList{

Scanner sc = new Scanner(System.in);

Node head;
	
	class Node{
	int data;
	Node next;
		Node(int data)
		{
		this.data = data;
	}
}



void createNode(SingleList l){
System.out.print("Enter an integer data:");
int data = sc.nextInt();
Node newnode = new Node(data);
newnode.next = null;
if(l.head == null)
	l.head = newnode;
else{
	Node lastnode = l.head;
	while(lastnode.next != null)
	lastnode = lastnode.next;
	lastnode.next = newnode;	
}
}

void printList(SingleList l){
Node lastnode = l.head;
System.out.print("Linked List:");
while(lastnode != null){
	System.out.print(lastnode.data+" ");
	lastnode = lastnode.next;
}
System.out.print("\n");
}



void deleteNodeByValue(SingleList l){
System.out.print("Enter a value to delete:");
int val = sc.nextInt();
Node curren_node = l.head,prev =  null;
while(curren_node !=null && curren_node.data == val && curren_node==l.head){
	l.head = curren_node.next;
	curren_node =  curren_node.next;
	prev = curren_node;	
	System.out.println("Element deleted");
	}
while(curren_node !=null ){
	if(curren_node.data == val)
	prev.next = curren_node.next;
	else
	prev = curren_node;
	curren_node =  curren_node.next;
}
}


static public int sizeOfList(SingleList l){
Node curren_node =  l.head;
int count = 1;
while(curren_node != null){
	curren_node = curren_node.next;
	count++;
	}
return count;
}

static public boolean isEmpty(SingleList l){
return (sizeOfList(l) == 0) ? true : false ;
}

void deleteNodeByPosition(SingleList l){
System.out.print("Enter a position to perform deletion:");
int pos = sc.nextInt();
int count = 1;
Node curren_node = l.head,prev = null;
if(pos > sizeOfList(l)){ System.out.println("Element not found");}
else{
if(pos == 1){
	l.head = curren_node.next;
	curren_node.next = null;
	System.out.println("Element deleted on head");
}else{
while(pos != count){
	prev = curren_node;
	curren_node = curren_node.next;
	count +=1;
}	
if(pos == count){
	prev.next = curren_node.next;
	curren_node.next = null;
	System.out.println("Element deleted");
}
}
}
}


void insertNode(SingleList l){
System.out.print("Enter the position to insert data:");
int pos = sc.nextInt();
if((pos-1) > sizeOfList(l)){System.out.println("Position invalid");}
else{
System.out.print("Enter the data to be entered:");
int val = sc.nextInt();
Node new_node = new Node(val);
new_node.next = null;
Node curren_node = l.head;
int count = 1;
if(pos == 1){
	new_node.next = l.head;
	l.head = new_node;
	}
else{
	while(count != pos -1){
	curren_node = curren_node.next;
	count++;
	}	
	new_node.next = curren_node.next;
	curren_node.next = new_node;	
	}
}
}


void reverseList(SingleList l){
Node curren_node = l.head;
Node next_node = l.head;
Node prev_node =  null;
while(curren_node != null){
next_node = curren_node.next;
curren_node.next = prev_node;
prev_node =  curren_node;
curren_node = next_node;
}
l.head = prev_node;
System.out.println("List Reversed");
}

public static void main(String args[])
{
SingleList l = new SingleList();
Scanner sc = new Scanner(System.in);
int choice;
do{
System.out.print("--------------------------------\n");
System.out.print("1.Create node \n2.Delete node{Value} \n3.Delete node {Position}   \n4.Insert node \n5.ReverseList \n6.PrintList \n7.Quit \nEnter the choice:");
choice = sc.nextInt();
switch(choice){
case 1:l.createNode(l);break;
case 2:l.deleteNodeByValue(l);break;
case 3:l.deleteNodeByPosition(l);break;
case 4:l.insertNode(l);break;
case 5:l.reverseList(l);break;
case 6:l.printList(l);break;
case 7:System.out.print("Bye See you later :)\n");break;
default :System.out.print("Enter something valid\n");
}}while(choice != 7);
} 
}


