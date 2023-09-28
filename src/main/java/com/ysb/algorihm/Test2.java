package com.ysb.algorihm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test2 {
    public static void main(String[] args) {
        Test2 test2 = new Test2();

        /**
         * 二维数组传入一个比较器也可以进行排序
         */
        int[][] matrix = {{1, 3}, {0, 2}, {2, 3}, {4, 6}, {4, 5}, {5, 5}, {0, 2}, {3, 3}};
        Arrays.sort(matrix, (o1, o2) -> {
            if (o1[0] == o2[0]){
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        //在java里，基本数据类型的数组其实被当作一个对象进行处理
        List<int[]> merged = new ArrayList<>();
        merged.toArray(new int[merged.size()][]);
        List<String> list = new ArrayList<>();
        list.add("name");
        list.add("name");
        list.toArray(new String[]{});
        System.out.println(list);

        test2.merge(new int[][]{{1,3},{0,2},{2,3},{4,6},{4,5},{5,5},{0,2},{3,3}});

        test2.insert(new int[][]{{1,5}},new int[]{2,3});

        //System.out.println(test2.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        //System.out.println(test2.findMinArrowShots(new int[][]{{1,2},{3,4},{5,6},{7,8}}));
        System.out.println(test2.findMinArrowShots(new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}}));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(-2147483645>2147483647);
        System.out.println(-2147483645-2147483647);

    }

    public int findMinArrowShots(int[][] points) {

        if (points.length==0){
            return 0;
        }
        Arrays.sort(points,(point1,point2)->{
            if (point1[1] > point2[1]) {
                return 1;
            } else if (point1[1] < point2[1]) {
                return -1;
            } else {
                return 0;
            }
        });
        
        int pos = points[0][1];
        int totalCount = 1;

        for (int[] balloon : points) {
            if (balloon[0]>pos){
                pos = balloon[1];
                totalCount++;
            }
        }

        return totalCount;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> intList = new ArrayList();

        int newLeft = newInterval[0];
        int newRight = newInterval[1];

        int left = 0;
        int right = 0;
        boolean added = false;

        if(intervals.length==0){
            return new int[][]{{newLeft,newRight}};
        }

        for(int i=0;i<intervals.length;i++){

            if(added){
                intList.add(new int[]{intervals[i][0],intervals[i][1]});
            }else{
                int currentLeft = intervals[i][0];
                int currentRight = intervals[i][1];

                if(newRight<currentLeft){
                    intList.add(new int[]{newLeft,newRight});
                    intList.add(new int[]{currentLeft,currentRight});
                    added = true;
                }else if( newRight>=currentLeft
                        && newRight<=currentRight
                        && newLeft<= currentLeft){
                    intList.add(new int[]{Math.min(newLeft,currentLeft),currentRight});
                    added = true;
                }else if(currentLeft<=newLeft
                        && newLeft<=currentRight){
                    newLeft = Math.min(newLeft,currentLeft);
                    newRight = Math.max(newRight,currentRight);
                }else if((currentRight<newLeft)||(currentLeft<newLeft&&newRight<currentRight)){
                    intList.add(new int[]{currentLeft,currentRight});
                }
            }
        }

        return intList.toArray(new int[intList.size()][]);
    }

    public int[][] merge(int[][] intervals) {
        Map<Integer,Integer> map = new HashMap();
        Map<Integer,Integer> resultMap = new LinkedHashMap();
        int length = intervals.length;
        int[] sort = new int[length];
        // 区间左值作为key，区间右值作为value，构建map
        for(int i=0;i<length;i++){
            map.put(intervals[i][0],
                    Math.max(map.getOrDefault(intervals[i][0],intervals[i][1]),intervals[i][1])
            );
            sort[i] = intervals[i][0];
        }

        Arrays.sort(sort);

        int left = sort[0];
        int right = map.get(left);


        for(int i= 1; i<length;i++){
            if(i+1<length&&sort[i]==sort[i+1]){
                continue;
            }

            int currentLeft = sort[i];
            int currentRight = map.get(currentLeft);

            if(currentLeft<=right){
                right = Math.max(right,currentRight);
            }else{
                resultMap.put(left,right);
                left = currentLeft;
                right = currentRight;
            }
        }
        resultMap.put(left,right);
        int[][] res = new int[resultMap.size()][2];

        int index = 0;
        for(Map.Entry entry :resultMap.entrySet())
        {
            res[index][0] =(int) entry.getKey();
            res[index][1] =(int) entry.getValue();
            index++;
        }
        return res;
    }
}
