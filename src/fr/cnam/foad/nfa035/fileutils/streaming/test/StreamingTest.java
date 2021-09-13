package fr.cnam.foad.nfa035.fileutils.streaming.test;

import fr.cnam.foad.nfa035.fileutils.streaming.media.ImageByteArrayFrame;
import fr.cnam.foad.nfa035.fileutils.streaming.serializer.ImageDeserializerBase64StreamingImpl;
import fr.cnam.foad.nfa035.fileutils.streaming.serializer.ImageSerializerBase64StreamingImpl;
import fr.cnam.foad.nfa035.fileutils.streaming.serializer.ImageStreamingDeserializer;
import fr.cnam.foad.nfa035.fileutils.streaming.serializer.ImageStreamingSerializer;
import org.apache.commons.codec.binary.StringUtils;

import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;


/**
 * Classe de Test unitaire faite maison
 */
public class StreamingTest {


    /**
     * Test unitaire fait maison
     *
     * @param args
     */
     public static void main(String[] args) {
        try {

            File image = new File("petite_image_2.png");
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

    public static String difference(String str1, String str2) {
        if (str1 == null) {
            return str2;
        }
        if (str2 == null) {
            return str1;
        }
        int at = indexOfDifference(str1, str2);
        if (at == -1) {
            return "";
        }
        return str2.substring(at);
    }

    public static int indexOfDifference(CharSequence cs1, CharSequence cs2) {
        if (cs1 == cs2) {
            return -1;
        }
        if (cs1 == null || cs2 == null) {
            return 0;
        }
        int i;
        for (i = 0; i < cs1.length() && i < cs2.length(); ++i) {
            if (cs1.charAt(i) != cs2.charAt(i)) {
                break;
            }
        }
        if (i < cs2.length() || i < cs1.length()) {
            return i;
        }
        return -1;
    }

}
