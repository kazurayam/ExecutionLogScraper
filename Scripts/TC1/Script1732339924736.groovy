import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

import com.kms.katalon.core.configuration.RunConfiguration
//import com.kms.katalon.core.setting.TakeScreenshotSetting

//TakeScreenshotSetting setting = RunConfiguration.getTakeScreenshotSetting()
//assert setting.isEnable() == true

TestObject makeTestObject(String id, String xpath) {
	TestObject tObj = new TestObject(id)
	tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	return tObj
		
}

WebUI.openBrowser("http://demoaut-mimic.kazurayam.com/")

TestObject validButton = makeTestObject("Make Appointment button", "//a[@id='btn-make-appointment']")


WebUI.verifyElementPresent(validButton, 3, FailureHandling.OPTIONAL)
WebUI.delay(1)

WebUI.verifyElementNotPresent(validButton, 3, FailureHandling.OPTIONAL)
WebUI.delay(1)
WebUI.verifyElementNotPresent(validButton, 3, FailureHandling.CONTINUE_ON_FAILURE)
WebUI.delay(1)
WebUI.verifyElementNotPresent(validButton, 3, FailureHandling.STOP_ON_FAILURE)
WebUI.delay(1)


WebUI.waitForElementNotPresent(validButton, 5, FailureHandling.OPTIONAL)

WebUI.waitForElementNotPresent(validButton, 5, FailureHandling.CONTINUE_ON_FAILURE)

WebUI.waitForElementNotPresent(validButton, 5, FailureHandling.STOP_ON_FAILURE)

WebUI.closeBrowser()