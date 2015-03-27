package com.project.betelguese.server.connection.utils;

public interface Response {

	public static final int GET = 0;
	public static final int POST = 1;

	public interface Listener<S> {
		public void onResponse(S s);
	}

	public interface ErrorListener {
		public void onErrorResponse(Exception exception);
	}

}
