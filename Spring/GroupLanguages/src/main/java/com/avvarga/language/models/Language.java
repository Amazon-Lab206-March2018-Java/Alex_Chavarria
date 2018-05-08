package com.avvarga.language.models;

import javax.validation.constraints.Size;

public class Language {
	@Size(min = 2, max = 20, message="Name is required")
	private String name;
	
	@Size(min = 2, max = 20, message="Creator is required")
	private String creator;
	
	@Size(min = 1, message="Version is required" )
	private String version;
	
	public Language() {
	}
	
	public Language (String n, String c, String v) {
		name = n;
		creator = c;
		version = v;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
