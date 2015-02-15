package com.ait.toolkit.crypto.client.core;

import com.ait.toolkit.core.client.JsObject;
import com.google.gwt.core.client.JavaScriptObject;

public class BaseHasher extends JsObject {

	protected BaseHasher(JavaScriptObject peer) {
		jsObj = peer;
	}

	public native void doFinal()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.finalize();
	}-*/;

	public native void update(String value)/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		peer.update(value);
	}-*/;

	private native BaseHasher create()/*-{
		var peer = this.@com.ait.toolkit.core.client.JsObject::getJsObj()();
		var o = peer.create();
		return @com.ait.toolkit.crypto.client.core.BaseHasher::new(Lcom/google/gwt/core/client/JavaScriptObject;)(o);
	}-*/;

}
