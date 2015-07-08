import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import processing.core.*;

public class MainApplet extends PApplet {
	
	class City{
		public City(String name, float x, float y) {
			this.name = name;
			this.x = x;
			this.y = y;
		}
		String name;
		float x;
		float y;
	}
	
	float r = 10;
	List<City> cityList = new ArrayList<City>();
	
	public void setup() {
		size(300, 300);
		background(0);
		
		try {
			loadData();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	public void draw() {
		stroke(255);
//		line(100, 200, 300, 400);
//		this.ellipse(100, 200, 10, 10);
//		this.ellipse(300, 400, 10, 10);
		
		for (City c : cityList) {
			ellipse(c.x, c.y, r, r);
		}
	}
	
	public void loadData() throws Exception{
		File file = new File("../data/location.txt");//Text文件
		System.out.println(file.getAbsolutePath());
		BufferedReader br = new BufferedReader(new FileReader(file));//构造一个BufferedReader类来读取文件
		String s = null;
		while((s = br.readLine())!=null){//使用readLine方法，一次读一行
			String[] tokens = s.split("\\s");
			String name = tokens[0];
			float x = Float.parseFloat(tokens[1]);
			float y = Float.parseFloat(tokens[2]);
			cityList.add(new City(name, x, y));
		}
		br.close();
	}
}
