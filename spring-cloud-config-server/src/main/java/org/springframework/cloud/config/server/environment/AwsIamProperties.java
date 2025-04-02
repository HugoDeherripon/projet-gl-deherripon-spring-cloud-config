package org.springframework.cloud.config.server.environment;

import java.net.URI;

import jakarta.validation.constraints.NotEmpty;

public class AwsIamProperties {
    /**
	 * Mount path of the AWS authentication backend.
	 */
	@NotEmpty
	private String awsPath = "aws";

	/**
	 * Name of the role, optional. Defaults to the friendly IAM name if not set.
	 */
	private String role = "";

	/**
	 * Name of the server used to set {@code X-Vault-AWS-IAM-Server-ID} header in the
	 * headers of login requests.
	 */
	private String serverName;

	/**
	 * STS server URI.
	 *
	 * @since 2.2
	 */
	private URI endpointUri;

	public String getAwsPath() {
		return this.awsPath;
	}

	public String getRole() {
		return this.role;
	}

	public String getServerName() {
		return this.serverName;
	}

	public void setAwsPath(String awsPath) {
		this.awsPath = awsPath;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public URI getEndpointUri() {
		return this.endpointUri;
	}

	public void setEndpointUri(URI endpointUri) {
		this.endpointUri = endpointUri;
	}    
}
