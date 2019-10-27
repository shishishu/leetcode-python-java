// recursion
class Solution {
    public int fib(int N){
        return (N <= 1) ? N : fib(N - 1) + fib(N - 2);
    }
}

// iterative
class Solution {
    public int fib(int N){
        int f = 0;
        int g = 1;
        while (N-- > 0) {
            g = g + f;
            f = g - f;
        }
        return f;
    }
}