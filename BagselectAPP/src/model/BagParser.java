package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;

public class BagParser {
	public List<Bag> getBag(String urlString) {
		List<Bag> bag = new ArrayList<>();
		HttpURLConnection con=null;
		JsonReader reader = null;

		try {
			URL url=new URL(urlString);
			con=(HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			InputStream is=con.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"UTF-8");
			reader=new JsonReader(isr);
			Gson gson=new Gson();

			//bag = gson.fromJson(reader, Bag.class);
			bag = new Gson().fromJson(reader,new TypeToken<List<Bag>>() {}.getType());

			//System.out.println(bag);
			//JsonObject root  = new Gson().fromJson(reader, JsonObject.class);
			//JsonArray  bagdata   = response.get("station").getAsJsonArray();
			//JsonArray  bagdata   = new Gson().fromJson(reader, JsonObject.class);
			//JsonArray  bagdata   = root.get("").getAsJsonArray();
            /*
			for(int i=0;i<bagdata.size();i++) {
				Bag data = new Bag();
				JsonObject sObj=bagdata.get(i).getAsJsonObject();

				data.setName(sObj.get("name").getAsString());
				data.setPrice(sObj.get("price").getAsString());
				data.setBagImage(sObj.get("bagImage").getAsString());
				bag.add(data);
			}
			*/

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(reader !=null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(con != null) {
				con.disconnect();
			}
		}
		return bag;
	}
}
