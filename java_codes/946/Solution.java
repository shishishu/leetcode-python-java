import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        int index = 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < pushed.length; i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty() && stack.peek() == popped[index]){
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }
}