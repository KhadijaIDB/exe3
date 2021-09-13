### Bienvenue dans ce cours CNAM en FOAD, NF035

Vous trouverez dans ce fichier **Readme** l'énoncé de chaque exercice noté dans le cadre du projet tutoré central à cet enseignement sur **JAVA: Bibliothèques et Patterns**.
_La solution de chaque exercice fera d'ailleurs l'objet d'un nouveau projet Git ici-même._

**Même si votre solution est bonne et recevable avec tous les points, il est par ailleurs préférable de repartir de la présente solution pour avancer dans ce projet tutoré sans risque, étant donné ce qui vous sera demandé en suite.**

Voici donc l'énoncé qui a fait l'objet, pour rappel (moodle), de la présente solution. Il s'agit du 2ème exercice noté de la toute première session de ce projet.

---

# Lecture / Ecriture par flux, de fichiers texte ou binaire

## Contexte
* Au programme de ce cours: fichiers en accès direct / flux texte
## Objectif
* Mise en application: Ecriture dans une structure en mémoire, du texte de l'image sérialisée par flux binaire.

## Consignes

- [] Commencez par télécharger le fichier jar de la librairie Commons-Codec, que nous allons exploiter afin d'écrire dans des flux encodé Base64, ici : https://mvnrepository.com/artifact/commons-codec/commons-codec/1.15, puis déposez le dans un répertoire lib à la racine de votre projet, et que vous devez aussi ajouter manuellement aux dépendances de votre projet, via votre IDE Eclipse (ou autre choix)

Puis, dans une approche **TDD**, prenez connaissance de ce test écrit en pur Java. Sans en modifier le contenu, il va s'agir de développer ce qui est nécessaire à sa compilation ainsi qu'à son exécution.

```java
public static void main(String[] args) {
    try {
        File image = new File("petite_image.png");
        ImageByteArrayFrame media = new ImageByteArrayFrame(new ByteArrayOutputStream());

        // Sérialisation
        ImageStreamingSerializer serializer = new ImageSerializerBase64StreamingImpl();
        serializer.serialize(image, media);

        String encodedImage = media.getEncodedImageOutput().toString();
        System.out.println(encodedImage + "\n");

        // Désérialisation
        ByteArrayOutputStream deserializationOutput = new ByteArrayOutputStream();
        ImageStreamingDeserializer deserializer = new ImageDeserializerBase64StreamingImpl(deserializationOutput);

        deserializer.deserialize(media);
        byte[] deserializedImage = ((ByteArrayOutputStream)deserializer.getSourceOutputStream()).toByteArray();
        // Vérification
        // 1/ Automatique
        byte[] originImage = Files.readAllBytes(image.toPath());
        assert Arrays.equals(originImage, deserializedImage);
        System.out.println("Cette sérialisation est bien réversible :)");

        //  2/ Manuelle
        File extractedImage = new File("petite_image_extraite.png");
        new FileOutputStream(extractedImage).write(deserializedImage);
        System.out.println("Je peux vérifier moi-même en ouvrant mon navigateur de fichiers et en ouvrant l'image extraite dans le répertoire de ce Test");

    } catch (IOException e) {
        e.printStackTrace();
    }
}
```

```java
Arrays.copyOfRange(originImage,0,originImage.length-2)
```

Et attention, il s'agit encore là de se débrouiller **uniquement avec l'aide des bibliothèques (modules) de votre JDK**.

- Pour ce faire, donc, écrivez et documentez:

  - [ ] L'interface Java **ImageByteArrayFrame**
  
  - [ ] En vous aidant de sa super-classe et la documentant (javadoc):

```java
public abstract class AbstractImageFrameMedia<T> {
    private T channel;
    protected AbstractImageFrameMedia() {
    }
    public T getChannel() {
        return channel;
    }
    public void setChannel(T channel) {
        this.channel = channel;
    }
    AbstractImageFrameMedia(T channel){
        this.channel = channel;
    }
    public abstract OutputStream getEncodedImageOutput() throws IOException;
    public abstract InputStream getEncodedImageInput() throws IOException;
}
```


 - [ ] Pour la sérialisation, l'interface **ImageStreamingSerializer**
 - [ ] Son implémentation base64: **ImageSerializerBase64StreamingImpl**
 - [ ] Pour la désérialisation, l'interface **ImageStreamingDeserializer**
 - [ ] Son implémentation base64: **ImageDeserializerBase64StreamingImpl**

En vous aidant cette fois, si possible, des 2 super-classes suivantes:

 - [ ] **AbstractStreamingImageSerializer** (javadoc)
```java
public abstract class AbstractStreamingImageSerializer<S,M> implements ImageStreamingSerializer<S,M> {
  @Override
  public final void serialize(S source, M media) throws IOException {
    getSourceInputStream(source).transferTo(getSerializingStream(media));
  }
}
```
- [ ] **AbstractStreamingImageDeserializer** (javadoc)
```java
public abstract class AbstractStreamingImageDeserializer<M> implements ImageStreamingDeserializer<M> {
    @Override
    public final void deserialize(M media) throws IOException {
        getDeserializingStream(media).transferTo(getSourceOutputStream());
    }
}
```

Ainsi que des 2 interfaces suivantes (javadoc à faire):

 - [ ] **ImageStreamingSerializer**
```java
public interface ImageStreamingSerializer<S, M> {
  void serialize(S source, M media) throws IOException;
  <K extends InputStream> K getSourceInputStream(S source) throws IOException;
  <T extends OutputStream> T getSerializingStream(M media) throws IOException;
}
```
- [ ] **ImageStreamingSerializer**
```java

public interface ImageStreamingDeserializer<M> {
  void deserialize(M media) throws IOException;
  <K extends InputStream> K getDeserializingStream(M media) throws IOException;
  <T extends OutputStream> T getSourceOutputStream();
}
```
 


- ENFIN, A l'aide d'un script (exemples fournis) s'exécutant sur votre plateforme (Windows ou Linux), 

  - [ ] Apportez de nouveau la preuve que votre sérialisation est correcte
    - [ ] en déclinant le script de nouveau pour ce test
    - [ ] **en ajoutant dans un fichier texte le résultat de votre sérialisation**, en vous basant sur l'échantillon d'image suivant:

![échantillon][petite_image]

[petite_image]: petite_image_2.png "Echantillon 2"


