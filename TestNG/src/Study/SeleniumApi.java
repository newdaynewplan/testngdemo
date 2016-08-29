package Study;


import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class SeleniumApi {
	private WebDriver driver;
	
	@Test
	public void ApiDemo() throws Exception {
		System.out.println("start test ...");

		//打开URL
		driver.get("http://www.baidu.com");

	/**
	 * 元素定位	
	 */
		
		//通过name定位
		driver.findElement(By.name("wd")).sendKeys("手机");
		
		//通过id定位
		driver.findElement(By.id("su")).click();
		
		//显性等待1
		Thread.sleep(1000);
		
		//通过xpath定位
		driver.findElement(By.xpath("//img[@title='到百度首页']")).click();
		
		//通过classname定位
		driver.findElement(By.className("s_ipt")).sendKeys("电脑");
		
		//通过linktext定位
		driver.findElement(By.linkText("百度首页")).click();
				
	
	/**
	 * 元素操作	
	 */
		driver.findElement(By.linkText("登录")).click();
	//输入框input
		
		//输入
		driver.findElement(By.id("TANGRAM__PSP_8__userName")).sendKeys("先输入用户名再清除");
		Thread.sleep(1000);
		
		//清空
		driver.findElement(By.id("TANGRAM__PSP_8__userName")).clear();
		
		Thread.sleep(1000);
		driver.findElement(By.id("TANGRAM__PSP_8__userName")).sendKeys("ss_shit1");
		driver.findElement(By.id("TANGRAM__PSP_8__password")).sendKeys("977338");
		
		//获取输入框值	因getText()获取不到，暂用getAttribute("value")获取
		System.out.println("将用这个用户登录:"+driver.findElement(By.id("TANGRAM__PSP_8__userName")).getAttribute("value"));
		
	//按钮button
		
		//判断是否可点击
		System.out.println("登录按钮是否可用:"+driver.findElement(By.id("TANGRAM__PSP_8__submit")).isEnabled());

		//点击
		driver.findElement(By.id("TANGRAM__PSP_8__submit")).click();
		driver.findElement(By.id("TANGRAM__PSP_30__closeBtn")).click();
		
	//窗口切换
		driver.findElement(By.linkText("新闻")).click();			//弹出新窗口
		Thread.sleep(2000);
		
		String title = "百度新闻搜索——全球最大的中文新闻平台";
		
		
		//切换到frame，有些tab页也是用frame做的
		//driver.switchTo().frame(nameOrId);
		
		// 切换到默认窗口		
		//driver.switchTo().defaultContent();
		
		// 得到当前窗口的句柄
		// String currentWindow = driver.getWindowHandle();
		
		// 得到所有窗口的句柄
		Set<String> handles = driver.getWindowHandles();
		//System.out.println(driver.getWindowHandles());
		
		//获取所有窗口句柄后，逐个切换，当窗口title等于指定title时终止
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			driver.switchTo().window(handle);
			//System.out.println(driver.getTitle());
			if (title.equals(driver.getTitle())) {
				System.out.println("找到窗口:" + title);
				break;
			}
		}

		driver.findElement(By.linkText("高级搜索")).click();
		Thread.sleep(1000);
		
		
	//下拉选择框select
		Select select = new Select(driver.findElement(By.name("mt")));		
		//获取选择项
		//System.out.println("选择项有："+select.getAllSelectedOptions());
		System.out.println("第一个选择项是："+select.getFirstSelectedOption().getText());
		//根据可见文本选择
		select.selectByVisibleText("最近一天");
		Thread.sleep(1000);
		//根据可见文本取消选择，只能用于多选
		//select.deselectByVisibleText("最近一天");
		//根据值选择
		select.selectByValue("168");
		Thread.sleep(1000);
		//根据索引顺序选择
		select.selectByIndex(3);
		Thread.sleep(1000);
	
		
	//单选、复选按钮radio
		//选中
		driver.findElement(By.id("newstitledy")).click();	//关键词位置
		//判断选中状态
		System.out.println("是否选中"+driver.findElement(By.id("newstitledy")).isSelected());
		
		
		
				
			
		Thread.sleep(2000);
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
		
		//打开Firefox浏览器
		driver = new FirefoxDriver();
				
		//隐形等待，这个时间将在WebDriver对象实例整个生命周期都起作用
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		

	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
		
		//关闭浏览器
		driver.quit();
	}
	
	@Test
	public void afterTest2() {
		System.out.println("include");		
	}
	
	@Test
	public void afterTest3() {
		System.out.println("exclude");		
	}
}
