package com.joe.ejb3.impl;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.joe.ejb3.IOther;

@Stateless
@Local(IOther.class)
public class OtherBean implements IOther {

	@Override
	public String sayMe() {
		return "other";
	}

}
