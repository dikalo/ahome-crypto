package com.ait.toolkit.crypto.client.encoding;

import com.ait.toolkit.crypto.client.core.BaseEncoder;
import com.ait.toolkit.crypto.client.core.WordArray;
import com.google.gwt.core.client.JavaScriptObject;

public class Hex extends BaseEncoder {

	public static final Hex INSTANCE = new Hex(BaseEncoder.createEncoder("Hex"));

	public static WordArray parse(String word) {
		return INSTANCE._parse(word);
	}

	public static String stringyfy(WordArray word) {
		return INSTANCE._stringify(word);
	}

	protected Hex(JavaScriptObject peer) {
		super(peer);
	}

}
