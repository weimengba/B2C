

import java.sql.Date;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
				
public class TestDom4j {

	/**
	 * @param args
	 * @throws DocumentException 
	 */
	public static void main(String[] args) throws DocumentException {
		Document document = DocumentHelper.parseText(""

		+ "<xml>                                                   "
				+ "<ToUserName><![CDATA[公众号]]></ToUserName>                "
				+ "<FromUserName><![CDATA[粉丝号]]></FromUserName>            "
				+ "<CreateTime>1460537339</CreateTime>                     "
				+ "<MsgType><![CDATA[text]]></MsgType>                     "
				+ "<Content><![CDATA[欢迎开启公众号开发者模式]]></Content>             "
				+ "<MsgId>6272960105994287618</MsgId>                      "
				+ "</xml> ");
		Element root = document.getRootElement();
		System.out.println(root.elementText("ToUserName"));
		System.out.println(root.elementText("FromUserName"));
		System.out.println(root.elementText("CreateTime"));
		System.out.println(root.elementText("MsgType"));
		System.out.println(root.elementText("Content"));
		System.out.println(root.elementText("MsgId"));

		Date date = new Date(1460537339L*1000);
		System.out.println(date);

		System.out.println(System.currentTimeMillis());
		System.out.println(System.nanoTime());
		
		Element newNode = root.addElement("newNode");
		newNode.setText("<1234><xml>12&34");
		

		Element newNode1 = root.addElement("newNode");
		newNode1.addCDATA("<1234><xml>12&34");
		newNode1.addComment("hahahahaha");
		
		System.out.println(document.asXML());
	}

}
