package fr.cnam.foad.nfa035.fileutils.streaming.serializer;

import fr.cnam.foad.nfa035.fileutils.streaming.media.AbstractImageFrameMedia;
import org.apache.commons.codec.binary.Base64InputStream;

import java.io.*;

/**
 * Implémentation Base64 de désérialiseur d'image, basée sur des flux.
 */
public class ImageDeserializerBase64StreamingImpl extends AbstractStreamingImageDeserializer<AbstractImageFrameMedia> {

    private OutputStream sourceOutputStream;

    /**
     * {@inheritDoc}
     *
     * @return le flux d'écriture
     */
    @Override
    public OutputStream getSourceOutputStream() {
        return sourceOutputStream;
    }

    /**
     * Constructeur élémentaire
     * @param sourceOutputStream
     */
    public ImageDeserializerBase64StreamingImpl(OutputStream sourceOutputStream) {
        this.sourceOutputStream = sourceOutputStream;
    }

    /**
     * {@inheritDoc}
     *
     * @param media
     * @return le flux de lecture
     * @throws IOException
     */
    @Override
    public InputStream getDeserializingStream(AbstractImageFrameMedia media) throws IOException {
        return new Base64InputStream(media.getEncodedImageInput());
    }


}
