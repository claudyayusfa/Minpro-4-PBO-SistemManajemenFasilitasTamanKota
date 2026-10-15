-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Oct 14, 2026 at 06:22 PM
-- Server version: 8.0.30
-- PHP Version: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fasilitas_taman_kota`
--

-- --------------------------------------------------------

--
-- Table structure for table `fasilitas`
--

CREATE TABLE `fasilitas` (
  `id` int NOT NULL,
  `nama` varchar(100) NOT NULL,
  `kategori` varchar(50) NOT NULL,
  `kondisi` varchar(50) NOT NULL,
  `jumlah` int NOT NULL,
  `jenis` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `fasilitas`
--

INSERT INTO `fasilitas` (`id`, `nama`, `kategori`, `kondisi`, `jumlah`, `jenis`) VALUES
(1, 'Gazebo', 'Umum', 'Baik', 4, 'Tempat Istirahat'),
(2, 'Lapangan Basket', 'Olahraga', 'Baik', 1, 'Basket'),
(4, 'Kursi', 'Umum', 'Cukup', 2, 'Tempat Bermain Anak');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `fasilitas`
--
ALTER TABLE `fasilitas`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `fasilitas`
--
ALTER TABLE `fasilitas`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
