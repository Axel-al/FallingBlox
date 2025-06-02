
# 🧱 FallingBlox

**FallingBlox** est un projet pédagogique de jeu de type Tetris, réalisé en Java avec une architecture MVC claire. Il met en œuvre des concepts avancés de programmation orientée objet, gestion des événements Swing, et manipulation graphique.

## 🎮 Objectif du jeu

Empiler correctement des pièces tombantes (Tetrominos et Pentominos) afin de compléter des lignes horizontales. Lorsqu’une ligne est complète, elle est supprimée et le score du joueur augmente.

---

## 📁 Organisation du projet

- `modele` : Comporte la logique métier (Puits, Piece, Tas…)
- `vue` : Affichage graphique (VuePuits, VueTas, PanneauInformation…)
- `controleur` : Gestion des interactions utilisateur (clavier, souris, gravité…)
- `FallingBloxVersion1` : Point d'entrée de l'application

---

## ⚙️ Fonctionnalités de base

- Déplacement des pièces avec la souris
- Rotation des pièces avec clic gauche/droit
- Affichage dynamique du puits, de la pièce actuelle et de la suivante
- Système de gravité automatique (via `javax.swing.Timer`)

---

## 🚀 Extensions réalisées

Voici la liste des améliorations notables apportées par rapport à l'énoncé de base :

### ✅ Interaction clavier
- Déplacement gauche/droite avec les flèches ← →  
- Chute accélérée avec ↓  
- Rotation antihoraire avec `Q`, horaire avec `D`

### ✅ Système de score
- Affichage d’un score dans le `PanneauInformation`
- +10 points par ligne complète supprimée

### ✅ Accélération de la gravité
- Chaque palier de 5 lignes supprimées (soit 50 pts) augmente la vitesse de chute de 5%
- Vitesse minimale imposée à 50ms

### ✅ Tous les types de pièces
- Intégration de **tous les Tetrominos** et **tous les Pentominos** (avec formes symétriques incluses)
- Support du mode cyclique, aléatoire simple, et aléatoire complet via `UsineDePiece`

### ✅ Suppression dynamique des lignes pleines
- Les lignes complètes du tas sont automatiquement supprimées
- Les éléments au-dessus descendent correctement pour combler les vides

---

## ▶️ Lancer le jeu

Exécuter la classe :

```bash
FallingBloxVersion1
```

### Avec paramètres optionnels :
- Aucun paramètre → Puits vide
- `java FallingBloxVersion1 20` → 20 blocs aléatoires dans le tas initial
- `java FallingBloxVersion1 20 4` → 20 blocs répartis sur 4 lignes en bas du puits

---

## 📌 Auteurs

Projet réalisé dans le cadre du module POO Java à l'ESEO.

---
