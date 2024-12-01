import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

TestObject makeTestObject(String id, String xpath) {
	TestObject tObj = new TestObject(id)
	tObj.addProperty("xpath", ConditionType.EQUALS, xpath)
	return tObj
}

WebUI.openBrowser("http://demoaut-mimic.kazurayam.com/")

TestObject h1 = makeTestObject("h1", "//h1")

WebUI.executeJavaScript(
	"arguments[0].innerText = 'Guri, Gura';", 
	Arrays.asList(WebUI.findWebElement(h1, 10))
	);

WebUI.delay(3)

String txt = WebUI.getText(h1)

WebUI.comment(txt)

//WebUI.closeBrowser()