package com.offers4u.auth.service;

import com.offers4u.auth.controller.dto.LoginDetails;

public interface UserAuthService {
	String authenticateUser(LoginDetails loginDetails);
}
