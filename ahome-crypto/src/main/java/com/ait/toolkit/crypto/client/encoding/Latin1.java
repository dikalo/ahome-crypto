package com.ait.toolkit.crypto.client.encoding;

import com.ait.toolkit.crypto.client.core.BaseEncoder;
import com.ait.toolkit.crypto.client.core.WordArray;
import com.google.gwt.core.client.JavaScriptObject;

public class Latin1 extends BaseEncoder {

	public static final Latin1 INSTANCE = new Latin1(BaseEncoder.createEncoder("Latin1"));

	public static WordArray parse(String word) {
		return INSTANCE._parse(word);
	}

	public static String stringyfy(WordArray word) {
		return INSTANCE._stringify(word);
	}

	protected Latin1(JavaScriptObject peer) {
		super(peer);
	}

}
