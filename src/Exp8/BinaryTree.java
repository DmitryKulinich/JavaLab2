package Exp8;

public class BinaryTree {

    // Клас для представлення вузла
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
        // Створюємо новий вузол:
        Node newNode = new Node(key, value, null);
        if (root == null) { // перший доданий вузол
            root = newNode;
        }
        else {
            // Починаємо обхід:
            Node currentNode = root;
            Node parent;
            while (true) {
                parent = currentNode;
                newNode = new Node(key, value, parent);
                // Перевіряємо ключі:
                if (key < currentNode.key) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        // Розміщуємо вузол в потрібному місці:
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else { 
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        // Розміщуємо вузол в потрібному місці:
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    // Обхід вузлів в порядку зростання ключів
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

    // Пошук вузла за ключем
    public Node findNode(int key) {
        Node focusNode = root;
        while (focusNode.key != key) {
            if (key < focusNode.key) {
                focusNode = focusNode.leftChild;
            }
            else {
                focusNode = focusNode.rightChild;
            }
            // Не знайшли:
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

    // Тест:
    public static void main(String[] args) {
        BinaryTree continents = new BinaryTree();
        continents.addNode(1, "Європа");
        continents.addNode(3, "Африка");
        continents.addNode(5, "Австралія");
        continents.addNode(4, "Америка");
        continents.addNode(2, "Азія");
        continents.addNode(6, "Антарктида");
        continents.remove(5);
        continents.traverseTree();
        System.out.println("\nКонтинент з ключем 4:");
        System.out.println(continents.findNode(4));
    }
}