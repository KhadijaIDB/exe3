### Bienvenue dans ce cours CNAM en FOAD, NF035

Vous trouverez dans ce fichier **Readme** l'énoncé de chaque exercice noté dans le cadre du projet tutoré central à cet enseignement sur **JAVA: Bibliothèques et Patterns**.
_La solution de chaque exercice fera d'ailleurs l'objet d'un nouveau projet Git ici-même._

**Même si votre solution est bonne et recevable avec tous les points, il est par ailleurs préférable de repartir de la présente solution pour avancer dans ce projet tutoré sans risque, étant donné ce qui vous sera demandé en suite.**

Voici donc l'énoncé du 3ème exercice noté de la toute première session de ce projet.

---

# Lecture / Ecriture par flux, de fichiers texte ou binaire

## Contexte
* Au programme de ce cours: Exploitation de librairies avancées voir framework
## Objectif
* Mise en application: Utilisation de Log4j pour les messages en sortie console, et de JUnit pour l'industrialisation des tests unitaires.

## Consignes

Exploitation de librairies avancées voir framework: log4j / JunitDans une approche **TDD**, prenez connaissance de ce test écrit en pur Java. Sans en modifier le contenu(*), il va s'agir de développer ce qui est nécessaire à sa compilation ainsi qu'à son exécution.

### Log4J

Se baser sur le site https://mvnrepository.com/ et sur cette configuration...
```xml
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="\n********** - Log émit: à %d{HH:mm:ss.SSS}, de niveau %-5level, par %logger{32} - **********************\n\n%msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Root level="info">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

...pour:

 - [ ] Intégrer au projet la ou les librairies jar nécessaire(s) à l'utilisation de la denière version finale et stable connue de log4j, dans un répertoire lib
 - [ ] Adapter le script de test pour que cet/ces librairie(s) fasse partie du "chemin de classe "de java"
 - [ ] Suite à une étude rapide du framework log4j, transformer l'ensemble des sorties console (*System.out.println*) en appels log4j
 - [ ] Modifier le format de sortie pour que chaque message log tienne sur une ligne et resszemble à:
```
2014-07-02 20:52:39 DEBUG HelloExample:19 - This is debug 
2014-07-02 20:52:39 INFO  HelloExample:23 - This is info 
2014-07-02 20:52:39 WARN  HelloExample:26 - This is warn 
```

### Junit

 - [ ] Intégrer au projet la ou les librairies jar nécessaire(s) à l'utilisation de la denière version finale et stable connue de JUnit, dans le répertoire lib
 - [ ] Porter le plus simplement possible le code d'une de nos 2 classes de test existantes sous la forme de tests unitaires JUnit. 
 - [ ] Apporter une preuve en image (screenshot laissant apparaitre à la fois la progression Junit et la sortie console)

