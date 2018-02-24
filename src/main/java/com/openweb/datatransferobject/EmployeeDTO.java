package com.openweb.datatransferobject;


public class EmployeeDTO {

	private String name;

	private String role;

	private String profileImageURL;
	
	private String skillset;

	private EmployeeDTO() {
	}
	
	private EmployeeDTO(String name, String role, String skillset ,String profileImageURL) {
		this.name = name;
		this.role = role;
		this.profileImageURL = profileImageURL;
		this.skillset = skillset;

	}

	public static EmployeeDTOBuilder newBuilder() {
		return new EmployeeDTOBuilder();
	}


	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	
	public String getProfileImageURL() {
		return profileImageURL;
	}
	
	
	public String getSkillset() {
		return skillset;
	}

	public static class EmployeeDTOBuilder {

		private String name;
		private String role;
		private String profileImageURL;
		private String skillset;


		public EmployeeDTOBuilder setName(String name) {
			this.name = name;
			return this;
		}
		
		public EmployeeDTOBuilder setSkillset(String skillset) {
			this.skillset = skillset;
			return this;
		}

		public EmployeeDTOBuilder setProfileImageURL(String profileImageURL) {
			this.profileImageURL = profileImageURL;
			return this;
		}

		public EmployeeDTOBuilder setRole(String role) {
			this.role = role;
			return this;
		}
		
		

		public EmployeeDTO createEmployeeDTO() {
			return new EmployeeDTO(name, role, skillset ,profileImageURL);
		}

	}
}
