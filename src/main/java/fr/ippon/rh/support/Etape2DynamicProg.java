package fr.ippon.rh.support;

/**
 * Resolution de l'etape 2 avec un algorithme dynamique.
 * 
 * @author sebastien.prunier
 */
public class Etape2DynamicProg {

    private static final Integer MAX_WEIGHT = 30;

    private static DevoxxObject[] DEVOXX_OBJECTS = { new DevoxxObject(1, 737, 7), new DevoxxObject(2, 842, 4),
            new DevoxxObject(3, 158, 1), new DevoxxObject(4, 36, 28), new DevoxxObject(5, 578, 26),
            new DevoxxObject(6, 173, 19), new DevoxxObject(7, 268, 28), new DevoxxObject(8, 273, 17),
            new DevoxxObject(9, 88, 26), new DevoxxObject(10, 699, 9), new DevoxxObject(11, 243, 11),
            new DevoxxObject(12, 578, 18), new DevoxxObject(13, 63, 27), new DevoxxObject(14, 639, 8),
            new DevoxxObject(15, 639, 18), new DevoxxObject(16, 639, 6), new DevoxxObject(17, 155, 15),
            new DevoxxObject(18, 819, 28), new DevoxxObject(19, 451, 19), new DevoxxObject(20, 183, 22),
            new DevoxxObject(21, 707, 29), new DevoxxObject(22, 971, 16), new DevoxxObject(23, 104, 9),
            new DevoxxObject(24, 370, 7), new DevoxxObject(25, 998, 29), new DevoxxObject(26, 380, 2),
            new DevoxxObject(27, 442, 3), new DevoxxObject(28, 760, 5), new DevoxxObject(29, 859, 1),
            new DevoxxObject(30, 146, 18), new DevoxxObject(31, 282, 28), new DevoxxObject(32, 757, 9),
            new DevoxxObject(33, 875, 8), new DevoxxObject(34, 594, 20), new DevoxxObject(35, 366, 21),
            new DevoxxObject(36, 666, 27), new DevoxxObject(37, 615, 13), new DevoxxObject(38, 579, 24),
            new DevoxxObject(39, 804, 2), new DevoxxObject(40, 764, 24) };

    public static void main(String[] args) {

        int[][] M = new int[DEVOXX_OBJECTS.length][MAX_WEIGHT + 1];

        // 1- ALIMENTATION DE LA MATRICE

        // Première ligne
        for (int j = 0; j <= MAX_WEIGHT; j++) {
            if (DEVOXX_OBJECTS[0].weight > j) {
                M[0][j] = 0;
            } else {
                M[0][j] = DEVOXX_OBJECTS[0].value;
            }
        }

        // Autres lignes
        for (int i = 1; i < DEVOXX_OBJECTS.length; i++) {
            for (int j = 0; j <= MAX_WEIGHT; j++) {
                if (DEVOXX_OBJECTS[i].weight > j) {
                    M[i][j] = M[i - 1][j];
                } else {
                    M[i][j] = Math.max(M[i - 1][j], M[i - 1][j - DEVOXX_OBJECTS[i].weight] + DEVOXX_OBJECTS[i].value);
                }
            }
        }

        // AFFICHAGE DE LA MATRICE
        for (int i = 0; i < DEVOXX_OBJECTS.length; i++) {
            for (int j = 0; j <= MAX_WEIGHT; j++) {
                System.out.print(M[i][j] + "|");
            }
            System.out.println();
        }

        // 2- RECHERCHE DU RESULTAT
        int i = DEVOXX_OBJECTS.length - 1;
        int j = MAX_WEIGHT;
        String result = "";

        while (M[i][j] == M[i][j - 1]) {
            j--;
        }

        while (j > 0) {
            while (i > 0 && M[i][j] == M[i - 1][j]) {
                i--;
            }
            j = j - DEVOXX_OBJECTS[i].weight;
            if (j >= 0) {
                result += DEVOXX_OBJECTS[i].id + "|";
            }
            i--;
        }

        System.out.println(result);

        // Resultat : 12162627282939 (objets 1,2,16,26,27,28,29,39)
        // Poids total : 30
        // Valeur totale : 998 + 859 = 1857
    }

    /*
     * Inner class permettant de representer un objet a emporter a Devoxx.
     */
    private static final class DevoxxObject implements Comparable<DevoxxObject> {

        private Integer id;

        private Integer value;

        private Integer weight;

        public DevoxxObject(Integer id, Integer value, Integer weight) {
            super();
            this.id = id;
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(DevoxxObject o) {
            return o.value.compareTo(this.value);
        }

    }

}
