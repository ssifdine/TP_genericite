package ma.saifdine.hd;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        MetierProduitImpl metier = new MetierProduitImpl();
        Scanner scanner = new Scanner(System.in);
        int choix;

        do {
            System.out.println("\nMenu :");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter");
            System.out.print("Votre choix : ");
            choix = scanner.nextInt();

            switch (choix) {
                case 1:
                    System.out.println("Liste des produits :");
                    for (Produit produit : metier.getAll()) {
                        System.out.println(produit.toString());
                    }
                    break;

                case 2:
                    System.out.print("Entrez l'id du produit à rechercher : ");
                    long idRecherche = scanner.nextLong();
                    Produit produit = metier.findById(idRecherche);
                    if (produit != null) {
                        System.out.println("Produit trouvé : " + produit);
                    } else {
                        System.out.println("Aucun produit trouvé avec cet id :" + idRecherche);
                    }
                    break;

                case 3:
                    System.out.print("Entrez l'id : ");
                    long id = scanner.nextLong();
                    scanner.nextLine(); // Consomme la ligne restante
                    System.out.print("Entrez le nom : ");
                    String nom = scanner.nextLine();
                    System.out.print("Entrez la marque : ");
                    String marque = scanner.nextLine();
                    System.out.print("Entrez le prix : ");
                    double prix = scanner.nextDouble();
                    scanner.nextLine(); // Consomme la ligne restante
                    System.out.print("Entrez la description : ");
                    String description = scanner.nextLine();
                    System.out.print("Entrez le nombre en stock : ");
                    int nombreEnStock = scanner.nextInt();
                    metier.add(new Produit(id, nom, marque, prix, description, nombreEnStock));
                    System.out.println("Produit ajouté avec succès !");
                    break;

                case 4:
                    System.out.print("Entrez l'id du produit à supprimer : ");
                    long idSuppression = scanner.nextLong();
                    metier.delete(idSuppression);
                    System.out.println("Produit supprimé avec succès !");
                    break;

                case 5:
                    System.out.println("Au revoir !");
                    break;

                default:
                    System.out.println("Choix invalide, veuillez réessayer.");
            }
        } while (choix != 5);

        scanner.close();
    }
}

