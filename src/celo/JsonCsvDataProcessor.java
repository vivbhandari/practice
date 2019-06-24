package celo;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonCsvDataProcessor {

	public static void main(String args[])
			throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		List<JSONData> jsonDataList = mapper.readValue(
				new File("/Users/vivb/eclipse/workspace/practice/src/celo/test2/data.json"),
				new TypeReference<List<JSONData>>() {
				});
		System.out.println(jsonDataList);

		HashMap<String, List<String>> csvMap = new HashMap<>();
		Scanner scanner = new Scanner(new File("/Users/vivb/eclipse/workspace/practice/src/celo/test2/data.csv"));
		int total = 0;
		while (scanner.hasNextLine()) {
			List<String> line = Arrays.asList(scanner.nextLine().split(","));
			csvMap.put(line.get(0), line);
			total += Integer.parseInt(line.get(1));
		}
		scanner.close();
		System.out.println(csvMap);
		System.out.println("Average=" + total/csvMap.size());
		
		for (JSONData jsonData : jsonDataList) {
			System.out.println(jsonData.getValue() + "="
					+ csvMap.get(jsonData.getId()).get(1));
		}
	}
}

class JSONData {
	String id;
	String value;
	long time;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", value=" + value + ", time=" + time + "]";
	}
}
