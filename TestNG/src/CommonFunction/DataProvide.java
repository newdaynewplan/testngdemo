package CommonFunction;

import java.io.File;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.testng.annotations.DataProvider;
import org.w3c.dom.Document;
/**
 * �ṩDataProvider
 * @author admin
 *
 */
public class DataProvide {
	public Document doc;

	public void init(String filename) throws Exception {
		File inputXml = new File(new File(filename).getAbsolutePath());
		//documentBuilder Ϊ������ֱ��ʵ��������XML�ļ�ת��ΪDOM�ļ���
		DocumentBuilder db = null;
		DocumentBuilderFactory dbf = null;
		try {
			//����documentBuilderFactory����
			dbf = DocumentBuilderFactory.newInstance();
			//����db������docmentBuilderFatory�����÷���docmentBuilder����
			db = dbf.newDocumentBuilder();
			//�õ�һ��DOM�����ظ�document����
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
