package com.ait.toolkit.crypto.client.cyphers;

import com.ait.toolkit.core.client.JsObject;
import com.ait.toolkit.core.client.JsoHelper;

public class CyphersOptions extends JsObject {

	public CyphersOptions() {
		jsObj = JsoHelper.createObject();
	}

	public void setIv(String value) {
		JsoHelper.setAttribute(jsObj, "iv", value);
	}

	// TODO
	// Mode and Padding
}
