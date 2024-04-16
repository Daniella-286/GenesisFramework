create database frame ;

\c frame;

create table etudiant (
    id serial primary key,
    nom varchar(100),
    prenom varchar(100)
);

create table professeur (
    id serial primary key,
    nom varchar(100),
    prenom varchar(100)
);

-- Données pour la table etudiant
INSERT INTO etudiant (nom, prenom) VALUES
('Dupont', 'Jean'),
('Martin', 'Sophie'),
('Dubois', 'Pierre'),
('Lefevre', 'Marie');

-- Données pour la table professeur
INSERT INTO professeur (nom, prenom) VALUES
('Leroy', 'Paul'),
('Durand', 'Isabelle'),
('Moreau', 'François'),
('Lefevre', 'Catherine');
