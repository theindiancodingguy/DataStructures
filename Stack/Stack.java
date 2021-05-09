class Stack{


class Node{
Integer data;
Node next;
public Node(Integer data){
this.data = data;
}
}

Node top = null;

public void push(Integer data){
Node stack_node = new Node(data);
if(top == null){
stack_node.next = null;
}
stack_node.next = top;
top = stack_node;
}

public Integer pop(){
if(top ==  null) return null;
Node temp =  top;
top = top.next;
return (Integer)temp.data;
}

public Integer peek(){

return (Integer)top.data;
}

public static void main(String args[]){
Stack  stack = new Stack();
stack.push(1);
stack.push(2);
stack.push(3);
stack.push(4);
System.out.println("Elements are " + stack.pop());
System.out.println("Elements are " + stack.pop());
System.out.println("Elements are " + stack.pop());
System.out.println("Elements are " + stack.pop());
}
}
