package TestCases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.w3c.dom.*;

import CommonFunction.CommonFuntions;
import CommonFunction.DataProvide;
import CommonFunction.DataReader;

public class LoginTest extends DataProvide{
	public CommonFuntions comfun;
	public DataReader dr;
	
	@BeforeTest
	public void setup() throws Exception {
		String url = "http://www.zhongchou.cn";
		comfun = new CommonFuntions(url);
		dr = new DataReader();
		
		//��������Դ
		init("src/TestData/LoginTest.xml");
	}
	
	@Test(dataProvider="Test_xml_dataprovider")
	public void testlogin(Document params) throws Exception {
		/**
		 * ����¼
		 */
		comfun.login(dr.readnodevalue(params, "login", "username"), 
				dr.readnodevalue(params, "login", "password"));

		comfun.checkequal(comfun.gettext("xpath", dr.readnodevalue(params, "login", "checkpoint1")),
				dr.readnodevalue(params, "login", "value1"));
		//�˳���¼
		comfun.logout();
	}
	
	@AfterTest
	public void teardown() {
		comfun.teardown();
	}
	
	
	
}
