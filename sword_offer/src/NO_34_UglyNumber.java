import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NO_34_UglyNumber {
    public static int solution(int index) {
        if(index <= 0) {
            return 0;
        }
        List<Integer> uglyList = new ArrayList<>(index);
        uglyList.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while(uglyList.size() < index) {
            int m2 = uglyList.get(i2) * 2;
            int m3 = uglyList.get(i3) * 3;
            int m5 = uglyList.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            uglyList.add(min);
            if(min == m2) i2 ++;
            if(min == m3) i3 ++;
            if(min == m5) i5 ++;
        }
        return uglyList.get(index -1);
    }

    public static void main(String[] args) {

    }
}
