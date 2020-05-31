import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class NO_40_KLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        if (k == 0 || input.length < k) {
            return new ArrayList<>();
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num: input) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }


        // 返回堆中的元素
        ArrayList<Integer> res = new ArrayList<Integer>(pq.size());
        res.addAll(pq);
        return res;
    }
}
