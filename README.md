# Guide d'utilisation du starter kit de test Selenium

## Requirements
* Java 11
* Maven 3.6

## Principe
Ce starter kit permet de créer un projet de test fonctionnels automatisés basés grâce à Selenium. Ces tests se reposent sur l'utilisation de Selenium Grid, présent sur les Production Lines.
Selenium Grid est un service permettant d'utiliser des webdrivers distants, et évite ainsi l'installation de webdrivers en local.

Le kit a été concu avec l'idée que les scénarios de test sont générés grâce à Selenium IDE.
Selenium IDE est un plugin Chrome ou Firefox, permettant de scripter des scénarios fonctionnels d'après les actions effectuées dans le navigateur. Les scénarios sont ensuite exportables en code Java, qui peuvent être directement intégrés à ce projet.

Le projet génère également un rapport de tests grâce à ExtentReports.

## Installation
Dans le pom.xml, modifier les informations suivantes pour s'accorder à votre projet :
* groupId
* artifactId
* name

## Utilisation
### Configuration
Editer le fichier **test.properties** afin d'indiquer les URL suivantes :
* Selenium Grid
* Application à tester

### Ajout de tests
Des templates de tests sont présents dans le package **tests**, contenant des exemples d'utilisation des groupes de tests et des dépendances.

Chaque classe de test doit extends la classe **BaseTest**, qui se charge d'effectuer les actions nécessaires avant et après les tests, notamment la gestion du RemoteWebDriver.

Les classes doivent obligatoirement avoir un nom se terminant par *Test* afin qu'ils soient reconnus par maven-surefire.

Chaque nouveau test doit être déclaré dans le fichier **testng.xml** afin d'ordonnancer l'exécution des méthodes.
Des groupes peuvent être créés afin de pouvoir conditionner l'exécution de certains groupes de tests à la réussite d'autres groupes.

Lors de l'export de tests provenant de Selenium IDE, simplement copier/coller la méthode de test (sans les méthodes *@Before* et *@After*) dans votre classe de test.

### Utilisation de TestNG
L'exécution des tests est gérée par le module **TestNG**. Toute la documentation relative à son utilisation est disponible ici :
[Documentation TestNG](https://testng.org/doc/documentation-main.html)