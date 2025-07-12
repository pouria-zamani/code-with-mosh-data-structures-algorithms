# 🔀 Graph Traversal Exercise

## 🎯 Objective
In this exercise, you will analyze a graph and perform **Breadth-First Search (BFS)** and **Depth-First Search (DFS)** starting from a given node.  
At each step, when choosing the next node to visit, always pick alphabetically (e.g., A before B, B before D, etc.).

## 📥 Input:
Given the following graph, perform BFS and DFS starting from node **C**:

![Graph](graph.svg)

## 📤 Output:

### 🔍 Depth-First Traversal  
**Answer:** [C, A, B, E, D]  

We begin at node **C**.  
- C has neighbors: A, B, and D. Alphabetically, we go to A.  
- A has neighbors: B and E. Next comes B.  
- B has only one neighbor: E.  
- E has no unvisited neighbors, so we backtrack.  
- Back at C, the next unvisited neighbor is D.

**Traversal Path:**  
`[C] → [C, A] → [C, A, B] → [C, A, B, E] → [C, A, B, E, D]`

---

### 🌐 Breadth-First Traversal  
**Answer:** [C, A, B, D, E]  

We use a queue to explore each level before moving deeper.  
- Start with C in the queue.  
- Visit C, enqueue its neighbors (A, B, D).  
- Visit A → enqueue B, E  
- Visit B → enqueue E  
- Visit D → enqueue E  
- Visit E → done.

**Traversal Path (step-by-step):**  
- Queue: `[C]`  
- Visit: `C` → Queue: `[A, B, D]`  
- Visit: `A` → Queue: `[B, D, B, E]`  
- Visit: `B` → Queue: `[D, B, E, E]`  
- Visit: `D` → Queue: `[B, E, E, E]`  
- Visit: `E` → Queue: `[E, E]`  
- Remaining: Already visited nodes.

Final BFS Output: `[C, A, B, D, E]`

## 🖼 Visual Answer:

Below is the visual representation of both traversals:  

![Graph Traversal Algorithm](graph-traversal-algorithm.svg)
