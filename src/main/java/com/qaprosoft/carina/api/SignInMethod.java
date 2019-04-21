package com.qaprosoft.carina.api;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class SignInMethod extends AbstractApiMethodV2{

		public SignInMethod() {
			super("api/signIn/_post/rq.json", "api/signIn/_post/rs.json", "api/signIn/login.properties");
			replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
		}
		
		
	}


