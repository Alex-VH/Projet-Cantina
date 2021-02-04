# Installation

Cette application est une API REST(-ish) pour gérer les menus de la Cantina.

Pour lancer l'application, exécutez les commandes suivantes :
```shell
$ mvn verify
$ java -jar target/projet-cantina-2.0.4.jar
```

Vous pouvez aussi récupérer l'exécutable directement sur le dépôt, en accédant au fichier de la release.

## Utilisation

Voici un exemple d'utilisation de l'API :
```shell
# Afficher tous les menus
$ curl -XGET localhost:8080/menus

# Créer un nouveau menu "Menu de Noel" avec un plat "Céréales sur lait"
$ curl -H "Content-Type: application/json"  -d '{"name": "Menu de Noel", "dishes": [{"name": "Céréales sur lait"}]}' http://localhost:8080/menus
```