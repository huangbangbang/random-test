package com.ysb.algorihm;

/**
 * @author huangbangbang
 */
public class TrieTest {
    public static void main(String[] args) {
        System.out.println("====");
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // 返回 False
        wordDictionary.search("bad"); // 返回 True
        wordDictionary.search(".ad"); // 返回 True
        wordDictionary.search("b.."); // 返回 True

    }
}

class WordDictionary {

    private Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }

    public void addWord(String word) {
        trie.insert(word);
    }

    public boolean search(String word) {
        return dfs(word,0,trie);
    }

    private boolean dfs(String word , int index,Trie trie){
        if (index==word.length()){
            return  trie.isEnd();
        }
        char c = word.charAt(index);
        if (Character.isLetter(c)){
            int position = c - 'a';
            Trie child = trie.getChildren()[position];
            if (child!=null && dfs(word,index+1,child)){
                return true;
            }
        }else {

            for (int i = 0; i < 26; i++) {
                Trie child = trie.getChildren()[i];
                if (child!=null && dfs(word,index+1,child)){
                    return true;
                }
            }

        }
        return false;
    }
}
class Trie {

    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
    }

    public boolean isEnd(){
        return isEnd;
    }

    public Trie[] getChildren(){
        return children;
    }

    public void insert(String word) {
        Trie trie = this;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (trie.children[index]==null){
                trie.children[index] = new Trie();
            }
            trie = trie.children[index];
        }
        trie.isEnd = true;
    }

    public boolean search(String word) {
        Trie trie = searchPrefix(word);
        return trie!=null && trie.isEnd;
    }

    public boolean startsWith(String prefix) {

        return searchPrefix(prefix)!=null;
    }

    private Trie searchPrefix(String prefix){
        Trie trie = this;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            int index = c - 'a';
            if (trie.children[index]==null){
                return null;
            }
            trie = trie.children[index];
        }
        return trie;
    }
}

