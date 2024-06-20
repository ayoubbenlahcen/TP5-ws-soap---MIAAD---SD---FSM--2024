package ma.fsm;

import proxy.BanqueService;
import proxy.BanqueWs;
import proxy.Compte;

public class Main {
    public static void main(String[] args) {
        BanqueService proxy = new BanqueWs().getBanqueServicePort() ;
        System.out.println("Voici la conversion de DH vers Euro : "+proxy.conversionEuroToDH(90));
        Compte compte = proxy.getCompte(4) ;
        System.out.println("Voici information du compte crée :");
        System.out.println("code compte :"+compte.getCode());
        System.out.println("solde compte  :"+compte.getSolde());
        System.out.println("Date de creation du compte :"+compte.getDateCreation());
        System.out.println("====================================================");
        System.out.println("Voici la liste des comptes  : ");
        proxy.listComptes().forEach(cp->{
            System.out.println("code compte :"+cp.getCode());
            System.out.println("solde compte  :"+cp.getSolde());
            System.out.println("Date de creation du compte :"+cp.getDateCreation());                }
        );
    }
}