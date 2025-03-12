package part2.binarytrees;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        public boolean hasLeftChild() {
            return leftChild != null;
        }

        public boolean hasRightChild() {
            return rightChild != null;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

    private Node root;

    public void insert(int value) {
        Node node = new Node(value);

        if (root == null) {
            root = new Node(value);
            return;
        }

        var current = root;
        while (true) {
            if (value < current.value) {
                if (current.leftChild == null) {
                    current.leftChild = node;
                    break;
                }
                current = current.leftChild;
            } else {
                if (current.rightChild == null) {
                    current.rightChild = node;
                    break;
                }
                current = current.rightChild;
            }
        }
//        var father = getNode(value);
//        if (father.value > value)
//            father.leftChild = node;
//        else
//            father.rightChild = node;
    }

    public boolean find(int value) {
        var current = root;
        while (current != null) {
            if (value < current.value)
                current = current.leftChild;
            else if (value > current.value)
                current = current.rightChild;
            else
                return true;
        }
        return false;
//
//        var node = getNode(value);
//        return node.value == value;
    }

    public Node getNode(int value) {
        if (root == null)
            return null;

        var current = root;
        while (current != null) {
            if (value == current.value || (!current.hasLeftChild() && !current.hasRightChild()))
                return current;
            if (value > current.value && current.hasRightChild())
                current = current.rightChild;
            if (value < current.value && current.hasLeftChild())
                current = current.leftChild;
            else
                return current;
        }
        return current;
    }

    public void traversePreOrder() {
        traversePreOrder(root);
    }

    private void traversePreOrder(Node root) {
        if (root == null)
            return;

        System.out.println(root.value);
        traversePreOrder(root.leftChild);
        traversePreOrder(root.rightChild);
    }

    public void traverseInOrder() {
        traverseInOrder(root);
    }

    private void traverseInOrder(Node root) {
        if (root == null)
            return;

        traverseInOrder(root.leftChild);
        System.out.println(root.value);
        traverseInOrder(root.rightChild);
    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void traversePostOrder(Node root) {
        if (root == null)
            return;

        traversePostOrder(root.leftChild);
        traversePostOrder(root.rightChild);
        System.out.println(root.value);
    }

    public int height() {
        return height(root);
    }

    private int height(Node root) {
        if (root == null)
            return -1;

        if (isLeaf(root))
            return 0;

        return 1 + Math.max(
                height(root.leftChild),
                height(root.rightChild));
    }

    private boolean isLeaf(Node node) {
        return node.leftChild == null && node.rightChild == null;
    }

    // O(log n)     this method works for binary search trees(BSTs)
    public int min() {
        if (root == null)
            throw new IllegalStateException();

        var current = root;
        var last = current;
        while (current != null) {
            last = current;
            current = current.leftChild;
        }
        return last.value;
    }

    // O(n)         this method works for binary trees
    private int min(Node root) {
        if (isLeaf(root))
            return root.value;

        var left = min(root.leftChild);
        var right = min(root.rightChild);

        return Math.min(Math.min(left, right), root.value);
    }

    public boolean equals(Tree tree) {
        if (tree == null)
            return false;

        return equals(root, tree.root);
    }

    private boolean equals(Node firstNode, Node secondNode) {
        if (firstNode == null && secondNode == null)
            return true;

        if (firstNode != null && secondNode != null)
            return firstNode.value == secondNode.value
                    && equals(firstNode.leftChild, secondNode.leftChild)
                    && equals(firstNode.rightChild, secondNode.rightChild);

        return false;
    }

    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBinarySearchTree(Node root, int min, int max) {
        if (root == null)
            return true;

        if (root.value < min || root.value > max)
            return false;

        return isBinarySearchTree(root.leftChild, min, root.value - 1)
                && isBinarySearchTree(root.rightChild, root.value + 1, max);
    }

    public ArrayList<Integer> getNodesAtDistance(int distance) {
        var list = new ArrayList<Integer>();
        getNodesAtDistance(root, distance, list);
        return list;
    }

    private void getNodesAtDistance(Node node, int distance, ArrayList<Integer> list) {
        if (node == null)
            return;

        if (distance == 0) {
            list.add(node.value);
            return;
        }

        getNodesAtDistance(node.leftChild, distance - 1, list);
        getNodesAtDistance(node.rightChild, distance - 1, list);
    }

    public void traverseLevelOrder() {
        for (var i = 0; i <= height(); i++) {
            System.out.println(getNodesAtDistance(i).toString());
        }
    }

    public int size() {
        return size(root);
    }

    private int size(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return 1 + size(root.leftChild) + size(root.rightChild);
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node root) {
        if (root == null)
            return 0;

        if (isLeaf(root))
            return 1;

        return countLeaves(root.rightChild) + countLeaves(root.leftChild);
    }

    // using recursion
    public int max() {
        if (root == null)
            throw new IllegalStateException();

        return max(root);
    }

    private int max(Node root) {
        if (root.rightChild == null)
            return root.value;

        return max(root.rightChild);
    }

    public boolean contains(int value) {
        return contains(root, value);
    }

    private boolean contains(Node node, int value) {
        if (node == null)
            return false;

        if (node.value == value)
            return true;

        return contains(node.leftChild, value) || contains(node.rightChild, value);
    }

    public boolean areSibling(int first, int second) {
        return areSibling(root, first, second);
    }

    private boolean areSibling(Node node, int first, int second) {
        if (node == null)
            return false;

        var areSibling = false;
        if (node.leftChild != null && node.rightChild != null) {
            areSibling = (node.leftChild.value == first && node.rightChild.value == second) ||
                    (node.rightChild.value == first && node.leftChild.value == second);
        }

        return areSibling ||
                areSibling(node.leftChild, first, second) ||
                areSibling(node.rightChild, first, second);
    }

    public List<Integer> getAncestors(int value) {
        var list = new ArrayList<Integer>();
        getAncestors(root, value, list);
        return list;
    }

    private boolean getAncestors(Node node, int value, List<Integer> list) {
        if (node == null)
            return false;

        if (node.value == value)
            return true;

        if (getAncestors(node.leftChild, value, list) ||
                getAncestors(node.rightChild, value, list)) {
            list.add(node.value);
            return true;
        }

        return false;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null)
            return true;

        var balanceFactor = height(node.leftChild) - height(node.rightChild);

        return Math.abs(balanceFactor) <= 1 &&
                isBalanced(node.leftChild) &&
                isBalanced(node.rightChild);
    }

    public boolean isPerfect() {
        return size() == (Math.pow(2, height() + 1) - 1);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(3);
        tree.insert(6);
        tree.insert(4);
        tree.insert(1);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);

        Tree secondTree = new Tree();
        secondTree.insert(3);
        secondTree.insert(6);
        secondTree.insert(4);
        secondTree.insert(1);
        secondTree.insert(2);
        secondTree.insert(10);
        secondTree.insert(9);

        System.out.println("Does tree have node with value 5: " + tree.find(5));
        System.out.println("Does tree have node with value 5(with recursion): " + tree.contains(5));
        System.out.println("Does tree have node with value 3: " + tree.find(3));
        System.out.println("Pre-order traverse: ");
        tree.traversePreOrder();
        System.out.println("In-order traverse: ");
        tree.traverseInOrder();
        System.out.println("Post-order traverse: ");
        tree.traversePostOrder();

        System.out.println("Height of tree: " + tree.height());
        System.out.println("Minimum element of tree: " + tree.min());
        System.out.println("Are first tree and second tree equals: " + tree.equals(secondTree));
        System.out.println("Is tree a BST: " + tree.isBinarySearchTree());

        System.out.println("nodes with distance 2: " + tree.getNodesAtDistance(2).toString());

        System.out.println("Level order traversal: ");
        tree.traverseLevelOrder();

        System.out.println("Size of tree: " + tree.size());
        System.out.println("Count of tree leaves: " + tree.countLeaves());

        System.out.println("Maximum element of tree: " + tree.max());

        System.out.println("Are 1, 6 siblings: " + tree.areSibling(1,6));
        System.out.println("Are 2, 6 siblings: " + tree.areSibling(2,6));

        System.out.println("Ancestors of 9: " + tree.getAncestors(9));

        System.out.println("Is tree balanced: " + tree.isBalanced());
        System.out.println("Is tree perfect: " + tree.isPerfect());
    }
}
