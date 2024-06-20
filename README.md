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

Pour le moment, nous avons besoin de créer un projet Java simple pour mieux pratiquer l'application SOAP basée sur JAX-WS. Plus tard, vous pouvez créer un projet Spring si vous le souhaitez.

Maintenant, nous allons créer un package qui contiendra les deux classes Compte et BanqueCompte comme suit :

#### Classe Compte : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/78dd5631-1e0b-4d80-a89c-502b9afcf237)

#### La classe CompteBanque : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/b01c85a4-09d2-46b6-81c5-f9bc0dbf46c8)

Comme on peut le voir dans les deux classes, nous avons quelques annotations qu'il faut connaître et qui sont liées au Web Service.

Mais en général, avant d'utiliser ces annotations, il faut ajouter la dépendance JAX-WS dans votre projet :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/732999a4-8327-4c3f-9376-03dd1b5d84c0)

Une fois que vous avez cette dépendance, rechargez votre projet Maven, puis vous pouvez utiliser les annotations pour un Web Service.

Le service web SOAP CompteBanque, développé en utilisant Jakarta EE, est conçu pour simuler des opérations bancaires de base. Le service, nommé BanqueWs, expose trois méthodes principales :

    - Conversion de devises : Une méthode qui convertit un montant en euros en dirhams
      marocains en utilisant un taux de conversion fixe.
    - Récupération de compte : Une méthode qui retourne les détails d'un compte
      bancaire, incluant un solde généré aléatoirement et la date actuelle, basé sur un 
      dentifiant de compte fourni.
    - Liste des comptes : Une méthode qui retourne une liste de comptes avec des soldes
      aléatoires et la date actuelle, simulant plusieurs comptes bancaires.


Les méthodes utilisent des annotations Jakarta pour définir les opérations de service web et les paramètres, permettant ainsi une interaction facile et standardisée avec des clients SOAP.

La classe Compte (non incluse dans le résumé) représente un compte bancaire avec des attributs tels que le code du compte, le solde et la date de création. Ces méthodes peuvent être appelées par des clients pour effectuer des opérations bancaires simulées.

Voici une petite explication sur les annotations du Web Service :

######    @WebService
    - Description : Indique que la classe représente un service web SOAP.
    - Exemple d'utilisation : @WebService(serviceName = "BanqueWs")
    - Rôle : Marque la classe comme un service web et spécifie le nom du service.

######    @WebMethod
    - Description : Indique qu'une méthode de la classe est une opération de service web.
    - Exemple d'utilisation : @WebMethod(operationName = "conversionEuroToDH")
    - Rôle : Marque une méthode pour qu'elle soit exposée comme une opération de service
      web. L'attribut operationName permet de spécifier un nom différent pour
      l'opération, si nécessaire.

######    @WebParam
    - Description : Spécifie le nom d'un paramètre d'une méthode de service web.
    - Exemple d'utilisation : @WebParam(name = "montant")
    - Rôle : Renomme les paramètres dans la description WSDL du service, ce qui améliore
      la clarté et la lisibilité pour les clients du service.

Après avoir créé un service, il faut le déployer. La manière la plus simple pour l'instant est de créer un serveur JaxWS simple. Pour cela, nous allons créer une classe nommée ServeurWs qui contiendra la méthode main :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/6ed9e311-d175-4349-b87d-b0da8177877f)

Après avoir exécuté ce code, voici les résultats obtenus :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/0030144f-4ee8-4b98-896a-495d014a147b)

Voici la description de notre service sous forme XML telle qu'on trouve une description de notre service CompteBanque et de la classe Banque, c'est-à-dire la description des différents attributs et méthodes utilisés dans notre petit porjet : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/3a839f3f-4886-4d8b-9931-4ec29ba736bc)
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/b8d7e419-0e83-4555-9d19-7611c45aeb19)
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/a242c7bf-7624-41e0-9a46-1b2badeb9d47)

Pour simplifier, on peut dire qu'un WSDL est basé sur un schéma XML dans lequel on déclare pour chaque input et chaque output quel est le type de donnée utilisé. C'est pour cela que nous utilisons les schémas XML pour les WSDL basés sur SOAP.

*****************************************************************************************
## Test du WSDL
Avant de continuer, il faut savoir que :

si vous aves locasion de tester un web service :  

####        La première question à poser pour tester un web service est :
            quel type de web service est-ce ? Est-ce un service basé sur SOAP, REST,
            GraphQL, ou GRPC ?
####        Si le test du web service est de type SOAP, 
            alors la deuxième question à poser est : donnez-moi le WSDL. 
            En posant cette question, vous montrez que vous savez ce que vous faites. Si
            vous commencez à poser des questions sur le langage de développement du
            service, cela indique que vous n'avez pas compris le concept. 
            Pour consommer le service en tant que client, vous avez uniquement besoin du
            WSDL.

Maintenant, nous allons utiliser SoapUI open source pour tester :
    1. Créez un nouveau projet SoapUI.
    2. Copiez l'URL http://localhost:9090/BanqueWs?wsdl dans le champ WSDL.
    3. Voici les résultats obtenus pour tester la méthode ConversionEuroToDH :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/a43a68ea-3cd8-4250-b04b-0e5578ef2381)

    4. Test de la Consultation d'un Compte : 
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/cbb62bfd-5544-48c0-8115-6e0b688ca170)

Nous avons rencontré un petit problème avec le type de la date de création d'un compte. Il est préférable de changer le type de ce dernier en Date. Voici le résultat après avoir testé sur SoapUI :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/42326d8c-67c9-4ff9-a8f4-282c95e755c2)

    5. Test de la Liste des Comptes :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/e4d4f418-1cda-413e-b267-60068b378ff3)



*******************************************************************************************************************************************************************************************************
## Création d'un Client SOAP Java
Notre objectif maintenant est de créer un client qui va consommer un web service. Vous pouvez le faire en créant un nouveau projet séparé ou en créant un module Maven que vous appellerez par exemple client-soap-java.

Ajoutez la dépendance JAX-WS dans le pom.xml.

Pour créer le client, je dois utiliser un WSDL à partir duquel je vais générer un proxy, qui est un exemple de classe permettant à mon application Java de communiquer avec le web service.

Si j'utilise IntelliJ, je peux le faire facilement en un seul clic. Voici comment procéder :

    1. Dans le menu Help, recherchez "find action".
    2. Recherchez "generate code java from WSDL".
    3. Vous trouverez une fenêtre comme celle-ci :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/c73caedd-b969-4801-865b-182fb75969c5)

    4. Spécifiez le chemin vers le WSDL.
    5. Dans le champ "Package prefix", spécifiez "proxy".
    6. Pour la plateforme de service, choisissez "Glassfish/...../JWSDP2.2".

Cela ajoutera un package "proxy" à votre module.

Ensuite, l'étape suivante consiste à tester le web service. Dans le fichier main de ce module, apportez les modifications suivantes :
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/d1bbdd85-ae50-43e4-b1e8-8e5ad2e19937)

### Note:  
        À noter que nous sommes en train de concevoir une application orientée objet
        distribuée.

Avant de conclure, voici un code utilisé pour tester notre service ainsi que les résultats obtenus.
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/329a4af7-3195-4773-ab5c-b8759c909c76)
![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/72030334-9342-4a69-b011-80c7749d675f)


![image](https://github.com/ayoubbenlahcen/TP5-ws-soap---MIAAD---SD---FSM--2024/assets/152870306/86b57f4d-22e8-4c79-9337-26927802a3e2)
