package fr.ippon.rh.support;

import java.util.HashSet;
import java.util.Set;

import org.jasypt.util.text.BasicTextEncryptor;

/**
 * Resolution de l'etape 3 par force brute.
 * 
 * @author sebastien.prunier
 */
public class ForceBrute {

    // Texte a decrypter
    private static final String etape4Texte = "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";

    /*
     * Programme principal
     */
    public static void main(String args[]) {

        Set<String> passwords = new HashSet<String>();
        permute("", "ABCDEGHIJ", passwords);

        System.out.println(passwords.size());

        System.out.println(getPassword(passwords));
    }

    /**
     * Calcul des permutations.
     * 
     * @param sStart
     *            chaine de depart.
     * @param sEnd
     *            chaine d'arrivee.
     * @param passwords
     *            ensemble des mots de passe.
     */
    public static void permute(String sStart, String sEnd, Set<String> passwords) {
        if (sEnd.length() <= 1) {
            passwords.add(sStart + sEnd);
        } else {
            for (int i = 0; i < sEnd.length(); i++) {
                String newString = sEnd.substring(0, i) + sEnd.substring(i + 1);
                permute(sStart + sEnd.charAt(i), newString, passwords);
            }
        }
    }

    /**
     * Recherche le bon mot de passe parmi les permutations possibles.
     * 
     * @param passwords
     *            les permutations.
     * @return le bon mot de passe, ou <code>null</code> si aucun bon mot de passe.
     */
    public static String getPassword(Set<String> passwords) {
        for (String password : passwords) {
            try {
                BasicTextEncryptor textEncryptor = new BasicTextEncryptor();
                textEncryptor.setPassword(password);
                String decryptedText = textEncryptor.decrypt(etape4Texte);
                if (decryptedText.contains("ippon")) {
                    return password;
                }
            } catch (Exception e) {
                // Bad password !
            }
        }
        return null; // No valid password :-(
    }

}
