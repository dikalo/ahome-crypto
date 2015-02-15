package com.ait.toolkit.crypto.client.hashers;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;

interface HasherResources extends ClientBundle {

	static final HasherResources INSTANCE = GWT.create(HasherResources.class);

	@Source("md5.js")
	TextResource md5();

	@Source("sha1.js")
	TextResource sha1();

	@Source("sha224.js")
	TextResource sha224();

	@Source("sha256.js")
	TextResource sha256();

	@Source("sha3.js")
	TextResource sha3();

	@Source("sha384.js")
	TextResource sha384();

	@Source("pbkdf2.js")
	TextResource pbkdf2();

	@Source("ripemd160.js")
	TextResource ripemd160();

	@Source("sha512.js")
	TextResource sha512();
}
