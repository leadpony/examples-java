package org.leadpony.examples;

import java.text.Normalizer;
import java.util.Locale;

import com.ibm.icu.lang.UCharacter;
import com.ibm.icu.text.Normalizer2;

public class Example {
    
    private void run() {
        int count = 0;
        for (int i = 0; i <= 0xffff; i++) {
            if (!isUnstable(i)) {
                String hex = String.format("%04x", i);
                System.out.print("'\\u" + hex + "', ");
                if ((++count % 8) == 0) {
                    System.out.println();
                }
            }
        }
        System.out.println();
        System.out.println("Total: " + count);
    }
    
    private boolean isUnstable(int codePoint) {
        String original = String.valueOf(Character.toChars(codePoint));
        Normalizer2 normalizer = Normalizer2.getNFKCInstance();
        String normalized = normalizer.normalize(original);
        String folded = UCharacter.foldCase(normalized, UCharacter.FOLD_CASE_DEFAULT);
        String result = normalizer.normalize(folded);
        return original.equals(result);
    }

    @SuppressWarnings("unused")
    private boolean isUnstable2(int codePoint) {
        String original = String.valueOf(Character.toChars(codePoint));
        String normalized = Normalizer.normalize(original, Normalizer.Form.NFKC );
        String folded = normalized.toLowerCase(Locale.ENGLISH);
        String result = Normalizer.normalize(folded, Normalizer.Form.NFKC);
        return original.equals(result);
    }

    public static void main(String[] args) {
        new Example().run();
    }
}
