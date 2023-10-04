package com.ysb.algorihm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordSearch {

    int[][] directions = new int[][]{{-1,0},{1,0},{0,1},{0,-1}};
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> set = new HashSet<>();
        HashMapTrie trie = new HashMapTrie();
        for (String word : words) {
            trie.insert(word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board,i,j,trie,set);
            }
        }
        return new ArrayList<>(set);
    }

    private void dfs(char[][] board, int x , int y, HashMapTrie pre, Set<String> set){
        char c = board[x][y];
        if (!pre.getMap().containsKey(c)){
            return;
        }

        HashMapTrie trie =  pre.getMap().get(c);
        if (!trie.getWord().equals("")){
            set.add(trie.getWord());
            trie.setWord("");
        }

        board[x][y] = '#';

        if (!trie.getMap().isEmpty()){
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (0 <= newX && newX< board.length  && 0 <= newY && newY <board[0].length){
                    dfs(board,newX,newY,trie,set);
                }
            }
        }


        board[x][y] = c;

        if (trie.getMap().isEmpty()){
            pre.getMap().remove(c);
        }
    }
}

class HashMapTrie{
    private String word;

    private Map<Character,HashMapTrie> map;

    private boolean isWord;

    public Map<Character,HashMapTrie> getMap(){
        return map;
    }

    public String getWord(){
        return word;
    }

    public void setWord(String word){
        this.word = word;
    }
    public HashMapTrie(){
        this.map = new HashMap<>();
        this.word ="";
    }
    public void insert(String word){
        HashMapTrie trie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!trie.map.containsKey(c)){
                trie.map.put(c,new HashMapTrie());
            }
            trie = trie.map.get(c);
        }
        trie.word = word;

    }
}



