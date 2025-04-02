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

package org.springframework.cloud.config.server.environment;

import java.net.URI;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import jakarta.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.config.server.environment.enums.AuthenticationMethod;
import org.springframework.cloud.config.server.environment.AppRoleProperties;
import org.springframework.cloud.config.server.environment.AwsEc2Properties;
import org.springframework.cloud.config.server.environment.AwsIamProperties;
import org.springframework.cloud.config.server.environment.AzureMsiProperties;
import org.springframework.cloud.config.server.environment.GcpGceProperties;
import org.springframework.cloud.config.server.environment.GcpIamProperties;
import org.springframework.cloud.config.server.environment.KubernetesProperties;
import org.springframework.cloud.config.server.environment.PcfProperties;
import org.springframework.cloud.config.server.environment.Ssl;
import org.springframework.cloud.config.server.proxy.ProxyHostProperties;
import org.springframework.cloud.config.server.support.HttpEnvironmentRepositoryProperties;
import org.springframework.core.io.Resource;
import org.springframework.validation.annotation.Validated;

/**
 * @author Dylan Roberts
 * @author Haroun Pacquee
 * @author Scott Frederick
 */
@ConfigurationProperties("spring.cloud.config.server.vault")
public class VaultEnvironmentProperties implements HttpEnvironmentRepositoryProperties {

	/** Vault host. Defaults to 127.0.0.1. */
	private String host = "127.0.0.1";

	/** Vault port. Defaults to 8200. */
	private Integer port = 8200;

	/** Vault scheme. Defaults to http. */
	private String scheme = "http";

	/** Timeout (in seconds) for obtaining HTTP connection, defaults to 5 seconds. */
	private int timeout = 5;

	/** Vault backend. Defaults to secret. */
	private String backend = "secret";

	/**
	 * The key in vault shared by all applications. Defaults to application. Set to empty
	 * to disable.
	 */
	private String defaultKey = "application";

	/**
	 * KV2 API required "data" after "mount-path". There could be folder/path structure,
	 * where the keys/applications are grouped. This property is the path after
	 * mount-path, under which application(s) are located (appended after "data") Default
	 * value is blank, which means all grouped applications are located right under the
	 * mount-path
	 *
	 */
	private String pathToKey = "";

	/** Vault profile separator. Defaults to comma. */
	private String profileSeparator = ",";

	/**
	 * Flag to indicate that SSL certificate validation should be bypassed when
	 * communicating with a repository served over an HTTPS connection.
	 */
	private boolean skipSslValidation = false;

	/**
	 * HTTP proxy configuration.
	 */
	private Map<ProxyHostProperties.ProxyForScheme, ProxyHostProperties> proxy = new HashMap<>();

	private int order = DEFAULT_ORDER;

	/**
	 * Value to indicate which version of Vault kv backend is used. Defaults to 1.
	 */
	private int kvVersion = 1;

	/**
	 * The value of the Vault X-Vault-Namespace header. Defaults to null. This a Vault
	 * Enterprise feature only.
	 */
	private String namespace;

	/**
	 * Static vault token. Required if {@link #authentication} is {@code TOKEN}.
	 */
	private String token;

	/**
	 * Flag to indicate that the repository should use 'label' as well as
	 * 'application-name' and 'profile', for vault secrets. By default, the vault secrets
	 * are expected to be in 'application-name,profile' path. When this flag enabled, they
	 * are expected to be in `application-name,profile,label' path. To maintain
	 * compatibility this flag is not enabled by default.
	 */
	private boolean enableLabel = false;

	private String defaultLabel = "main";

	private AppRoleProperties appRole = new AppRoleProperties();

	private AwsEc2Properties awsEc2 = new AwsEc2Properties();

	private AwsIamProperties awsIam = new AwsIamProperties();

	private AzureMsiProperties azureMsi = new AzureMsiProperties();

	private GcpGceProperties gcpGce = new GcpGceProperties();

	private GcpIamProperties gcpIam = new GcpIamProperties();

	private KubernetesProperties kubernetes = new KubernetesProperties();

	private PcfProperties pcf = new PcfProperties();

	private Ssl ssl = new Ssl();

	private AuthenticationMethod authentication;

	public String getHost() {
		return this.host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return this.port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public String getScheme() {
		return this.scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getBackend() {
		return this.backend;
	}

	public void setBackend(String backend) {
		this.backend = backend;
	}

	public String getDefaultKey() {
		return this.defaultKey;
	}

	public void setDefaultKey(String defaultKey) {
		this.defaultKey = defaultKey;
	}

	public String getProfileSeparator() {
		return this.profileSeparator;
	}

	public void setProfileSeparator(String profileSeparator) {
		this.profileSeparator = profileSeparator;
	}

	@Override
	public boolean isSkipSslValidation() {
		return this.skipSslValidation;
	}

	public void setSkipSslValidation(boolean skipSslValidation) {
		this.skipSslValidation = skipSslValidation;
	}

	@Override
	public Map<ProxyHostProperties.ProxyForScheme, ProxyHostProperties> getProxy() {
		return this.proxy;
	}

	public void setProxy(Map<ProxyHostProperties.ProxyForScheme, ProxyHostProperties> proxy) {
		this.proxy = proxy;
	}

	public int getOrder() {
		return this.order;
	}

	@Override
	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public int getTimeout() {
		return this.timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getKvVersion() {
		return this.kvVersion;
	}

	public void setKvVersion(int kvVersion) {
		this.kvVersion = kvVersion;
	}

	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) {
		this.namespace = namespace;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public boolean isEnableLabel() {
		return enableLabel;
	}

	public void setEnableLabel(boolean enableLabel) {
		this.enableLabel = enableLabel;
	}

	public String getDefaultLabel() {
		return defaultLabel;
	}

	public void setDefaultLabel(String defaultLabel) {
		this.defaultLabel = defaultLabel;
	}

	public AppRoleProperties getAppRole() {
		return this.appRole;
	}

	public AwsEc2Properties getAwsEc2() {
		return this.awsEc2;
	}

	public AwsIamProperties getAwsIam() {
		return this.awsIam;
	}

	public AzureMsiProperties getAzureMsi() {
		return this.azureMsi;
	}

	public GcpGceProperties getGcpGce() {
		return this.gcpGce;
	}

	public GcpIamProperties getGcpIam() {
		return this.gcpIam;
	}

	public KubernetesProperties getKubernetes() {
		return this.kubernetes;
	}

	public PcfProperties getPcf() {
		return this.pcf;
	}

	public Ssl getSsl() {
		return this.ssl;
	}

	public void setAuthentication(AuthenticationMethod authentication) {
		this.authentication = authentication;
	}

	public AuthenticationMethod getAuthentication() {
		return authentication;
	}

	public String getPathToKey() {
		return pathToKey;
	}

	public void setPathToKey(String pathToKey) {
		this.pathToKey = pathToKey;
	}
}
