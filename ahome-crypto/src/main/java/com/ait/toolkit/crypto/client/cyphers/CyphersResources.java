package com.ait.toolkit.crypto.client.cyphers;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

public interface CyphersResources extends ClientBundle {

	static final CyphersResources INSTANCE = GWT.create(CyphersResources.class);

	@Source("aes.js")
	TextResource aes();

	@Source("rabbit.js")
	TextResource rabbit();
}
