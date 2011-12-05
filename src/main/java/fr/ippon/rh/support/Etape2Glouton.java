package fr.ippon.rh.support;

import java.util.Arrays;

/**
 * Resolution de l'etape 2 avec un algorithme glouton.
 * 
 * @author sebastien.prunier
 */
public class Etape2Glouton {

    // Capacite du sac a dos.
    private static final Integer MAX_WEIGHT = 30;

    // Liste des objets
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

        // Tri des objets par ordre decroissant de valeur. (cf. methode compareTo de DevoxxObject)
        Arrays.sort(DEVOXX_OBJECTS);

        Integer total_weight = 0;
        String result = "";

        // Algo glouton !
        for (int i = 0; i < DEVOXX_OBJECTS.length; i++) {
            DevoxxObject devoxxObject = DEVOXX_OBJECTS[i];
            if (devoxxObject.weight + total_weight <= MAX_WEIGHT) {
                total_weight += devoxxObject.weight;
                result += devoxxObject.id;
            }
        }

        System.out.println(result);

        // Resultat : 2529 (objets 25,29)
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
