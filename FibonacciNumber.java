import java.util.List;

public class FibonacciNumber{
    private int i;
    private int p;
    private int q;
    private boolean stop = false;

    private void init(List<Integer> sequence){
        stop = false;
        int k = 0;
        int n = sequence.size();
        for (; getFibonacciNumber(k + 1) < n + 1;){
            k+=1;
        }
        int m = (int)(getFibonacciNumber(k + 1) - (n + 1));
        i = (int)(getFibonacciNumber(k) - m);
        p = (int) getFibonacciNumber(k - 1);
        q = (int) getFibonacciNumber(k - 2);
    }

    public double getFibonacciNumber(int k){
        double firstNumber = 0;
        double secondNumber = 1;
        for (int i = 0; i < k; i++){
            double temp = secondNumber;
            secondNumber += firstNumber;
            firstNumber = temp;
        }
        return firstNumber;
    }

    private void upIndex(){
        if (p == 1){
            stop = true;
        }
        i = i + q;
        p = p - q;
        q = q - p;
    }

    private void downIndex(){
        if (q == 0){
            stop = true;
        }
        i = i - q;
        int temp = q;
        q = p - q;
        p = temp;
    }

    public int search(List<Integer> sequence, int element){
        init(sequence);
        int n = sequence.size();
        int resultIndex = -1;
        for (; !stop;){
            if (i < 0){
                upIndex();
            } else if (i >= n) {
                downIndex();
            } else if (sequence.get(i) == element){
                resultIndex = i;
                break;
            } else if (element < sequence.get(i)){
                downIndex();
            } else if (element > sequence.get(i)) {
                upIndex();
            }
        }
        return resultIndex;
    }
}