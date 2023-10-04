package com.ysb.algorihm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Test7 {
    public static void main(String[] args) {
        Test7 aa = new Test7();
        aa.canFinish(2,new int[][]{{1,0}});
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer,Integer> inDegree= new HashMap<>(numCourses);
        Map<Integer, List<Integer>> adj = new HashMap<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i,0);

        }
        for (int[] prerequisite : prerequisites) {
            int dependency = prerequisite[0];
            int pre = prerequisite[1];

            inDegree.put(dependency,inDegree.getOrDefault(dependency,0)+1);
            List<Integer> orDefault = adj.getOrDefault(pre, new ArrayList<>());
            orDefault.add(dependency);
            adj.put(pre,orDefault);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue()==0){
                queue.offer(entry.getKey());
            }
        }

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if (adj.get(poll)!=null){
                for (Integer integer : adj.get(poll)) {
                    inDegree.put(integer,inDegree.get(integer)-1);
                    if (inDegree.get(integer)==0){
                        queue.offer(integer);
                    }
                }
            }


        }

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue()!=0){
                return false;
            }
        }

        return true;
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses];
        Map<Integer,Integer> inDegree= new HashMap<>(numCourses);
        Map<Integer, List<Integer>> adj = new HashMap<>(numCourses);

        for (int i = 0; i < numCourses; i++) {
            inDegree.put(i,0);

        }
        for (int[] prerequisite : prerequisites) {
            int dependency = prerequisite[0];
            int pre = prerequisite[1];

            inDegree.put(dependency,inDegree.getOrDefault(dependency,0)+1);
            List<Integer> orDefault = adj.getOrDefault(pre, new ArrayList<>());
            orDefault.add(dependency);
            adj.put(pre,orDefault);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue()==0){
                queue.offer(entry.getKey());
            }
        }

        int count = 0;
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            res[count] = poll;
            count++;
            if (adj.get(poll)!=null){
                for (Integer integer : adj.get(poll)) {
                    inDegree.put(integer,inDegree.get(integer)-1);
                    if (inDegree.get(integer)==0){
                        queue.offer(integer);
                    }
                }
            }


        }

        for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
            if (entry.getValue()!=0){
                return null;
            }
        }

        return res;
    }
}
