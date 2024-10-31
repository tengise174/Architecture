public class Exercise_1 {

    static int lengthBumpy(int n) {
        int length = 1;
        while(n!=1) {
            if(n%2 == 0) {
                n /= 2;
            }
            else {
                n = n*3 + 1;
            }
            length++;
        }
        return length;
    }

    public static void main(String[] args) {
        System.out.println(lengthBumpy(11));
    }


}
