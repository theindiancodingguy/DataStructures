import java.util.*;

class DoublyLinkedList{

class Node{
int data;
Node prev;
Node next;

	Node(int data){
	this.data = data;
	}	
}

Node head = null;

void createNode(int data,DoublyLinkedList list)
{
Node newnode = new Node(data);
newnode.next = null;
newnode.prev = null;

if(list.head == null)
	list.head = newnode;
else{
	Node currentNode = list.head;
	while(currentNode.next != null)
	currentNode = currentNode.next;
	currentNode.next = newnode;
	newnode.prev = currentNode; 
}
}


void displayList(DoublyLinkedList list){
Node currentNode = list.head;
System.out.print("Elements are:");
while(currentNode != null){
System.out.print(currentNode.data+" ");
currentNode = currentNode.next;
}
System.out.print("\n");
}

public static int sizeOfList(DoublyLinkedList list){
Node currentNode = list.head;
currentNode = list.head;
int count = 0;
while(currentNode != null){
count+=1;
currentNode = currentNode.next;
}
return count;
}

public boolean isEmpty(DoublyLinkedList list)
{
return (list.head == null) ? true : false;
}

public static void main(String args[]){
DoublyLinkedList list = new DoublyLinkedList();
list.createNode(1,list);
list.createNode(1,list);
list.createNode(1,list);
list.createNode(1,list);
list.createNode(1,list);
list.createNode(1,list);
list.createNode(1,list);
list.createNode(1,list);
list.displayList(list);
}
}


	
