package CommonFunction;

import java.io.File;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
/**
 * 提供DataProvider
 * @author admin
 *
 */
public class DataProvide {
	public Document doc;

	public void init(String filename) throws Exception {
		File inputXml = new File(new File(filename).getAbsolutePath());
		//documentBuilder 为抽象不能直接实例化（将XML文件转换为DOM文件）
		DocumentBuilder db = null;
		DocumentBuilderFactory dbf = null;
		try {
			//返回documentBuilderFactory对象
			dbf = DocumentBuilderFactory.newInstance();
			//返回db对象用docmentBuilderFatory对象获得返回docmentBuilder对象
			db = dbf.newDocumentBuilder();
			//得到一个DOM并返回给document对象
			doc = (Document)db.parse(inputXml);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	@DataProvider(name = "Test_xml_dataprovider")
	public Object[][] providerMethod(Method method){
		return new Object[][]{new Object[]{doc}};
	}
}
