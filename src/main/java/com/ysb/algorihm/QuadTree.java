package com.ysb.algorihm;

public class QuadTree {
    public static void main(String[] args) {
        QuadTree aa = new QuadTree();
        Node node = aa.construct(new int[][]{{0, 1}, {1, 0}});
        System.out.println("=========");
        System.out.println(-1/2);
    }

    public Node construct(int[][] grid) {
        return divideAndConquer(grid,0,0,grid.length);
    }

    private Node divideAndConquer(int[][] grid,int x ,int y ,int length){
        //终点
        if(length==2){
            return getNode(grid,x,y);
        }

        //分
        int newLength = length/2;
        Node topLeft = divideAndConquer(grid,x,y,newLength);
        Node topRight = divideAndConquer(grid,x,y+newLength,newLength);
        Node bottomLeft = divideAndConquer(grid,x+newLength,y,newLength);
        Node bottomRight = divideAndConquer(grid,x+newLength,y+newLength,newLength);

        //治
        Node res = null;
        if(topLeft.isLeaf==true
                && (topLeft.isLeaf==topRight.isLeaf && topLeft.isLeaf==bottomLeft.isLeaf && topLeft.isLeaf==bottomRight.isLeaf)
                && (topLeft.val==topRight.val && topLeft.val==bottomLeft.val && topLeft.val==bottomRight.val)
        ){
            res = new Node(topLeft.val,true);
        }else{
            res = new Node(true,false);
            res.topLeft = topLeft;
            res.topRight = topRight;
            res.bottomLeft = bottomLeft;
            res.bottomRight = bottomRight;
        }

        return res;

    }
    //构造并简化
    private Node getNode(int[][] grid,int x, int y ){
        Node res =  new Node(true,false,
                new Node(grid[x][y]==1,true),
                new Node(grid[x][y+1]==1,true),
                new Node(grid[x+1][y]==1,true),
                new Node(grid[x+1][y+1]==1,true)
        );
        if(res.topLeft.val ==res.topRight.val
                &&res.topLeft.val==res.bottomLeft.val
                &&res.topLeft.val==res.bottomRight.val){
            res.isLeaf = true;
            res.val = res.topLeft.val;
            res.topLeft = null;
            res.topRight = null;
            res.bottomLeft = null;
            res.bottomRight = null;
        }
        return res;
    }

    class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;


        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };
}
