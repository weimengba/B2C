import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONReader;
import com.util.MM;
import com.util.MMUtil;

public class Json处理测试 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MM mm = MMUtil.getMM();
		
		mm.put("id", 12);
		mm.put("c_tb", "demo");

		String json = JSON.toJSONString(mm);

		System.out.println(json);

		Map jsonObj = JSON.parseObject(json);
		System.out.println(jsonObj.get("id"));
		System.out.println(jsonObj.get("c_tb"));

		jsonObj.put("mm", mm);

		System.out.println(JSON.toJSONString(jsonObj));

		List data = new ArrayList();
		data.add("123");
		data.add(new Date());
		data.add("hello");

		MM mm1 = new MM();

		mm1.put("id", 12);
		mm1.put("c_tb", "demo");
		data.add(mm1);

		jsonObj.put("数组", data);

		System.out.println(JSON.toJSONString(jsonObj));
		String complexJson = JSON.toJSONString(jsonObj);

		Map oo1 = JSON.parseObject(complexJson);
		System.out.println(oo1.get("id"));
		Map oo2 = (Map) oo1.get("mm");
		System.out.println(oo1.get("c_tb"));

		Object oo3 = oo1.get("数组");
		System.out.println(oo1);
		System.out.println(oo3.getClass());
		List xx3 = (List) oo3;
		System.out.println(xx3.get(0));
		System.out.println(new Date(Long.valueOf(xx3.get(1).toString())));
		System.out.println(xx3.get(2));
		System.out.println(xx3.get(3));

		
		ReadWithFastJson();
	}

	/** 
	 * FastJson逐行解析json 
	 * @author drlyee 
	 * @date 2015-02-10 
	 */  
	public static void ReadWithFastJson()  
	{  
	    String jsonString = "{\"array\":[1,2,3],\"arraylist\":[{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"}],\"object\":{\"a\":\"b\",\"c\":\"d\",\"e\":\"f\"},\"string\":\"HelloWorld\"}";  
	  
	    // 如果json数据以形式保存在文件中，用FileReader进行流读取！！  
	    // path为json数据文件路径！！  
	    // JSONReader reader = new JSONReader(new FileReader(path));  
	  
	    // 为了直观，方便运行，就用StringReader做示例！  
	    JSONReader reader = new JSONReader(new StringReader(jsonString));  
	    reader.startObject();  
	    System.out.print("start fastjson");  
	    while (reader.hasNext())  
	    {  
	        String key = reader.readString();  
	        System.out.print("key " + key);  
	        if (key.equals("array"))  
	        {  
	            reader.startArray();  
	            System.out.print("start " + key);  
	            while (reader.hasNext())  
	            {  
	                String item = reader.readString();  
	                System.out.print(item);  
	            }  
	            reader.endArray();  
	            System.out.print("end " + key);  
	        }  
	        else if (key.equals("arraylist"))  
	        {  
	            reader.startArray();  
	            System.out.print("start " + key);  
	            while (reader.hasNext())  
	            {  
	                reader.startObject();  
	                System.out.print("start arraylist item");  
	                while (reader.hasNext())  
	                {  
	                    String arrayListItemKey = reader.readString();  
	                    String arrayListItemValue = reader.readObject().toString();  
	                    System.out.print("key " + arrayListItemKey);  
	                    System.out.print("value " + arrayListItemValue);  
	                }  
	                reader.endObject();  
	                System.out.print("end arraylist item");  
	            }  
	            reader.endArray();  
	            System.out.print("end " + key);  
	        }  
	        else if (key.equals("object"))  
	        {  
	            reader.startObject();  
	            System.out.print("start object item");  
	            while (reader.hasNext())  
	            {  
	                String objectKey = reader.readString();  
	                String objectValue = reader.readObject().toString();  
	                System.out.print("key " + objectKey);  
	                System.out.print("value " + objectValue);  
	            }  
	            reader.endObject();  
	            System.out.print("end object item");  
	        }  
	        else if (key.equals("string"))  
	        {  
	            System.out.print("start string");  
	            String value = reader.readObject().toString();  
	            System.out.print("value " + value);  
	            System.out.print("end string");  
	        }  
	    }  
	    reader.endObject();  
	    System.out.print("start fastjson");  
	}  
}
