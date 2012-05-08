package org.springframework.social.flickr.connect;

import static org.springframework.http.HttpMethod.GET;
import static org.springframework.social.test.client.RequestMatchers.method;
import static org.springframework.social.test.client.RequestMatchers.requestTo;
import static org.springframework.social.test.client.ResponseCreators.withResponse;
import org.junit.Test;

/**
 * @author HemantS
 *
 */
public class ActivityTemplateTest extends AbstractFlickrApiTest {
	@Test
	public void userCommentsTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.activity.userComments&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

	@Test
	public void userPhotosTest() {
		mockServer
				.expect(requestTo("http://api.flickr.com/services/rest/?method=flickr.activity.userPhotos&format=json&nojsoncallback=1"))
				.andExpect(method(GET))
				.andRespond(
						withResponse(jsonResource("testuser"), responseHeaders));
	}

}