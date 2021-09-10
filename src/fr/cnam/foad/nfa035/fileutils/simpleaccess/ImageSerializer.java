package fr.cnam.foad.nfa035.fileutils.simpleaccess;

import java.io.File;
import java.io.IOException;

/**
 * Inteface de base pour sérialiser désérialiser une image au format texte
 *
 * @author tvonstebut
 */
public interface ImageSerializer<S,M> {

    /**
     * Sérialise une image en chaîne de caractères
     *
     * @param image
     * @return
     * @throws IOException
     */
    S serialize(File image) throws IOException;

    /**
     * Désérialise une chaîne de caractères en image
     *
     * @param image
     * @return
     */
    M deserialize(String image) ;

}
