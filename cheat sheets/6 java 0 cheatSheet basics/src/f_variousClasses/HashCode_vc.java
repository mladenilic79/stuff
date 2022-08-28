package f_variousClasses;

import java.security.NoSuchAlgorithmException;

public class HashCode_vc {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        // ovaj kod nisam testirao
        
        String password = "pera";

        java.security.MessageDigest md 
                = java.security.MessageDigest.getInstance("MD5");

        byte[] array = md.digest(password.getBytes());

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < array.length; ++i) {

            sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100)
                    .substring(1, 3));

        }

        System.out.println("hash code " + sb);
    }
}
