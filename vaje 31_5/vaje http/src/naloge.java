import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;

public class naloge {

	public static void main(String[] args) throws ClientProtocolException, IOException, URISyntaxException {
		odjava("z");
		odjava("a");
		// uporabniki();

	}

	public static void uporabniki() throws ClientProtocolException, IOException {
		String responseBody = Request.Get("http://chitchat.andrej.com/users").execute().returnContent().asString();

		System.out.println(responseBody);
	}

	public static void prijava(String ime) throws URISyntaxException, ClientProtocolException, IOException {
		try {
			URI uri = new URIBuilder("http://chitchat.andrej.com/users").addParameter("username", ime).build();

			String responseBody = Request.Post(uri).execute().returnContent().asString();

			System.out.println(responseBody);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void odjava(String ime) throws URISyntaxException, ClientProtocolException, IOException {
		URI uri = new URIBuilder("http://chitchat.andrej.com/users").addParameter("username", ime).build();

		String responseBody = Request.Delete(uri).execute().returnContent().asString();

		System.out.println(responseBody);
	}

	public static void prejmi(String jaz) throws URISyntaxException, ClientProtocolException, IOException {
		  URI uri = new URIBuilder("http://chitchat.andrej.com/messages")
		          .addParameter("username", jaz)
		          .build();

		  String responseBody = Request.Get(uri)
		                               .execute()
		                               .returnContent()
		                               .asString();

		  System.out.println(responseBody);
	}
	
	public static void poslji(String jaz, String prejemnik, String sporocilo) throws ClientProtocolException, IOException, URISyntaxException {
		  URI uri = new URIBuilder("http://chitchat.andrej.com/messages")
		          .addParameter("username", jaz)
		          .build();
		  String poruka;
		  if (prejemnik == null) {
			  poruka = "{ \"global\" : true, \"text\" : \"" + sporocilo + "\"  }";
		  } else {
			  poruka = "{ \"global\" : false, \"recipient\" : \"" + prejemnik + "\", \"text\" : \"" + sporocilo + "\"  }";
		  }
		  

		  String responseBody = Request.Post(uri)
		          .bodyString(poruka, ContentType.APPLICATION_JSON)
		          .execute()
		          .returnContent()
		          .asString();

		  System.out.println(responseBody);
	}
}
