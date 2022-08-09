package airport;

import java.util.List;

import de.fhpotsdam.unfolding.data.Feature;
import de.fhpotsdam.unfolding.data.PointFeature;
import de.fhpotsdam.unfolding.marker.SimpleLinesMarker;
import module6.CommonMarker;
import processing.core.PConstants;
import processing.core.PGraphics;

/** 
 * A class to represent AirportMarkers on a world map.
 *   
 * @author Adam Setters and the UC San Diego Intermediate Software Development
 * MOOC team
 *
 */
public class AirportMarker extends CommonMarker {
	public static List<SimpleLinesMarker> routes;
	
	public AirportMarker(Feature city) {
		super(((PointFeature)city).getLocation(), city.getProperties());
	
	}
	
	@Override
	public void drawMarker(PGraphics pg, float x, float y) {
		pg.fill(1);
		pg.ellipse(x, y, 5, 5);
		
		
	}
	@Override
	public void showTitle(PGraphics pg, float x, float y) {
		 // show rectangle with title
		String name = getName();
		String country = getCountry();
		pg.pushStyle();
		
		pg.rectMode(PConstants.CORNER);
		
		pg.stroke(110);
		pg.fill(255,255,255);
		pg.rect(x, y + 15, pg.textWidth(name) +  pg.textWidth(country) +6, 18, 5);
		
		pg.textAlign(PConstants.LEFT, PConstants.TOP);
		pg.fill(0);
		pg.text(country.replace("\"", "")+": "+name.replace("\"", ""), x + 3 , y +18);
		
		
		pg.popStyle();
		// show routes
		
		
	}
	
	public String getName() {
		return (String) getProperty("name");
	}
	
	public String getCity() {
		return (String) getProperty("city");
	}
	
	public String getCountry() {
		return (String) getProperty("country");
	}
 
	public int getAltitude() {
		return Integer.parseInt(getProperty("altitude").toString());
	}
	
	public String getCode() {
		return (String) getProperty("code");
	}
	
}
