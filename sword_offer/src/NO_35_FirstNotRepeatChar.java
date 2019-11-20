import java.util.ArrayList;
import java.util.List;

public class NO_35_FirstNotRepeatChar {
    public static int solution(String str) {
        if(str == null || "".equals(str)) {
            return -1;
        }

        int[] arr = new int[256];
        for(int i = 0; i < str.length(); i ++) {
            arr[str.charAt(i)] += 1;
        }

        for(int i = 0; i < str.length(); i ++) {
            if(arr[str.charAt(i)] == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
    }
}

