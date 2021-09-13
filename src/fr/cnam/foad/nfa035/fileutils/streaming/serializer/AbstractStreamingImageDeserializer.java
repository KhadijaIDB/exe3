package fr.cnam.foad.nfa035.fileutils.streaming.serializer;

import java.io.IOException;

/**
 * Classe abstraite visant à structurer/guider le développement de manière rigoureuse
 * Elle s'applique donc à tout objet dont les methodes auraient pour effet la sérialisation d'une image,
 * quel qu'en soit le format ou le média/canal de destination.
 *
 * @param <M> Le Media de sérialisation,
 *           à partir duquel nous voulons désérialiser notre image en base 64,
 *           c'est-à-dire la récupérer à son format original.
 */
public abstract class AbstractStreamingImageDeserializer<M> implements ImageStreamingDeserializer<M> {

    /**
     * Désérialise une image depuis un media quelconque vers un support quelconque
     *
     * @param media
     * @throws IOException
     */
    @Override
    public final void deserialize(M media) throws IOException {
        getDeserializingStream(media).transferTo(getSourceOutputStream());
    }
}
