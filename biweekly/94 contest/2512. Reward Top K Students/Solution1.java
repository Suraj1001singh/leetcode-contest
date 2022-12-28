import java.util.*;;

class Solution {
    public List<Integer> topStudents(String[] positive_feedback, String[] negative_feedback, String[] report,
            int[] student_id, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        Set<String> posi = new HashSet<>();
        Set<String> neg = new HashSet<>();
        for (String s : positive_feedback)
            posi.add(s);
        for (String s : negative_feedback)
            neg.add(s);
        for (int i = 0; i < report.length; i++) {
            int id = student_id[i];
            String keys[] = report[i].split(" ");
            int point = 0;
            for (String s : keys) {
                if (posi.contains(s))
                    point += 3;
                else if (neg.contains(s))
                    point -= 1;

            }
            pq.add(new int[] { id, point });
        }
        List<Integer> res = new ArrayList<>();
        while (k-- > 0 && !pq.isEmpty()) {
            res.add(pq.poll()[0]);
        }
        return res;
    }
}
// Time complexity : O(N*log N)