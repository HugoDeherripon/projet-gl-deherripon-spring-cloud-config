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

import org.springframework.cloud.config.server.environment.VaultEnvironmentProperties;
import org.springframework.cloud.config.server.environment.PcfProperties;
import org.springframework.cloud.config.server.environment.enums.AuthenticationMethod;
import org.springframework.cloud.config.server.environment.vault.SpringVaultClientAuthenticationProvider;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;
import org.springframework.vault.authentication.ClientAuthentication;
import org.springframework.vault.authentication.PcfAuthentication;
import org.springframework.vault.authentication.PcfAuthenticationOptions;
import org.springframework.vault.authentication.ResourceCredentialSupplier;
import org.springframework.web.client.RestOperations;

public class PcfClientAuthenticationProvider extends SpringVaultClientAuthenticationProvider {

	public PcfClientAuthenticationProvider() {
		super(AuthenticationMethod.PCF);
	}

	@Override
	public ClientAuthentication getClientAuthentication(VaultEnvironmentProperties vaultProperties,
			RestOperations vaultRestOperations, RestOperations externalRestOperations) {

		PcfProperties pcfProperties = vaultProperties.getPcf();

		assertClassPresent("org.bouncycastle.crypto.signers.PSSSigner",
				missingClassForAuthMethod("BouncyCastle", "bcpkix-jdk15on", AuthenticationMethod.PCF));
		Assert.hasText(pcfProperties.getRole(), missingPropertyForAuthMethod("pcf.role", AuthenticationMethod.PCF));

		PcfAuthenticationOptions.PcfAuthenticationOptionsBuilder builder = PcfAuthenticationOptions.builder()
			.role(pcfProperties.getRole())
			.path(pcfProperties.getPcfPath());

		if (pcfProperties.getInstanceCertificate() != null) {
			builder.instanceCertificate(new ResourceCredentialSupplier(pcfProperties.getInstanceCertificate()));
		}
		else {
			builder.instanceCertificate(new ResourceCredentialSupplier(resolveEnvVariable("CF_INSTANCE_CERT")));
		}

		if (pcfProperties.getInstanceKey() != null) {
			builder.instanceKey(new ResourceCredentialSupplier(pcfProperties.getInstanceKey()));
		}
		else {
			builder.instanceKey(new ResourceCredentialSupplier(resolveEnvVariable("CF_INSTANCE_KEY")));
		}

		return new PcfAuthentication(builder.build(), vaultRestOperations);
	}

	private static String resolveEnvVariable(String name) {

		String value = System.getenv(name);

		if (ObjectUtils.isEmpty(value)) {
			throw new IllegalStateException(String.format("Environment variable %s not set", name));
		}

		return value;
	}

}
