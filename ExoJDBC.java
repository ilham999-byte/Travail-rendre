
package devpackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

public class ExoJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/db1"; 
        String user = "root"; 
        String password = ""; 

        Scanner scanner = new Scanner(System.in); // Création du scanner 

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            Statement stmt = conn.createStatement();

            // (a) Afficher la personne ayant réalisé le nombre maximum de scripts en une journée
            System.out.println("Développeur ayant réalisé le maximum de scripts en une journée :");
            ResultSet rsMax = stmt.executeQuery(
                "SELECT Developpeurs, Jour, NbScripts " +
                "FROM DevData " +
                "WHERE NbScripts = (SELECT MAX(NbScripts) FROM DevData)"
            );

            if (rsMax.next()) { 
                System.out.print("Développeur: " + rsMax.getString("Developpeurs"));
                System.out.print(", Jour: " + rsMax.getString("Jour"));
                System.out.println(", MaxScripts: " + rsMax.getInt("NbScripts"));
            } else {
                System.out.println("Aucun script trouvé.");
            }

            // (b) Afficher la liste des personnes triée dans l’ordre décroissant selon leur nombre de scripts
            System.out.println("\nListe des personnes triée par nombre total de scripts :");
            ResultSet rsTotal = stmt.executeQuery(
                "SELECT Developpeurs, SUM(NbScripts) AS TotalScripts " +
                "FROM DevData " +
                "GROUP BY Developpeurs " +
                "ORDER BY TotalScripts DESC"
            );

            while (rsTotal.next()) {
                System.out.print(rsTotal.getString("Developpeurs"));
                System.out.println(" - Total Scripts: " + rsTotal.getInt("TotalScripts"));
            }

            // 2. Nombre total de scripts réalisés en une semaine
            ResultSet rsWeeklyTotal = stmt.executeQuery(
                "SELECT SUM(NbScripts) AS TotalScripts FROM DevData"
            );

            if (rsWeeklyTotal.next()) {
                System.out.println("\nNombre total de scripts réalisés en une semaine : " + rsWeeklyTotal.getInt("TotalScripts"));
            }

            // 3. Nombre total de scripts réalisés par un programmeur donné (par exemple "WAFI")
            String programmer = "WAFI"; 
            ResultSet rsProgrammerTotal = stmt.executeQuery(
                "SELECT SUM(NbScripts) AS TotalScripts FROM DevData WHERE Developpeurs = '" + programmer + "'"
            );

            if (rsProgrammerTotal.next()) {
                System.out.println("Nombre total de scripts réalisés par " + programmer + " : " + rsProgrammerTotal.getInt("TotalScripts"));
            }

            // Demander à l'utilisateur de saisir une requête SQL
            System.out.print("Veuillez entrer votre requête SQL : ");
            String sqlQuery = scanner.nextLine();

            // Exécuter la requête
            boolean isResultSet = stmt.execute(sqlQuery);
            
            if (isResultSet) {
                // La requête retourne un ResultSet
                ResultSet rs = stmt.getResultSet();
                ResultSetMetaData metaData = rs.getMetaData();

                // Obtenir le nombre de colonnes
                int columnCount = metaData.getColumnCount();
                System.out.println("Nombre de colonnes dans le résultat : " + columnCount);

                // Afficher le nom et le type de chaque colonne
                for (int i = 1; i <= columnCount; i++) {
                    System.out.println("Colonne " + i + ": " + metaData.getColumnName(i) + 
                                       " | Type: " + metaData.getColumnTypeName(i));
                }

                // Afficher le contenu du ResultSet
                System.out.println("\nContenu de la table :");
                while (rs.next()) {
                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(rs.getString(i) + "\t");
                    }
                    System.out.println();
                }
                rs.close();
            } else {
                // La requête n'a pas produit de ResultSet
                int rowsAffected = stmt.getUpdateCount();
                System.out.println("Nombre de lignes modifiées : " + rowsAffected);
            }

            // Fermer les ResultSet
            rsMax.close();
            rsTotal.close();
            rsWeeklyTotal.close();
            rsProgrammerTotal.close();
            
            // Fermer le Statement et la Connection
            stmt.close();
            conn.close();
        } catch (Exception e) {
            System.err.println("Une erreur est survenue : " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close(); // Fermer le scanner ici
        }
    }
}