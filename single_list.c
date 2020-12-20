#include<stdio.h>
#include<stdlib.h>

/* the code  is 
completed with operations like traversing the list
 creating list , insertion operation and a display 
function,deleting nodes and reversing the list*/
void create_node();
void display_node();
void insertnode();
void insertnode_begining();
void insertnode_end();
void insertnode_location();
void deletenode();
void deletenode_begining();
void deletenode_end();
void deletenode_location();
void reverse_list();

struct node{
int data;
struct node *link;
};

struct node *head,*newnode,*temp;
// temp is used to traverse through the list 
int main()
{
int choice;
printf("\n Linked list program.");
do{
printf("\n 1.Create node \n2.Delete node \n3.Insert node \n4.Display node \n5.Reverse list \n6.Quit \nEnter the choice:  ");
scanf("%d",&choice);
switch(choice){
case 1:create_node();break;
case 2:deletenode();break;
case 3:insertnode();break;
case 4:display_node();break;
case 5:reverse_list();break;
case 6:printf("\n Bye See you later :)");break;
default : printf("\n Enter something valid ");
}}while(choice!=6);
printf("\n");
return 0;
}


void create_node(){
head = 0;
int choice = 1;
while(choice){
newnode = (struct node *)malloc(sizeof(struct node));
printf("\n Enter the number to be added to the list:");
scanf("%d",&newnode->data);
newnode->link = 0;
if(head == 0){
head = newnode;
temp=newnode;
}
else{
temp ->link = newnode;
temp = newnode;}
printf("\n Do you like to continue ?<0 for no , 1 for yes>:");
scanf("%d",&choice);
}
}

void display_node(){
int count=0;
printf("\n Displaying the elements");
temp = head;
while(temp !=0){
printf("\n Data is %d\n", temp->data);
temp = temp->link;
count++;}
printf("\n Number of nodes is %d\n",count);
}

void insertnode(){
int choice;
printf("\n1. insert begin \n2.insert end \n 3. insert location \n choice:");
scanf("%d",&choice);
switch(choice){
case 1:
insertnode_begining();
break;
case 2:
insertnode_end();
break;
case 3:
insertnode_location();
break;

}}


void insertnode_begining(){
printf("\nInsertion operation in linked list");
newnode = (struct node*)malloc(sizeof(struct node));
printf("\n Enter the data");
scanf("%d",&newnode->data);
newnode->link = head;
head= newnode;
}

void insertnode_end(){
printf("\nInsertion operation in linked list");
newnode = (struct node*)malloc(sizeof(struct node));
printf("\n Enter the data");
scanf("%d",&newnode->data);
temp = head;
while(temp->link != 0)
{
temp = temp -> link;
 }
temp->link = newnode;
newnode->link = 0;
}

void insertnode_location(){
int pos;
int count = 0;
printf("\nInsertion operation in linked list");
printf("\nEnter the position where after  you want to enter the element");
scanf("%d",&pos);
temp = head;
 while (temp !=0){
temp = temp ->link;
count++;}
 if (pos> count){
printf("\n position invalid");}
else if (pos==1){
insertnode_begining();}
else{
int i=1;
temp = head;
newnode = (struct node*)malloc(sizeof(struct node));
printf("\nEnter the element to be inserted :");
scanf("%d",&newnode->data);
while(i<pos)
{
temp = temp -> link;
i++;}
newnode->link = temp -> link;
temp->link =  newnode;
}
}

void deletenode(){
int choice;
printf("\n1.Delete begining\n2.Delete at end\n3.Delete at position\nchoice:");
scanf("%d",&choice);
switch(choice){
case 1:
deletenode_begining();
break;
case 2:
deletenode_end();
break;
case 3:
deletenode_location();
break;
}}

void deletenode_begining(){
if (head == 0)
{
printf("\nList is empty");
}else{
temp = head;
head = head ->link;
free(temp);
printf("\nNode deleted");}
}

void deletenode_end(){
struct node *prev;
if (head == 0)
{
printf("\nList is empty");
}
else{
temp = head;
while(temp ->link != 0){
prev = temp;
temp = temp ->link;}
prev-> link = 0;
free(temp);
printf("\nNode deleted");
}
}

void deletenode_location(){
int count=0;
int pos;
int i=1;
struct node *next;
temp = head;
if (head == 0)
{
printf("\nList is empty");
}
while(temp !=0){
temp = temp ->link;
count++;}
printf("Enter the position you want to  enter the node:");
scanf("%d",&pos);
if(pos>count){
printf("\n Position innvalid");}
else if(pos==1){
deletenode_begining();}
else
{
temp = head;
while(i<pos-1)
{
temp = temp ->link;
i++;
}
next =  temp ->link;
temp ->link =  next ->link;
free(next);
printf("\nOne elemenet deleted");
}
}

void reverse_list(){
struct node   *prev,*current,*next;
prev = 0;
current = head;
next = head;
while(next!=0){
next = current ->link;
current->link = prev;
prev = current;
current = next;
}
head = prev;
}





