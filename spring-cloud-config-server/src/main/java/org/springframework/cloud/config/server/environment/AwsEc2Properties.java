package org.springframework.cloud.config.server.environment;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;

@Validated
public class AwsEc2Properties {
    /**
	 * URL of the AWS-EC2 PKCS7 identity document.
	 */
	@NotEmpty
	private String identityDocument = "http://169.254.169.254/latest/dynamic/instance-identity/pkcs7";

	/**
	 * Mount path of the AWS-EC2 authentication backend.
	 */
	@NotEmpty
	private String awsEc2Path = "aws-ec2";

	/**
	 * Name of the role, optional.
	 */
	private String role = "";

	/**
	 * Nonce used for AWS-EC2 authentication. An empty nonce defaults to nonce
	 * generation.
	 */
	private String nonce;

	public String getIdentityDocument() {
		return this.identityDocument;
	}

	public String getAwsEc2Path() {
		return this.awsEc2Path;
	}

	public String getRole() {
		return this.role;
	}

	public String getNonce() {
		return this.nonce;
	}

	public void setIdentityDocument(String identityDocument) {
		this.identityDocument = identityDocument;
	}

	public void setAwsEc2Path(String awsEc2Path) {
		this.awsEc2Path = awsEc2Path;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setNonce(String nonce) {
		this.nonce = nonce;
	}

}

