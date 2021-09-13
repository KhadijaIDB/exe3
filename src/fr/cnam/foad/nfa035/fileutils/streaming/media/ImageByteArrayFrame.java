package fr.cnam.foad.nfa035.fileutils.streaming.media;

import java.io.*;

/**
 * Implémentation d'ImageFrame pour un simple Tableau d'Octets comme canal
 */
public class ImageByteArrayFrame extends AbstractImageFrameMedia<ByteArrayOutputStream> {


    /**
     * Simple constructeur
     *
     * @param walletDatabase
     */
    public ImageByteArrayFrame(ByteArrayOutputStream walletDatabase) {
        super(walletDatabase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OutputStream getEncodedImageOutput() throws FileNotFoundException {
        return getChannel();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream getEncodedImageInput() throws FileNotFoundException {
        return new ByteArrayInputStream(getChannel().toByteArray());
    }
}
