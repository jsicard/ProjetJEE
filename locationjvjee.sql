-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Client :  127.0.0.1
-- Généré le :  Mer 24 Octobre 2018 à 08:43
-- Version du serveur :  5.7.14
-- Version de PHP :  5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `locationjvjee`
--

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE `client` (
  `idClient` int(11) NOT NULL,
  `NomC` varchar(50) NOT NULL,
  `PrenomC` varchar(50) NOT NULL,
  `AdresseC` text NOT NULL,
  `carteIdC` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `client`
--

INSERT INTO `client` (`idClient`, `NomC`, `PrenomC`, `AdresseC`, `carteIdC`) VALUES
(1, 'Décamps', 'Margot', '34 Avenue Blabla 86000 Poitiers', NULL),
(2, 'Sicard', 'Jérémy', 'test', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `jeux`
--

CREATE TABLE `jeux` (
  `idJeux` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Auteur` varchar(50) NOT NULL,
  `Resume` text,
  `Prix` int(11) NOT NULL,
  `Note` int(11) DEFAULT NULL,
  `Commentaire` text,
  `Support` varchar(50) NOT NULL,
  `idProprietaire` int(11) NOT NULL,
  `photo` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `jeux`
--

INSERT INTO `jeux` (`idJeux`, `Nom`, `Auteur`, `Resume`, `Prix`, `Note`, `Commentaire`, `Support`, `idProprietaire`, `photo`) VALUES
(1, 'Assassin\'s Creed Odyssey', 'Ubisoft', NULL, 5, NULL, NULL, 'PC', 2, 'ACOPC.jpg'),
(2, 'Assassin\'s Creed Odyssey', 'Ubisoft', NULL, 4, NULL, NULL, 'PS4', 4, 'ACOPS4.jpg'),
(3, 'Spider-Man', 'Insomniac', NULL, 5, NULL, NULL, 'PS4', 4, 'SMPS4.jpg'),
(4, 'Skyrim', 'Bethesda', NULL, 5, NULL, NULL, 'PC', 3, 'SKYPC.jpg'),
(5, 'Shadow of the Tomb Raider', 'Square Enix', NULL, 5, NULL, NULL, 'PC', 3, 'TRPC.jpg'),
(6, 'Gears of War 2', 'Epic Games', NULL, 5, NULL, NULL, 'Xbox 360', 5, 'GOWXBOX.jpg'),
(7, 'Halo 3', 'Bungie', NULL, 2, NULL, NULL, 'Xbox 360', 3, 'H3XBOX.jpg');

-- --------------------------------------------------------

--
-- Structure de la table `loue`
--

CREATE TABLE `loue` (
  `idJeux` int(11) NOT NULL,
  `idClient` int(11) NOT NULL,
  `Duree` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `loue`
--

INSERT INTO `loue` (`idJeux`, `idClient`, `Duree`) VALUES
(3, 2, 3);

-- --------------------------------------------------------

--
-- Structure de la table `propriétaire`
--

CREATE TABLE `propriétaire` (
  `idProprietaire` int(11) NOT NULL,
  `Nom` varchar(50) NOT NULL,
  `Prenom` varchar(50) NOT NULL,
  `Adresse` text NOT NULL,
  `Note` int(11) DEFAULT NULL,
  `Commentaire` text,
  `CarteId` varchar(50) DEFAULT NULL,
  `nomRegion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `propriétaire`
--

INSERT INTO `propriétaire` (`idProprietaire`, `Nom`, `Prenom`, `Adresse`, `Note`, `Commentaire`, `CarteId`, `nomRegion`) VALUES
(2, 'Fenneteau', 'Alexandre', '23 rue du bulbe, 86000, POITIERS', NULL, NULL, 'carteId', 'Nouvelle-Aquitaine'),
(3, 'Décamps', 'Némo', '86 allée des glands, 79000, NIORT', NULL, NULL, 'carteId', 'Nouvelle-Aquitaine'),
(4, 'Henris', 'Charles', '07 rue de l\'enfer, 86000, POITIERS', NULL, NULL, 'carteId', 'Nouvelle-Aquitaine'),
(5, 'Dus', 'Antoine', '88 allée des prunes, 75000, PARIS', NULL, NULL, 'carteId', 'Île-de-France');

-- --------------------------------------------------------

--
-- Structure de la table `region_geo`
--

CREATE TABLE `region_geo` (
  `nomRegion` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `region_geo`
--

INSERT INTO `region_geo` (`nomRegion`) VALUES
('Auvergne-Rhône-Alpes'),
('Bourgogne-Franche-Comté'),
('Bretagne'),
('Centre-Val de Loire'),
('Corse'),
('Grand Est'),
('Hauts-de-France'),
('Île-de-France'),
('Normandie'),
('Nouvelle-Aquitaine'),
('Occitanie'),
('Pays de la Loire'),
('Provence-Alpes-Côte d\'Azur');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `client`
--
ALTER TABLE `client`
  ADD PRIMARY KEY (`idClient`);

--
-- Index pour la table `jeux`
--
ALTER TABLE `jeux`
  ADD PRIMARY KEY (`idJeux`),
  ADD KEY `idProprietaire` (`idProprietaire`);

--
-- Index pour la table `loue`
--
ALTER TABLE `loue`
  ADD PRIMARY KEY (`idJeux`,`idClient`),
  ADD KEY `idClient` (`idClient`),
  ADD KEY `idJeux` (`idJeux`);

--
-- Index pour la table `propriétaire`
--
ALTER TABLE `propriétaire`
  ADD PRIMARY KEY (`idProprietaire`),
  ADD KEY `nomRegion` (`nomRegion`);

--
-- Index pour la table `region_geo`
--
ALTER TABLE `region_geo`
  ADD PRIMARY KEY (`nomRegion`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `client`
--
ALTER TABLE `client`
  MODIFY `idClient` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT pour la table `jeux`
--
ALTER TABLE `jeux`
  MODIFY `idJeux` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- AUTO_INCREMENT pour la table `propriétaire`
--
ALTER TABLE `propriétaire`
  MODIFY `idProprietaire` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `jeux`
--
ALTER TABLE `jeux`
  ADD CONSTRAINT `fk_idProprietaire` FOREIGN KEY (`idProprietaire`) REFERENCES `propriétaire` (`idProprietaire`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `loue`
--
ALTER TABLE `loue`
  ADD CONSTRAINT `fk_idClient` FOREIGN KEY (`idClient`) REFERENCES `client` (`idClient`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_idJeux` FOREIGN KEY (`idJeux`) REFERENCES `jeux` (`idJeux`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `propriétaire`
--
ALTER TABLE `propriétaire`
  ADD CONSTRAINT `fk_nomRegion` FOREIGN KEY (`nomRegion`) REFERENCES `region_geo` (`nomRegion`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
