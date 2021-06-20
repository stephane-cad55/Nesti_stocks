<p align="center">
  <img src="https://github.com/lauree-p/Nesti_Stelare/blob/main/img/Nesti_Stelare-logo.png">
</p>

<h2 align="center" style="color: red">Gestion de stock en JAVA</h2>

Contexte :
L’entreprise Nesti souhaite gérer ses stocks via une application. 
Pour cela, L’entreprise Nesti vous propose de développer une application en JAVA accompagnée d’une base de données locale ( MySQL ) qui sera accessible uniquement par les administrateurs.

### Entreprise Nesti
Cliquer le lien https://agnes.needemand.com/nesti-site/ pour ouvrir la ressource.

### Objectif
Le but de cette application est de gérer les articles de type ustensile de cuisine, ainsi que les ingrédients nécessaires aux recettes.
L’outil doit être clair et intuitif.

### Connexion
L’application sera accessible après une étape de connexion par un administrateur.

### Ingrédients
L’application doit permettre de créer, modifier, supprimer et mettre à jour les informations des ingrédients.
A partir d’ingrédient, l’administrateur peut choisir de créer un article vendable.

Par exemple :
- un paquet de 1 kg de farine

Un ingrédient peut être vendu sous différents conditionnements.
Par exemple :
- une boite de 6 oeufs
- une boite de 12 oeufs

Exemples d'ingrédients :
- banane
- farine
- oeuf
- lait

### Ustensiles
L'administrateur peut aussi ajouter des articles de type ustensiles de cuisine.

Exemples d'ustensiles :
- cuillère en bois
- fouet
- manic
- couteau
- cuillère en bois
- saladier
- fouet
- balance

### Articles
Les articles peuvent être de type ustensile ou de type ingrédient. Les frais de livraison varient en fonction du poids de l’article. Les articles seront achetés à différents fournisseurs.
Un article peut être fourni par plusieurs fournisseurs.

Il se peut qu’un nouveau fournisseur puisse nous vendre des articles. Il faut donc prévoir la possibilité d’ajouter un nouveau fournisseur avec les informations suivantes :
- Nom de l’entreprise et adresse
- Nom et prénom du contact, avec son numéro de téléphone

Les prix varient aussi en fonction du temps.

### Commande aux fournisseurs
Prévoir un affichage qui permet de saisir une entrée dans le stock d’un article.
Un fournisseur peut fournir plusieurs articles. Tous les fournisseurs ne fournissent pas tous les articles.

Par exemple :
Achat de 100 articles ( 1kg de farine ) au fournisseur X.
Et ainsi le stock de cet article sera augmenté de 100 unités.
Un article peut être vendu par plusieurs fournisseurs. Le prix d’achat peut varier d’un fournisseur à l’autre.
Le prix d’achat permet de déterminer le prix de vente de l’article .
Le prix de vente est égal au prix d’achat le plus élevé, augmenté de 20%.

Par exemple :
L’article 1 est un paquet de 1kg de farine.
Le fournisseur A vend cet article 89 centimes
Le fournisseur B vend cet article 69 centimes

Le prix de vente est :
89 + ( 89 * 20 / 100 ) = 89 + 17.8 = 106,9

Après arrondis :
Le prix de vente de l’article 1 est de 107 centimes, soit 1 euros et 7 centimes.

### Précisions
L'administrateur doit pouvoir gérer la liste des fournisseurs pour un article et la liste des articles pour un fournisseur.
Pas besoin d'image pour la partie administrative Java
Seul un superAdministrateur pourra ajouter un autre administrateur. Les informations login et mot de passe, seront fourni au moment de la livraison au client.
Dans le jargon de l'entreprise Nesti, on appelle "Product" l'ensemble des ingrédients et des ustensiles. Produits = ( Ingrédients + Ustensiles )

### Bonnes Idées
Indiquer la date de consommation limite sur les articles de type ingrédients

Conséquences :
- les articles de type ingrédient dont la date est dépassé, ne doit pas être vendu.
- une date ne dépend pas d'un article, mais d'un lot de cet article acheté à un fournisseur particulier.
- On ne doit pas créer plusieurs articles avec le même nom, avec une date différente.

Indiquer la provenance du produit
Indiquer la marque de l'article : MAIS tous les articles seront vendu sous la marques NESTI

### Interface graphique
L'utilisation des JTabPannels permet de passer rapidement d'un onglet à l'autre, en restant sur la même frame.
L'interface peut être aussi grande que possible : plein écran. Les administrateurs doivent pouvoir travailler toute la journée dessus. Ils doivent avoir tout à leur disposition, sur un même écran. ( sans retour en arrière ou presque ) Profitez de toute la place d'une page.

### Validation par le client
Les documents produits dans le dossier de conception devront être validés un par un par le client.
La maquette de l'application est validé écran par écran. De tel sorte, que vous pouvez commencé à développer les écrans validés, en attendant la validation des autres écrans.
Le diagramme de classe, la maquette ... etc devront correspondre au projet développé.
S'il y a des modifications, il faudra fournir une nouvelle version du document, et être de nouveau validé par le client. Il faudra alors préciser pourquoi, il y a eu un changement.

### Livrables
- Dossier de conception
- Code source via un accès d’un repo public sur github ( par exemple )
- Documentation sur le fonctionnement du code, des algorithmes, recherches techniques réalisées au cours du développement.
Cette documentation doit être illustrée par des captures d’écran et clairement expliquer le fonctionnement du code.
- Script de la base de données
- Rapport de réunion écrit et daté attestant des échanges réalisés entre les différents développeurs.
- Manuel d’utilisation pour l’administrateur. Réunissant des captures d’écran de l’application commentée.
- Démonstration de l’application présentant les différentes étapes de création. ( Visioconférences )

### Contraintes
Utilisation de SWING, Java, Mysql.
Pour des raisons pédagogiques : on ne tiendra pas compte de la TVA.

### Outils

#### Répartition des taches

Utilisation de Trello

Trello : https://trello.com/b/Ixz1jhAb/nestistelare

#### Logiciels utilisés

- StarUML (https://staruml.io/)
- Looping (https://www.looping-mcd.fr/)
- SmartSheet (https://fr.smartsheet.com/)

##### Projet réalisé dans le cadre d'un projet pédagogique par Stéphane, Laurélenne et Rémi

##### Nesti_Stelare©2021 