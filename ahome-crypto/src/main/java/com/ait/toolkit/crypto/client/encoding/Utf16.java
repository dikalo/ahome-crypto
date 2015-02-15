package com.ait.toolkit.crypto.client.encoding;

import com.ait.toolkit.crypto.client.core.BaseEncoder;
import com.ait.toolkit.crypto.client.core.WordArray;
import com.google.gwt.core.client.JavaScriptObject;

public class Utf16 extends BaseEncoder {

	public static final Utf16 INSTANCE = new Utf16(BaseEncoder.createEncoder("Utf16"));

	public static WordArray parse(String word) {
		return INSTANCE._parse(word);
	}

	public static String stringyfy(WordArray word) {
		return INSTANCE._stringify(word);
	}

	protected Utf16(JavaScriptObject peer) {
		super(peer);
	}

}
