/*
 * Copyright 2013-2022 the original author or authors.
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
