package random;

import lombok.NoArgsConstructor;
import java.util.Random;

@NoArgsConstructor
public class MyRand {
    public Integer get(int min, int max,boolean ls, boolean rs){
        int diff = max - min;
        Random random = new Random();
        if (!rs)
            diff = diff -1;
        if (!ls)
            min = min + 1;
        int i = random.nextInt(diff) + min;
        return  i;
    }
}
