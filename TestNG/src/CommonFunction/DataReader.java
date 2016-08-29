package CommonFunction;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * ��XML�л�ȡ��Ӧ�Ľڵ������
 * @author admin
 * @param doc �����ļ���Document 
 * @param firsttag �ӽڵ�
 * @param senondtag Ҫ��ȡ��Ԫ�صĽڵ�
 * @return Ҫ���ҵĽڵ�����
 */
public class DataReader {
	public String readnodevalue(Document doc,String firsttag,String secondtag){
		String result = "";
		Element root = doc.getDocumentElement();
		NodeList childnode = root.getElementsByTagName(firsttag);
		NodeList resnode = childnode.item(0).getChildNodes();
		for (int i=0; i<resnode.getLength();i++){
			if (resnode.item(i).getNodeName().equals(secondtag)){
				result = resnode.item(i).getTextContent();
				break;
			}
		}
		return result;
	}
}
