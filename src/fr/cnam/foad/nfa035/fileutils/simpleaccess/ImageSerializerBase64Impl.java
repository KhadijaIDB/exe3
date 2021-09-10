package fr.cnam.foad.nfa035.fileutils.simpleaccess;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

/**
 * Implémentation Base64 de sérializeur d'image
 */
public class ImageSerializerBase64Impl implements ImageSerializer<String,byte[]> {

    /**
     * Sérialise un fichier image au format Base64
     *
     * @param image
     * @return
     * @throws IOException
     */
    @Override
    public String serialize(File image) throws IOException {
        byte[] fileContent = Files.readAllBytes(image.toPath());
        String encodedString = Base64.getEncoder().encodeToString(fileContent);
        return encodedString;
    }

    /**
     * Désérialise un fichier image au format Base64
     *
     * @param image
     * @return
     */
    @Override
    public byte[] deserialize(String image){
        byte[] decodedBytes = Base64.getDecoder().decode(image);
        return decodedBytes;
    }
}
