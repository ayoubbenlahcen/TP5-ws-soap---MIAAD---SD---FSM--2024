import jakarta.xml.ws.Endpoint;
import ws.BanqueService;

public class ServeurJWS { // serveur jax web service
    // c'est pour deployer notre application
    public static void main(String[] args) {
        String url = "http://0.0.0.0:9091/" ;
        // publier le web service
        // je peux faire par exemple :
        Endpoint.publish("http://0.0.0.0:9091/" , new BanqueService()) ;
        // c'est pour donne l'accee a nimporte qui machine dans le reseau local d'accede a ce service

        //Endpoint.publish(url , new BanqueService()) ;
        System.out.println("Le Web service est deployer sur : " +url);
    }
}
