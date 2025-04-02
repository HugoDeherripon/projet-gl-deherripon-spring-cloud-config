package org.springframework.cloud.config.server.environment;

import jakarta.validation.constraints.NotEmpty;

public class AzureMsiProperties {
    /**
	 * Mount path of the Azure MSI authentication backend.
	 */
	@NotEmpty
	private String azurePath = "azure";

	/**
	 * Name of the role.
	 */
	private String role = "";

	/**
	 * URI to the Azure MSI Identity Service.
	 */
	private String identityTokenService = "";

	/**
	 * URI to the Azure MSI Metadata Service.
	 */
	private String metadataService = "";

	public String getAzurePath() {
		return this.azurePath;
	}

	public String getIdentityTokenService() {
		return identityTokenService;
	}

	public String getMetadataService() {
		return metadataService;
	}

	public String getRole() {
		return this.role;
	}

	public void setAzurePath(String azurePath) {
		this.azurePath = azurePath;
	}

	public void setIdentityTokenService(String identityTokenService) {
		this.identityTokenService = identityTokenService;
	}

	public void setMetadataService(String metadataService) {
		this.metadataService = metadataService;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
