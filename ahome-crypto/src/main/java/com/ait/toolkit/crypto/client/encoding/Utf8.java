package com.ait.toolkit.crypto.client.encoding;

import com.ait.toolkit.crypto.client.core.BaseEncoder;
import com.ait.toolkit.crypto.client.core.WordArray;
import com.google.gwt.core.client.JavaScriptObject;

public class Utf8 extends BaseEncoder {

	public static final Utf8 INSTANCE = new Utf8(BaseEncoder.createEncoder("Utf8"));

	public static WordArray parse(String word) {
		return INSTANCE._parse(word);
	}

	public static String stringyfy(WordArray word) {
		return INSTANCE._stringify(word);
	}

	protected Utf8(JavaScriptObject peer) {
		super(peer);
	}

}
