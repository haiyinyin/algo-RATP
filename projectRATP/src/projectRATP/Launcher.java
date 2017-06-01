package projectRATP;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.Stack;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Launcher {

	public static void main(String[] args) throws JsonParseException,
			JsonMappingException, IOException {
		// TODO Auto-generated method stub
/*
		// 读取JSON
		ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally
		Map<String, Object> userData = mapper.readValue(new File(
				"/Users/xhy0908/Desktop/reseau.json"), Map.class);

		// 地铁线去重复
		Set<String> set = new HashSet<String>();

		// 存储每条线上的车站号，String类型
		Map<String, List<String>> lignesNum = new HashMap<String, List<String>>();
		// store lignes number
		List<String> arraylist1 = new ArrayList<String>();

		int nodeNumber = 0;

		// 储存所有的地铁站编号
		List<String> stationNum = new ArrayList<String>();

		// 存储地铁站名字
		List<String> stationsName = new ArrayList<String>();
		// 存储<地铁线编号，<地铁站名>>
		Map<String, List<String>> lignesName = new HashMap<String, List<String>>();

		for (int i = 1621; i <= 4028973; i++) {
			String strI = Integer.toString(i);

			if (((Map<String, Object>) userData.get("stations")).get(strI) != null) {
				List<String> valuesList = new ArrayList<String>();

				valuesList = (List<String>) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) userData
						.get("stations")).get(strI)).get("lignes"))
						.get("metro");

				String stationName;
				stationName = (String) ((Map<String, Object>) ((Map<String, Object>) userData
						.get("stations")).get(strI)).get("nom");

				if (valuesList != null) {
					stationNum.add(strI);
					stationsName.add(stationName);
					String lignes = "0";
					lignes = valuesList.get(0);

					// 地铁线编号去重复
					set.add(lignes);

				}

			}

		}
		// 地铁线编号放到Map<地铁线，[地铁站名字]>
		Iterator<String> it = set.iterator();
		int j = 0;
		while (it.hasNext()) {
			lignesName.put(it.next(), new LinkedList<String>());
			// lignesNumInt.put(it.next(), new LinkedList<Integer>());
		}

		// 将地铁站加到对应线路里
		for (int i = 1621; i <= 4028973; i++) {
			String strI = Integer.toString(i);

			if (((Map<String, Object>) userData.get("stations")).get(strI) != null) {
				List<String> valuesList = new ArrayList<String>();
				valuesList = (List<String>) ((Map<String, Object>) ((Map<String, Object>) ((Map<String, Object>) userData
						.get("stations")).get(strI)).get("lignes"))
						.get("metro");

				String stationName;
				stationName = (String) ((Map<String, Object>) ((Map<String, Object>) userData
						.get("stations")).get(strI)).get("nom");
				if (valuesList != null) {
					for (int k = 0; k < valuesList.size(); k++) {

						if (valuesList.get(k) != null) {
							String lignes = valuesList.get(k);
							// lignesNum.get(lignes).add(strI);
							lignesName.get(lignes).add(stationName);
						}
					}

				}

			}

		}
		Graph graph = new Graph(stationsName);

		Iterator<String> it3 = set.iterator();
		while (it3.hasNext()) {
			String lignes = it3.next();
			for (int i = 0; i < lignesName.get(lignes).size(); i++) {
				String u;
				u = lignesName.get(lignes).get(i);
				for (int k = 1; k < lignesName.get(lignes).size(); k++) {
					String v;
					v = lignesName.get(lignes).get(k);
					graph.addEdgeString(u, v);
				}

			}

		}

		Stack<String> result = new Stack<String>();
		result = graph.findPathTo("Liberté", "Richelieu-Drouot");
		//graph.print();
		while (!result.isEmpty()) {
			System.out.print(result.pop());
			System.out.print(" ");
			
		}
		*/
		//以上是无权重图 BFS最短路径
		
		//从txt文件里读取地铁站坐标，保存到stationsLocation里面，<地铁站名字，<double x坐标，y坐标>>
		//Map<String, List<Double>> stationsLocation = new HashMap<String, List<Double>>();
		
		//从txt读每一行
		String filePath1="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_1/stops.txt";
		String filePath2="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_2/stops.txt";
		String filePath3="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_3/stops.txt";
		String filePath3b="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_3b/stops.txt";
		String filePath4="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_4/stops.txt";
		String filePath5="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_5/stops.txt";
		String filePath6="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_6/stops.txt";
		String filePath7="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_7/stops.txt";
		String filePath7b="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_7b/stops.txt";
		String filePath8="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_8/stops.txt";
		String filePath9="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_9/stops.txt";
		String filePath10="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_10/stops.txt";
		String filePath11="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_11/stops.txt";
		String filePath12="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_12/stops.txt";
		String filePath13="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_13/stops.txt";
		String filePath14="/Users/xhy0908/Downloads/RATP_GTFS_LINES/RATP_GTFS_METRO_14/stops.txt";
		station station=new station();
		station.addStation(filePath1);
		station.addStart(station.stationList());
		station.addStation(filePath2);
		station.addStation(filePath3);
		station.addStation(filePath3b);
		station.addStation(filePath4);
		station.addStation(filePath5);
		station.addStation(filePath6);
		station.addStation(filePath7);
		station.addStation(filePath7b);
		station.addStation(filePath8);
		station.addStation(filePath9);
		station.addStation(filePath10);
		station.addStation(filePath11);
		station.addStation(filePath12);
		station.addStation(filePath13);
		station.addStation(filePath14);
		
		
		
		
	
	
		
	}

}


