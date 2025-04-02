package org.springframework.cloud.config.server.environment;

import org.springframework.core.io.Resource;

public class GcpCredentials {
    /**
	 * Location of the OAuth2 credentials private key.
	 *
	 * <p>
	 * Since this is a Resource, the private key can be in a multitude of locations,
	 * such as a local file system, classpath, URL, etc.
	 */
	private Resource location;

	/**
	 * The base64 encoded contents of an OAuth2 account private key in JSON format.
	 */
	private String encodedKey;

	public Resource getLocation() {
		return this.location;
	}

	public String getEncodedKey() {
		return this.encodedKey;
	}

	public void setLocation(Resource location) {
		this.location = location;
	}

	public void setEncodedKey(String encodedKey) {
		this.encodedKey = encodedKey;
	}

}
