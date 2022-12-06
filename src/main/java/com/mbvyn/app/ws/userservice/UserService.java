package com.mbvyn.app.ws.userservice;

import com.mbvyn.app.ws.ui.model.request.UserDetailsRequestModel;
import com.mbvyn.app.ws.ui.model.response.UserRest;

public interface UserService {
	UserRest createUser(UserDetailsRequestModel userDetails);
}
