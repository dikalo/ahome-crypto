package com.ait.toolkit.crypto.client.core;

public final class CryptoLoader {

	public static boolean isLibrarySet(String libName) {
		return isSet(libName);
	}

	private static native boolean isSet(String libName)/*-{
		if ($wnd.CryptoJS && $wnd.CryptoJS[libName]) {
			return true;
		}
		return false;
	}-*/;

}
