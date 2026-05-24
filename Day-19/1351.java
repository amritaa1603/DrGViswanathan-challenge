class Solution {
    public int countNegatives(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

     int r = row -1;
     int c = 0;
     int count =0;
     while(r>=0&&c<col){
        if(grid[r][c]<0){
            count+=col-c;
            r--;

        }
        else{
            c++;
        }

     }
     return count;
    }
}