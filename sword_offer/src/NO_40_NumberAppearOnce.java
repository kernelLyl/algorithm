public class NO_40_NumberAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
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

    public boolean isa1(int i, int index){
        i = i >> index;
        return (i & 1) == 1;
    }
}
