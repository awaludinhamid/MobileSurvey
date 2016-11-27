/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package id.co.sim.mobsur.security;

import java.util.Random;

/**
 * @created Apr 20, 2013
 * @author awal
 */
public class RandomKeyGenerator {

    private static Random random = new Random();
    private static final int KEY_LENGTH = 10;

    public enum AsciiNumberLimit {
        MIN_CAPS(48),   // start ascii number represented uppercase character
        MAX_CAPS(57),   // end ascii number represented uppercase character
        MIN_LOW(65),    // start ascii number represented lowercase character
        MAX_LOW(90),    // end ascii number represented lowercase character
        MIN_NUM(97),    // start ascii number represented number character
        MAX_NUM(122);    // end ascii number represented number character
        private final int asciiNumber;
        AsciiNumberLimit(int asciiNumber) {
            this.asciiNumber = asciiNumber;
        }
    }

    private RandomKeyGenerator() {
    }

    public static RandomKeyGenerator getInstance() {
        return RandomKeyGeneratorHolder.INSTANCE;
    }

    private static class RandomKeyGeneratorHolder {
        private static final RandomKeyGenerator INSTANCE = new RandomKeyGenerator();
    }

    public String getRandomKey() {
        StringBuilder string = new StringBuilder("");
        for(int idxRand = 0; idxRand < KEY_LENGTH; idxRand++) {
            string.append(Character.toString(getAsciiChar()));
        }
        return string.toString();
    }

    private Character getAsciiChar() {
        Character charRand = null;
        while(charRand == null) {
            int intRand = AsciiNumberLimit.MIN_CAPS.asciiNumber +
                            random.nextInt(AsciiNumberLimit.MAX_NUM.asciiNumber -
                            AsciiNumberLimit.MIN_CAPS.asciiNumber + 1);
        if(
            (intRand >= AsciiNumberLimit.MIN_CAPS.asciiNumber &&
                intRand <= AsciiNumberLimit.MAX_CAPS.asciiNumber) || // A-Z
            (intRand >= AsciiNumberLimit.MIN_LOW.asciiNumber &&
                intRand <= AsciiNumberLimit.MAX_LOW.asciiNumber) || // a-z
            (intRand >= AsciiNumberLimit.MIN_NUM.asciiNumber &&
                intRand <= AsciiNumberLimit.MAX_NUM.asciiNumber)   // 0-9
           )
            charRand = (char) intRand;
        }
        return charRand;
    }
 }
