package com.bigearblessed.smartv.pojos;


public class UserEdit {
    private UserRegistration originalUser;
    private UserRegistration modifiedUser;
	public UserRegistration getOriginalUser() {
		return originalUser;
	}
	public void setOriginalUser(UserRegistration originalUser) {
		this.originalUser = originalUser;
	}
	public UserRegistration getModifiedUser() {
		return modifiedUser;
	}
	public void setModifiedUser(UserRegistration modifiedUser) {
		this.modifiedUser = modifiedUser;
	}
	public UserEdit() {
		super();
		// TODO Auto-generated constructor stub
	}
    
}
