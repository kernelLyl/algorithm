public class NO_47_AddTwoNumbers {

    int AddWithoutArithmetic(int num1, int num2) {
        if(num2 == 0)
            return num1;

        //先通过异或来进行相加, 不考虑进位
        int sum = num1 ^ num2;

        //使用'与'来进行进位, 两位都为1, 则为1 , 并向左移一位
        int carry = (num1 & num2) << 1;

        return AddWithoutArithmetic(sum, carry);
    }
}
