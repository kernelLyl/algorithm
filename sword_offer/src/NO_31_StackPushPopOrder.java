import java.util.LinkedList;
import java.util.List;

public class NO_31_StackPushPopOrder {
    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0) {
            return false;
        }

        LinkedList<Integer> stack = new LinkedList<>();
        stack.add(pushA[0]);
        int j = 1;

        for(int i = 0; i < popA.length;) {
            if(stack.peekLast() == popA[i]) {
                stack.removeLast();
                i++;
            } else {
                while(true) {
                    if(j >= pushA.length) {
                        return false;
                    }
                    if(pushA[j] != popA[i]) {
                        stack.addLast(pushA[j++]);
                    } else {
                        i ++;
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
