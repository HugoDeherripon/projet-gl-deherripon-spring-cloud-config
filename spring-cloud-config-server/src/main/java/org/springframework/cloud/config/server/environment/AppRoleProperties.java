package org.springframework.cloud.config.server.environment;

import org.springframework.validation.annotation.Validated;

/**
 * AppRole properties.
 */
@Validated
public class AppRoleProperties {
    /**
		 * Mount path of the AppRole authentication backend.
		 */
		private String appRolePath = "approle";

		/**
		 * Name of the role, optional, used for pull-mode.
		 */
		private String role = "";

		/**
		 * The RoleId.
		 */
		private String roleId = null;

		/**
		 * The SecretId.
		 */
		private String secretId = null;

		public String getAppRolePath() {
			return this.appRolePath;
		}

		public String getRole() {
			return this.role;
		}

		public String getRoleId() {
			return this.roleId;
		}

		public String getSecretId() {
			return this.secretId;
		}

		public void setAppRolePath(String appRolePath) {
			this.appRolePath = appRolePath;
		}

		public void setRole(String role) {
			this.role = role;
		}

		public void setRoleId(String roleId) {
			this.roleId = roleId;
		}

		public void setSecretId(String secretId) {
			this.secretId = secretId;
		}
}
