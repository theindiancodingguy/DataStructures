class Stack<Data>{


class Node<Data>{
Data data;
Node next;
public Node(Data data){
this.data = data;
}
}

Node top = null;

public void push(Data data){
Node stack_node = new Node(data);
if(top == null){
stack_node.next = null;
}
stack_node.next = top;
top = stack_node;
}

public Data pop(){
if(top ==  null) return null;
Node temp =  top;
top = top.next;
return temp.data;
}

public Data peek(){

return top.data;
}

public static void main(String args[]){
Stack <Object> stack = new Stack();
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
