package com.ait.toolkit.crypto.client.core;

import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

public class WordArray extends JsObject {

	public WordArray() {
		this(60);
	}

	WordArray(JavaScriptObject peer) {
		jsObj = peer;
	}

	public WordArray(int size) {
		jsObj = createPeer(size);
	}

	public native String getValue(BaseEncoder encdoer)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer
				.toString(encdoer.@com.ait.toolkit.core.client.JsObject::getJsObj()());
	}-*/;

	public native String getValue()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer.toString();
	}-*/;

	private native JavaScriptObject createPeer(int size)/*-{
		return $wnd.CryptoJS.lib.WordArray.random(size);
	}-*/;

}
