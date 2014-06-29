public class createLinkedList<T>{
	public static void main(String args[]){
		createLinkedList.executeMethods();
	}
	T data;
	createLinkedList<T> next;
	public createLinkedList(T value){
		this.data=value;
	}
	public T getValue(){
		return this.data;
	}
	public createLinkedList<T> getNext(){
		return this.next;
	}
	public void setValue(T value){
		data=value;
	}
	public void setNext(createLinkedList<T> nextNode){
		this.next=nextNode;
	}
	//This method displays the element of linked list
	// Base case - If list is empty  
	public void displayList(createLinkedList<T> linkList){
		try{
			createLinkedList<T> reference=linkList;
			if(reference==null){
				throw new NullPointerException ("Cannot display an empty list");
			}
			while(reference!=null){
				System.out.println(reference.getValue());
				reference=reference.getNext();
			}
		}
		catch(Exception ex){
			System.out.println(ex);
		}
	}
	//This method inserts an "element" at the front of the list,makes it the new head,if the
	//list is empty then it returns the list with only 1 node "element"
	public createLinkedList<T> insertInFront(createLinkedList<T> list,T data){
		createLinkedList<T> newHead=new createLinkedList<T>(data);
		if(list == null){
			newHead.setNext(null);
			return newHead;
		}
		newHead.setValue(data);
		newHead.setNext(list);
		return newHead;
	}
	//If the list is empty then this method created a new list with only 1 node ,the node
	//to be inserted else adds the new element to the tail of the linked list and makes it
	//the new tails
	public createLinkedList<T> insertInEnd(createLinkedList<T> list,T data){
		createLinkedList<T> element=new createLinkedList<T>(data);
		createLinkedList<T> currPointer=list;
		element.setNext(null);
		element.setValue(data);
		if(list==null){
			return element;
		}
		else{
			while(currPointer.getNext()!=null){
				currPointer=currPointer.getNext();
			}
			currPointer.setNext(element);
		}
		return list;
	}
	//If method throws an exception if the list is empty,otherwise finds the element and delete it,
	//updating the corresponding next pointers of the influenced nodes
	public createLinkedList<T> deleteListElement(createLinkedList<T> list,T data){
		createLinkedList<T> currPointer=list;
		createLinkedList<T> element=new createLinkedList<T>(data);
		element.setNext(null);
		element.setValue(data);
		if(currPointer == null){
			throw new NullPointerException ("List is empty ,cannot delete the element");

		}
		if(currPointer.getValue()==data){                                             // If head is the item to be deleted
			list=currPointer.getNext();
			return list;
		}
		else{
			boolean found=false;
			while(currPointer!=null && !found){
				if(currPointer.getNext()==null && currPointer.getValue()==data){       //If tail is the item to be deleted
					currPointer.setNext(null);
					found=true;
				}
				else if(currPointer.getNext()!=null && currPointer.getNext().getValue()==data  ){   //If the item to be deleted is intermediate
					currPointer.next=currPointer.getNext().getNext();					
					found=true;
				}
				currPointer=currPointer.getNext();
			}
			if(found==false){                                                          //If element is not present
				System.out.println("No such element exists");
			}
		}

		return list;
	}
	//This method inserts a new node after the one specified by the user
	public createLinkedList<T> insertAfter(T insertAfter,T insertValue,createLinkedList<T> list){
		try{
			if(list==null){
				return null;
			}
			else{
				createLinkedList<T> reference =list;
				boolean found=false;
				while(reference!=null && ! found){
					if(reference.getValue() == insertAfter){
						createLinkedList<T> newNode =new createLinkedList<T>(insertValue);
						newNode.next=reference.next;
						reference.next=newNode;
						found=true;
					}
					else{
						reference=reference.getNext();
					}
				}
				if(found == false){
					System.out.println ("Insert AFter element does not exists");
					return list;
				}
			}
		} 
		catch(Exception ex){
			System.out.println(ex);
		}
		return list;

	}
	public boolean searchElement(createLinkedList<T> list,T element){
		createLinkedList<T> reference = list;
		boolean found = false;
		if(reference == null){
			found =false;
		}
		while(reference!=null && ! found){
			if(reference.getValue() == element){
				found =true;
				System.out.println("Element "+element+  " exists in the list");

			}
			else{
				reference=reference.next;
			}
		}
		if(found == false){
			System.out.println("Element "+element +" not found in the list");

		}

		return found;
	}
	public createLinkedList<T> findMthLastElement(createLinkedList<T> list ,int m){
		createLinkedList<T> curr_Pointer = list;
		createLinkedList<T> mthPointer = list;
		for(int i=0;i<m;i++){
			if(curr_Pointer!=null){
			curr_Pointer=curr_Pointer.next;
			}
			else{
				return null;
			}
		}
		
		while(curr_Pointer!=null){
			mthPointer=mthPointer.next;
			curr_Pointer=curr_Pointer.next;
		}
		return mthPointer;
	}
	public boolean findCycle (createLinkedList<T> list){
		createLinkedList<T> reference =list;
		if(reference == null){
			System.out.println("No cycle exists as the list is empty");
			return true;
		}
		createLinkedList <T> tortoize =list;
		createLinkedList <T> hare =list;
		do{
			tortoize=tortoize.next;
			hare =hare.next.next;
			if(tortoize==hare){
				System.out.println("cycle detected between nodes :"+tortoize.getValue()+","+hare.getValue());
				return true;
			}
		}while(hare.next!=null && hare.next.next!=null);
		System.out.println("No cycle detected");
		return false;

	}
	public static void executeMethods(){
		createLinkedList<Integer> head=new createLinkedList<Integer>(10);
		createLinkedList<Integer> node1=new createLinkedList<Integer>(-8);
		createLinkedList<Integer> node2=new createLinkedList<Integer>(9);
		head.setValue(head.getValue());
		head.setNext(node1);
		node1.setValue(node1.getValue());
		node1.setNext(node2);
		node2.setValue(node2.getValue());
		node2.setNext(null);
		System.out.println("Original Linked List");
		System.out.println("--------------------------------------------------");
		head.displayList(head);
		System.out.println("--------------------------------------------------");
		/*
		head=node1.insertInFront(head,20);
		System.out.println("After Inserting a new element 20 before the head");
		System.out.println("--------------------------------------------------");
		head.displayList(head);
		System.out.println("New Head is "+head.getValue());
		head=head.insertInEnd(head, 50);
		System.out.println("After Inserting new element in back");
		System.out.println("--------------------------------------------------");
		head.displayList(head);
		int Element=60;
		System.out.println("--------------------------------------------------");
		System.out.println("After processing deletion of the  element "+Element);
		System.out.println("--------------------------------------------------");
		head=head.deleteListElement(head, Element);
		head.displayList(head);
		System.out.println("Head is "+ head.getValue());
		System.out.println("--------------------------------------------------");
		System.out.println("Linked List post inserting value 60 after element "+15  );
		head = head.insertAfter(60, 15, head);
		head.displayList(head);
		System.out.println("Linked List post inserting value 10 after element "+9  );
		head = head.insertAfter(9, 10, head);
		head.displayList(head);
		boolean result = head.searchElement(head,70);
		System.out.println("Result is:"+result );
		head.findCycle(head);*/
		int m=0;
		createLinkedList<Integer> mthElement =head.findMthLastElement(head, m);
		if(mthElement!=null){
		System.out.println(m+"th element from back is "+mthElement.getValue());
		}
		else{
			System.out.println("Could not found this mth value,index out of bound");
		}
		}

}