package com.onlineInterview.BusinessLogic;

import org.springframework.stereotype.Service;

@Service
public abstract class Account_Manager<type> {
	public abstract boolean login (String user_name, String password );
	public abstract boolean register(type user);
}
