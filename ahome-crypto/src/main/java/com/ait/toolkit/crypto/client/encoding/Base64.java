package com.ait.toolkit.crypto.client.encoding;

import com.ait.toolkit.crypto.client.core.BaseEncoder;
import com.ait.toolkit.crypto.client.core.WordArray;
import com.google.gwt.core.client.JavaScriptObject;

public class Base64 extends BaseEncoder {

	public static final Base64 INSTANCE = new Base64(BaseEncoder.createEncoder("Base64"));

	public static WordArray parse(String word) {
		return INSTANCE._parse(word);
	}

	public static String stringyfy(WordArray word) {
		return INSTANCE._stringify(word);
	}

	protected Base64(JavaScriptObject peer) {
		super(peer);
	}

}
