package fr.inti.services;

import java.net.URI;

import javax.ws.rs.core.UriBuilder;

import org.springframework.stereotype.Service;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import fr.inti.services.WebServiceRestFull;

@Service
public class WebServiceRestFullImpl implements WebServiceRestFull{

	
	/* (non-Javadoc)
	 * @see fr.adaming.serviceImpl.WebServiceRestFull#simulationCreditConsommation(float, float, float)
	 */
	public float simulationCreditConsommation(float montant,float duree,float teag){
	
		
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);

		URI uri= UriBuilder.fromUri("http://localhost:8181/WebSrviceCreditCosm").build();

		WebResource service = client.resource(uri);
	

		WebResource resource =service.path("rest/simulation").path("/"+montant+"/"+duree+"/"+teag*0.01);
		ClientResponse response = resource.post(ClientResponse.class);
		
		
		String output = response.getEntity(String.class);
		
		float mensualite=Float.parseFloat(output);
		

		return mensualite;
	}



	
		/* (non-Javadoc)
		 * @see fr.adaming.serviceImpl.WebServiceRestFull#simulationCreditConsommation1(float, float, float)
		 */
		public float simulationCreditConsommation1(float mensualite1, float duree1, float teag1){
		
			
			ClientConfig config = new DefaultClientConfig();
			Client client = Client.create(config);

			URI uri= UriBuilder.fromUri("http://localhost:8181/WebSrviceCreditCosm").build();

			WebResource service = client.resource(uri);
		

			WebResource resource =service.path("rest/simulation/ment").path("/"+mensualite1+"/"+ duree1+"/"+teag1*0.01);
			ClientResponse response = resource.get(ClientResponse.class);
			
			
			String output = response.getEntity(String.class);
			
			float capital=Float.parseFloat(output);
			

			return capital;
		}


}


    
