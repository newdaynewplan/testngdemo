package CommonFunction;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 * 从XML中获取相应的节点的数据
 * @author admin
 * @param doc 数据文件的Document 
 * @param firsttag 子节点
 * @param senondtag 要获取的元素的节点
 * @return 要查找的节点数据
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
