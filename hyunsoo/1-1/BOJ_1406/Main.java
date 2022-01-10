package BOJ_1406;

import java.io.*;
import java.util.Stack;

/**
 * 주어진 시간 제한이 짧은 문제.
 * 시간복잡도, 입출력 시간을 최소화해야함
 * 스택을 이용해서 삽입, 삭제할때 O(1)의 시간복잡도를 가짐.
 * 입출력 시간을 최소화하기 위해 BufferedReader, BufferedWriter를 사용
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Edit edit = new Edit(br.readLine());
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            String command = br.readLine();

            switch (command.charAt(0)) {
                case 'L':
                    edit.moveLeft();
                    break;
                case 'D':
                    edit.moveRight();
                    break;
                case 'B':
                    edit.delete();
                    break;
                case 'P':
                    edit.insert(command.charAt(2));
                    break;
            }
        }

        edit.print();
    }
}

class Edit {
    Stack<Character> left;
    Stack<Character> right = new Stack<>();

    // Edit 클래스를 만들때 String을 받고 전부 left 스택에 넣음
    public Edit(String str) {
        this.left = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            this.left.push(str.charAt(i));
        }
    }

    // 왼쪽으로 커서를 이동하면 오른쪽 스택에 왼쪽 스택 맨 위 값을 pop하고 그 값을 push
    public void moveLeft() {
        if (!left.isEmpty()) {
            this.right.add(this.left.pop());
        }
    }

    // 오른쪽 커서를 이동하면 왼쪽 스택에 오른쪽 스택 맨 위 값을 pop하고 그 값을 push
    public void moveRight() {
        if (!right.isEmpty()) {
            this.left.add(this.right.pop());
        }
    }

    // 삭제는 왼쪽 커서의 값을 삭제하므로 왼쪽 스택의 값을 pop
    public void delete() {
        if (!left.isEmpty()) {
            this.left.pop();
        }
    }

    public void insert(char ch) {
        this.left.push(ch);
    }

    public void print() throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!this.left.isEmpty()) {
            this.right.push(this.left.pop());
        }

        while (!this.right.isEmpty()) {
            bw.write(this.right.pop());
        }
        bw.flush();
        bw.close();
    }
}