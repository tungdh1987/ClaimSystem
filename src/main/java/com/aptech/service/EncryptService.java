package com.aptech.service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EncryptService {

	private static String byteToHex(final byte[] hash) {
		String result;
		Formatter formatter = new Formatter();
		for (byte b : hash) {
			formatter.format("%02X", b);
		}
		result = formatter.toString();
		formatter.close();
		return result;
	}

	public static String SHA1(String str) {
		String sha1 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-1");
			crypt.reset();
			crypt.update(str.getBytes("UTF-8"));
			sha1 = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(EncryptService.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(EncryptService.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return sha1;
	}

	public static String SHA256(String str) {
		String sha256 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-256");
			crypt.reset();
			crypt.update(str.getBytes("UTF-8"));
			sha256 = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(EncryptService.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(EncryptService.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return sha256;
	}

	public static String SHA512(String str) {
		String sha512 = "";
		try {
			MessageDigest crypt = MessageDigest.getInstance("SHA-512");
			crypt.reset();
			crypt.update(str.getBytes("UTF-8"));
			sha512 = byteToHex(crypt.digest());
		} catch (NoSuchAlgorithmException ex) {
			Logger.getLogger(EncryptService.class.getName()).log(Level.SEVERE,
					null, ex);
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(EncryptService.class.getName()).log(Level.SEVERE,
					null, ex);
		}
		return sha512;
	}
}
