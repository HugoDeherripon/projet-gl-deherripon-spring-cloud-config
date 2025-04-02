package org.springframework.cloud.config.server.environment;

import java.time.Duration;

import org.springframework.cloud.config.server.environment.GcpCredentials;

import jakarta.validation.constraints.NotEmpty;

public class GcpIamProperties {
    /**
	 * Credentials configuration.
	 */
	private final GcpCredentials credentials = new GcpCredentials();

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
	 * Overrides the GCP project Id.
	 */
	private String projectId = "";

	/**
	 * Overrides the GCP service account Id.
	 */
	private String serviceAccountId = "";

	/**
	 * Validity of the JWT token.
	 */
	private Duration jwtValidity = Duration.ofMinutes(15);

	public GcpCredentials getCredentials() {
		return this.credentials;
	}

	public String getGcpPath() {
		return this.gcpPath;
	}

	public String getRole() {
		return this.role;
	}

	public String getProjectId() {
		return this.projectId;
	}

	public String getServiceAccountId() {
		return this.serviceAccountId;
	}

	public Duration getJwtValidity() {
		return this.jwtValidity;
	}

	public void setGcpPath(String gcpPath) {
		this.gcpPath = gcpPath;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setServiceAccountId(String serviceAccountId) {
		this.serviceAccountId = serviceAccountId;
	}

	public void setJwtValidity(Duration jwtValidity) {
		this.jwtValidity = jwtValidity;
	}
}
