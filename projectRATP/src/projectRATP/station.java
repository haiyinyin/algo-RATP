package projectRATP;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

public class station {
	private Map<String, List<Double>> stationLocation;
	private Map<String, Map<String,List<Double>>> weightedEadge;
	
	public station(){
		
		
	}

	
	public void addStation (String filePath) throws IOException{
		Map<String, List<Double>> stationLocation = new HashMap<String, List<Double>>();
		List<String> lines = Files.readAllLines(Paths.get(filePath),
				StandardCharsets.UTF_8);
		
		
		for (String line : lines) {
			String[] ss=line.split(",");			
			//System.out.println(ss[1]);        //地铁名字
			stationLocation.put(ss[0], new LinkedList<Double>());
			}

		
		for (String line : lines) {
			String[] ss=line.split(",");

			double x=Double.parseDouble(ss[4]);
			double y=Double.parseDouble(ss[5]);
			stationLocation.get(ss[0]).add(x);
	        stationLocation.get(ss[0]).add(y);
			}

	}
	
	public Map<String, List<Double>> stationList(){	
		return stationLocation;
	}
	
	public void addStart(Map<String, List<Double>> station){
		
		for (String key :stationLocation.keySet()) {
			System.out.println("Key = " + key);
		}

		  
	
		
	}


}
