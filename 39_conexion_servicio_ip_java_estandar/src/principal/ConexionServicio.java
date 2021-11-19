package principal;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;

import com.google.gson.Gson;

import model.Datos;

public class ConexionServicio {

	public static void main(String[] args) {
		
		String url="http://ip.jsontest.com/";
		HttpRequest request=HttpRequest.newBuilder()
				.uri(URI.create(url))
				.GET()
				.build();
		HttpClient client=HttpClient.newBuilder()
				.version(Version.HTTP_1_1)
				.build();
		try {
			HttpResponse<String> response=client.send(request, BodyHandlers.ofString());
			String cuerpoRespuesta=response.body();
			Gson gson=new Gson();
			Datos datos=gson.fromJson(cuerpoRespuesta, Datos.class);
			System.out.println("Tu dirección ip es: "+datos.getIp());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
