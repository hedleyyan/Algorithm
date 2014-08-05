
package exercise;

import collection.Stack;
import collection.StackAdapter;
import util.IOUtil;

public class _1_3_44_Buffer {

    private static class Buffer {
        private static final String DEFAULT_CHARSET = "GBK";

        private Stack<Character> left;

        private Stack<Character> right;

        public Buffer(String path) {
            this(path, DEFAULT_CHARSET);
        }

        public Buffer(String path, String charset) {
            char[] chars = IOUtil.readToString(path, charset).toCharArray();
            left = new StackAdapter<Character>();
            right = new StackAdapter<Character>();
            for (int i = chars.length - 1; i >= 0; i--) {
                right.push(chars[i]);
            }
        }

        public void insert(char c) {
            left.push(c);
        }

        public char delete() {
            return right.pop();
        }

        public void left(int k) {
            for (int i=0; i<k; i++) {
                if (!left.isEmpty()) {
                    right.push(left.pop());
                }
            }
        }

        public void right(int k) {
            for (int i=0; i<k; i++) {
                if (!right.isEmpty()) {
                    left.push(right.pop());
                }
            }
        }

        public int size() {
            return left.size() + right.size();
        }
        
        public void flush() {
            char[] chars = new char[size()];
            
            int cursorPos = left.size();
            
            for (int i = cursorPos - 1; i>=0; i--) {
                chars[i] = left.pop();
            }
            
            chars[cursorPos] = '_';
            
            for (int i = cursorPos + 1; i < size(); i++) {
                chars[i] = right.pop();
            }
            System.out.println(chars);
        }
        
    }

    public static void main(String[] args) {
        //        "D:\\SVN\\Docs\\Record\\版本延期发布问题.txt"
        Buffer b = new Buffer("D:\\SVN\\Docs\\Record\\版本延期发布问题.txt");
        b.right(10);
        b.insert('h');
        b.delete();
        b.left(2);
        b.flush();
    }
}
