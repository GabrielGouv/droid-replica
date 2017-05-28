package com.gabriel.droidr.core.bootstrap;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.gabriel.droidr.core.Activity;
import com.gabriel.droidr.core.manifest.ManifestProcessor;


public class Bootstrap {

	/**
	 * Starts the main Activity configured in manifest.json.
	 */
	public void startApplication() {
		try {
			Class<?> startActivity = ManifestProcessor.getInstance().getMainActivity();
			Method onCreate = startActivity.getDeclaredMethod("onCreate");
			Activity toInstance = (Activity) startActivity.newInstance();
			onCreate.invoke(toInstance);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		}
	}
	
}
