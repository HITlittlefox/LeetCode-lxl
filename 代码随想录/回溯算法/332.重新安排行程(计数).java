import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 * @lc app=leetcode.cn id=332 lang=java
 *
 * [332] 重新安排行程
 */

// @lc code=start
class Solution {
    private Deque<String> res;
    // 参数：出发机场，到达机场，航班次数
    private Map<String, Map<String, Integer>> map;

    public List<String> findItinerary(List<List<String>> tickets) {
        map = new HashMap<String, Map<String, Integer>>();
        res = new LinkedList<>();
        // 记录映射关系
        for (List<String> t : tickets) {
            // temp表示 <目的机场，达到目的机场的航班次数>
            Map<String, Integer> temp;
            // 发现该出发机场已经存在
            if (map.containsKey(t.get(0))) {
                // 拿到value
                temp = map.get(t.get(0));
                // 给该出发机场添加新的目的（降落）机场，更新到达目的机场的航班次数
                temp.put(t.get(1), temp.getOrDefault(t.get(1), 0) + 1);
            } else {
                // 映射关系中初次发现出发机场，初始化达到目的机场的航班次数
                temp = new TreeMap<>();// 升序Map
                temp.put(t.get(1), 1);
            }
            // 存入出发机场 -> 目的机场的映射
            map.put(t.get(0), temp);

        }
        // 添加本次行程的起点
        res.add("JFK");
        backTracking(tickets.size());
        return new ArrayList<>(res);
    }

    private boolean backTracking(int ticketNum) {
        if (res.size() == ticketNum + 1) {
            // res存放的是出发地->目的地，ticketNum可以认为是从出发地到目的地的机票数量
            // 抽象来说就是res存放的是点，ticketNum是过程，所以res的数量比ticketNum大1
            return true;
        }

        // 获取本次行程的起点（出发地）[也就是上一次行程的目的地]
        String last = res.getLast();
        if (map.containsKey(last)) {// 防止出现null
            for (Map.Entry<String, Integer> target : map.get(last).entrySet()) {
                // 获取当前可以到达目的机场的航班数量
                int count = target.getValue();
                if (count > 0) { // 大于零，表示还有航班可以达到该目的机场
                    res.add(target.getKey());
                    target.setValue(count - 1);
                    // 选择本次航班，并进入下一次行程
                    if (backTracking(ticketNum))
                        return true; // 所有的机票都使用完，则直接返回结果
                    // 本次行程无法满足要求，回溯
                    res.removeLast();
                    target.setValue(count);
                }
                // count = 0，表示已经没有可以到达该目的机场的航班了（之前已经坐过）
            }
        }
        return false;
    }
}
// @lc code=end
