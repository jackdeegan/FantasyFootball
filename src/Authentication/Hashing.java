package Authentication;

import java.security.MessageDigest;

public class Hashing {
	
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();

	public static String HashPassword(String pwd) throws Exception{
		
        String SALT = "34F6JD";
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.reset();
        md.update(SALT.getBytes());
        md.update(pwd.getBytes());
        byte[] out = md.digest();
        return bytesToHex(out);
	}

	public static String bytesToHex(byte[] bytes){
        char[] hexChar = new char[bytes.length * 2];
        int v;
        for (int i = 0; i < bytes.length; i++) {
            v = bytes[i] & 0xFF;
            hexChar[i * 2] = hexArray[v >>> 4];
            hexChar[i * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChar);
    }
}
