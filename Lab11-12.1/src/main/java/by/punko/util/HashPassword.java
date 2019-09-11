package main.java.by.punko.util;

import net.sourceforge.jtds.util.MD5Digest;
import org.apache.commons.codec.digest.DigestUtils;

public class HashPassword {
    public static byte[] getHash(String st) {
        String md5Hex = DigestUtils.md5Hex(st);
        return md5Hex.getBytes();
    }
}
