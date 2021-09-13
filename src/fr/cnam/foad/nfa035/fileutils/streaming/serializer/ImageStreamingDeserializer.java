package fr.cnam.foad.nfa035.fileutils.streaming.serializer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Interface définissant le comportement attendu d'un objet servant  à la désérialisation d'une image.
 * Ces objets doivent donc désérialiser à partir d'un média typé,
 * et il doit être possible d'en obtenir un flux de lecture pour l'obtention du contenu désérialisé.
 *
 * @param <M>
 */
public interface ImageStreamingDeserializer<M> {

    /**
     * Méthode principale de désérialisation, consistant au transfert simple du flux de lecture vers un flux d'écriture
     * @param media
     * @throws IOException
     */
    void deserialize(M media) throws IOException;

    /**
     * Permet de récupérer le flux de lecture et de désérialisation à partir du media
     *
     * @param media
     * @param <K>
     * @return
     * @throws IOException
     */
    <K extends InputStream> K getDeserializingStream(M media) throws IOException;

    /**
     * Utile pour récupérer un Flux d'écriture sur la source à restituer
     *
     * @param <T>
     * @return
     */
    <T extends OutputStream> T getSourceOutputStream();


}
