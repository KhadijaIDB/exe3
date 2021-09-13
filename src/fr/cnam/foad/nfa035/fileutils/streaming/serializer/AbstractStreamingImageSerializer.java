package fr.cnam.foad.nfa035.fileutils.streaming.serializer;

import java.io.IOException;
import java.io.OutputStream;

/**
 *
 * Classe abstraite visant à structurer/guider le développement dee manière rigoureuse
 *
 * @param <S>
 * @param <M> Le Media de sérialisation,
 *           à vers lequel nous voulons sérialiser notre image en base 64
 */
public abstract class AbstractStreamingImageSerializer<S,M> implements ImageStreamingSerializer<S,M> {

    /**
     * Sérialise une image depuis un support quelconque vers un media quelconque
     *
     * @param source
     * @param media
     * @throws IOException
     */
    @Override
    public final void serialize(S source, M media) throws IOException {
        try(OutputStream os = getSerializingStream(media)){
            getSourceInputStream(source).transferTo(os);
        }
    }

}
