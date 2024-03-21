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
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			// compute the hash of the input 'entity'
			md.update(entity.getBytes());

			// we use MD5 with 128 bits digest
			byte[] digest = md.digest();

			// convert the hash into hex format
			StringBuilder hexString = new StringBuilder();
			for (byte b : digest) {
				hexString.append(String.format("%02x", b));
			}
			// convert the hex into BigInteger
			hashint = new BigInteger(hexString.toString(), 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		// return the BigInteger
		return hashint;
	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5
		try {
			MessageDigest md1 = MessageDigest.getInstance("MD5");

			// compute the number of bits = bitSize()
			int bitSize = md1.getDigestLength() * 8;

			// compute the address size = 2 ^ number of bits
			BigInteger adressSize = BigInteger.valueOf(2).pow(bitSize);

			// return the address size
			return adressSize;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static int bitSize() {

		try {
			MessageDigest md2 = MessageDigest.getInstance("MD5");

			// find the digest length
			int digestlen = md2.getDigestLength();

			return digestlen * 8;

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return 0;
		}
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
