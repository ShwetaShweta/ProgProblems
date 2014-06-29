

class Node<T>{
	T value;
	Node<T> next;
	Node<T> previous;
	Node<T> child;
	public Node(T value){
		this.value=value;
	}
}

public class doublyLinkedList<T> {
	public static void main(String[] args) {
		Node<Integer> root =new Node<Integer>(5);
		Node<Integer> node1=new Node<Integer>(33);
		Node<Integer> node2=new Node<Integer>(17);
		Node<Integer> node3=new Node<Integer>(2);
		Node<Integer> node4=new Node<Integer>(1);
		Node<Integer> node5=new Node<Integer>(6);
		Node<Integer> node6=new Node<Integer>(25);
		Node<Integer> node7=new Node<Integer>(6);
		Node<Integer> node8=new Node<Integer>(2);
		Node<Integer> node9=new Node<Integer>(7);
		Node<Integer> node10=new Node<Integer>(8);
		Node<Integer> node11=new Node<Integer>(9);
		Node<Integer> node12=new Node<Integer>(12);
		Node<Integer> node13=new Node<Integer>(5);
		Node<Integer> node14=new Node<Integer>(7);
		Node<Integer> node15=new Node<Integer>(21);
		Node<Integer> node16=new Node<Integer>(3);
		doublyLinkedList<Integer> objDouble=new doublyLinkedList<Integer>(root);
		objDouble.setNext(node1);                                 //5(root),33,null,6(node5)
		objDouble.setPrevious(null);
		objDouble.setChild(node5);
		objDouble=new doublyLinkedList<Integer>(node1);          //33,17,root(5),null
		objDouble.setNext(node2);
		objDouble.setPrevious(root);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node2);          //17,2,33,null
		objDouble.setNext(node3);
		objDouble.setPrevious(node1);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node3);         //2,1,17,node8(2)
		objDouble.setNext(node4);
		objDouble.setPrevious(node2);
		objDouble.setChild(node8);
		objDouble=new doublyLinkedList<Integer>(node4);        //1,null,2,null
		objDouble.setNext(null);
		objDouble.setPrevious(node3);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node5);        //6,25,null,null
		objDouble.setNext(node6);
		objDouble.setPrevious(null);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node6);        //25,6(node7),25,(node11)9
		objDouble.setNext(node7);
		objDouble.setPrevious(node6);
		objDouble.setChild(node11);
		objDouble=new doublyLinkedList<Integer>(node7);       //6,null,26,node11
		objDouble.setNext(null);
		objDouble.setPrevious(node6);
		objDouble.setChild(node11);
		objDouble=new doublyLinkedList<Integer>(node8);       //2,7,null,node12
		objDouble.setNext(node9);
		objDouble.setPrevious(null);
		objDouble.setChild(node12);
		objDouble=new doublyLinkedList<Integer>(node9);       //7,null,2,null
		objDouble.setNext(null);
		objDouble.setPrevious(node8);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node10);       //8,null,null,null
		objDouble.setNext(null);
		objDouble.setPrevious(null);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node11);       //11,null,null,node14(7)
		objDouble.setNext(null);
		objDouble.setPrevious(null);
		objDouble.setChild(node14);
		objDouble=new doublyLinkedList<Integer>(node12);       //12,5,null,node15
		objDouble.setNext(node13);
		objDouble.setPrevious(null);
		objDouble.setChild(node15);
		objDouble=new doublyLinkedList<Integer>(node13);       //7,null,12,null
		objDouble.setNext(null);
		objDouble.setPrevious(node12);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node14);       //7,null,null,null
		objDouble.setNext(null);
		objDouble.setPrevious(null);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node15);       //21,3,null,null
		objDouble.setNext(node16);
		objDouble.setPrevious(null);
		objDouble.setChild(null);
		objDouble=new doublyLinkedList<Integer>(node16);       //2,7,null,node12
		objDouble.setNext(null);
		objDouble.setPrevious(node15);
		objDouble.setChild(null);
		root=objDouble.listFlattening(root,node4);
		/*Node<Integer> reference=root;
		while(reference!=null){
			System.out.println(reference.value);
			reference=reference.next;
		}*/
	}
	Node<T> node;
	public doublyLinkedList(Node<T> node){
		this.node=node;
	}
	public void setNext(Node<T> next){
		node.next=next;
	}
	public void setPrevious(Node<T> previous){
		node.previous=previous;
	}
	public void setChild(Node<T> child){
		node.child=child;
	}
	public Node<T> listFlattening(Node<T> head,Node<T> tail){
		Node<T> reference=head;
		while(reference!=null){
			System.out.println("Level1:"+reference.value);
			if(reference.child!=null){
				System.out.println("Tail is:"+tail.value);
				tail.next=reference.child;
			    reference.child.previous=tail;	
			   append(reference.child,tail);
			}
			
			reference=reference.next;
			
		}
		return head;
	}
	public void append(Node<T> child,Node<T> tail){
		Node<T> currNode;
		tail.next=child;
		child.previous=tail;	
		currNode=child;
		while(currNode!=null){
			currNode=currNode.next;
		}
		tail=currNode;
		//tail=currNode;
		//System.out.println("Tail is:"+tail.value);
		
	}
}



