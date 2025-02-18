package com.example.fingerprintapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	@Lob // Large Object (for binary fingerprint data)
	@Column(columnDefinition = "BLOB")
	private byte[] fingerprint;

	// Constructors
	public User() {
	}

	public User(String name, byte[] fingerprint) {
		this.name = name;
		this.fingerprint = fingerprint;
	}

	// Getters & Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(byte[] fingerprint) {
		this.fingerprint = fingerprint;
	}
}
