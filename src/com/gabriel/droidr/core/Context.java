package com.gabriel.droidr.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Context {

	/**
	 * Starts the activity configured in the intent passed in parameter.
	 * @param intent
	 */
	public void startActivity(Intent intent) {
		try {
			Method onCreate = intent.to.getDeclaredMethod("onCreate");
			Activity toInstance = (Activity) intent.to.newInstance();
			onCreate.invoke(toInstance);
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
	
}
