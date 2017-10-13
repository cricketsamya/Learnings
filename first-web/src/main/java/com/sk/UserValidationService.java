package com.sk;

public class UserValidationService {

	public boolean isUserValid(String user, String password) {
		if (user != null && password != null) {
			if (user.equals("sam") && password.equals("sam")) {
				return true;
			}
		}
		return false;
	}

}
