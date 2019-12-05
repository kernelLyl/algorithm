//不修改数组找出重复的数字
public class NO_03_02_DuplicationInArrayNoEdit {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || numbers.length == 0) {
            return false;
        }

        for(int i = 0; i < length; i ++) {

            while (numbers[i] != i) {
                int m = numbers[i];
                if (numbers[m] == m) {
                    duplication[0] = m;
                    return true;
                } else {
                    numbers[i] = numbers[m];
                    numbers[m] = m;
                }
            }
        }
        return false;
    }
}
