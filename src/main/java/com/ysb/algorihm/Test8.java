package com.ysb.algorihm;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test8 {
    public static void main(String[] args) {
        Test8 aa = new Test8();
        aa.minMutation("AACCGGTT","AACCGGTA",new String[]{"AACCGGTA"});



    }

    public int minMutation(String startGene, String endGene, String[] bank) {

        int n = bank.length;
        boolean[] vis = new boolean[n+1];
        Queue<String[]> queue = new LinkedList();
        queue.offer(new String[]{startGene,String.valueOf(0)});
        while(!queue.isEmpty()){
            String[] p = queue.poll();
            String current = p[0];
            for(int i=0;i<n;++i){
                int matchNum = matchNum(current,bank[i]);
                if(matchNum==7){
                    String next = bank[i];

                    if(next.equals(endGene)){
                        return Integer.valueOf(p[1]) +1;
                    }
                    if(!vis[i]){
                        vis[i] = true;
                        queue.offer(new String[]{next,String.valueOf(Integer.valueOf(p[1]) +1)});
                    }
                }

            }
        }
        return -1;
    }

    public int matchNum(String source,String target){
        int count = 0;
        for(int i=0;i<8;i++){
            if(source.charAt(i)==target.charAt(i)){
                count++;
            }
        }
        return count;
    }

}
