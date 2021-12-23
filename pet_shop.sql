-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 22, 2021 at 07:39 AM
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
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id` int(11) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `harga` int(11) NOT NULL,
  `stock` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id`, `nama`, `harga`, `stock`) VALUES
(1, 'Makanan kucing', 20000, 2),
(2, 'Makanan anjing', 21000, 5);

-- --------------------------------------------------------

--
-- Table structure for table `hewan`
--

CREATE TABLE `hewan` (
  `id` int(5) NOT NULL,
  `id_user` int(5) NOT NULL,
  `nama` varchar(15) NOT NULL,
  `tahun_lahir` int(4) NOT NULL,
  `jenis` varchar(15) NOT NULL,
  `breed` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `hewan`
--

INSERT INTO `hewan` (`id`, `id_user`, `nama`, `tahun_lahir`, `jenis`, `breed`) VALUES
(1, 1, 'belang', 2011, 'kucing', 'maung'),
(2, 1, 'belung', 2012, 'anjing', 'husky');

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
(2, 1, 2, '2021-12-22 05:52:16', '2021-12-22 06:51:58', 50000);

-- --------------------------------------------------------

--
-- Table structure for table `history_pembelian`
--

CREATE TABLE `history_pembelian` (
  `id` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `timestamp` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `harga` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

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
(2, 1, 2, '2021-12-22 05:46:12', 14, 180000);

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(5) NOT NULL,
  `username` varchar(15) NOT NULL,
  `email` varchar(15) NOT NULL,
  `password` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `password`) VALUES
(1, 'shirokygerung', 'shiroky@gerung', 'shirokygerung');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id`);

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
-- Indexes for table `history_pembelian`
--
ALTER TABLE `history_pembelian`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_id_user_pembelian` (`id_user`);

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
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `hewan`
--
ALTER TABLE `hewan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `history_grooming`
--
ALTER TABLE `history_grooming`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `history_pembelian`
--
ALTER TABLE `history_pembelian`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `history_penitipan`
--
ALTER TABLE `history_penitipan`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

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
-- Constraints for table `history_pembelian`
--
ALTER TABLE `history_pembelian`
  ADD CONSTRAINT `fk_id_user_pembelian` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`);

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
