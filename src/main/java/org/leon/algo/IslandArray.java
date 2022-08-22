package org.leon.algo;

public class IslandArray {
    public int numIslands(char[][] grid) {
        if(grid ==null || grid.length==0) return 0;
        int nums = 0;
        for(int row=0; row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                nums +=dfs(row,col,grid);
            }
        }
        return nums;
    }
    public int dfs(int row, int col, char[][] grid){
        if(!inArea(row, col, grid)) return 0;

        if(grid[row][col] != '1') return 0;

        grid[row][col]='2';
        dfs(row-1,col,grid);
        dfs(row+1,col,grid);
        dfs(row,col-1,grid);
        dfs(row, col+1,grid);

        return 1 ;
    }

    public boolean inArea(int row, int col, char[][] grid){
        return (row>=0 && row<grid.length) && (col>=0 && col<grid[0].length);
    }

    public int areaIslands(char[][] grid){
        if(grid ==null || grid.length==0) return 0;
        int max = 0;
        for(int row=0; row<grid.length;row++){
            for(int col=0;col<grid[0].length;col++){
                if(grid[row][col] == '1'){
                    max = Math.max(dfs(row, col, grid), max);
                }
            }
        }
        return max;
    }

    public int dfsArea(int row, int col, char[][] grid){
        if(!inArea(row, col, grid)) return 0;
        if(grid[row][col] != '1') return 0;
        grid[row][col] = '2';
        return 1 + dfs(row-1,col,grid)
         + dfs(row+1,col,grid)
         + dfs(row,col-1,grid)
         + dfs(row, col+1,grid);
    }
}
