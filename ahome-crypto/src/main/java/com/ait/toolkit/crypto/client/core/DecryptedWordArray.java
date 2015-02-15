package com.ait.toolkit.crypto.client.core;

import com.ait.toolkit.crypto.client.encoding.Utf8;
import com.google.gwt.core.client.JavaScriptObject;

public class DecryptedWordArray extends WordArray {

	DecryptedWordArray(JavaScriptObject peer) {
		jsObj = peer;
	}

	public String getDecryptedValue() {
		return getValue(Utf8.INSTANCE);
	}

}
