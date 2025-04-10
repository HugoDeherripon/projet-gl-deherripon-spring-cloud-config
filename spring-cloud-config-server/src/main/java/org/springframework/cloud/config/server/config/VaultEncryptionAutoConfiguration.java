/*
 * Copyright 2020-2020 the original author or authors.
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

package org.springframework.cloud.config.server.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.config.server.encryption.VaultEnvironmentEncryptor;
import org.springframework.cloud.config.server.environment.vault.SpringVaultEnvironmentRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.vault.core.VaultTemplate;

/**
 * Auto configuration for vault encryptor.
 *
 * @author Alexey Zhokhov
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(VaultTemplate.class)
@Profile("vault")
public class VaultEncryptionAutoConfiguration {

	@Value("${spring.cloud.config.server.encrypt.prefixInvalidProperties:${spring.cloud.config.server.encrypt.prefix-invalid-properties:true}}")
	private boolean prefixInvalidProperties;

	@Bean
	public VaultEnvironmentEncryptor vaultEnvironmentEncryptor(
			SpringVaultEnvironmentRepository vaultEnvironmentRepository) {
		VaultEnvironmentEncryptor vaultEnvironmentEncryptor = new VaultEnvironmentEncryptor(
				vaultEnvironmentRepository.getKeyValueTemplate());
		vaultEnvironmentEncryptor.setPrefixInvalidProperties(this.prefixInvalidProperties);
		return vaultEnvironmentEncryptor;
	}

}
