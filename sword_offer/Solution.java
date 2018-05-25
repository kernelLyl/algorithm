public class Solution {
    public boolean Find(int target, int [][] array) {
        int row=0;
        int column=array[0].length-1;
        while(row <=array.length-1 &&    column >= 0) {
            if(array[row][column] == target)
                return true;
            else if(array[row][column] > target)
                column --;
            else
                row ++;
    	}
        return false;
    }
}
