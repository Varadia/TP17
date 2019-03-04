/* Create - database */
CREATE DATABASE tp17_bdd
CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;


/* Create - table */
CREATE TABLE Categorie(
  idCategorie int(11) NOT NULL AUTO_INCREMENT,
  libelle varchar(64),
  PRIMARY KEY (idCategorie)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE AppartenanceCategorie(
  idTapas int(11), /* FKey */
  idCategorie int(11) /* FKey */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Tapas(
  idTapas int(11) NOT NULL AUTO_INCREMENT,
  nomTapas varchar(64),
  PRIMARY KEY (idTapas)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE ContenanceChoix(
  quantite int(11),
  idTapas int(11), /* FKey */
  idChoix int(11) /* FKey */
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Choix(
  idChoix int(11) NOT NULL AUTO_INCREMENT,
  idClient int(11), /* FKey */
  idCommande int(11), /* FKey */
  PRIMARY KEY (idChoix)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Client(
  idClient int(11) NOT NULL AUTO_INCREMENT,
  pseudo varchar(64),
  couleur varchar(64),
  idGroupe int(11), /* FKey */
  PRIMARY KEY (idClient)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Groupe(
  idGroupe int(11) NOT NULL AUTO_INCREMENT,
  numeroTable int(11),
  PRIMARY KEY (idGroupe)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE Commande(
  idCommande int(11) NOT NULL AUTO_INCREMENT,
  dateCommande date,
  idGroupe int(11), /* FKey */
  PRIMARY KEY (idCommande)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


/* Create - foreign key > AppartenanceCategorie */
ALTER TABLE AppartenanceCategorie
ADD CONSTRAINT AppartenanceCategorie_idTapas
FOREIGN KEY (idTapas)
REFERENCES Tapas(idTapas)
ON DELETE CASCADE;

ALTER TABLE AppartenanceCategorie
ADD CONSTRAINT AppartenanceCategorie_idCategorie
FOREIGN KEY (idCategorie)
REFERENCES Categorie(idCategorie)
ON DELETE CASCADE;

/* Create - foreign key > ContenanceChoix */
ALTER TABLE ContenanceChoix
ADD CONSTRAINT ContenanceChoix_idTapas
FOREIGN KEY (idTapas)
REFERENCES Tapas(idTapas)
ON DELETE CASCADE;

ALTER TABLE ContenanceChoix
ADD CONSTRAINT ContenanceChoix_idChoix
FOREIGN KEY (idChoix)
REFERENCES Choix(idChoix)
ON DELETE CASCADE;

/* Create - foreign key > Choix */
ALTER TABLE Choix
ADD CONSTRAINT Choix_idClient
FOREIGN KEY (idClient)
REFERENCES Client(idClient)
ON DELETE CASCADE;

ALTER TABLE Choix
ADD CONSTRAINT Choix_idCommande
FOREIGN KEY (idCommande)
REFERENCES Commande(idCommande)
ON DELETE CASCADE;

/* Create - foreign key > Client */
ALTER TABLE Client
ADD CONSTRAINT Client_idGroupe
FOREIGN KEY (idGroupe)
REFERENCES Groupe(idGroupe)
ON DELETE CASCADE;

/* Create - foreign key > Commande */
ALTER TABLE Commande
ADD CONSTRAINT Commande_idGroupe
FOREIGN KEY (idGroupe)
REFERENCES Groupe(idGroupe)
ON DELETE CASCADE;