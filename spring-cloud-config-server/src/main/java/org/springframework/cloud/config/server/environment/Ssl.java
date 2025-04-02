package org.springframework.cloud.config.server.environment;

import org.springframework.core.io.Resource;

import jakarta.validation.constraints.NotEmpty;

public class Ssl {
    /**
	 * Trust store that holds certificates and private keys.
	 */
	private Resource keyStore;

	/**
	 * Password used to access the key store.
	 */
	private String keyStorePassword;

	/**
	 * Trust store that holds SSL certificates.
	 */
	private Resource trustStore;

	/**
	 * Password used to access the trust store.
	 */
	private String trustStorePassword;

	/**
	 * Mount path of the TLS cert authentication backend.
	 */
	@NotEmpty
	private String certAuthPath = "cert";

	public Resource getKeyStore() {
		return this.keyStore;
	}

	public String getKeyStorePassword() {
		return this.keyStorePassword;
	}

	public Resource getTrustStore() {
		return this.trustStore;
	}

	public String getTrustStorePassword() {
		return this.trustStorePassword;
	}

	public String getCertAuthPath() {
		return this.certAuthPath;
	}

	public void setKeyStore(Resource keyStore) {
		this.keyStore = keyStore;
	}

	public void setKeyStorePassword(String keyStorePassword) {
		this.keyStorePassword = keyStorePassword;
	}

	public void setTrustStore(Resource trustStore) {
		this.trustStore = trustStore;
	}

	public void setTrustStorePassword(String trustStorePassword) {
		this.trustStorePassword = trustStorePassword;
	}

	public void setCertAuthPath(String certAuthPath) {
		this.certAuthPath = certAuthPath;
	}
}
