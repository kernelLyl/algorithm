public class NO_12_StringPathInMatrix {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str)
    {
        if(matrix==null || rows<1 || cols<1 || str==null){
            return false;
        }
        int[] visited = new int[matrix.length];

        for(int i = 0; i < rows; i ++){
            for(int j = 0; j < cols; j++){
                if(findPath(matrix,rows,cols,i,j,str,0,visited)){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean findPath(char[] matrix,int rows,int cols,int row,int col,char[] str,int index,int[] visited){
        if(index == str.length){
            return true;
        }
        boolean hasPath = false;
        if(row>=0 && row<rows && col>=0 && col<cols && matrix[row*cols+col]==str[index] && visited[row*cols+col]==0) {
            index++;
            visited[row*cols+col] = 1;

            hasPath = findPath(matrix,rows,cols,row-1,col,str,index,visited) ||
                    findPath(matrix,rows,cols,row+1,col,str,index,visited) ||
                    findPath(matrix,rows,cols,row,col-1,str,index,visited) ||
                    findPath(matrix,rows,cols,row,col+1,str,index,visited);

            if(!hasPath) {
                visited[row*cols+col] = 0;
            }
        }
        return hasPath;
    }
}
