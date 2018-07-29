package com.test;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {

	public static void main(String[] args) {
		String str = encryption("Mellon");
		System.out.println("加密结果：" + str);
		String st = MD5("Mellon");
		System.out.println("加密结果2：" + st);
		String str3 = encryption2("Mellon");
		System.out.println("加密结果3：" + str3);
	}
	
	public static String encryption(String plain) {
		String re_md5 = new String();
		try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(plain.getBytes());
		byte b[] = md.digest();

		int i;

		StringBuffer buf = new StringBuffer("");
		for (int offset = 0; offset < b.length; offset++) {
		i = b[offset];
		if (i < 0)
		i += 256;
		if (i < 16)
		buf.append("0");
		buf.append(Integer.toHexString(i));
		}

		re_md5 = buf.toString();

		} catch (NoSuchAlgorithmException e) {
		e.printStackTrace();
		}
		return re_md5;
		}
	
	private static String MD5(String sourceStr) {
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes());
            byte b[] = md.digest();
            int i;
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
            System.out.println("MD5(" + sourceStr + ",32) = " + result);
            System.out.println("MD5(" + sourceStr + ",16) = " + buf.toString().substring(8, 24));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e);
        }
        return result;
    }
	
	public static String encryption2(String plainText) {
        String re_md5 = new String();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();
 
            int i;
 
            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
 
            re_md5 = buf.toString();
 
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return re_md5;
    }

}
