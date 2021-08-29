import java.util.*;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;
    int dia;
    boolean res;

    BinaryTree() {
        root = null;
    }

    public ArrayList<Integer> LevelOrder() {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            res.add(curr.data);
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
        return res;
    }

    public ArrayList<Integer> reverseLevelOrder() {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node curr = q.poll();
            res.add(curr.data);
            if (curr.right != null) {
                q.add(curr.right);
            }
            if (curr.left != null) {
                q.add(curr.left);
            }
        }
        Collections.reverse(res);
        return res;
    }

    // HEIGHT OF A TREE
    public int heightOfTree(Node node) {
        if (node == null) {
            return 0;
        }
        return Math.max(heightOfTree(node.left), heightOfTree(node.right)) + 1;
    }

    // DIAMETER OF A TREE
    public int diameter(Node root) {
        dia = Integer.MIN_VALUE;
        int x = calculateDiameter(root);
        return dia;
    }

    public int calculateDiameter(Node root) {
        if (root == null) {
            return 0;
        }

        int x = calculateDiameter(root.left);
        int y = calculateDiameter(root.right);

        dia = Math.max(dia, x + y + 1);
        return Math.max(x, y) + 1;
    }

    // MIRROR OF A TREE
    public void mirror(Node root) {
        if (root == null) {
            return;
        }

        Node left = root.left;
        Node right = root.right;

        root.left = right;
        root.right = left;

        mirror(root.left);
        mirror(root.right);
    }

    public ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            res.add(q.peek().data);
            while (size != 0) {
                Node curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                size--;
            }
        }

        return res;
    }

    // RIGHT VIEW
    public ArrayList<Integer> rightView(Node root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node curr = null;
            while (size != 0) {
                curr = q.poll();
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
                size--;
            }
            res.add(curr.data);
        }

        return res;
    }

    // CHECK IF TWO BINARY TREES ARE EQUAL
    public boolean identical(Node root1, Node root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return ((root1.data == root2.data) && identical(root1.left, root2.left) && identical(root1.right, root2.right));
    }

    // GET LEVEL OF A NODE
    public int getLevel(Node root, int data, int level) {
        if (root == null) {
            return 0;
        }
        if (root.data == data) {
            return level;
        }

        int l = 0;
        l = getLevel(root.left, data, level + 1);
        if (l != 0) {
            return l;
        }
        return getLevel(root.right, data, level + 1);
    }

    // CHECK IF TREE IS BALANCED
    public boolean isBalanced(Node root) {
        res = true;
        balanced(root);
        return res;
    }

    public int balanced(Node root) {
        if (root == null) {
            return 0;
        }
        int l = balanced(root.left);
        int r = balanced(root.right);
        if (Math.abs(l - r) > 1) {
            res = false;
        }
        return Math.max(l, r) + 1;
    }

    // CONVERT BINARY TREE TO DLL
    Node head;
    Node prev;

    public Node treeToDLL(Node root) {
        tToDLL(root);
        return head;
    }

    public void tToDLL(Node root) {
        if (root == null) {
            return;
        }
        tToDLL(root.left);
        if (prev == null) {
            head = root;
            prev = root;
        } else {
            root.left = prev;
            prev.right = root;
            prev = root;
        }

        tToDLL(root.right);
    }

    // FIND LCA IN BINARY TREE OF TWO NODES
    public Node LCA(Node root, int n1, int n2) {
        if (root == null) {
            return root;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        Node l = LCA(root.left, n1, n2);
        Node r = LCA(root.right, n1, n2);
        if (l != null && r != null) {
            return root;
        }
        if (l != null) {
            return l;
        } else {
            return r;
        }
    }

    // FIND DISTANCE BETWEEN 2 NODES IN BINARY TREE
    public int findDistance(Node root, int a, int b) {
        Node lca = LCA(root, a, b);
        int x = getDist(lca, a);
        int y = getDist(lca, b);
        return x + y - 2;
    }

    public int getDist(Node root, int val) {
        if (root == null) {
            return 0;
        }
        if (root.data == val)
            return 1;
        int a = getDist(root.left, val);
        int b = getDist(root.right, val);
        if (a == 0 && b == 0)
            return 0;
        return a + b + 1;
    }
}

public class Tree {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.reverseLevelOrder()); // Level Order
        System.out.println(tree.heightOfTree(tree.root)); // Height of Tree
        System.out.println(tree.diameter(tree.root)); // Diameter of Tree
        System.out.println(tree.leftView(tree.root)); // Left View
        System.out.println(tree.rightView(tree.root)); // Right View
        System.out.println(tree.isBalanced(tree.root));
    }
}
