package Exp8;

public class BinaryTree {

    // ���� ��� ������������� �����
    public static class Node {
        int    key;
        String value;
        Node   leftChild;
        Node   rightChild;
        Node   parent;
        Node(int key, String name, Node parent) {
            this.key = key;
            this.value = name;
            this.parent = parent;
        }
        @Override
        public String toString() {
            return "Key: " + key + " Value:" + value;
        }
    }

    private Node root;

    public void addNode(int key, String value) {
        // ��������� ����� �����:
        Node newNode = new Node(key, value, null);
        if (root == null) { // ������ ������� �����
            root = newNode;
        }
        else {
            // �������� �����:
            Node currentNode = root;
            Node parent;
            while (true) {
                parent = currentNode;
                newNode = new Node(key, value, parent);
                // ���������� �����:
                if (key < currentNode.key) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        // �������� ����� � ��������� ����:
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else { 
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        // �������� ����� � ��������� ����:
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    // ����� ����� � ������� ��������� ������
    public void traverseTree(Node currentNode) {
        if (currentNode != null) {
            traverseTree(currentNode.leftChild);
            System.out.println(currentNode);
            traverseTree(currentNode.rightChild);
        }
    }

    public void traverseTree() {
        traverseTree(root);
    }

    // ����� ����� �� ������
    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            }
            else {
                focusNode = focusNode.rightChild;
            }
            // �� �������:
            if (focusNode == null) {
                return null;
            }
        }
        return focusNode;
    }
    
    void replace(Node a, Node b) {
        if (a.parent == null)
            root = b;
        else if (a == a.parent.leftChild)
            a.parent.leftChild = b;
        else
            a.parent.rightChild = b;
        if (b != null)
            b.parent = a.parent;
    }
    
    void remove(Node t, int key) {
        if (t == null)
            return;
        if (key < t.key)
            remove(t.leftChild, key);
        else if (key > t.key)
            remove(t.rightChild, key);
        else if (t.leftChild != null && t.rightChild != null) {
            Node m = t.rightChild;
            while (m.leftChild != null)
                m = m.leftChild;
            t.key = m.key;
            t.value = m.value;
            replace(m, m.rightChild);
        } else if (t.leftChild != null) {
            replace(t, t.leftChild);
        } else if (t.rightChild != null) {
            replace(t, t.rightChild);
        } else {
            replace(t, null);
        }
    }
    
    public void remove(int key) {
        remove(root, key);
    }

    // ����:
    public static void main(String[] args) {
        BinaryTree continents = new BinaryTree();
        continents.addNode(1, "������");
        continents.addNode(3, "������");
        continents.addNode(5, "��������");
        continents.addNode(4, "�������");
        continents.addNode(2, "���");
        continents.addNode(6, "����������");
        continents.remove(5);
        continents.traverseTree();
        System.out.println("\n��������� � ������ 4:");
        System.out.println(continents.findNode(4));
    }
}