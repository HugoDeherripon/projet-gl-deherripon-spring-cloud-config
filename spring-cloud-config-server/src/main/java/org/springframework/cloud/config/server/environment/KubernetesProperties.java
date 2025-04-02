package org.springframework.cloud.config.server.environment;

import jakarta.validation.constraints.NotEmpty;

public class KubernetesProperties {
    /**
	 * Mount path of the Kubernetes authentication backend.
	 */
	@NotEmpty
	private String kubernetesPath = "kubernetes";

	/**
	 * Name of the role against which the login is being attempted.
	 */
	private String role = "";

	/**
	 * Path to the service account token file.
	 */
	@NotEmpty
	private String serviceAccountTokenFile = "/var/run/secrets/kubernetes.io/serviceaccount/token";

	public String getKubernetesPath() {
		return this.kubernetesPath;
	}

	public String getRole() {
		return this.role;
	}

	public String getServiceAccountTokenFile() {
		return this.serviceAccountTokenFile;
	}

	public void setKubernetesPath(String kubernetesPath) {
		this.kubernetesPath = kubernetesPath;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setServiceAccountTokenFile(String serviceAccountTokenFile) {
		this.serviceAccountTokenFile = serviceAccountTokenFile;
	}
}
