package d_external;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonSimple {
	
	public static void main(String[] args) throws ParseException {
		
		JSONParser parser = new JSONParser();
		
		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// unordered (object/map) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		
		// create some json array
		JSONArray list1 = new JSONArray();
        list1.add("msg 1");
        list1.add("msg 2");
		
		// encode object directly
		JSONObject obj1 = new JSONObject();
		obj1.put("name","sonoo");
		obj1.put("age",new Integer(27));
		obj1.put("messages", list1);
		
		// encode using map
		Map obj2 = new HashMap();
		obj2.put("name","sonoo");
		obj2.put("age",new Integer(27));
		obj2.put("messages", list1);
		String jsonText2 = JSONValue.toJSONString(obj2);
		
		// decode back to object from string if is in map with jsonvalue
		Object objDec1 = JSONValue.parse(jsonText2);
	    // or with parser
	    Object objDec2 = parser.parse(jsonText2);
	    // and
	    JSONObject jsonObject = (JSONObject) objDec2;
		
	    // access object elements
	    String name2 = (String) jsonObject.get("name");
 		ArrayList<String> list2 = (ArrayList<String>)obj1.get("list");
	    
 		// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	    // ordered (array/list) @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
	    
 		// create some json objects
		JSONObject obj3 = new JSONObject();
		obj3.put("name","sonoo");
		obj3.put("age",new Integer(27));
		JSONObject obj4 = new JSONObject();
		obj4.put("name","sonoo");
		obj4.put("age",new Integer(27));
 		
	    // encode array directly
 		JSONArray arr1 = new JSONArray();
 		arr1.add(obj3);
 		arr1.add(obj4);
	    
 		// encode using list
		List arr2 = new ArrayList();
		arr2.add(obj3);
 		arr2.add(obj4);
		String jsonText4 = JSONValue.toJSONString(arr2);
 		
		// decode back to array from string
		Object jsonObj4 = parser.parse(jsonText4);
		JSONArray jsonArray = (JSONArray) jsonObj4;
		
		// access array elements
		JSONObject jsonObject2 = (JSONObject)jsonArray.get(1);
		
        System.out.println("executed");
	}
	
}
