package com.ait.toolkit.crypto.client.cyphers;

import com.ait.toolkit.core.client.Util;
import com.ait.toolkit.crypto.client.core.CryptoLoader;
import com.ait.toolkit.crypto.client.core.DecryptedWordArray;
import com.ait.toolkit.crypto.client.core.WordArray;
import com.google.gwt.core.client.JavaScriptObject;

public final class CrytoCyphers {

	private static final String AES = "AES";
	private static final String RABBIT = "RABBIT";

	public static WordArray aesEncrypt(String value, String key) {
		return encrypt(AES, value, key);
	}

	public static WordArray rabbitEncrypt(String value, String key, CyphersOptions options) {
		return encrypt(RABBIT, value, key, options);
	}

	public static WordArray aesEncrypt(String value, String key, CyphersOptions options) {
		return encrypt(AES, value, key, options);
	}

	public static WordArray rabbitEncrypt(String value, String key) {
		return encrypt(RABBIT, value, key);
	}

	public static DecryptedWordArray aesDecrypt(String value, String key) {
		return _decrypt(AES, value, key);
	}

	public static DecryptedWordArray rabbitDecrypt(String value, String key) {
		return _decrypt(RABBIT, value, key);
	}

	private static WordArray encrypt(String fn, String value, String key) {
		if (!CryptoLoader.isLibrarySet(fn)) {
			injectLib(fn);
		}
		return _call(fn, value, key);
	}

	private static WordArray encrypt(String fn, String value, String key, CyphersOptions options) {
		if (!CryptoLoader.isLibrarySet(fn)) {
			injectLib(fn);
		}
		return _call(fn, value, key, options.getJsObj());
	}

	private static DecryptedWordArray decrypt(String fn, String value, String key) {
		if (!CryptoLoader.isLibrarySet(fn)) {
			injectLib(fn);
		}
		return _decrypt(fn, value, key);
	}

	private static native WordArray _call(String fn, String value, String key)/*-{
		var o = $wnd.CryptoJS[fn].encrypt(value, key);
		return @com.ait.toolkit.crypto.client.core.WordArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

	private static native WordArray _call(String fn, String value, String key, JavaScriptObject opts)/*-{
		var o = $wnd.CryptoJS[fn].encrypt(value, key, opts);
		return @com.ait.toolkit.crypto.client.core.WordArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

	private static native DecryptedWordArray _decrypt(String fn, String value, String key)/*-{
		var o = $wnd.CryptoJS[fn].decrypt(value, key);
		return @com.ait.toolkit.crypto.client.core.DecryptedWordArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

	private static void injectLib(String libName) {
		if (libName.equalsIgnoreCase(AES)) {
			Util.injectJs(CyphersResources.INSTANCE.aes());
		} else if (libName.equalsIgnoreCase(RABBIT)) {
			Util.injectJs(CyphersResources.INSTANCE.rabbit());
		}

	}
}
