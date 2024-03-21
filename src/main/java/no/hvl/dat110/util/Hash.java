package no.hvl.dat110.util;

/**
 * exercise/demo purpose in dat110
 * @author tdoy
 *
 */

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash { 
	
	
	public static BigInteger hashOf(String entity) {	
		
		BigInteger hashint = null;
		
		// Task: Hash a given string using MD5 and return the result as a BigInteger.
		try{
			MessageDigest md = MessageDigest.getInstance("MD5");
			// compute the hash of the input 'entity'
			md.update(entity.getBytes());

			// we use MD5 with 128 bits digest
			byte[] digest = md.digest();
		
			// convert the hash into hex format
			StringBuilder hexString = new StringBuilder();
			for(byte b : digest) {
				hexString.append(String.format("%02x", b));
			}
			// convert the hex into BigInteger
			hashint = new BigInteger(hexString.toString(), 16);
		} catch (NoSuchAlgorithmException e){
			e.printStackTrace();
		}
			// return the BigInteger		
			return hashint;
	}
	
	public static BigInteger addressSize() {
		
		// Task: compute the address size of MD5
		
		// compute the number of bits = bitSize()
		
		// compute the address size = 2 ^ number of bits
		
		// return the address size
		
		return null;
	}
	
	public static int bitSize() {
		
		int digestlen = 0;
		
		// find the digest length
		
		return digestlen*8;
	}
	
	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for(byte b : digest) {
			strbuilder.append(String.format("%02x", b&0xff));
		}
		return strbuilder.toString();
	}

}
