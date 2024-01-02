# Programme de caisse enregistreuse

## Présentation

Le programme simule le comportement d'une caisse enregistreuse.
le programme expose des api, avec comme fonctionnalités:
- Le calcul d'un rendu de monnaie
- La gestion de tickets de caisse

## Rendu de monnaie

On considère qu'on dispose toujours de chaque valeur de monnaie
(plus tard on pourra implémenter le fait qu'il manque telle ou telle valeur de monnaie).

On prend les valeurs monétaires en € entre 50€ et 1 cent, pas de valeur au dessus.

On compte rendre la monnaie de la manière suivante:

- On vérifie combien on doit au client grâce aux informations rentrées
- On utilise les valeurs de monnaie de manière décroissante jusqu'à ne plus avoir de reste à payer
- On retourne une chaîne de caractères de type: Je dois au client: X billets de Y, X' pièces de Y' etc...

Exemple:

Le client doit payer 128,59

Il me donne 130€

Je dois lui rendre 130 - 128,59 = 1,41

Le message doit préciser qu'on lui rend 1 pièce de 1€, 2 pièces de 20 centimes d'euros, 1 pièce de 1 centimes d'€


## Ticket de caisse

On permet la création, suppression et modification d'un ticket de caisse.
Sur un ticket on trouve une liste de produits avec la quantité associée ainsi que le prix par article et le prix total.

Il est aussi possible d'ajouter, supprimer, modifier un produit.
Un produit est représenté par un nom et un prix.

