package com.gabriel.droidr.core.manifest;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class ManifestProcessor {

	private static ManifestProcessor instance;
	
	private String manifestPath = "src" + File.separator + "com" 
			+ File.separator + "gabriel" + File.separator + "droidr" 
			+ File.separator + "manifest" + File.separator + "manifest.json";

	private Manifest manifest;
	private Class<?> mainActivityClass;
	
	private ManifestProcessor() {
		processManifest();
	}
	
	public static ManifestProcessor getInstance() {
		if (instance == null) {
			instance = new ManifestProcessor();
		}
		return instance;
	} 
	
	/**
	 * Processes the manifest.json file.
	 */
	private void processManifest() {
		try {
			
			setManifestObject();
			setMainActivityClass();
			
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Convert the manifest.json file to an object.
	 * @throws IOException
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 */
	private void setManifestObject() throws IOException, JsonParseException, JsonMappingException {
		ObjectMapper mapper = new ObjectMapper();
		manifest = mapper.readValue(new File(manifestPath), Manifest.class);
	}
	
	/**
	 * Get the fully qualified name from the main activity class (defined in the manifest) and then convert to a Class object.
	 * @throws ClassNotFoundException
	 */
	private void setMainActivityClass() throws ClassNotFoundException {
		String mainClassName = manifest.getMainActivity();
		mainActivityClass = Class.forName(mainClassName);
	}
	
	/**
	 * Return the class of the main activity. 
	 * @return
	 */
	public Class<?> getMainActivity() {
		return mainActivityClass;
	}

	/**
	 * Return the Manifest object from manifest.json file.
	 * @return
	 */
	public Manifest getManifest() {
		return manifest;
	}
	
}
