package datastructure.collection.properties;

import java.io.FileReader;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertiesEx2 {

	public static void main(String[] args) throws Exception{
		Properties properties = new Properties();
		//읽어 오려는 property 파일의 경로 
		String path = PropertiesExample.class.getResource("Country.properties").getPath();
		path = URLDecoder.decode(path,"utf-8");
		properties.load(new FileReader(path));
		
		String country = properties.getProperty("country");
		String language = properties.getProperty("language");
		
		System.out.println("Country :" + country);
		System.out.println("language" + language);


	}

}
