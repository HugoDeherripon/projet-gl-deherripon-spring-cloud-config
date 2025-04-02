package org.springframework.cloud.config.server.environment;

import org.springframework.core.io.Resource;

import jakarta.validation.constraints.NotEmpty;

public class PcfProperties {
    /**
	 * Mount path of the Kubernetes authentication backend.
	 */
	@NotEmpty
	private String pcfPath = "pcf";

	/**
	 * Name of the role against which the login is being attempted.
	 */
	private String role = "";

	/**
	 * Path to the instance certificate (PEM). Defaults to {@code CF_INSTANCE_CERT}
	 * env variable.
	 */
	private Resource instanceCertificate;

	/**
	 * Path to the instance key (PEM). Defaults to {@code CF_INSTANCE_KEY} env
	 * variable.
	 */
	private Resource instanceKey;

	public String getPcfPath() {
		return this.pcfPath;
	}

	public void setPcfPath(String pcfPath) {
		this.pcfPath = pcfPath;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Resource getInstanceCertificate() {
		return this.instanceCertificate;
	}

	public void setInstanceCertificate(Resource instanceCertificate) {
		this.instanceCertificate = instanceCertificate;
	}

	public Resource getInstanceKey() {
		return this.instanceKey;
	}

	public void setInstanceKey(Resource instanceKey) {
		this.instanceKey = instanceKey;
	}    
}
