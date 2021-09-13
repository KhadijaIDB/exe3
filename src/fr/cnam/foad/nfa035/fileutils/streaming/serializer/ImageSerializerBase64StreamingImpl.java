package fr.cnam.foad.nfa035.fileutils.streaming.serializer;

import fr.cnam.foad.nfa035.fileutils.streaming.media.AbstractImageFrameMedia;
import org.apache.commons.codec.binary.Base64OutputStream;

import java.io.*;

/**
 * Implémentation Base64 de sérialiseur d'image, basée sur des flux.
 */
public class ImageSerializerBase64StreamingImpl
        extends AbstractStreamingImageSerializer<File, AbstractImageFrameMedia> {

    /**
     * {@inheritDoc}
     *
     * @param source
     * @return
     * @throws FileNotFoundException
     */
    @Override
    public InputStream getSourceInputStream(File source) throws FileNotFoundException {
        return new FileInputStream(source);
    }

    /**
     * {@inheritDoc}
     *
     * @param media
     * @return
     * @throws IOException
     */
    @Override
    public OutputStream getSerializingStream(AbstractImageFrameMedia media) throws IOException {
        return new Base64OutputStream(media.getEncodedImageOutput());
    }

}
