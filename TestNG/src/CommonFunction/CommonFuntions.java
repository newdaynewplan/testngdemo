package CommonFunction;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.*;
/**
 * 程序公用函数
 * @author admin
 *
 */
public class CommonFuntions {
	 public static WebDriver driver;
	/*
	 * 构造函数
	 */
	 public void CommonFunctions() {
		//do nothing
	}
	
	 public CommonFuntions(String url) {
		 //如果你的FireFox没有安装在默认目录，那么必须在程序中设置
		 System.setProperty("webdriver.firefox.bin","C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
		 
		 //创建一个FireFox的浏览器实例
		 driver = new FirefoxDriver();
		 //最大化窗口
		 driver.manage().window().maximize();
		 driver.get(url);
	 }
	 
	 /**
	  * 打开网页
	  * @param url 要打开的URL
	  * @throws Exception
	  */
	
	 public void geturl(String url) throws Exception {
		 driver.get(url);
		 Thread.sleep(5000);
	 }
	 
	 /**
	  * 退出浏览器
	  */
	 public void teardown() {
		 try {
			 driver.quit();
		 } catch (Exception e ) {
			 e.printStackTrace();
		 }

	 }
	 
	 /**
	  * 获取页面标签
	  * @param type 元素定位类型，如：Xpath，css，name等
	  * @param location 元素位置
	  * @return 返回获取到的页面元素的文本
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
	  * 单击某个元素
	  * @param type 元素定位类型，如：xpath,css,name等
	  * @param location 元素位置
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
	  * 向文本框中输入文字
	  * @param type 元素定位类型，如：xpath,css,name等
	  * @param location 元素位置
	  * @param text 要输入的内容
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
	  * 向文本框中清除文字
	  * @param type 元素定位类型，如：xpath,css,name等
	  * @param location 元素位置
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
	  * 判断str1和str2是否相等
	  * @param str1 源字符串
	  * @param str2 目标字符串
	  */
	 public void checkequal(String str1,String str2) {
		 assertEquals(str1,str2);
	 }
	 
	 /**
	  * 登录操作
	  * @param name 用户名
	  * @param psd 密码
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
	  * 退出登录
	  * @throws Exception
	  */
	 public void logout() throws Exception {
		 this.geturl("http://www.zhongchou.cn/usernew-loginout");
	 }
	 
}
