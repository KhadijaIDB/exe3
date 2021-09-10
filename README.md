### Bienvenue dans ce cours CNAM en FOAD, NF035

Vous trouverez dans ce fichier **Readme** l'énoncé de chaque exercice noté dans le cadre du projet tutoré central à cet enseignement sur **JAVA: Bibliothèques et Patterns**.
_La solution de chaque exercice fera d'ailleurs l'objet d'un nouveau projet Git ici-même._

Voici donc sans plus attendre le l'énoncer de premier exercice noté de la toute première session de ce projet.

---

# Sérialisation d'une image en Base64

## Contexte
* Au programme de ce cours: fichiers en accès séquentiel / flux binaires
## Objectif
* Mise en application: Lecture d'une image et sérialisation à un format texte : en base 64

## Consignes

Dans une approche **TDD**, prenez connaissance de ce test écrit en pur Java. Sans en modifier le contenu, il va s'agir de développer ce qui est nécessaire à sa compilation ainsi qu'à son exécution.

```java
public static void main(String[] args) {
        try {
            File image = new File("petite_image.png");
            ImageSerializer serializer = new ImageSerializerBase64Impl();

            // Sérialization
            String encodedImage = (String) serializer.serialize(image);
            System.out.println(splitDisplay(encodedImage,76));

            // Désérialisation
            byte[] deserializedImage = (byte[]) serializer.deserialize(encodedImage);

            // Vérifications
            //  1/ Automatique
            assert (Arrays.equals(deserializedImage, Files.readAllBytes(image.toPath())));
            System.out.println("Cette sérialisation est bien réversible :)");
            //  2/ Manuelle
            File extractedImage = new File("petite_image_extraite.png");
            new FileOutputStream(extractedImage).write(deserializedImage);
            System.out.println("Je peux vérifier moi-même en ouvrant mon navigateur de fichiers et en ouvrant l'image extraite dans le répertoire de ce Test");


        } catch (IOException e) {
            e.printStackTrace();
        }
```

Mais attention, il s'agit là de se débrouiller **uniquement avec l'aide des bibliothèques (modules) de votre JDK**.

- Pour ce faire, donc, écrivez et documentez:

  - [ ] L'interface Java **ImageSerializer**
  - [ ] Son implémentation **ImageSerializerBase64Impl**


- A l'aide d'un script (exemples fournits) s'exécutant sur votre plateforme (Windows ou Linux), 

  - [ ] Apportez la preuve que votre sérialisation est correcte **en ajoutant dans un fichier texte le résultat de votre sérialisation**, en vous basant sur l'échantillon d'image suivant:

![échantillon][petite_image]

[petite_image]: petite_image.png "Echantillon principal"


