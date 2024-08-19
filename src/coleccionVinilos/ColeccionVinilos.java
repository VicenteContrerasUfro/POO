package coleccionVinilos;

public class ColeccionVinilos {

    public static void main(String[] args) {

        String vinilos[][] = new String[100][3];

        System.out.println(agregarVinilo(vinilos, "Iron Maiden", "Iron Maiden", "1980"));
        System.out.println(agregarVinilo(vinilos, "Iron Maiden", "Killers", "1981"));
        System.out.println(agregarVinilo(vinilos, "Iron Maiden", "The number of the beast", "1982"));
        System.out.println(agregarVinilo(vinilos, "AC-DC", "Back in black", "1980"));
        System.out.println(agregarVinilo(vinilos, "AC-DC", "Highway to Hell", "1979"));
        System.out.println(agregarVinilo(vinilos, "AC-DC", "Who made who", "1986"));
        System.out.println(agregarVinilo(vinilos, "Judas Priest", "British steel", "1980"));
        System.out.println(agregarVinilo(vinilos, "Judas Priest", "Painkiller", "1990"));
        System.out.println(agregarVinilo(vinilos, "Judas Priest", "Defenders of the faith", "1984"));
        System.out.println(agregarVinilo(vinilos, "Kiss", "Destroyer", "1976"));

        System.out.println("Espacio máximo en la colección: " + vinilos.length);

        mostrarTotal(vinilos);
        mostrarDisponibles(vinilos);

        String artista = "AC-DC";
        System.out.println("Buscando vinilos del artista: " + artista);
        mostrarBusquedaArtista(vinilos, artista);

        mostrarColeccion(vinilos);
    }

    public static String agregarVinilo(String[][] coleccion, String artista, String nombreDisco, String año) {
        for (int i = 0; i < coleccion.length; i++) {
            if (coleccion[i][0] == null) {
                coleccion[i][0] = artista;
                coleccion[i][1] = nombreDisco;
                coleccion[i][2] = año;
                return "Vinilo agregado: " + artista + " - " + nombreDisco;
            }
        }
        return "La colección está llena, no se pudo agregar el vinilo.";
    }

    public static boolean buscarArtista(String[][] coleccion, String artista) {
        for (int i = 0; i < coleccion.length; i++) {
            if (coleccion[i][0] != null && coleccion[i][0].equalsIgnoreCase(artista)) {
                return true;
            }
        }
        return false;
    }

    public static void mostrarColeccion(String[][] coleccion) {
        System.out.println("Colección completa de vinilos:");
        for (int i = 0; i < coleccion.length; i++) {
            if (coleccion[i][0] != null) {
                System.out.println(coleccion[i][0] + " - " + coleccion[i][1] + " (" + coleccion[i][2] + ")");
            }
        }
    }

    public static void mostrarTotal(String[][] coleccion) {
        int total = totalVinilos(coleccion);
        System.out.println("Total de vinilos en la colección: " + total);
    }

    public static int totalVinilos(String[][] coleccion) {
        int total = 0;
        for (int i = 0; i < coleccion.length; i++) {
            if (coleccion[i][0] != null) {
                total++;
            }
        }
        return total;
    }

    public static void mostrarDisponibles(String[][] coleccion) {
        int disponibles = coleccion.length - totalVinilos(coleccion);
        System.out.println("Espacios disponibles en la colección: " + disponibles);
    }

    public static void mostrarBusquedaArtista(String[][] coleccion, String artista) {
        if (buscarArtista(coleccion, artista)) {
            System.out.println("Se encontraron vinilos del artista " + artista + ":");
            for (int i = 0; i < coleccion.length; i++) {
                if (coleccion[i][0] != null && coleccion[i][0].equalsIgnoreCase(artista)) {
                    System.out.println(coleccion[i][1] + " (" + coleccion[i][2] + ")");
                }
            }
        } else {
            System.out.println("No se encontraron vinilos del artista " + artista);
        }
    }
}

