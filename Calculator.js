public class Calculator{
    public static linkedList add(linkedList num1, linkedList num2) {
        linkedList ans = new linkedList();
        if (num1.getSize() > num2.getSize()){  // if smaller, add 0's until same size
            int diff = num1.getSize() - num2.getSize();
            for (int i = 0; i < diff; i++)
                num2.add(0);
        }
        if (num2.getSize() > num1.getSize()) {  // if smaller add 0's until same size
            int diff = num2.getSize() - num1.getSize();
            for (int i = 0; i < diff; i++)
                num1.add(0);
        }
        int carry = 0;
        int sum = 0;
        for (int i = 0; i < num1.getSize(); i++){
            int n1 = num1.getVal(i);
            int n2 = num2.getVal(i);
            if (carry == 1){
                sum = n1 + n2 + 1;
                carry = 0;
            }
            else
                sum = n1 + n2;
            if (sum > 9){
                carry = 1;
                ans.add(sum-10);
            }
            else
                ans.add(sum);
        }
        if (carry == 1){
            ans.add(1);
        }
        return ans;
    }

    public static linkedList multi(linkedList num1, linkedList num2) {
        linkedList sum = new linkedList();  // init answer list
        for (int i = 0; i < num1.getSize(); i++) {
            int n1_d, n2, mul, carry = 0;
            linkedList ans = new linkedList();
            n1_d = num1.getVal(i);
            for (int k =0; k < i; k++){ans.add(0);}  // adding zeroes
            for (int j = 0; j < num2.getSize(); j++) {

                n2 = num2.getVal(j);
                mul = (n1_d * n2) + carry;
                if (mul > 9) {
                    carry = mul / 10;
                    ans.add(mul % 10);
                } else {
                    ans.add(mul);
                    carry = 0;
                }

            }
            if (carry !=0)
                ans.add(carry);
            linkedList ans_copy = ans.clone();
            sum = add(ans_copy, sum);
        }
        return sum;
    }
    public static linkedList exp(linkedList num1, int num2) {
        linkedList num3 = new linkedList();
        linkedList ans = new linkedList();
        num3.add(1);
        int orgNum2=num2;
        //check power
        if (num2 == 0) { //zero
            ans.add(1);
        }
        while (num2 > 1) {
            if ((num2 % 2) == 0) { //even
                num1 = multi(num1, num1);
                num2 = num2/2;
            } else if((num2 % 2 != 0)) {//odd
                num3 = multi(num1, num3);
                num1 = multi(num1, num1);
                num2 = (num2-1)/2;
            }
        }
        if(orgNum2!=0){
            ans = multi(num1, num3);
        }
        return ans;

    }

}

