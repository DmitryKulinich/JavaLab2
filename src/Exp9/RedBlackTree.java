package Exp9;


public class RedBlackTree {
	
	public static class Node {
        int    key;
        Node   leftChild;
        Node   rightChild;
        Node   parent;
        int colour;
        Node(int key, Node parent, int colour) {
            this.key = key;
            this.parent = parent;
            this.colour = colour;
        }
        @Override
        public String toString() {
            return "Key: " + key + " Color:" + colour;
        }
    }
	
	private Node root;
	
	private Node grandparent(Node n) {
		if ((n != null) && (n.parent != null))
			return n.parent.parent;
		else
			return null;
	}
	
	private Node uncle(Node n) {
		Node grandparent = grandparent(n);
		if(grandparent == null) {
			return null;
		}
		if(n.parent == grandparent.leftChild)
			return grandparent.rightChild;
		else
			return grandparent.leftChild;
	}
	
	private void left_rotate(Node n) {
		Node pivot = n.rightChild;
		
		n.rightChild = pivot.leftChild;
		if(pivot.leftChild != null)
			pivot.leftChild.parent = n;
		if(pivot != null)
			pivot.parent = n.parent;
		if(n.parent != null) {
			if (n == n.parent.leftChild) {
				n.parent.leftChild = pivot;
			}
			else {
				n.parent.rightChild = pivot;
			}
		}
		else {
			root = pivot;
		}
		pivot.leftChild = n;
		if(n != null)
			n.parent = pivot;
	}
	
	private void right_rotate(Node n) {
		Node pivot = n.leftChild;
		
		n.leftChild = pivot.rightChild;
		if(pivot.rightChild != null)
			pivot.rightChild.parent = n;
		if(pivot != null)
			pivot.parent = n.parent;
		if(n.parent != null) {
			if (n == n.parent.rightChild) {
				n.parent.rightChild = pivot;
			}
			else {
				n.parent.leftChild = pivot;
			}
		}
		else {
			root = pivot;
		}
		pivot.rightChild = n;
		if(n != null)
			n.parent = pivot;	
	}
	
    public void traverseTree(Node currentNode) {
        if (currentNode != null) {
        	if(currentNode == root) {
	            traverseTree(currentNode.leftChild);
	            System.out.println(currentNode);
	            System.out.println("root");
	            traverseTree(currentNode.rightChild);
        	}
        	else {
        		traverseTree(currentNode.leftChild);
	            System.out.println(currentNode);
	            traverseTree(currentNode.rightChild);
        	}
        }
    }

    public void traverseTree() {
        traverseTree(root);
    }
	
	public void add(int key) {
        Node newNode = new Node(key, null, Colors.RED);
        if (root == null) { 
            root =  newNode;
            root.colour = Colors.BLACK;
        }
        else {
            Node currentNode = root;
            Node parent;
            while (true) {
                parent = currentNode;
                newNode = new Node(key, parent, Colors.RED);
                if (key < currentNode.key) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parent.leftChild = newNode;
                        add_check1(newNode);
                        return;
                    }
                }
                else { 
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parent.rightChild = newNode;
                        add_check1(newNode);
                        return;
                    }
                }
            }
        }
    }
	
	private void add_check1(Node node) {
		if(node.parent == null) {
			node.colour = Colors.BLACK;
			root = node;
		}
		else
			add_check2(node);
	}
	
	private void add_check2(Node node) {
		if(node.parent.colour == Colors.BLACK)
			return;
		else
			add_check3(node);
	}
	
	private void add_check3(Node node) {
		Node uncle = uncle(node);
		if(uncle != null && uncle.colour == Colors.RED) {
			node.parent.colour = Colors.BLACK;
			uncle.colour = Colors.RED;
			Node grand =grandparent(node);
			grand.colour = Colors.RED;
			add_check1(grand);
		}
		else
			add_check4(node);
	}
	
	private void add_check4(Node node) {
		Node grand = grandparent(node);
		
		if(node == node.parent.rightChild && node.parent == grand.leftChild) {
			left_rotate(node.parent);
			node = node.leftChild;
		}
		else if(node == node.parent.leftChild && node.parent == grand.rightChild) {
			right_rotate(node.parent);
			node = node.rightChild;
		}
		add_check5(node);
	}
	
	private void add_check5(Node node) {
		Node grand = grandparent(node);
		
		node.parent.colour = Colors.BLACK;
		grand.colour = Colors.RED;
		if(node == node.parent.leftChild && node.parent == grand.leftChild) 
			right_rotate(grand);
		else
			left_rotate(grand);
	}
		
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
