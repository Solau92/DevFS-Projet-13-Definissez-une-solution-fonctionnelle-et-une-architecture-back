package com.openclassrooms.yourcaryourway.session;

import com.openclassrooms.yourcaryourway.entity.User;

public class ConnectedUser {

	public static User user;

	public static User getUser() {
		return user;
	}

	public static void setUser(User user) {
		ConnectedUser.user = user;
	}

}
