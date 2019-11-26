public class NO_40_NumberAppearOnce {
    public static void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        num1[0] = 0;
        num2[0] = 0;
        if(array.length == 0)
            return;
        int num = 0;
        for(int i = 0; i < array.length; i++){
            num ^= array[i];
        }
        int index = 0;
        while((num & 1) == 0 && index < 8){
            num = num >> 1;
            index ++;
        }

        for(int i = 0; i < array.length; i++){
            if(isa1(array[i], index))
                num1[0] ^= array[i];
            else
                num2[0] ^= array[i];
        }
    }

    //判断i 的第index位是否为1
    public static boolean isa1(int i, int index){
        i = i >> index;
        return (i & 1) == 1;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3 , 4, 10, 205, 34410, 205, 24410, 2, 1, 3};
        FindNumsAppearOnce(test, new int[1], new int[1]);
    }
}
