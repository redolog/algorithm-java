package com.algorithm.string;

/**
 * <a href="https://leetcode.cn/problems/determine-if-two-events-have-conflict/">2446. Determine if Two Events Have Conflict</a>
 *
 * @author songhuilong  @date 2023/5/17
 */
public class DetermineIfTwoEventsHaveConflict {

    static class StringCmpSolution {
        /**
         * 字符串直接比较即可。
         * 不相交仅有两种情况：
         * 1. event1整体在event2左侧；
         * 2. event2整体在event1左侧；
         * 排除两种情况即可得解。
         */
        public boolean haveConflict(String[] event1, String[] event2) {
            return !(event1[1].compareTo(event2[0]) < 0 || event2[1].compareTo(event1[0]) < 0);
        }
    }
    
    static class TransToMinSolution{
        public boolean haveConflict(String[] event1, String[] event2) {
            int startMin1 = toMin(event1[0]);
            int endMin1 = toMin(event1[1]);
            int startMin2 = toMin(event2[0]);
            int endMin2 = toMin(event2[1]);
            return intersect(startMin1, startMin2, endMin2)
                    || intersect(endMin1, startMin2, endMin2)
                    || intersect(startMin2, startMin1, endMin1)
                    || intersect(endMin2, startMin1, endMin1)
                    ;
        }

        private boolean intersect(int startMin1, int startMin2, int endMin2) {
            return startMin1 >= startMin2 && startMin1 <= endMin2;
        }

        /**
         * @param event HH:MM
         */
        private int toMin(String event) {
            int hh = Integer.parseInt(event.substring(0, 2));
            int mm = Integer.parseInt(event.substring(3, 5));
            return hh * 60 + mm;
        }
    }

}
