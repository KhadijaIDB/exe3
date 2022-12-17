package fr.cnam.foad.nfa035.fileutils.simpleaccess.test;

import fr.cnam.foad.nfa035.fileutils.simpleaccess.ImageSerializer;
import fr.cnam.foad.nfa035.fileutils.simpleaccess.ImageSerializerBase64Impl;
import org.apache.log4j.*;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;

/**
 * Classe de Test unitaire faite maison
 */
public class SimpleAccessTest {

    static private  Logger log =Logger.getLogger(SimpleAccessTest.class);
     /* Test unitaire fait maison
     *
     * @param args
     */
     public static void main(String[] args) {
        try {
            File image = new File("petite_image.png");
            ImageSerializer serializer = new ImageSerializerBase64Impl();

            // Sérialization
            String encodedImage = (String) serializer.serialize(image);
            log.info(splitDisplay(encodedImage,76));

            // Désérialisation
            byte[] deserializedImage = (byte[]) serializer.deserialize(encodedImage);

            // Vérifications
            //  1/ Automatique
            assert (Arrays.equals(deserializedImage, Files.readAllBytes(image.toPath())));
            log.info("Cette sérialisation est bien réversible :)");
            //  2/ Manuelle
            File extractedImage = new File("petite_image_extraite.png");
            new FileOutputStream(extractedImage).write(deserializedImage);
            log.info("Je peux vérifier moi-même en ouvrant mon navigateur de fichiers et en ouvrant l'image extraite dans le répertoire de ce Test");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Méthode utile pour afficher une image sérialisée
     *
     * @param str
     * @param chars
     * @return
     */
    private static String splitDisplay(String str, int chars){
        StringBuffer strBuf = new StringBuffer();
        int i = 0;
        strBuf.append("================== Affichage de l'image encodée en Base64 ==================\n");
        for (; i+chars < str.length(); ){
            strBuf.append(str.substring(i,i+= chars));
            strBuf.append("\n");
        }
        strBuf.append(str.substring(i));
        strBuf.append("\n================================== FIN =====================================\n");

        return strBuf.toString();
    }
}
