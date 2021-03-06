package Lafore.Chap8_BinaryTree;

public class BinaryTree {
    private Node root;

    public Node find(int key) {
        Node current = root;
        while (current.id != key) {
            if (key < current.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }

            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int key) {
        Node newNode = new Node(key);

        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent = current;

            while (true) {
                if (key < current.id) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        //  There is no one of the successors
        while (current.id != key) {
            if (key < current.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if ((current.leftChild == null) && (current.rightChild == null)) {
            if (current == root) {
                root = current.leftChild;
            } else if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
            return true;
            // There is one of the successors
        } else if (current.leftChild == null) {// There is only right successor
            if (current == root) {
                root = current.rightChild;
            } else if (isLeftChild) {
                parent.rightChild = current.leftChild;
            } else {
                parent.rightChild = current.rightChild;
            }
            return true;
        } else if (current.rightChild == null) { // There is only left successor
            if (current == root) {
                root = current.leftChild;
                return true;
            } else if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.leftChild = current.rightChild;
            }
            return true;
        } else {
            Node successor = getSuccessor(current);
            if (current == null) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            return true;
        }
    }

    /**
     * @param delNode deleted Node
     * @return Successor for deleted element (node)
     */
    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild;

        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if (successor != delNode.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }

    public Node findMin() {
        Node current = root;
        Node min = root;
        while (current != null) {
            min = current;
            current = current.leftChild;
        }
        return min;
    }

    public Node findMax() {
        Node current = root;
        Node max = root;
        while (current != null) {
            max = current;
            current = current.rightChild;
        }
        return max;
    }

    private void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.id + " ");
            preOrder(node.leftChild);
            preOrder(node.rightChild);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            inOrder(node.leftChild);
            System.out.println(node.id + " ");
            inOrder(node.rightChild);
        }
    }

    private void postOrder(Node node) {
        if (node != null) {
            postOrder(node.leftChild);
            postOrder(node.rightChild);
            System.out.println(node.id + " ");
        }
    }
}
