package carina;

import com.qaprosoft.carina.core.foundation.api.AbstractApiMethodV2;
import com.qaprosoft.carina.core.foundation.utils.Configuration;

public class ResetAPIMethod extends AbstractApiMethodV2{

	public ResetAPIMethod() {
		super("api/reset/_post/rq.json","api/reset/_post/rs.json", "api/reset/reset.properties");
		replaceUrlPlaceholder("base_url", Configuration.getEnvArg("api_url"));
	}
}
