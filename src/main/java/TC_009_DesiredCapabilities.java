import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TC_009_DesiredCapabilities {
	
	public void desiredCaps() {
		DesiredCapabilities caps=new DesiredCapabilities();
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notfications","--start-maximized");
		caps.setCapability(ChromeOptions.CAPABILITY, options);
		
		Map<String, Object> pref=new HashMap<String, Object>();
		pref.put("profile.default_content_setting.Notifications", 2);
		pref.put("profile.default_content_setting.popups", 2);
		Map<String, Object> content=new HashMap<String, Object>();
		
		
		
	}

}
