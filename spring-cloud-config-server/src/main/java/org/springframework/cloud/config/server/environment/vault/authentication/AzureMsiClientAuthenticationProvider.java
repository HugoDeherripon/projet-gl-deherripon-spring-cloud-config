/*
 * Copyright 2018-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.config.server.environment.vault.authentication;

import java.net.URI;

import org.springframework.cloud.config.server.environment.VaultEnvironmentProperties;
import org.springframework.cloud.config.server.environment.AzureMsiProperties;
import org.springframework.cloud.config.server.environment.enums.AuthenticationMethod;
import org.springframework.cloud.config.server.environment.vault.SpringVaultClientAuthenticationProvider;
import org.springframework.util.Assert;
import org.springframework.vault.authentication.AzureMsiAuthentication;
import org.springframework.vault.authentication.AzureMsiAuthenticationOptions;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.web.client.RestOperations;

public class AzureMsiClientAuthenticationProvider extends SpringVaultClientAuthenticationProvider {

	public AzureMsiClientAuthenticationProvider() {
		super(AuthenticationMethod.AZURE_MSI);
	}

	@Override
	public ClientAuthentication getClientAuthentication(VaultEnvironmentProperties vaultProperties,
			RestOperations vaultRestOperations, RestOperations externalRestOperations) {

		AzureMsiProperties azureMsi = vaultProperties.getAzureMsi();

		Assert.hasText(azureMsi.getRole(),
				missingPropertyForAuthMethod("azure-msi.role", AuthenticationMethod.AZURE_MSI));

		AzureMsiAuthenticationOptions options = AzureMsiAuthenticationOptions.builder()
			.role(azureMsi.getRole())
			.path(azureMsi.getAzurePath())
			.instanceMetadataUri(getUri(azureMsi.getMetadataService(),
					AzureMsiAuthenticationOptions.DEFAULT_INSTANCE_METADATA_SERVICE_URI))
			.identityTokenServiceUri(getUri(azureMsi.getIdentityTokenService(),
					AzureMsiAuthenticationOptions.DEFAULT_IDENTITY_TOKEN_SERVICE_URI))
			.build();

		return new AzureMsiAuthentication(options, vaultRestOperations, externalRestOperations);
	}

	private URI getUri(String uriString, URI defaultUri) {
		if (uriString == null || uriString.isEmpty()) {
			return defaultUri;
		}
		return URI.create(uriString);
	}

}
