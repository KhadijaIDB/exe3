package fr.cnam.foad.nfa035.fileutils.streaming.media;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Classe abstraite visant à structurer/guider le développement dee manière rigoureuse
 * Elle s'applique à tout objet représentant un média de sérialisation.
 * Les implémentations sous-jacentes peuvent revêtir des aspects de fichiers ou bien de flux.
 *
 * @param <T>
 */
public abstract class AbstractImageFrameMedia<T> {

    /**
     * le canal de distribution de notre image sérialisée, potentiellement un Fichier ou bien même un Flux
     */
    private T channel;

    /**
     * Constructeur vide
     */
    protected AbstractImageFrameMedia() {
    }

    /**
     * Permet d'obtenir le canal de distribution de notre image sérialisée, potentiellement un Fichier ou bien même un Flux
     *
     * @return le canal
     */
    public T getChannel() {
        return channel;
    }

    /**
     * Permet de définir le canal de distribution de notre image sérialisée, potentiellement un Fichier ou bien même un Flux
     *
     * @param channel
     */
    public void setChannel(T channel) {
        this.channel = channel;
    }

    /**
     * Constructeur simple
     * @param channel
     */
    AbstractImageFrameMedia(T channel){
        this.channel = channel;
    }

    /**
     * Permet d'obtenir le flux d'écriture sous-tendant à notre canal
     *
     * @return le flux d'écriture
     * @throws IOException
     */
    public abstract OutputStream getEncodedImageOutput() throws IOException;

    /**
     * Permet d'obtenir le flux de lecture sous-tendant à notre canal
     *
     * @return le flux de lecture
     * @throws IOException
     */
    public abstract InputStream getEncodedImageInput() throws IOException;
}
