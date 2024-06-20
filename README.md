# TP5-ws-soap---MIAAD---SD---FSM--2024

Objectif :
1. Créer un Web service qui permet de :
    • Convertir un montant de l’euro en DH
    • Consulter un Compte
    • Consulter une Liste de comptes
3. Déployer le Web service avec un simple Serveur JaxWS
4. Consulter et analyser le WSDL avec un Browser HTTP
5. Tester les opérations du web service avec un outil comme SoapUI ou Oxygen
6. Créer un Client SOAP Java
      - Générer le Stub à partir du WSDL
      - Créer un client SOAP pour le web service

******************************************************************************************

Pour le moment on est besoin de faire creer un projet java simple pour faire paratique mieux en mieux l'application Soap qui est basé sur l'ajax apres vous pouvez faire creer un projet Spring si vous voulez : 

aLors maintenant on va essayer faire un creer un package qui va contenir les deux classe Compte et BanqueCompte
comme suite :
   - La classe Compte : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/78dd5631-1e0b-4d80-a89c-502b9afcf237)

   - La classe CompteBanque : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/b01c85a4-09d2-46b6-81c5-f9bc0dbf46c8)

Commr on vois dans les deux classe on a quelque anotation qu'il faut connaitre qui sont lie au Web Service

Mais en genrale avant d'tiliser ces notaion il faut ajouter la dependance de JAX-WS dans votre projet : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/732999a4-8327-4c3f-9376-03dd1b5d84c0)

une fois que vous avez cette dependance faire reload de vore proje maven , puis vous pouves utliser les anotattions quk sont utliserr pour un wevb service : 

le service web SOAP CompteBanque , développé en utilisant Jakarta EE, est conçu pour simuler des opérations bancaires de base. Le service, nommé BanqueWs, expose trois méthodes principales :

    Conversion de devises : Une méthode qui convertit un montant en euros en dirhams
    marocains en utilisant un taux de conversion fixe.
    
    Récupération de compte : Une méthode qui retourne les détails d'un compte bancaire,
    incluant un solde généré aléatoirement et la date actuelle, basé sur un identifiant
    de compte fourni.
    
    Liste des comptes : Une méthode qui retourne une liste de comptes avec des soldes
    aléatoires et la date actuelle, simulant des comptes bancaires multiples.

Les méthodes utilisent des annotations Jakarta pour définir les opérations de service web et les paramètres, permettant ainsi une interaction facile et standardisée avec des clients SOAP. 

La classe Compte (non incluse dans le résumé) représente un compte bancaire avec des attributs tels que le code du compte, le solde et la date de création. 
Ces méthodes peuvent être appelées par des clients pour effectuer des opérations bancaires simulées.

Alors voici une petit explication sur les annotation du web Service :

  @WebService
    Description : Indique que la classe représente un service web SOAP.
    Exemple d'utilisation : @WebService(serviceName = "BanqueWs")
    Rôle : Marque la classe comme un service web et spécifie le nom du service.
    
  @WebMethod
    Description : Indique qu'une méthode de la classe est une opération de service web.
    Exemple d'utilisation : @WebMethod(operationName = "conversionEuroToDH")
    Rôle : Marque une méthode pour qu'elle soit exposée comme une opération de service
    web. L'attribut operationName permet de spécifier un nom différent pour l'opération,
    si nécessaire.
    
  @WebParam
    Description : Spécifie le nom d'un paramètre d'une méthode de service web.
    Exemple d'utilisation : @WebParam(name = "mantant")
    Rôle : Renomme les paramètres dans la description WSDL du service, ce qui améliore la
    clarté et la lisibilité pour les clients du service.

Alors apres quand on a essayer de faire creer un service , il faut le deployer  alors la simple facon jusqu'a maintenant est de faire creer un simple serveur Ws , 

et pour ca on va  essayer de creer une classe quand on va lui donne comme nom ServeurWs 
ALors cette classe contient la methode main , en suite  : 
    en demarrenotre serveur a l'aide de l'intruction : 
            String url = "http://0.0.0.0:9090/" ;
            // on specifier une adresse dans URL si on veut que ontre service soit
            accessible a distants sinon  je peut lance le service locale : specifait localhost au lieyu de l'adresse
            // Endpoint.publish("http://0.0.0.0:9090/" , new BanqueService()) ;
            Endpoint.publish(url , new BanqueService()) ;

![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/6ed9e311-d175-4349-b87d-b0da8177877f)

Alors Voici leS resulatS quand on va voir apres le run de code : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/0030144f-4ee8-4b98-896a-495d014a147b)

Voici la descirption de notre service sous forme XML tel que on trouve une descrption de notre service CompteBanque et la classe Banque c'est a dire la description des defferent  atrribue et deffirent methode utliser dans notre petit porjet : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/3a839f3f-4886-4d8b-9931-4ec29ba736bc)
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/b8d7e419-0e83-4555-9d19-7611c45aeb19)
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/a242c7bf-7624-41e0-9a46-1b2badeb9d47)
Alors pour simpliferi on peut dire qu'un wsdl est base sur une schema XMl dont laquel on declarre pour chaque input et pour chaque out qu'il est le type de donne utliser  donc c'est pour ce la on utilise les schema XML  pour les WSDL qui sont base sur SPOAP


maintenat on  a arrive a la troisimme partie c'est comment  faire tester notre WSDL  

alors mais avant  de continuer il faut connaitre que : 
si vous aves locasion faire tester un web service  

    - la premier question qu'il faut poser c'est  qu'il type de web service ?
      est ce que c'est un service base sur le soap , rest ou bien graphe QL ou bien GRPC
      
et bien si le teste web service est de type Soap  alors la deusimme question qu'il faut poser  c'est : 
     donne moi le WSDL alors quand vous poser cette question dons vous savez vraiment qu'est ce que vous faites 
    mais si vous commance a poser des questions sur le langage qui et developer  pour faire tester le service  =====> alors ça indique que vous n'avez rien comprits
    parce que pour que j'arrive de faire consomer le service en tanque client j'ai besoin seulment au WSDL  

Alors pour nous maintenant on va utiliser  soap open source pour faire le teste  : 
afin de creer un nouveu Soap Project on et faire copier http://localhost:9090/BanqueWs?wsdl dans le champs WSDL 
voici ce quant va trouver comme resultat afin de faire teste la methode ConversionEuroToDH : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/a43a68ea-3cd8-4250-b04b-0e5578ef2381)

teste pour faire la consultation  d'un compte : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/cbb62bfd-5544-48c0-8115-6e0b688ca170)

on a ici un petit probleme dans date de creation d'un compte alors il est prifirable faire changer dans le code le type de ce dernier vers Date et voici le rsulat afin de tester sur le soap open source  : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/42326d8c-67c9-4ff9-a8f4-282c95e755c2)

Alors Voici un teste pour le listage des  produits :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/e4d4f418-1cda-413e-b267-60068b378ff3)



*******************************************************************************************************************************************************************************************************
Alors notre bute maintenant est de faire creer un Client qui va consommer un web service soit on creant un nouveux projet separer
ou bein en creant un modul maven  quand on va m'apple par exmple client-soap-Java

Alors pour ce client la on est besoin de faire ajouter la dependance jax-ws dans pom.Xml 

alors pour creer le client je suis besoin d'un WSDL a partie de ce dernier on va generer  un  PROXY qui est un ensemple de classe que je dois generer a partir de WSDL  qui vont permetre a mon application java de communiquer avec le web service 

alors pour generer ce proxy si vous utlisez intellij donc c'est simple de le faire seulement avec un seul click
voici comment : 
dans Help on cherche |find action|-----> en cherche sur |generate code java from WSDL| ----->en suite on va trouver comme cette fenetre :![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/c73caedd-b969-4801-865b-182fb75969c5)

on specifiant le WSDL 
et dans le package prefix en specifiant : proxy  
et pour service plat form en choisie : Glassfich/...../JWSDP2.2

et comme ca un package proxi va etre ajouter dans notre module 

Alors l'etape suivant est de tester le  web service 

on faire dans le fichier main de ce module quelque modification comme suite : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/d1bbdd85-ae50-43e4-b1e8-8e5ad2e19937)

A savoir  : 

que maintenant on est entrain de faire concevoir une application oriente objet destribué 







