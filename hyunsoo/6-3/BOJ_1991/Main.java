package BOJ_1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void preorder(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preorder(node.left);
            preorder(node.right);
        }
    }

    public static void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data);
            inorder(node.right);
        }
    }

    public static void postorder(Node node) {
        if (node != null) {
            postorder(node.left);
            postorder(node.right);
            System.out.print(node.data);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Node[] nodes = new Node[N];

        for (int i = 0; i < N; i++) {
            char ch = (char) (65 + i);
            nodes[i] = new Node(ch);
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            Node node = nodes[st.nextToken().charAt(0) - 65];
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            if (leftValue != '.') {
                node.setLeft(nodes[leftValue - 65]);
            }

            if (rightValue != '.') {
                node.setRight(nodes[rightValue - 65]);
            }
        }

        Node root = nodes[0];

        preorder(root);
        System.out.println();
        inorder(root);
        System.out.println();
        postorder(root);
    }
}

class Node {
    char data;
    Node left;
    Node right;

    public Node(char data) {
        this.data = data;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
