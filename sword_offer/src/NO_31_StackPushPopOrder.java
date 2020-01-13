import java.util.LinkedList;
import java.util.List;

public class NO_31_StackPushPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0) {
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        int j = 0;

        for(int i = 0; i < popA.length; i ++) {
            if(!stack.isEmpty() && stack.peekLast() == popA[i]) {
                stack.removeLast();
            } else {
                while(true) {
                    if(j >= pushA.length) {
                        return false;
                    }
                    if(pushA[j] != popA[i]) {
                        stack.addLast(pushA[j++]);
                    } else {
                        j ++;
                        break;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,5,3,2,1};
        System.out.println(IsPopOrder(pushA, popA));
    }
}
