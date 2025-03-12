# 🌳 Binary Tree Traversal Exercise

## 🎯 Objective
In this exercise, you will perform different tree traversal techniques on a given Binary Tree. You will explore the **Breadth First Search (Level Order)** and **Depth First Search** traversals, and compare the results from the **Pre-order**, **In-order**, and **Post-order** methods.

## 📥 Input:
You will be given the following Binary Tree:

![Binary Tree](tree-traverse.svg)

## 📝 Answer:

### 1. **Breadth First (Level Order):**
The Level Order traversal visits the nodes level by level, starting from the root and moving down through each level. For the given tree, the Breadth First (Level Order) traversal is:
- **20, 10, 30, 6, 14, 24, 3, 8, 26**

### 2. **Depth First Traversal:**

#### - **Pre-order:**
In Pre-order traversal, the node is visited first, followed by its left and right subtrees. For the given tree, the Pre-order traversal is:
- **20, 10, 6, 3, 8, 14, 30, 24, 26**

#### - **In-order:**
In In-order traversal, the left subtree is visited first, followed by the node, and then the right subtree. For the given tree, the In-order traversal is:
- **3, 6, 8, 10, 14, 20, 24, 26, 30**

#### - **Post-order:**
In Post-order traversal, the left and right subtrees are visited first, and the node is visited last. For the given tree, the Post-order traversal is:
- **3, 8, 6, 14, 10, 26, 24, 30, 20**