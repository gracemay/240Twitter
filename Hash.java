//package TwitterAssignment;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Provides an easy way to use cryptographic hash functions
 * Under the current class, NoSuchAlgorithmException and UnsupportedEncodingExceptions
 * should never be thrown unless using a different version of Java or the algorithms
 * have been removed from the JDK (unlikely, as they are not deprecated)
 */
public class Hash
{
    /**
     * Hashes a String with MD5
     * @param input The String to be hashed
     * @return The MD5 digest of the String
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String md5(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes("UTF-8"));
        byte[] digest = md.digest();
        return String.format("%032x", new java.math.BigInteger(1, digest));
    }

    /**
     * Hashes a String with SHA-1
     * @param input The String to be hashed
     * @return The SHA-1 digest of the String
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String sha1(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        md.update(input.getBytes("UTF-8"));
        byte[] digest = md.digest();
        return String.format("%040x", new java.math.BigInteger(1, digest));
    }

    /**
     * Hashes a String with SHA-256
     * @param input The String to be hashed
     * @return The SHA-256 digest of the String
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String sha256(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(input.getBytes("UTF-8"));
        byte[] digest = md.digest();
        return String.format("%064x", new java.math.BigInteger(1, digest));
    }

    /**
     * Hashes a String with SHA-384
     * @param input The String t be hashed
     * @return THe SHA-384 digest of the String
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String sha384(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-384");
        md.update(input.getBytes("UTF-8"));
        byte[] digest = md.digest();
        return String.format("%064x", new java.math.BigInteger(1, digest));
    }

    /**
     * Hashes a String with SHA-512
     * @param input The String to be hashed
     * @return The SHA-512 digest of the String
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static String sha512(String input) throws NoSuchAlgorithmException, UnsupportedEncodingException
    {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        md.update(input.getBytes("UTF-8"));
        byte[] digest = md.digest();
        return String.format("%064x", new java.math.BigInteger(1, digest));
    }

}