import java.lang.reflect.Array;

public class Exercise_2 {

    static int is235Array(int[] a) {
        int counter = 0;
        for(int i = 0; i < a.length; i++) {
            if(a[i]%2 == 0) counter++;

            if(a[i]%3 == 0) counter++;

            if(a[i]%5 == 0) counter++;

            if(a[i]%2!=0 && a[i]%3!=0 && a[i]%5!=0) counter++;
        }

        if(counter==a.length) return 1;
        else return 0;

    }


    public static void main(String[] args) {
        int[] arr = {};
        System.out.println(is235Array(arr));
    }
}
