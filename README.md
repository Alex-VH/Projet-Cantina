# Menu Server

Cette application est une API REST(-ish) pour gérer les menus de la Cantina.

Pour lancer l'application, executer les commandes suivantes :
```shell
$ mvn verify
$ java -jar target/projet-cantina-2.0.2.jar
```

## Utilisation

Les personnes du département "Quality Assurance" disent qu'on peut tester l'application manuellement avec ces requêtes HTTP :

```shell
# Afficher tous les menus
$ curl -XGET localhost:8080/menus

# Créer un nouveau menu "Menu de Noel" avec un plat "Céréales sur lait"
$ curl -H "Content-Type: application/json"  -d '{"name": "Menu de Noel", "dishes": [{"name": "Céréales sur lait"}]}' http://localhost:8080/menus
```

## Nouvelles fonctionnalités

Mise en place d'une intégration continus.
Mise en place de Maven