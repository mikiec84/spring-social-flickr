package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import junit.framework.Assert;

import org.junit.Test;
import org.springframework.social.flickr.api.Place;
import org.springframework.social.flickr.api.Place_types;
import org.springframework.social.flickr.api.Places;
import org.springframework.social.flickr.api.Shapes;
import org.springframework.social.flickr.api.Tags;

/**
 * @author hemant
 *
 */
public class PlacesTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void findTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?query=pune&method=flickr.places.find&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("places"), responseHeaders));
		Places places = flickr.placesOperations().find("pune");
		assertPlaces(places);
	}
	@Test
	public void findByLatLonTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?lat=18.531&lon=73.853&accuracy=10&method=flickr.places.findByLatLon&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placesgeo"), responseHeaders));
		Places places = flickr.placesOperations().findByLatLon( "18.531", "73.853", "10");
		assertPlacesGeo(places);
	}

	
	@Test
	public void getChildrenWithPhotosPublicTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?woe_id=2295412&method=flickr.places.getChildrenWithPhotosPublic&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placeschildren"), responseHeaders));
		Places places = flickr.placesOperations().getChildrenWithPhotosPublic( null, "2295412");
		assertPlacesChildren(places);
	}


	@Test
	public void getInfoTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?woe_id=2295412&method=flickr.places.getInfo&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placesinfo"), responseHeaders));
		Place place = flickr.placesOperations().getInfo( null, "2295412");
		assertPlace(place);
		
	}


	@Test
	public void getInfoByUrlTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?url=%2FIndia%2FMaharashtra%2FPune&method=flickr.places.getInfoByUrl&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placesinfo"), responseHeaders));
		Place place = flickr.placesOperations().getInfoByUrl( "/India/Maharashtra/Pune");
		assertPlace(place);
	}

	@Test
	public void getPlaceTypesTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.places.getPlaceTypes&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placetypes"), responseHeaders));
		Place_types placeTypes = flickr.placesOperations().getPlaceTypes();
		assertPlaceTypes(placeTypes);
	}

	@Test
	public void getShapeHistoryTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?woe_id=2295412&method=flickr.places.getShapeHistory&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("shapehistory"), responseHeaders));
		Shapes shapes = flickr.placesOperations().getShapeHistory( null, "2295412");
		assertShapes(shapes);
				
	}


	@Test
	public void getTopPlacesListTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?place_type_id=22&method=flickr.places.getTopPlacesList&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placestop"), responseHeaders));
		Places places = flickr.placesOperations().getTopPlacesList( "22", null,null, null);
		assertTopPlaces(places);
	}


	@Test
	public void placesForBoundingBoxTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?bbox=73.410645%2C18.208480%2C74.443359%2C18.604601&place_type_id=12&method=flickr.places.placesForBoundingBox&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placebbox"), responseHeaders));
		Places places = flickr.placesOperations().placesForBoundingBox( "73.410645,18.208480,74.443359,18.604601", null, "12");
		assertPhotosBBox(places);
		
	}

	@Test
	public void placesForContactsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?place_type_id=7&method=flickr.places.placesForContacts&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placesforcontact"), responseHeaders));
		Places places = flickr.placesOperations().placesForContacts( null, "7", null, null, null, null, null, null, null, null);
		assertPhotosForContact(places);
	}


	@Test
	public void placesForTagsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?place_type_id=22&tags=snow&method=flickr.places.placesForTags&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placesfortags"), responseHeaders));
		Places places = flickr.placesOperations().placesForTags( "22", null, null, null, "snow", null, null, null, null, null, null, null);
		assertPhotosForTags(places);
	}


	@Test
	public void placesForUserTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?place_type_id=7&method=flickr.places.placesForUser&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placesfortags"), responseHeaders));
		Places places = flickr.placesOperations().placesForUser( "7", null, null, null, null, null, null, null, null);
		assertPhotosForTags(places);
	}


	@Test
	public void tagsForPlaceTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?woe_id=2295412&method=flickr.places.tagsForPlace&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("placetags"), responseHeaders));
		Tags tags= flickr.placesOperations().tagsForPlace( "2295412", null, null, null, null, null);
		assertTags(tags);
	}
	

	private void assertPlaces(Places places) {
		Assert.assertEquals("pune", places.getQuery());
	}
	private void assertPlacesGeo(Places places) {
		Assert.assertEquals("18.531", places.getLatitude());
		
	}
	private void assertPlacesChildren(Places places) {
		Assert.assertEquals(6, places.getTotal());
		
	}
	private void assertPlace(Place place) {
		Assert.assertEquals("2295412", place.getWoeid());
	}

	private void assertPlaceTypes(Place_types placeTypes) {
		Assert.assertEquals(6, placeTypes.getPlace_type().size());
	}
	private void assertShapes(Shapes shapes) {
		Assert.assertEquals("7", shapes.getTotal());
	}
	private void assertTopPlaces(Places places) {
		Assert.assertEquals(2, places.getTotal());		
	}
	private void assertPhotosForContact(Places places) {
		Assert.assertEquals(3, places.getTotal());		
	}
	private void assertPhotosForTags(Places places) {
		Assert.assertEquals(2, places.getTotal());		
		
	}
	private void assertTags(Tags tags) {
		Assert.assertEquals(100, tags.getTag().size());		
	}
	private void assertPhotosBBox(Places places){
		Assert.assertEquals(1, places.getPage());
	}
}