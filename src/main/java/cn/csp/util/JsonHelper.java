package cn.csp.util;


import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * JSON处理帮助类
 */
@Component
public class JsonHelper {
	
	
	
	private static JsonHelper HELPER = new JsonHelper();
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private JsonHelper(){
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		mapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, true);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
	}
	/**
	 * 取出Json处理对象
	 * 
	 * @return Json处理对象
	 */
	public static JsonHelper getInstance(){
		return HELPER;
	}
	/** Json对象转换为字符串. 
	*@param object 传入对象
	*@return 转换后字符串
	*/
	public String write(Object object) {
		StringWriter sw = new StringWriter();
		try {
			mapper.writeValue(sw, object);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sw.toString();
	}
	/** 字符串转换为Json对象. 
	*@param string 传入字符串
	*@return 转换后Json对象
	*/
	public Object read(String string){
		Object obj = null;
		try {
			obj = readObj(string);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return obj;
	}
	
	/**
	 * 字符串转换为json对象，抛出转换过程中的异常
	 * @param string
	 * @return
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 * @since 2.4.1
	 */
	public Object readObj(String string) throws JsonParseException, JsonMappingException, IOException{
		string = string.trim();
		Object obj = null;
		Class cls = string.startsWith("[")?List.class:Map.class;
		obj = mapper.readValue(string,cls);
		return obj;
	}
	
	/** 字符串转换为泛型对象. 
	*@param string 传入字符串
	*@return 转换后泛型对象
	*/
	public <T> T read(String string,Class<T> clz){
		string = string.trim();
		T obj = null;
		try {
			obj = mapper.readValue(string,clz);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		return (T)obj;
	}
	
	public <T> T read(String json, TypeReference<T> jsonTypeReference) {
        try {
            return (T) mapper.readValue(json, jsonTypeReference);
        } catch (JsonParseException e) {
        } catch (JsonMappingException e) {
        } catch (IOException e) {
        }
        return null;
    }
}
