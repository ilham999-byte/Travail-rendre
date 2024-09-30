
package devpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {

    public static void Insert(DevData d) {
        // Information d'accès à la base de données
        String user = "root";
        String password = ""; 
        String url = "jdbc:mysql://localhost/db1";
        Connection cn = null;
        Statement st = null;

        try {
            // Étape 1 : Chargement du driver
            Class.forName("com.mysql.jdbc.Driver");

            // Étape 2 : Récupération de la connexion
            cn = DriverManager.getConnection(url, user, password);

            // Étape 3 : Création d'un statement
            st = cn.createStatement();

            // Insertion des données 
            String req = "insert into DevData values('" + d.getDeveloppeur() + "','" + d.getJour() + "'," + d.getNbrscripts() + ")";

            // Étape 4 : Exécution de la requête
            st.executeUpdate(req);
            System.out.println("Données insérées dans DevData");

        } catch (SQLException e) {
            System.out.println("Erreur SQL : " + e.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Impossible de charger le driver : " + ex.getMessage());
        } finally {
            try {
                // Étape 5 : Libération des ressources de la mémoire
                if (st != null) st.close();
                if (cn != null) cn.close();
            } catch (SQLException ex) {
                System.out.println("Impossible de libérer les ressources : " + ex.getMessage());
            }
        }
    }
    

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/db1", "root", "");
             Statement statement = connection.createStatement()) {
            // Création de la table DevData 
            String createTable = "CREATE TABLE IF NOT EXISTS DevData (" +
                                 "Developpeurs VARCHAR(32), " +
                                 "Jour CHAR(11), " +
                                 "NbScripts INTEGER)";
            statement.executeUpdate(createTable);
            System.out.println("Table DevData créée");
        } catch (SQLException e) {
            System.out.println("Erreur SQL lors de la création de la table : " + e.getMessage());
        }
        // Exemple d'insertion dans la table DevData
        DevData dev1 = new DevData("ALAMI", "Lundi", 1);
        Insert(dev1);
    
        DevData dev2 = new DevData("WAFI", "Lundi", 2);
        Insert(dev2);
    
        DevData dev3 = new DevData("SALAMI", "Mardi", 9);
        Insert(dev3);
    
        DevData dev4 = new DevData("SAFI", "Mardi", 2);
        Insert(dev4);
    
        DevData dev5 = new DevData("ALAMI", "Mardi", 2);
        Insert(dev5);
    
        DevData dev6 = new DevData("SEBIHI", "Mercredi", 2);
        Insert(dev6);
    
        DevData dev7 = new DevData("WAFI", "Jeudi", 3);
        Insert(dev7);
    
        DevData dev8 = new DevData("ALAOUI", "Vendredi", 9);
        Insert(dev8);
    
        DevData dev9 = new DevData("WAFI", "Vendredi", 3);
        Insert(dev9);
    
        DevData dev10 = new DevData("SEBIHI", "Vendredi", 4);
        Insert(dev10);
}
        

        
        
    }

