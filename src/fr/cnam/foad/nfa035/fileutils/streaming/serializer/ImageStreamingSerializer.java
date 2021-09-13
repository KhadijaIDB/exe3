package fr.cnam.foad.nfa035.fileutils.streaming.serializer;

import java.io.*;

/**
 * Interface définissant le comportement attendu d'un objet servant  à la sérialisation d'une image.
 * Ces objets doivent donc sérialiser à partir d'une source et vers un média typé,
 * et il doit être possible d'en obtenir un flux d'écriture et sérialisation du contenu.
 *
 * @param <S>
 * @param <M>
 */
public interface ImageStreamingSerializer<S, M> {

    /**
     *
     * @param source
     * @param media
     * @throws IOException
     */
    void serialize(S source, M media) throws IOException;

    /**
     * Utile pour récupérer un Flux de lecture de la source à sérialiser
     *
     * @param source
     * @param <K>
     * @return
     * @throws IOException
     */
    <K extends InputStream> K getSourceInputStream(S source) throws IOException;

    /**
     * Permet de récupérer le flux d'écriture et de sérialisation vers le media
     *
     * @param media
     * @param <T>
     * @return
     * @throws IOException
     */
    <T extends OutputStream> T getSerializingStream(M media) throws IOException;


}
