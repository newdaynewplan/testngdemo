package CommonFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;
/**
 * �����ú���
 * @author admin
 *
 */
public class CommonFuntions {
	 public static WebDriver driver;
	/*
	 * ���캯��
	 */
	 public void CommonFunctions() {
		//do nothing
	}
	
	 public CommonFuntions(String url) {
		 //������FireFoxû�а�װ��Ĭ��Ŀ¼����ô�����ڳ���������
		 System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		 
		 //����һ��FireFox�������ʵ��
		 driver = new FirefoxDriver();
		 //��󻯴���
		 driver.manage().window().maximize();
		 driver.get(url);
	 }
	 
	 /**
	  * ����ҳ
	  * @param url Ҫ�򿪵�URL
	  * @throws Exception
	  */
	
	 public void geturl(String url) throws Exception {
		 driver.get(url);
		 Thread.sleep(5000);
	 }
	 
	 /**
	  * �˳������
	  */
	 public void teardown() {
		 try {
			 driver.quit();
		 } catch (Exception e ) {
			 e.printStackTrace();
		 }

	 }
	 
	 /**
	  * ��ȡҳ���ǩ
	  * @param type Ԫ�ض�λ���ͣ��磺Xpath��css��name��
	  * @param location Ԫ��λ��
	  * @return ���ػ�ȡ����ҳ��Ԫ�ص��ı�
	  */
	 
	 public String gettext(String type,String location) {
		 WebElement elem = null;
		 if (type.equals("xpath")) {
			 elem = driver.findElement(By.xpath(location));
		 }
		 if (type.equals("name")) {
			 elem = driver.findElement(By.name(location));
		 }
		 if (type.equals("id")) {
			 elem = driver.findElement(By.id(location));
		 }
		 if (type.equals("classname")) {
			 elem = driver.findElement(By.className(location));
		 }
		 if (type.equals("css")) {
			 elem = driver.findElement(By.cssSelector(location));
		 }
		 return elem.getText();
	 }
	 
	 /**
	  * ����ĳ��Ԫ��
	  * @param type Ԫ�ض�λ���ͣ��磺xpath,css,name��
	  * @param location Ԫ��λ��
	  */
	 public void clickitem(String type,String location) {
		 WebElement elem = null;
		 if (type.equals("xpath")) {
			 elem = driver.findElement(By.xpath(location));
		 }
		 if (type.equals("classname")) {
			 elem = driver.findElement(By.className(location));
		 }
		 if (type.equals("text")) {
			 elem = driver.findElement(By.linkText(location));
		 }
		 if (type.equals("name")) {
			 elem = driver.findElement(By.name(location));
		 }
		 elem.click();		 
	 }
	 
	 /**
	  * ���ı�������������
	  * @param type Ԫ�ض�λ���ͣ��磺xpath,css,name��
	  * @param location Ԫ��λ��
	  * @param text Ҫ���������
	  */
	 public void inputvalue(String type,String location,String text) {
		 WebElement elem = null;
		 if (type.equals("xpath")) {
			 elem = driver.findElement(By.xpath(location));
		 }
		 if (type.equals("id")) {
			 elem = driver.findElement(By.id(location));
		 }
		 if (type.equals("name")) {
			 elem = driver.findElement(By.name(location));
		 }
		 elem.sendKeys(text);		 
	 }

	 /**
	  * ���ı������������
	  * @param type Ԫ�ض�λ���ͣ��磺xpath,css,name��
	  * @param location Ԫ��λ��
	  */
	 public void clearvalue(String type,String location) {
		 WebElement elem = null;
		 if (type.equals("xpath")) {
			 elem = driver.findElement(By.xpath(location));
		 }
		 if (type.equals("id")) {
			 elem = driver.findElement(By.id(location));
		 }
		 if (type.equals("name")) {
			 elem = driver.findElement(By.name(location));
		 }
		 elem.clear();		
	}
	 
	 /**
	  * �ж�str1��str2�Ƿ����
	  * @param str1 Դ�ַ���
	  * @param str2 Ŀ���ַ���
	  */
	 public void checkequal(String str1,String str2) {
		 assertEquals(str1,str2);
	 }
	 
	 /**
	  * ��¼����
	  * @param name �û���
	  * @param psd ����
	  * @throws Exception
	  */
	 public void login(String name,String psd) throws Exception {
		 this.clickitem("classname", "Js-showLogin");
		 Thread.sleep(3000);
		 this.clearvalue("name","username");
		 this.inputvalue("name","username",name);
		 this.clearvalue("name","user_pwd");
		 this.inputvalue("name","user_pwd",psd);
		 Thread.sleep(1000);
		 this.clickitem("classname", "zc");
		 Thread.sleep(3000);				 
	 }

	 /**
	  * �˳���¼
	  * @throws Exception
	  */
	 public void logout() throws Exception {
		 this.geturl("http://www.zhongchou.cn/usernew-loginout");
	 }
	 
}
