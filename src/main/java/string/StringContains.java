package string;

import java.util.Arrays;

public class StringContains {
    public boolean stringContains(String a, String b) {
        char astr[] = a.toCharArray();
        for (char c :
                b.toCharArray()) {
            int i = 0;
            for (i = 0; i < astr.length && astr[i] != c; i++) ;
            if (i >= astr.length) return false;
        }
        return true;
    }

    public boolean stringContainsHash(String a, String b) {
        int flag = 0;
        for (char c : a.toCharArray()) {
            flag |= 1 << (c - 'A');
        }
        for (char c : b.toCharArray()) {
            if ((flag & (1 << (c - 'A'))) == 0) return false;
        }
        return true;
    }

    public boolean stringContainsLiner(String a, String b) {
        char sortA[] = a.toCharArray();
        char sortB[] = b.toCharArray();
        Arrays.sort(sortA);
        Arrays.sort(sortB);

        int i = 0, j = 0;
        for (; i < sortA.length && j < sortB.length; i++, j++) {
            while (i < sortA.length && sortA[i] < sortB[j]) i++;
            if (i >= sortA.length || sortA[i] > sortB[j]) return false;
        }

        if (j < sortB.length) return false;
        return true;
    }
}
