package com.ait.toolkit.crypto.client.core;

import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

public class BaseEncoder extends JsObject {

	protected BaseEncoder(JavaScriptObject peer) {
		jsObj = peer;
	}

	protected native String _stringify(WordArray word)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		return peer
				.stringify(word.@com.ait.toolkit.core.client.JsObject::getJsObj()());

	}-*/;

	protected native WordArray _parse(String word)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var o = peer
				.stringify(word.@com.ait.toolkit.core.client.JsObject::getJsObj()());
		return @com.ait.toolkit.crypto.client.core.WordArray::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

	protected static native JavaScriptObject createEncoder(String encoder)/*-{
		return $wnd.CryptoJS.enc[encoder];
	}-*/;

}
