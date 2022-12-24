package admin.com;

import java.util.HashMap;
import java.util.Map;

public class AddItems 
{
	
	public static Map<String, Double> getItems()
	{
		
		Map<String, Double> products = new HashMap<String,Double>();
		products.put("Shoes", 2000.00);
		products.put("Lays", 20.00);
		products.put("Cold_Drinks", 60.00);
		products.put("Ethnic_wear", 5000.00);
		products.put("Sanitary Napkins", 100.00);
		products.put("Watches",4000.00);
		return products;
		
		
	}
	
}
