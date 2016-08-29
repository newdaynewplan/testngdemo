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

		//��URL
		driver.get("http://www.baidu.com");

	/**
	 * Ԫ�ض�λ	
	 */
		
		//ͨ��name��λ
		driver.findElement(By.name("wd")).sendKeys("�ֻ�");
		
		//ͨ��id��λ
		driver.findElement(By.id("su")).click();
		
		//���Եȴ�1
		Thread.sleep(1000);
		
		//ͨ��xpath��λ
		driver.findElement(By.xpath("//img[@title='���ٶ���ҳ']")).click();
		
		//ͨ��classname��λ
		driver.findElement(By.className("s_ipt")).sendKeys("����");
		
		//ͨ��linktext��λ
		driver.findElement(By.linkText("�ٶ���ҳ")).click();
				
	
	/**
	 * Ԫ�ز���	
	 */
		driver.findElement(By.linkText("��¼")).click();
	//�����input
		
		//����
		driver.findElement(By.id("TANGRAM__PSP_8__userName")).sendKeys("�������û��������");
		Thread.sleep(1000);
		
		//���
		driver.findElement(By.id("TANGRAM__PSP_8__userName")).clear();
		
		Thread.sleep(1000);
		driver.findElement(By.id("TANGRAM__PSP_8__userName")).sendKeys("ss_shit1");
		driver.findElement(By.id("TANGRAM__PSP_8__password")).sendKeys("977338");
		
		//��ȡ�����ֵ	��getText()��ȡ����������getAttribute("value")��ȡ
		System.out.println("��������û���¼:"+driver.findElement(By.id("TANGRAM__PSP_8__userName")).getAttribute("value"));
		
	//��ťbutton
		
		//�ж��Ƿ�ɵ��
		System.out.println("��¼��ť�Ƿ����:"+driver.findElement(By.id("TANGRAM__PSP_8__submit")).isEnabled());

		//���
		driver.findElement(By.id("TANGRAM__PSP_8__submit")).click();
		driver.findElement(By.id("TANGRAM__PSP_30__closeBtn")).click();
		
	//�����л�
		driver.findElement(By.linkText("����")).click();			//�����´���
		Thread.sleep(2000);
		
		String title = "�ٶ�������������ȫ��������������ƽ̨";
		
		
		//�л���frame����ЩtabҳҲ����frame����
		//driver.switchTo().frame(nameOrId);
		
		// �л���Ĭ�ϴ���		
		//driver.switchTo().defaultContent();
		
		// �õ���ǰ���ڵľ��
		// String currentWindow = driver.getWindowHandle();
		
		// �õ����д��ڵľ��
		Set<String> handles = driver.getWindowHandles();
		//System.out.println(driver.getWindowHandles());
		
		//��ȡ���д��ھ��������л���������title����ָ��titleʱ��ֹ
		Iterator<String> it = handles.iterator();
		while (it.hasNext()) {
			String handle = it.next();
			driver.switchTo().window(handle);
			//System.out.println(driver.getTitle());
			if (title.equals(driver.getTitle())) {
				System.out.println("�ҵ�����:" + title);
				break;
			}
		}

		driver.findElement(By.linkText("�߼�����")).click();
		Thread.sleep(1000);
		
		
	//����ѡ���select
		Select select = new Select(driver.findElement(By.name("mt")));		
		//��ȡѡ����
		//System.out.println("ѡ�����У�"+select.getAllSelectedOptions());
		System.out.println("��һ��ѡ�����ǣ�"+select.getFirstSelectedOption().getText());
		//���ݿɼ��ı�ѡ��
		select.selectByVisibleText("���һ��");
		Thread.sleep(1000);
		//���ݿɼ��ı�ȡ��ѡ��ֻ�����ڶ�ѡ
		//select.deselectByVisibleText("���һ��");
		//����ֵѡ��
		select.selectByValue("168");
		Thread.sleep(1000);
		//��������˳��ѡ��
		select.selectByIndex(3);
		Thread.sleep(1000);
	
		
	//��ѡ����ѡ��ťradio
		//ѡ��
		driver.findElement(By.id("newstitledy")).click();	//�ؼ���λ��
		//�ж�ѡ��״̬
		System.out.println("�Ƿ�ѡ��"+driver.findElement(By.id("newstitledy")).isSelected());
		
		
		
				
			
		Thread.sleep(2000);
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("before test");
		
		//��Firefox�����
		driver = new FirefoxDriver();
				
		//���εȴ������ʱ�佫��WebDriver����ʵ�������������ڶ�������
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); 
		

	}

	@AfterTest
	public void afterTest() {
		System.out.println("after test");
		
		//�ر������
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
