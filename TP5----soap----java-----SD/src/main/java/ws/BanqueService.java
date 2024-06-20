package ws;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;

import java.util.Date;
import java.util.List;


@WebService(serviceName = "BanqueWs")
public class BanqueService {
    @WebMethod(operationName = "conversionEuroToDH")
    public double  conversion(@WebParam(name = "mantant") double mt){
        return  mt*11 ;
    }

    @WebMethod() // il va prendre comme nom  getCompte par defaut
    public Compte  getCompte(@WebParam(name = "code") int code){
        return new Compte(code , Math.random()*60000 , new Date())   ;
    }

    @WebMethod() // Cette il va prendre par defaut le  nom :  listComptes
    public List<Compte>  listComptes(){
        return List.of(
                new Compte(1 , Math.random()*60000 , new Date()) ,
                new Compte(2 , Math.random()*60000 , new Date()) ,
                new Compte(3 , Math.random()*60000 , new Date())
        );
    }
}
