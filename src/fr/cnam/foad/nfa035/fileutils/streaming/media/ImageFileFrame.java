package fr.cnam.foad.nfa035.fileutils.streaming.media;

import java.io.*;

/**
 * Implémentation d'ImageFrame pour un simple Fichier comme canal
 */
public class ImageFileFrame extends AbstractImageFrameMedia<File> {

    public ImageFileFrame(File walletDatabase) {
        super(walletDatabase);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public OutputStream getEncodedImageOutput() throws FileNotFoundException {
        return new FileOutputStream(getChannel());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public InputStream getEncodedImageInput() throws FileNotFoundException {
        return new FileInputStream(getChannel());
    }
}
