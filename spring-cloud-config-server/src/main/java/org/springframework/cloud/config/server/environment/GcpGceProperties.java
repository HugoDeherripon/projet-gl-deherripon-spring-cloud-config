package org.springframework.cloud.config.server.environment;

import jakarta.validation.constraints.NotEmpty;

public class GcpGceProperties {
	/**
	 * Mount path of the Kubernetes authentication backend.
	 */
	@NotEmpty
	private String gcpPath = "gcp";

	/**
	 * Name of the role against which the login is being attempted.
	 */
	private String role = "";

	/**
	 * Optional service account id. Using the default id if left unconfigured.
	 */
	private String serviceAccount = "";

	public String getGcpPath() {
		return this.gcpPath;
	}

	public String getRole() {
		return this.role;
	}

	public String getServiceAccount() {
		return this.serviceAccount;
	}

	public void setGcpPath(String gcpPath) {
		this.gcpPath = gcpPath;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setServiceAccount(String serviceAccount) {
		this.serviceAccount = serviceAccount;
	}

}
