import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/*This class contains the basic structure of a Binary Search tree
 * 
 */
class Node{
	int key;
	String value;
	Node leftChild;
	Node rightChild;
	public Node(int key,String value){
		this.key=key;
		this.value=value;
	}
	public void printValue(){
		System.out.println("Node key:"+this.key+",value"+this.value);
	}
	public void setLeftChild(Node leftChild){
		this.leftChild = leftChild;
	}
	public void setRightChild (Node rightChild){
		this.rightChild = rightChild;
	}
}
public class BinarySearchTree{
	public static void main(String[] args){
		BinarySearchTree tree = new BinarySearchTree();
		Node root =new Node(75 , "Mango");
		Node node1 =new Node(85 , "Zara");
		Node node2=new Node(65 , "Gucci");
		Node node3=new Node(55 , "Prada");
		Node node4=new Node(95 , "Ralph");
		Node node5=new Node(60 , "Sabyasachi");
		Node node6=new Node(100, "La Senza");
		//--------------------------------------------------------------
		tree.insertNode(root);
		tree.insertNode(node1);
		tree.insertNode(node2);
		tree.insertNode(node3);
		tree.insertNode(node4);
		tree.insertNode(node5);
		tree.insertNode(node6);
		System.out.println("Tree root is:"+tree.root.value);
		//--------------------------------------------------------------
		Node lc =tree.lowestCommonAncestor(root, node2, node4);
		System.out.println("Lowest Common Ancestor of nodes "+node2.value+"," + node4.value +" is:"+lc.value);
		//---------------------------------------------------------------
		//tree.preOrderTraversal(tree.root);
		tree.preOrderWithoutRecursion(tree.root);
		//----------------------------------------------------------------
		Node smallest = tree.findSmallest(tree.root);
		if(smallest !=null){
			System.out.println("Smallest key is "+smallest.key+",value is :"+smallest.value);
		}
		//----------------------------------------------------------------
		int height =tree.treeHeight(tree.root);
		System.out.println("Tree height:"+ height);
		//----------------------------------------------------------------
		Node heap = tree.heapifyBST(tree.root);
		System.out.println("Heap from BST is :");
		tree.preOrderTraversal(heap);
		//System.out.println("Number of nodes in the tree are:"+ count);
	}
	Node root;
	/* Method Name      - insertNode(Node newNode) 
	 * Description      - Method to insert a new node in its correct position in a BST
	 * Input Parameters - new node to be inserted
	 * Output Parameters- null
	 * Pre-Condition    - null
	 * Post - Condition - null  
	 */
	public void insertNode(Node newNode){
		if(root==null){
			root=newNode;
			System.out.println(root.value+",Node inserted");
		}
		else{
			Node currentNode=root;
			Node parent;
			while(true){
				parent =currentNode;
				if(newNode.key < currentNode.key){
					currentNode = currentNode.leftChild;
					if(currentNode == null){
						parent.leftChild =newNode;
						System.out.println(newNode.value+",Node inserted");
						return;
					}
				}
				else{
					currentNode = currentNode.rightChild;
					if(currentNode == null){
						parent.rightChild = newNode;
						System.out.println(newNode.value+",Node inserted");
						return;
					}
				}
			}
		}

	}
	/*This method tries to mimick the internal stack implementation used by a compiler to remove recursion 
	 * by using Stack as a data structure which follows LIFO,Since we insert left subtree as the last element
	 * it is the first one to be popped out of stack and displayed.
	 */
	public void preOrderWithoutRecursion(Node root){
		ArrayList<Node> stack = new ArrayList<Node>();                      
		if(root == null){
			System.out.println("Tree is empty");
			return;
		}
		stack.add(root);
		while(stack.size()>0){
			int size=stack.size();
			Node currValue = stack.get(size-1);
			stack.remove(size-1);
			currValue.printValue();
			Node rightChild = currValue.rightChild;
			if(rightChild!=null)	stack.add(rightChild);
			Node leftChild = currValue.leftChild;
			if(leftChild!=null) stack.add(leftChild);

		}
	}
	public void preOrderTraversal(Node root){
		/*First the root then all left children followed by right children
		In post order left children and right children are processed before root
		In in order left children then root followed by right children is done
		 */
		if(root!=null){
			root.printValue();
			preOrderTraversal(root.leftChild);
			preOrderTraversal(root.rightChild);
		}
	}
	public Node lowestCommonAncestor(Node root,Node node1,Node node2){
		int value = root.key;
		if(root == null || node1 == null || node2 == null){
			return null;
		}
		while(root!=null){
			if( value < node1.key  && value < node2.key){
				root=root.rightChild;
			}
			else if( value > node1.key && value > node2.key){
				root=root.leftChild;

			}
			return root;
		}
		return null;
	}

	/*This method takes an random BST ,maps to to an array,sorts it and then converts it into
	 * a heap(min) using a BST data structure,Best Approach would be to reorder the initial BST to satisfy
	 * the properties of heap instead of converting into an array first.
	 * Time Complexity is O(nlogn) due to array sorting
	 */
	public int nodesCount(Node node , int count ,Node[] array){
		if(node == null){
			return count;
		}
		if(array!=null){
			array[count] = node;
		}
		count++;
		count = nodesCount(node.leftChild,count,array);
		count = nodesCount(node.rightChild,count,array);
		return count;
	}
	public Node heapifyBST(Node root){
		int size = nodesCount(root,0,null);
		Node []newArray = new Node[size];
		nodesCount(root,0,newArray);
		Arrays.sort(newArray, new Comparator<Node>(){
			public int compare(Node m , Node n){
				int mv = m.key, nv = n.key;
				return (mv < nv ? -1 : (mv == nv ?0 : 1));
			}
		});
		//Heapify
		for(int i = 0;i < size;i++){
			int left =2*i +1 ;
			int right=left+1;
			newArray[i].setLeftChild(left >= size ? null : newArray[left]);
			newArray[i].setRightChild(right >= size ? null : newArray[right]);
		}
		return newArray[0];
	}

	public int treeHeight(Node root){
		if(root == null){
			return 0;
		}
		else{
			return 1+Math.max(treeHeight(root.leftChild),treeHeight(root.rightChild));
		}


	}
	public Node findSmallest(Node root){
		while(root.leftChild!=null){
			root=root.leftChild;
			return root;
		}
		return null;
	}


}