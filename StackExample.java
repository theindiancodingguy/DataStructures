
/*
This code is used to implement a basic stack with operations like 
push,pop,peek,isEmpty
TODO : Develop the code with user defined values
*/
import java.util.*;
class Stack<T>{
	private static class StackNode<T>{
	private T data;
	private StackNode<T> next;
	public StackNode(T data){
	this.data = data;
	}
}
private  StackNode<T> top;

public void push(T item){
StackNode<T> node = new StackNode<>(item);
node.next = top;
top = node;
}

public T pop(){
if(top == null) throw new EmptyStackException();
T item = top.data;
top = top.next;
return item;
}

public boolean isEmpty(){
return (top == null);
}

public T peek(){
if(top == null) throw new EmptyStackException();
return top.data;
}
}

class StackExample{
public static void main(String args[]){
Stack<Object> stack = new Stack<>();
System.out.println("Is stack empty ? -> " + stack.isEmpty());
System.out.println("Pushing elements 1,Hello,3.14 to the stack");
stack.push(1);
stack.push("Hello");
stack.push(3.14);
System.out.println("Is stack empty ? -> " + stack.isEmpty());
System.out.println("Peek element is -> " + stack.peek());
System.out.println("Poping element  -> " + stack.pop());
System.out.println("Peek element is -> " +stack.peek());
System.out.println("Poping element  -> " + stack.pop());
System.out.println("Peek element is -> " + stack.peek());
System.out.println("Poping element  -> " + stack.pop());
System.out.println("Is stack empty ? -> " + stack.isEmpty());
}
}
