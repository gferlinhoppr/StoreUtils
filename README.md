# Programme de calcul de monnaie

## Présentation simple du programme

Le programme a pour but d'indiquer à l'utilisateur comment rendre la monnaie à un client.

Pour cela:

- Un prompt affiche "Entrer le prix total: "
- L'utilisateur peut ensuite indiquer un nombre représentant le prix total à payer (séparé par une ',' pour les décimales)
- un prompt affiche ensuite "Entrer le montant donné par le client: "
- L'utilisateur peut alors indiquer combien le client a donné (séparé par une ',' pour les décimales)
- Le résultat s'affiche ensuite sous forme de chaîne de caractères (voir ci dessous)
- On revient ensuite à l'étape 1 du programme

## Détails du fonctionnement du programme.

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

## Autres détails

Pas de consignes concernant la gestion des erreurs et autres cas limites mais ce serait préférable d'en avoir ;)
