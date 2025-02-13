-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jul 06, 2024 at 02:30 PM
-- Server version: 5.7.24
-- PHP Version: 7.2.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `progettotecweb`
--

-- --------------------------------------------------------

--
-- Table structure for table `acquisto`
--

CREATE TABLE `acquisto` (
  `id_acquisto` bigint(20) NOT NULL,
  `id_articolo` bigint(20) DEFAULT NULL,
  `id_marchio` bigint(20) DEFAULT NULL,
  `id_utente` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acquisto`
--

INSERT INTO `acquisto` (`id_acquisto`, `id_articolo`, `id_marchio`, `id_utente`) VALUES
(1, 2, 2, 202),
(2, 2, 2, 202),
(3, 7, 7, 202),
(4, 18, 3, 202),
(52, 1, 1, 253),
(53, 8, 8, 253);

-- --------------------------------------------------------

--
-- Table structure for table `acquisto_seq`
--

CREATE TABLE `acquisto_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `acquisto_seq`
--

INSERT INTO `acquisto_seq` (`next_val`) VALUES
(151);

-- --------------------------------------------------------

--
-- Table structure for table `articolo`
--

CREATE TABLE `articolo` (
  `id_articolo` bigint(20) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `recensioni` int(11) DEFAULT NULL,
  `id_diz_categoria` bigint(20) DEFAULT NULL,
  `id_diz_colore_lente` bigint(20) DEFAULT NULL,
  `id_diz_colore_montatura` bigint(20) DEFAULT NULL,
  `id_diz_genere` bigint(20) DEFAULT NULL,
  `id_diz_marchio` bigint(20) DEFAULT NULL,
  `descrizione` varchar(255) DEFAULT NULL,
  `foto` varchar(255) DEFAULT NULL,
  `quantita_disponibile` int(11) DEFAULT NULL,
  `prezzo` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articolo`
--

INSERT INTO `articolo` (`id_articolo`, `nome`, `recensioni`, `id_diz_categoria`, `id_diz_colore_lente`, `id_diz_colore_montatura`, `id_diz_genere`, `id_diz_marchio`, `descrizione`, `foto`, `quantita_disponibile`, `prezzo`) VALUES
(1, 'Occhiali da sole Ray-Ban Aviator', 7, 1, 2, 1, 1, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 2, 120),
(2, 'Occhiali da sole Oakley Holbrook', 5, 1, 4, 3, 1, 2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 3, 100),
(3, 'Occhiali da vista Persol PO3012V', 8, 2, 6, 5, 2, 3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 2, 50),
(4, 'Occhiali da vista Gucci GG0038O', 6, 2, 8, 7, 2, 4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 5, 48),
(5, 'Occhiali da sole Prada Linea Rossa', 4, 1, 10, 9, 1, 5, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 5, 50),
(6, 'Occhiali da vista Dolce & Gabbana DG5031', 9, 2, 12, 11, 2, 6, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 4, 50),
(7, 'Occhiali da sole Versace VE4361', 3, 1, 14, 13, 1, 7, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 11, 120),
(8, 'Occhiali da vista Armani EA1041', 2, 2, 1, 15, 2, 8, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 2, 130),
(9, 'Occhiali da sole Maui Jim Breakwall', 6, 1, 12, 11, 1, 9, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 5, 120),
(10, 'Occhiali da vista Bulgari BV4119B', 8, 2, 14, 13, 3, 10, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 1, 200),
(11, 'Occhiali da sole Calvin Klein CK19501S', 1, 1, 1, 15, 1, 11, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 1, 220),
(12, 'Occhiali da vista Michael Kors MK3029', 9, 2, 2, 1, 2, 12, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 4, 120.5),
(13, 'Occhiali da sole Fendi FF 0379/S', 5, 1, 4, 3, 2, 13, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 4, 129.99),
(14, 'Occhiali da vista Burberry BE1334', 7, 2, 6, 5, 3, 14, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 3, 119.98),
(15, 'Occhiali da sole Coach HC7064', 8, 1, 8, 7, 1, 15, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 2, 99.9),
(16, 'Occhiali da vista Ray-Ban RX3447V', 2, 2, 10, 9, 2, 1, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 3, 43.5),
(17, 'Occhiali da sole Oakley Radar EV Path', 3, 1, 12, 11, 3, 2, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 7, 99.9),
(18, 'Occhiali da vista Persol PO6649V', 4, 2, 14, 13, 1, 3, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 9, 49.99),
(19, 'Occhiali da sole Gucci GG0441S', 9, 1, 1, 15, 2, 4, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 11, 39.99),
(20, 'Occhiali da vista Prada PR 11VV', 6, 2, 2, 1, 3, 5, 'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nunc congue nisi vitae suscipit tellus. Turpis nunc eget lorem dolor sed viverra.', NULL, 2, 99.99);

-- --------------------------------------------------------

--
-- Table structure for table `articolo_seq`
--

CREATE TABLE `articolo_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `articolo_seq`
--

INSERT INTO `articolo_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `carrello`
--

CREATE TABLE `carrello` (
  `id_carrello` bigint(20) NOT NULL,
  `id_stato_carrello` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carrello`
--

INSERT INTO `carrello` (`id_carrello`, `id_stato_carrello`) VALUES
(1, 1),
(3, 1);

-- --------------------------------------------------------

--
-- Table structure for table `carrello_articoli`
--

CREATE TABLE `carrello_articoli` (
  `carrello_id_carrello` bigint(20) NOT NULL,
  `articoli_id_articolo` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `carrello_seq`
--

CREATE TABLE `carrello_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `carrello_seq`
--

INSERT INTO `carrello_seq` (`next_val`) VALUES
(101);

-- --------------------------------------------------------

--
-- Table structure for table `diz_categoria`
--

CREATE TABLE `diz_categoria` (
  `id_categoria` bigint(20) NOT NULL,
  `attivo` varchar(1) NOT NULL,
  `desc_categoria` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_categoria`
--

INSERT INTO `diz_categoria` (`id_categoria`, `attivo`, `desc_categoria`) VALUES
(1, 'S', 'Occhiali da sole'),
(2, 'S', 'Occhiali da vista'),
(3, 'S', 'Occhiali sportivi');

-- --------------------------------------------------------

--
-- Table structure for table `diz_categoria_seq`
--

CREATE TABLE `diz_categoria_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_categoria_seq`
--

INSERT INTO `diz_categoria_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `diz_colore`
--

CREATE TABLE `diz_colore` (
  `id_colore` bigint(20) NOT NULL,
  `attivo` varchar(1) NOT NULL,
  `desc_colore` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_colore`
--

INSERT INTO `diz_colore` (`id_colore`, `attivo`, `desc_colore`) VALUES
(1, 'S', 'Nero'),
(2, 'S', 'Bianco'),
(3, 'S', 'Blu'),
(4, 'S', 'Rosso'),
(5, 'S', 'Verde'),
(6, 'S', 'Giallo'),
(7, 'S', 'Grigio'),
(8, 'S', 'Marrone'),
(9, 'S', 'Arancione'),
(10, 'S', 'Rosa'),
(11, 'S', 'Viola'),
(12, 'S', 'Azzurro'),
(13, 'S', 'Beige'),
(14, 'S', 'Oro'),
(15, 'S', 'Argento');

-- --------------------------------------------------------

--
-- Table structure for table `diz_colore_seq`
--

CREATE TABLE `diz_colore_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_colore_seq`
--

INSERT INTO `diz_colore_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `diz_genere`
--

CREATE TABLE `diz_genere` (
  `id_genere` bigint(20) NOT NULL,
  `attivo` varchar(1) NOT NULL,
  `desc_genere` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_genere`
--

INSERT INTO `diz_genere` (`id_genere`, `attivo`, `desc_genere`) VALUES
(1, 'S', 'Maschio'),
(2, 'S', 'Donna'),
(3, 'S', 'N,D.');

-- --------------------------------------------------------

--
-- Table structure for table `diz_genere_seq`
--

CREATE TABLE `diz_genere_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_genere_seq`
--

INSERT INTO `diz_genere_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `diz_marchio`
--

CREATE TABLE `diz_marchio` (
  `id_marchio` bigint(20) NOT NULL,
  `attivo` varchar(1) NOT NULL,
  `desc_marchio` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_marchio`
--

INSERT INTO `diz_marchio` (`id_marchio`, `attivo`, `desc_marchio`) VALUES
(1, 'S', 'Ray-Ban'),
(2, 'S', 'Oakley'),
(3, 'S', 'Persol'),
(4, 'S', 'Gucci'),
(5, 'S', 'Prada'),
(6, 'S', 'Dolce & Gabbana'),
(7, 'S', 'Versace'),
(8, 'S', 'Armani'),
(9, 'S', 'Maui Jim'),
(10, 'S', 'Bulgari'),
(11, 'S', 'Calvin Klein'),
(12, 'S', 'Michael Kors'),
(13, 'S', 'Fendi'),
(14, 'S', 'Burberry'),
(15, 'S', 'Coach');

-- --------------------------------------------------------

--
-- Table structure for table `diz_marchio_seq`
--

CREATE TABLE `diz_marchio_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_marchio_seq`
--

INSERT INTO `diz_marchio_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `diz_stato_carrello`
--

CREATE TABLE `diz_stato_carrello` (
  `id_stato_carrello` bigint(20) NOT NULL,
  `attivo` varchar(1) NOT NULL,
  `desc_stato_carrello` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_stato_carrello`
--

INSERT INTO `diz_stato_carrello` (`id_stato_carrello`, `attivo`, `desc_stato_carrello`) VALUES
(1, 'S', 'Bozza'),
(2, 'N', 'Confermato'),
(3, 'N', 'Ordinato'),
(4, 'N', 'In Consegna'),
(5, 'N', 'Consegnato'),
(6, 'S', 'Acquistato');

-- --------------------------------------------------------

--
-- Table structure for table `diz_stato_carrello_seq`
--

CREATE TABLE `diz_stato_carrello_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_stato_carrello_seq`
--

INSERT INTO `diz_stato_carrello_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `diz_tipologia_utente`
--

CREATE TABLE `diz_tipologia_utente` (
  `id_tipologia_utente` bigint(20) NOT NULL,
  `attivo` varchar(1) NOT NULL,
  `desc_tipologia_utente` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_tipologia_utente`
--

INSERT INTO `diz_tipologia_utente` (`id_tipologia_utente`, `attivo`, `desc_tipologia_utente`) VALUES
(1, 'S', 'Cliente'),
(2, 'S', 'Venditore');

-- --------------------------------------------------------

--
-- Table structure for table `diz_tipologia_utente_seq`
--

CREATE TABLE `diz_tipologia_utente_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `diz_tipologia_utente_seq`
--

INSERT INTO `diz_tipologia_utente_seq` (`next_val`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `utente`
--

CREATE TABLE `utente` (
  `id_utente` bigint(20) NOT NULL,
  `cognome` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `id_carrello` bigint(20) DEFAULT NULL,
  `id_tipologia_utente` bigint(20) DEFAULT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utente`
--

INSERT INTO `utente` (`id_utente`, `cognome`, `email`, `nome`, `password`, `id_carrello`, `id_tipologia_utente`, `username`) VALUES
(202, 'Prova Cognome', 'ProvaUsername', 'Prova Nome', '$2a$10$dgx0YHdSCJ07quNoNLjANucNMfvbgwNg670fWXeNVcfiJ/kFe2viW', 1, 1, 'ProvaUsername'),
(253, 'CognomeProva', 'UsernameDiTest', 'NomeProva1', '$2a$10$xkBGRlA9DXKJZYgAi9qxGOkAXdUZxtHkzkdRVwKqoqGqnTRV2ekB6', 3, 1, 'UsernameDiTest');

-- --------------------------------------------------------

--
-- Table structure for table `utente_acquisti_effettuati`
--

CREATE TABLE `utente_acquisti_effettuati` (
  `utente_id_utente` bigint(20) NOT NULL,
  `acquisti_effettuati_id_acquisto` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utente_acquisti_effettuati`
--

INSERT INTO `utente_acquisti_effettuati` (`utente_id_utente`, `acquisti_effettuati_id_acquisto`) VALUES
(202, 2),
(202, 3),
(202, 4),
(253, 52),
(253, 53);

-- --------------------------------------------------------

--
-- Table structure for table `utente_seq`
--

CREATE TABLE `utente_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `utente_seq`
--

INSERT INTO `utente_seq` (`next_val`) VALUES
(351);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `acquisto`
--
ALTER TABLE `acquisto`
  ADD PRIMARY KEY (`id_acquisto`),
  ADD KEY `FKn660waaor2ec8lf44l5vus553` (`id_articolo`),
  ADD KEY `FKq20qlmij1v04wncv5957dqp7l` (`id_marchio`),
  ADD KEY `FK714ve4qass6e5lruah6w9gj71` (`id_utente`);

--
-- Indexes for table `articolo`
--
ALTER TABLE `articolo`
  ADD PRIMARY KEY (`id_articolo`),
  ADD KEY `FK1ahc7ap25ght5ay30ot66nnwa` (`id_diz_categoria`),
  ADD KEY `FKpourm87lsc1er5lhd8q1houx3` (`id_diz_colore_lente`),
  ADD KEY `FKd86m8vftvx6rs8tj46otnljgk` (`id_diz_colore_montatura`),
  ADD KEY `FKh4xu6aevc3ohp5k8sexchtllg` (`id_diz_genere`),
  ADD KEY `FK6aknkincquvd2yx7w3d2ws680` (`id_diz_marchio`);

--
-- Indexes for table `carrello`
--
ALTER TABLE `carrello`
  ADD PRIMARY KEY (`id_carrello`),
  ADD KEY `FKaa49x0o9wher21q3bqkhsjqgy` (`id_stato_carrello`);

--
-- Indexes for table `carrello_articoli`
--
ALTER TABLE `carrello_articoli`
  ADD UNIQUE KEY `UK_r2t0a9s8xncwllwcn223y9ibx` (`articoli_id_articolo`),
  ADD KEY `FKlff1i31wdu3gfs9c9l3l7svf` (`carrello_id_carrello`);

--
-- Indexes for table `diz_categoria`
--
ALTER TABLE `diz_categoria`
  ADD PRIMARY KEY (`id_categoria`);

--
-- Indexes for table `diz_colore`
--
ALTER TABLE `diz_colore`
  ADD PRIMARY KEY (`id_colore`);

--
-- Indexes for table `diz_genere`
--
ALTER TABLE `diz_genere`
  ADD PRIMARY KEY (`id_genere`);

--
-- Indexes for table `diz_marchio`
--
ALTER TABLE `diz_marchio`
  ADD PRIMARY KEY (`id_marchio`);

--
-- Indexes for table `diz_stato_carrello`
--
ALTER TABLE `diz_stato_carrello`
  ADD PRIMARY KEY (`id_stato_carrello`);

--
-- Indexes for table `diz_tipologia_utente`
--
ALTER TABLE `diz_tipologia_utente`
  ADD PRIMARY KEY (`id_tipologia_utente`);

--
-- Indexes for table `utente`
--
ALTER TABLE `utente`
  ADD PRIMARY KEY (`id_utente`),
  ADD UNIQUE KEY `UK_2vq82crxh3p7upassu0k1kmte` (`username`),
  ADD KEY `FKk4qiyjk45tgmvunurkjfeuf02` (`id_carrello`),
  ADD KEY `FK3a8013hx2ifvu22tksblyf6i1` (`id_tipologia_utente`);

--
-- Indexes for table `utente_acquisti_effettuati`
--
ALTER TABLE `utente_acquisti_effettuati`
  ADD UNIQUE KEY `UK_5qxb5are0aglbnlsbqmk89ypq` (`acquisti_effettuati_id_acquisto`),
  ADD KEY `FKx9cq9ir7qp4sv947bumeuj4q` (`utente_id_utente`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `acquisto`
--
ALTER TABLE `acquisto`
  ADD CONSTRAINT `FK714ve4qass6e5lruah6w9gj71` FOREIGN KEY (`id_utente`) REFERENCES `utente` (`id_utente`),
  ADD CONSTRAINT `FKn660waaor2ec8lf44l5vus553` FOREIGN KEY (`id_articolo`) REFERENCES `articolo` (`id_articolo`),
  ADD CONSTRAINT `FKq20qlmij1v04wncv5957dqp7l` FOREIGN KEY (`id_marchio`) REFERENCES `diz_marchio` (`id_marchio`);

--
-- Constraints for table `articolo`
--
ALTER TABLE `articolo`
  ADD CONSTRAINT `FK1ahc7ap25ght5ay30ot66nnwa` FOREIGN KEY (`id_diz_categoria`) REFERENCES `diz_categoria` (`id_categoria`),
  ADD CONSTRAINT `FK6aknkincquvd2yx7w3d2ws680` FOREIGN KEY (`id_diz_marchio`) REFERENCES `diz_marchio` (`id_marchio`),
  ADD CONSTRAINT `FKd86m8vftvx6rs8tj46otnljgk` FOREIGN KEY (`id_diz_colore_montatura`) REFERENCES `diz_colore` (`id_colore`),
  ADD CONSTRAINT `FKh4xu6aevc3ohp5k8sexchtllg` FOREIGN KEY (`id_diz_genere`) REFERENCES `diz_genere` (`id_genere`),
  ADD CONSTRAINT `FKpourm87lsc1er5lhd8q1houx3` FOREIGN KEY (`id_diz_colore_lente`) REFERENCES `diz_colore` (`id_colore`);

--
-- Constraints for table `carrello`
--
ALTER TABLE `carrello`
  ADD CONSTRAINT `FKaa49x0o9wher21q3bqkhsjqgy` FOREIGN KEY (`id_stato_carrello`) REFERENCES `diz_stato_carrello` (`id_stato_carrello`);

--
-- Constraints for table `carrello_articoli`
--
ALTER TABLE `carrello_articoli`
  ADD CONSTRAINT `FKlc6vbid323ndk0e17o8aml9ct` FOREIGN KEY (`articoli_id_articolo`) REFERENCES `articolo` (`id_articolo`),
  ADD CONSTRAINT `FKlff1i31wdu3gfs9c9l3l7svf` FOREIGN KEY (`carrello_id_carrello`) REFERENCES `carrello` (`id_carrello`);

--
-- Constraints for table `utente`
--
ALTER TABLE `utente`
  ADD CONSTRAINT `FK3a8013hx2ifvu22tksblyf6i1` FOREIGN KEY (`id_tipologia_utente`) REFERENCES `diz_tipologia_utente` (`id_tipologia_utente`),
  ADD CONSTRAINT `FKk4qiyjk45tgmvunurkjfeuf02` FOREIGN KEY (`id_carrello`) REFERENCES `carrello` (`id_carrello`);

--
-- Constraints for table `utente_acquisti_effettuati`
--
ALTER TABLE `utente_acquisti_effettuati`
  ADD CONSTRAINT `FK4ovcbxtcoylsfrnlpnk3m6b2a` FOREIGN KEY (`acquisti_effettuati_id_acquisto`) REFERENCES `acquisto` (`id_acquisto`),
  ADD CONSTRAINT `FKx9cq9ir7qp4sv947bumeuj4q` FOREIGN KEY (`utente_id_utente`) REFERENCES `utente` (`id_utente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
