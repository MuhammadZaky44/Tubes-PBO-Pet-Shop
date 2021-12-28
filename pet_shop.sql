-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 28, 2021 at 02:01 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 8.0.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `pet_shop`
--

-- --------------------------------------------------------

--
-- Table structure for table `hewan`
--

CREATE TABLE `hewan` (
  `id` int(5) NOT NULL,
  `id_user` int(5) NOT NULL,
  `nama` varchar(15) NOT NULL,
  `tahun_lahir` int(4) NOT NULL,
  `jenis` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hewan`
--

INSERT INTO `hewan` (`id`, `id_user`, `nama`, `tahun_lahir`, `jenis`) VALUES
(1, 1, 'belang', 2011, 'kucing'),
(2, 1, 'blackie', 2014, 'Anjing'),
(4, 2, 'smol', 2016, 'Kucing'),
(5, 2, 'big boss', 2013, 'Kucing'),
(6, 2, 'marshall', 2010, 'Anjing');

-- --------------------------------------------------------

--
-- Table structure for table `history_grooming`
--

CREATE TABLE `history_grooming` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_hewan` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `jam` datetime NOT NULL,
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history_grooming`
--

INSERT INTO `history_grooming` (`id`, `id_user`, `id_hewan`, `timestamp`, `jam`, `harga`) VALUES
(1, 1, 1, '2021-12-22 05:52:16', '2021-12-22 06:51:58', 50000),
(2, 1, 2, '2021-12-22 05:52:16', '2021-12-22 06:51:58', 50000),
(3, 2, 6, '2021-12-27 06:00:01', '2021-12-27 10:00:00', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `history_penitipan`
--

CREATE TABLE `history_penitipan` (
  `id` int(5) NOT NULL,
  `id_user` int(5) NOT NULL,
  `id_hewan` int(5) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `lama_penitipan` int(4) NOT NULL,
  `harga` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `history_penitipan`
--

INSERT INTO `history_penitipan` (`id`, `id_user`, `id_hewan`, `timestamp`, `lama_penitipan`, `harga`) VALUES
(1, 1, 1, '2021-12-22 05:46:12', 7, 90000),
(2, 1, 2, '2021-12-22 05:46:12', 14, 180000),
(3, 2, 6, '2021-12-23 13:30:56', 3, 75000),
(4, 2, 5, '2021-12-27 05:59:16', 3, 75000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(5) NOT NULL,
  `username` varchar(15) NOT NULL,
  `password` varchar(32) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `password`) VALUES
(1, 'shirokygerung', 'shirokygerung'),
(2, 'asd', 'asdasdasd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `hewan`
--
ALTER TABLE `hewan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_user_hewan` (`id_user`);

--
-- Indexes for table `history_grooming`
--
ALTER TABLE `history_grooming`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_user_grooming` (`id_user`),
  ADD KEY `fk_id_hewan_grooming` (`id_hewan`);

--
-- Indexes for table `history_penitipan`
--
ALTER TABLE `history_penitipan`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_user_penitipan` (`id_user`),
  ADD KEY `fk_id_hewan_penitipan` (`id_hewan`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `hewan`
--
ALTER TABLE `hewan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `history_grooming`
--
ALTER TABLE `history_grooming`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `history_penitipan`
--
ALTER TABLE `history_penitipan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `hewan`
--
ALTER TABLE `hewan`
  ADD CONSTRAINT `fk_id_user_hewan` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints for table `history_grooming`
--
ALTER TABLE `history_grooming`
  ADD CONSTRAINT `fk_id_hewan_grooming` FOREIGN KEY (`id_hewan`) REFERENCES `hewan` (`id`),
  ADD CONSTRAINT `fk_id_user_grooming` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

--
-- Constraints for table `history_penitipan`
--
ALTER TABLE `history_penitipan`
  ADD CONSTRAINT `fk_id_hewan_penitipan` FOREIGN KEY (`id_hewan`) REFERENCES `hewan` (`id`),
  ADD CONSTRAINT `fk_id_user_penitipan` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
