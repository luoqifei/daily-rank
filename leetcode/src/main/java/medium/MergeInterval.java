package medium;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class MergeInterval {

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    /**
     * 众多区间，必须先排序，才对相邻的区间进行判断合并
     */
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null) {
            throw new IllegalArgumentException("this intervals list is null");
        }
        if (intervals.size() <= 1) {
            return intervals;
        }
        //排序
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        //声明结果集
        List<Interval> result = new LinkedList<>();
        //声明一个待入队的基准区间start 、end，有点像空气区间被挂起了，默认值是有序区间集合第一个区间
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval i : intervals) {//遍历每一个区间
            if (i.start <= end) {//当前遍历的区间，是否与待入队的基准区间有交集
                end = Math.max(end, i.end);//有重合，那就合并，然后更新待入队的基准区间
            } else {//如果没有重合，那现在浮在空气中的这个待入队基准区间可以入队了
                result.add(new Interval(start, end));
                start = i.start;//然后目前遍历到的这个区间，就可以作为新的基准区间
                end = i.end;
            }
        }
        Interval interval = new Interval(start, end);//将基准区间加入结果集
        result.add(interval);
        return result;
    }
}
