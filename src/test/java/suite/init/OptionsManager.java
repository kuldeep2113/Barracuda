package suite.init;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Platform;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;

import io.github.bonigarcia.wdm.WebDriverManager;
import suite.constants.WebdriverConstants;

/**
 * This class contains all the browser configurations for the automation suite
 * 
 */
public class OptionsManager {

	private ChromeOptions option;
	private FirefoxOptions optionFF;

	public ChromeOptions getChromeOptions() {
		option = new ChromeOptions();
		Map<String, Object> prefs = new HashMap<String, Object>();
		Map<String, Object> profile = new HashMap<String, Object>();
		Map<String, Object> contentSettings = new HashMap<String, Object>();

		contentSettings.put("geolocation", 1);
		profile.put("managed_default_content_settings", contentSettings);
		prefs.put("profile", profile);
		option.setExperimentalOption("prefs", prefs);
		option.addArguments("--incognito");
		option.addArguments("--disable-notifications");
		option.addArguments("--disable-popup-blocking");
		option.addArguments("start-maximized");
		option.addArguments("enable-automation");
		option.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		option.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", WebdriverConstants.CHROMEDRIVER_PATH);
		return option;
	}

	public ChromeOptions getChromeHeadlessOptions() {
		option = new ChromeOptions();
		option.addArguments("--headless");
		option.addArguments("--incognito");
		option.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
		option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		option.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
		System.setProperty("webdriver.chrome.driver", WebdriverConstants.CHROMEDRIVER_PATH);
		return option;
	}

	
	  public ChromeOptions getChromeGridOptions(){ 
	  option = new ChromeOptions();
	  option.addArguments("--incognito"); option.addArguments("lang=en_GB");
	  option.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,
	  UnexpectedAlertBehaviour.ACCEPT);
	  option.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	  option.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
	  option.setCapability(CapabilityType.PLATFORM_NAME, Platform.LINUX);
	  option.setCapability("screenResolution", "1280x720");
	  option.setCapability("tz", "Asia/Kolkata");
	  option.setCapability("idleTimeout", 150); option.setCapability("recordVideo",
	  false); 
	  return option; 
	  }
	 
	  public FirefoxOptions getFireFoxOptions() {
		  optionFF = new FirefoxOptions();
			Map<String, Object> prefs = new HashMap<String, Object>();
			Map<String, Object> profile = new HashMap<String, Object>();
			Map<String, Object> contentSettings = new HashMap<String, Object>();

			contentSettings.put("geolocation", 1);
			profile.put("managed_default_content_settings", contentSettings);
			prefs.put("profile", profile);
			//optionFF.setExperimentalOption("prefs", prefs);
			optionFF.addArguments("--incognito");
			optionFF.addArguments("--disable-notifications");
			optionFF.addArguments("--disable-popup-blocking");
			optionFF.addArguments("start-maximized");
			optionFF.addArguments("enable-automation");
			optionFF.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			optionFF.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			optionFF.setCapability(CapabilityType.SUPPORTS_JAVASCRIPT, true);
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", WebdriverConstants.FIREFOXDRIVER_PATH);
			return optionFF;
		}

	
	}


