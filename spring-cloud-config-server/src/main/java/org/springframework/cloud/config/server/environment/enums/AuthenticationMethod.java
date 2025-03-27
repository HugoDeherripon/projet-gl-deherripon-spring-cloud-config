package org.springframework.cloud.config.server.environment.enums;

public enum AuthenticationMethod {
    /**
		 * Vault AppRole machine authentication.
		 */
		APPROLE,

		/**
		 * Amazon Web Services Compute authentication.
		 */
		AWS_EC2,

		/**
		 * Amazon Web Services IAM authentication.
		 */
		AWS_IAM,

		/**
		 * Azure Cloud MSI authentication.
		 */
		AZURE_MSI,

		/**
		 * TLS certificate authentication.
		 */
		CERT,

		/**
		 * Cubbyhole token authentication.
		 */
		CUBBYHOLE,

		/**
		 * Google Cloud Compute authentication.
		 */
		GCP_GCE,

		/**
		 * Google Cloud IAM authentication.
		 */
		GCP_IAM,

		/**
		 * Kubernetes service account token authentication.
		 */
		KUBERNETES,

		/**
		 * Cloud Foundry instance identity certificate authentication.
		 */
		PCF,

		/**
		 * Static token authentication.
		 */
		TOKEN

}
