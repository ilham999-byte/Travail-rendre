# Travail à Rendre : Scripts des Développeurs

## Description
Ce projet vise à suivre la réalisation des scripts des développeurs d'un projet. Chaque jour, un rapport est établi par le chef de projet pour enregistrer le nombre de scripts réalisés par les différents développeurs. Ces informations sont stockées dans une base de données MySQL.

## Objectifs
- Ouvrir une connexion à la base de données MySQL.
- Créer et remplir une table pour stocker les informations des scripts.
- Rechercher et afficher des informations à partir de la base de données.
- Manipuler les données en utilisant l'API JDBC en Java.

## Structure de la Table
La table `DevData` contient trois colonnes :
- **Développeurs** : Nom du développeur.
- **Jour** : Jour de la semaine.
- **NbScripts** : Nombre de scripts réalisés.

### Exemples de Données
Le projet inclut des données sur les scripts réalisés par plusieurs développeurs, classées par jour et par nombre de scripts.

## Exercice 1 : Ouvrir une Connexion, Créer et Remplir une Table
Les étapes à suivre sont les suivantes :
1. Charger le driver JDBC pour MySQL.
2. Établir une connexion à la base de données.
3. Créer la table `DevData` en exécutant les commandes SQL appropriées.
4. Insérer les données correspondantes dans la table.
5. Supprimer la table si nécessaire.
6. Compiler et tester le programme pour s'assurer de son bon fonctionnement.

## Exercice 2 : Rechercher des Informations dans la Base de Données
Dans cet exercice, il est demandé d'écrire le programme `ExoJDBC` pour afficher :
- Le développeur ayant réalisé le maximum de scripts en une seule journée.
- La liste des développeurs triée selon leur nombre total de scripts réalisés.
Il faut également calculer et afficher le nombre total de scripts réalisés en une semaine et le nombre de scripts réalisés par un développeur spécifique.

## Exercice 3 : Requête Libre et Méta-Information
Le programme `ExoJDBC` devra également exécuter une requête libre et afficher des informations sur les types de données des résultats obtenus.

## 
Liens vers le Code Source

Démo Vidéo
