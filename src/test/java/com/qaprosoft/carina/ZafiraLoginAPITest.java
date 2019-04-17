package com.qaprosoft.carina;

import org.testng.annotations.Test;

import com.qaprosoft.carina.core.foundation.AbstractTest;
import com.qaprosoft.carina.core.foundation.api.http.HttpResponseStatusType;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;

import carina.ResetAPIMethod;
import carina.SignInMethod;


public class ZafiraLoginAPITest extends AbstractTest {
	@Test(description = "Zafira-login")
	@MethodOwner(owner = "fedorova")
	public void testSignIn() {
	 	SignInMethod signInMethod = new SignInMethod();
		signInMethod.expectResponseStatus(HttpResponseStatusType.UNAUTHORIZED_401);
		signInMethod.callAPI();
	}
	
	@Test(description = "Zafira-reset")
	@MethodOwner(owner = "fedorova")
	public void testReset() {
	 	ResetAPIMethod resetMethod = new ResetAPIMethod();
		resetMethod.expectResponseStatus(HttpResponseStatusType.OK_200);
		resetMethod.callAPI();
	}
	
	
}
