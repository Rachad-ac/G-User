# Documentation Complète du Projet Web Service

## Vue d'ensemble du Projet

Ce projet est un service web RESTful développé avec Spring Boot pour la gestion des utilisateurs. Il utilise Spring Data JPA pour l'accès aux données, MySQL comme base de données, et fournit une API CRUD complète pour les entités `User`.

### Technologies Utilisées
- **Spring Boot 3.5.6** : Framework principal
- **Spring Data JPA** : Pour l'accès aux données
- **MySQL** : Base de données
- **Lombok** : Pour réduire le code boilerplate
- **Maven** : Gestion des dépendances

### Structure du Projet
```
web_service/
├── src/main/java/com/example/demo/
│   ├── controller/UserController.java  # Contrôleur REST
│   ├── model/
│   │   ├── User.java                   # Entité utilisateur
│   │   └── Responses.java              # Modèle de réponse
│   ├── repository/UserRepository.java  # Repository JPA
│   ├── service/
│   │   ├── UserService.java            # Interface service
│   │   └── impl/UserServiceImpl.java   # Implémentation service
│   └── DemoApplication.java            # Classe principale
├── src/main/resources/
│   └── application.yaml                # Configuration
└── pom.xml                             # Configuration Maven
```

## Configuration et Installation

### Prérequis
- Java 17
- MySQL Server
- Maven (ou utiliser les wrappers fournis)

### Variables d'Environnement
Configurez les variables suivantes dans `application.yaml` ou via les variables d'environnement :
- `DB_HOST` : Hôte de la base de données (défaut : 127.0.0.1)
- `DB_NAME` : Nom de la base de données (défaut : user-db-kotlin)
- `DB_USERNAME` : Nom d'utilisateur MySQL (défaut : root)
- `DB_PASSWORD` : Mot de passe MySQL (défaut : vide)

### Démarrage du Service
1. Assurez-vous que MySQL est en cours d'exécution
2. Naviguez vers le répertoire `web_service/`
3. Exécutez : `./mvnw spring-boot:run` (Linux/Mac) ou `mvnw.cmd spring-boot:run` (Windows)
4. Le service sera disponible sur `http://localhost:2000/api-webService`

## Documentation de l'API

### URL de Base
```
http://localhost:2000/api-webService
```

### Endpoints Disponibles

#### 1. Créer un Utilisateur
- **URL** : `POST /users`
- **Description** : Crée un nouvel utilisateur
- **Corps de la Requête (JSON)** :
```json
{
  "nom": "John Doe",
  "email": "john.doe@example.com",
  "message": "Bonjour, je suis un nouvel utilisateur"
}
```
- **Réponse de Succès (201 Created)** :
```json
{
  "status": "success",
  "message": "Utilisateur créé avec succès",
  "data": {
    "id": 1,
    "nom": "John Doe",
    "email": "john.doe@example.com",
    "message": "Bonjour, je suis un nouvel utilisateur"
  }
}
```
- **Réponse d'Erreur** :
```json
{
  "status": "error",
  "message": "Erreur lors de la création de l'utilisateur",
  "data": null
}
```

#### 2. Mettre à Jour un Utilisateur
- **URL** : `PUT /users/{id}`
- **Description** : Met à jour un utilisateur existant
- **Paramètres** : `id` (Long) - ID de l'utilisateur
- **Corps de la Requête (JSON)** :
```json
{
  "nom": "Jane Doe",
  "email": "jane.doe@example.com",
  "message": "Message mis à jour"
}
```
- **Réponse de Succès (200 OK)** :
```json
{
  "status": "success",
  "message": "Utilisateur mis à jour avec succès",
  "data": {
    "id": 1,
    "nom": "Jane Doe",
    "email": "jane.doe@example.com",
    "message": "Message mis à jour"
  }
}
```

#### 3. Récupérer un Utilisateur
- **URL** : `GET /users/{id}`
- **Description** : Récupère un utilisateur par son ID
- **Paramètres** : `id` (Long) - ID de l'utilisateur
- **Réponse de Succès (200 OK)** :
```json
{
  "status": "success",
  "message": "Utilisateur récupéré avec succès",
  "data": {
    "id": 1,
    "nom": "John Doe",
    "email": "john.doe@example.com",
    "message": "Bonjour, je suis un nouvel utilisateur"
  }
}
```

#### 4. Récupérer Tous les Utilisateurs
- **URL** : `GET /users/all`
- **Description** : Récupère la liste de tous les utilisateurs
- **Réponse de Succès (200 OK)** :
```json
{
  "status": "success",
  "message": "2 utilisateurs trouvés",
  "data": [
    {
      "id": 1,
      "nom": "John Doe",
      "email": "john.doe@example.com",
      "message": "Bonjour, je suis un nouvel utilisateur"
    },
    {
      "id": 2,
      "nom": "Jane Doe",
      "email": "jane.doe@example.com",
      "message": "Un autre message"
    }
  ]
}
```

#### 5. Supprimer un Utilisateur
- **URL** : `DELETE /users/{id}`
- **Description** : Supprime un utilisateur par son ID
- **Paramètres** : `id` (Long) - ID de l'utilisateur
- **Réponse de Succès (200 OK)** :
```json
{
  "status": "success",
  "message": "Utilisateur supprimé avec succès",
  "data": null
}
```

## Collection Postman

Voici la collection Postman au format JSON pour tester l'API :

```json
{
  "info": {
    "name": "Web Service API",
    "schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json"
  },
  "item": [
    {
      "name": "Créer un Utilisateur",
      "request": {
        "method": "POST",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nom\": \"John Doe\",\n  \"email\": \"john.doe@example.com\",\n  \"message\": \"Bonjour, je suis un nouvel utilisateur\"\n}"
        },
        "url": {
          "raw": "http://localhost:2000/api-webService/users",
          "protocol": "http",
          "host": ["localhost"],
          "port": "2000",
          "path": ["api-webService", "users"]
        }
      }
    },
    {
      "name": "Mettre à Jour un Utilisateur",
      "request": {
        "method": "PUT",
        "header": [
          {
            "key": "Content-Type",
            "value": "application/json"
          }
        ],
        "body": {
          "mode": "raw",
          "raw": "{\n  \"nom\": \"Jane Doe\",\n  \"email\": \"jane.doe@example.com\",\n  \"message\": \"Message mis à jour\"\n}"
        },
        "url": {
          "raw": "http://localhost:2000/api-webService/users/1",
          "protocol": "http",
          "host": ["localhost"],
          "port": "2000",
          "path": ["api-webService", "users", "1"]
        }
      }
    },
    {
      "name": "Récupérer un Utilisateur",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:2000/api-webService/users/1",
          "protocol": "http",
          "host": ["localhost"],
          "port": "2000",
          "path": ["api-webService", "users", "1"]
        }
      }
    },
    {
      "name": "Récupérer Tous les Utilisateurs",
      "request": {
        "method": "GET",
        "header": [],
        "url": {
          "raw": "http://localhost:2000/api-webService/users/all",
          "protocol": "http",
          "host": ["localhost"],
          "port": "2000",
          "path": ["api-webService", "users", "all"]
        }
      }
    },
    {
      "name": "Supprimer un Utilisateur",
      "request": {
        "method": "DELETE",
        "header": [],
        "url": {
          "raw": "http://localhost:2000/api-webService/users/1",
          "protocol": "http",
          "host": ["localhost"],
          "port": "2000",
          "path": ["api-webService", "users", "1"]
        }
      }
    }
  ]
}
```

### Captures Postman
Pour les captures d'écran Postman, veuillez importer la collection ci-dessus dans Postman et exécuter les requêtes. Voici des descriptions textuelles des captures :

1. **Créer un Utilisateur** :
   - Méthode : POST
   - URL : http://localhost:2000/api-webService/users
   - Body : JSON avec nom, email, message
   - Status : 201 Created
   - Response : JSON avec status "success", message, et data contenant l'utilisateur créé

2. **Mettre à Jour un Utilisateur** :
   - Méthode : PUT
   - URL : http://localhost:2000/api-webService/users/1
   - Body : JSON avec les champs mis à jour
   - Status : 200 OK
   - Response : JSON avec status "success" et données mises à jour

3. **Récupérer un Utilisateur** :
   - Méthode : GET
   - URL : http://localhost:2000/api-webService/users/1
   - Status : 200 OK
   - Response : JSON avec l'utilisateur demandé

4. **Récupérer Tous les Utilisateurs** :
   - Méthode : GET
   - URL : http://localhost:2000/api-webService/users/all
   - Status : 200 OK
   - Response : JSON avec la liste de tous les utilisateurs

5. **Supprimer un Utilisateur** :
   - Méthode : DELETE
   - URL : http://localhost:2000/api-webService/users/1
   - Status : 200 OK
   - Response : JSON avec status "success" et message de confirmation

## Modèles de Données

### User
```json
{
  "id": "Long (auto-généré)",
  "nom": "String",
  "email": "String (unique)",
  "message": "String"
}
```

### Responses
```json
{
  "status": "String (success/error)",
  "message": "String",
  "data": "Object (User ou List<User> ou null)"
}
```

## Gestion des Erreurs
Toutes les erreurs sont gérées de manière uniforme avec le modèle `Responses` :
- `status` : "error"
- `message` : Description de l'erreur
- `data` : null

## Tests
Pour exécuter les tests :
```
./mvnw test
```

## Déploiement
Le projet peut être packagé en JAR exécutable :
```
./mvnw clean package
java -jar target/demo-0.0.1-SNAPSHOT.jar
```

Cette documentation couvre tous les aspects demandés : URLs, endpoints, exemples JSON, et captures Postman (via collection JSON et descriptions).
