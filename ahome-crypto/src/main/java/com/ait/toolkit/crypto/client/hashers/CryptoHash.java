package com.ait.toolkit.crypto.client.hashers;

import com.ait.toolkit.core.client.Util;
import com.ait.toolkit.crypto.client.core.BaseHasher;
import com.ait.toolkit.crypto.client.core.CryptoLoader;
import com.ait.toolkit.crypto.client.core.WordArray;

/**
 * Implements different hashing algorithms
 * 
 * @author Alain Ekambi
 *
 */
public final class CryptoHash {

	private static final String MD5 = "MD5";
	private static final String SHA1 = "SHA1";
	private static final String SHA224 = "SHA224";
	private static final String SHA256 = "SHA256";
	private static final String SHA3 = "SHA3";
	private static final String SHA384 = "SHA384";
	private static final String SHA512 = "SHA512";
	private static final String RIPEMD160 = "RIPEMD160";
	private static final String PBKDF2 = "pbkdf2";
	private static final int DEFAULT_SIZE = 512;
	private static final int DEFAULT_ITERATIONS = 10000;

	/**
	 * MD5 is a widely used hash function. It's been used in a variety of security applications and is also commonly used to check the integrity of files. Though, MD5 is not
	 * collision resistant, and it isn't suitable for applications like SSL certificates or digital signatures that rely on this property.
	 * 
	 * @param value
	 *            , the value to hash
	 * @return, the md5 hash of the value
	 */
	public static WordArray md5(String value) {
		return hash(MD5, value);
	}

	public static WordArray sha1(String value) {
		return hash(SHA1, value);
	}

	public static WordArray sha224(String value) {
		return hash(SHA224, value);
	}

	public static WordArray sha256(String value) {
		return hash(SHA256, value);
	}

	public static WordArray sha3(String value) {
		return hash(SHA3, value);
	}

	public static WordArray sha384(String value) {
		return hash(SHA384, value);
	}

	public static WordArray sha512(String value) {
		return hash(SHA512, value);
	}

	public static WordArray ripeMd160(String value) {
		return hash(RIPEMD160, value);
	}

	public static BaseHasher getMD5() {
		return _get(MD5);
	}

	public static BaseHasher getSHA1() {
		return _get(SHA1);
	}

	public static BaseHasher getSHA224() {
		return _get(SHA224);
	}

	public static BaseHasher getSHA256() {
		return _get(SHA224);
	}

	public static BaseHasher getSHA3() {
		return _get(SHA3);
	}

	public static BaseHasher getSHA384() {
		return _get(SHA384);
	}

	public static BaseHasher getSHA512() {
		return _get(SHA256);
	}

	public static BaseHasher getRIPEMD160() {
		return _get(RIPEMD160);
	}

	public static WordArray pbkf2(String passPhrase, String salt) {
		return pbkdf2(passPhrase, salt, DEFAULT_SIZE, DEFAULT_ITERATIONS);
	}

	public static WordArray pbkdf2(String passPhrase, String salt, int size, int iterations) {
		if (!CryptoLoader.isLibrarySet(PBKDF2)) {
			injectLib(PBKDF2);
		}
		return _pbkdf2(passPhrase, salt, size, iterations);
	}

	private static native WordArray _call(String hashFn, String value)/*-{
		var o = $wnd.CryptoJS[hashFn](value);
		return @com.ait.toolkit.crypto.client.core.WordArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

	private static native WordArray _pbkdf2(String pass, String salt, int size, int it)/*-{
		var o = $wnd.CryptoJS.PBKDF2(pass, salt, {
			keySize : size / 32,
			iterations : it
		});
		return @com.ait.toolkit.crypto.client.core.WordArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

	private static native BaseHasher _get(String hashFn)/*-{
		var o = $wnd.CryptoJS[hashFn];
		return @com.ait.toolkit.crypto.client.core.BaseHasher::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

	private static WordArray hash(String hashFn, String value) {
		if (!CryptoLoader.isLibrarySet(hashFn)) {
			injectLib(hashFn);
		}
		return _call(hashFn, value);
	}

	private static void injectLib(String libName) {
		if (libName.equalsIgnoreCase(MD5)) {
			Util.injectJs(HasherResources.INSTANCE.md5());
		} else if (libName.equalsIgnoreCase(SHA1)) {
			Util.injectJs(HasherResources.INSTANCE.sha1());
		} else if (libName.equalsIgnoreCase(SHA224)) {
			Util.injectJs(HasherResources.INSTANCE.sha224());
		} else if (libName.equalsIgnoreCase(SHA256)) {
			Util.injectJs(HasherResources.INSTANCE.sha256());
		} else if (libName.equalsIgnoreCase(SHA3)) {
			Util.injectJs(HasherResources.INSTANCE.sha3());
		} else if (libName.equalsIgnoreCase(SHA384)) {
			Util.injectJs(HasherResources.INSTANCE.sha384());
		} else if (libName.equalsIgnoreCase(SHA512)) {
			Util.injectJs(HasherResources.INSTANCE.sha512());
		} else if (libName.equalsIgnoreCase(RIPEMD160)) {
			Util.injectJs(HasherResources.INSTANCE.ripemd160());
		} else if (libName.equalsIgnoreCase(PBKDF2)) {
			Util.injectJs(HasherResources.INSTANCE.pbkdf2());
		}
	}
}
