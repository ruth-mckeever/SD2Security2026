package org.rmck.SimpleEncryption;

public class EncryptionUtil {
    public static String encyptShiftCipher(String plaintext, int key){
        String encryptedText = "";

        //Convert to an array of uppercase characters
        char[] letters = plaintext.toUpperCase().toCharArray();

        //Iterate through all characters in plaintext
        for (int i = 0; i < letters.length; i++) {
            //'A' = 65 - only dealing with letters
            if (letters[i] >= 'A' && letters[i] <= 'Z')
            {
                //TODO: Explain this better
                letters[i] = (char) (Math.floorMod(letters[i] - 'A' + key, 26) +'A');
            }
        }

        encryptedText = new String(letters);
        return encryptedText;
    }

    public static String decryptShiftCipher(String encryptedtext, int key){
        return encyptShiftCipher(encryptedtext, -key);
    }

    public static String encryptCeaserCipher(String plaintext){
        return encyptShiftCipher(plaintext, 3);
    }

    public static String decryptCeaserCipher(String encryptedtext) {
        return encyptShiftCipher(encryptedtext, -3);
    }

}
