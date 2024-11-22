-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: baotrimaylanh
-- ------------------------------------------------------
-- Server version	8.0.36

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `account` (
  `username` varchar(255) NOT NULL,
  `is_active` bit(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `role_id` bigint DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `FKd4vb66o896tay3yy52oqxr9w0` (`role_id`),
  CONSTRAINT `FKd4vb66o896tay3yy52oqxr9w0` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES ('androidx.appcompat.widget.AppCompatEditText{5cd5eb VFED..CL. ......I. 0,0-0,0 #7f0800b2 app:id/edtUsername}',_binary '','$2a$10$hTRv9Svyqu61Xe/XekC/beC5OhCbLd7PUFNvpmTWqZmb6zQPre7xC',3),('customer1',_binary '','$2a$10$p8PuVuUBwok8WXmHqRX18uS3v/2NfaBZdSmsRY8c91RNIk05c6Em6',3),('customer2',_binary '','$2a$10$vJNrrQQ2SQB6iNuqmwyWOuCyICUPwNShf1CWHgJn5FWf4SHTKYw4m',3),('customertest',_binary '','$2a$10$hUh9hxKMZGpyreFcWJCwMuVoOoc.2XPMs8sRAZuzMJM9ZO2zPlOrq',3),('ltq',_binary '','$2a$10$555I4JiADMuJX7Z4bm.Rle88ULgRTJV3hrSd9fPrLLHomOMWxf0aG',3),('luong',_binary '','$2a$10$NJOCe3RScASK0oL4vJoGpOuX7YvDLvFcN9Owshpz7188Co5JJEfku',3),('Luong Thanh Quy',_binary '','$2a$10$.51XgJNiqMubE3QgEY7TIOdHMDBNdvywSX6KFeLt5B5kabm8k7W9i',3),('Luong Thanh Quy 1',_binary '','$2a$10$N8atRZdq8qGOezqLdVIzguQKfD26MHKvO.yaI4.yKzgpLSptt8RVi',3),('nhanvien1',_binary '','$2a$10$K.KNb9XXy.T5Pp4lKkuMZuTfx4./tCY.rU4G3bx9DBXKeGM1ldaUu',2),('NV 3',_binary '','$2a$10$gV5zEqB8sGdRsoLlk6vTreeflqXB38ix4XdfhOpZr1zZ1psbCWhaW',2),('NV Quy',_binary '','$2a$10$FblwePWHqO8G.nDalrNuZOUJud4morwRL2GCVtY8sJPTkDQp6mCui',2),('QL Quy',_binary '','$2a$10$717ThaBnn6CT/DhiGAD/SuY3UMa7Jyd7BpPtGSuf4VYsPBT4swFVi',1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth_year` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKirnrrncatp2fvw52vp45j7rlw` (`username`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  CONSTRAINT `FKsn7i4emc8fm44n66ge5ulpfio` FOREIGN KEY (`username`) REFERENCES `account` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'quận 9','2002','Nam','Lương Quý','0385258727','Luong Thanh Quy 1'),(3,'123 Đường ABC, Quận XYZ, Hà Nội','1990','MALE','Nguyễn Văn A','0987654321','customer1'),(6,'quận 7','2000','Nam','Lương Thanh Quý','0385258721','customer2'),(8,'hcm','2002','Nam','lương văn a','012345678','ltq'),(9,'quan 9 man thien','2002','Nam','quy','0987654','luong'),(10,'quận 7','2000','Nam','Lương Thanh Thanh','0385958721','customertest');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dich_vu`
--

DROP TABLE IF EXISTS `dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dich_vu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `common_price` varchar(255) DEFAULT NULL,
  `is_fixed_price` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dich_vu`
--

LOCK TABLES `dich_vu` WRITE;
/*!40000 ALTER TABLE `dich_vu` DISABLE KEYS */;
INSERT INTO `dich_vu` VALUES (6,'Lắp đặt máy lạnh treo tường','500.000',_binary ''),(7,'Bảo trì máy lạnh âm trần','600.000',_binary ''),(10,'Dịch vụ vệ sinh',NULL,_binary '\0'),(11,'Nén Ni tơ','300.000',_binary ''),(12,'Thay lồng sóc','800.000',_binary '\0'),(13,'Gói Dịch Vụ Bảo Trì Máy Lạnh Treo Tường Pro 1 Năm','1.650.000',_binary '');
/*!40000 ALTER TABLE `dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `don_gia`
--

DROP TABLE IF EXISTS `don_gia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `don_gia` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `price` double DEFAULT NULL,
  `ma_goi_dich_vu` bigint DEFAULT NULL,
  `ma_loai_may_lanh` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKp6c3w43qqsntsm2grcj5lnfnv` (`ma_goi_dich_vu`,`ma_loai_may_lanh`),
  KEY `FKb3db6udsk4bkst0ni5wpkxssw` (`ma_loai_may_lanh`),
  CONSTRAINT `FKb3db6udsk4bkst0ni5wpkxssw` FOREIGN KEY (`ma_loai_may_lanh`) REFERENCES `loai_may_lanh` (`id`),
  CONSTRAINT `FKim8b3c3b8o89befvlpa6g8u6n` FOREIGN KEY (`ma_goi_dich_vu`) REFERENCES `goi_dich_vu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `don_gia`
--

LOCK TABLES `don_gia` WRITE;
/*!40000 ALTER TABLE `don_gia` DISABLE KEYS */;
INSERT INTO `don_gia` VALUES (1,100000,2,2),(2,200000,2,3),(4,300000,2,4),(5,200000,3,2),(6,200000,3,3),(7,400000,3,4),(8,400000,4,2),(9,400000,4,3),(10,400000,4,4);
/*!40000 ALTER TABLE `don_gia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `birth_year` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `id_card` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UKim8flsuftl52etbhgnr62d6wh` (`username`),
  UNIQUE KEY `phone_number_UNIQUE` (`phone_number`),
  UNIQUE KEY `id_card_UNIQUE` (`id_card`),
  CONSTRAINT `FKfyykgcnyif1w8n02bn82vl4yv` FOREIGN KEY (`username`) REFERENCES `account` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (1,'quận 9','2002','Nam','072202000002','Lương Thanh QUý','0385258727','QL Quy'),(2,'123 Đường ABC, Quận XYZ, Hà Nội','1990','Nam','072202000001','Nguyễn Văn B','0987654321','NV Quy'),(4,'quận 8','2000','Nam','072202000028','NGuyễn Văn D','0386258751','NV 3'),(5,'quận 7','2000','Nam','50051','Lương Thanh','0385558721','nhanvien1');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gia_dich_vu`
--

DROP TABLE IF EXISTS `gia_dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `gia_dich_vu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `price` varchar(255) DEFAULT NULL,
  `dich_vu_id` bigint NOT NULL,
  `loai_may_lanh_id` bigint NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKk5snqa23f82xbkkgv655wfn3l` (`dich_vu_id`),
  KEY `FKe5ov9b4g4p2clqaeokoac6km2` (`loai_may_lanh_id`),
  CONSTRAINT `FKe5ov9b4g4p2clqaeokoac6km2` FOREIGN KEY (`loai_may_lanh_id`) REFERENCES `loai_may_lanh` (`id`),
  CONSTRAINT `FKk5snqa23f82xbkkgv655wfn3l` FOREIGN KEY (`dich_vu_id`) REFERENCES `dich_vu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gia_dich_vu`
--

LOCK TABLES `gia_dich_vu` WRITE;
/*!40000 ALTER TABLE `gia_dich_vu` DISABLE KEYS */;
INSERT INTO `gia_dich_vu` VALUES (7,'800.000',10,2),(8,'900.000',10,3),(9,'400.000',10,4);
/*!40000 ALTER TABLE `gia_dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `goi_dich_vu`
--

DROP TABLE IF EXISTS `goi_dich_vu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `goi_dich_vu` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `goi_dich_vu`
--

LOCK TABLES `goi_dich_vu` WRITE;
/*!40000 ALTER TABLE `goi_dich_vu` DISABLE KEYS */;
INSERT INTO `goi_dich_vu` VALUES (2,'Gói bảo trì tiêu chuẩn','Gói bảo trì bao gồm 15 bước vệ sinh tiêu chuẩn Daikin, có khử khuẩn bằng hơi nước nóng.Các thao tác bảo trì tiêu chuẩn Daikin làm sạch, loại bỏ mọi bụi bẩn, đặc biệt bước phun hơi nước nóng có thể tiêu diệt virus bên trong máy điều hòa không khí. Kèm theo các bước kiểm tra thông số vận hành đảm bảo máy thực sự được vận hành trong điều kiện tốt nhất.'),(3,'Gói chống vi khuẩn và nấm mốc','Gói dịch vụ bao gồm: Dịch vụ vệ sinh tiêu chuẩn 15 bước - Daikin, có khử khuẩn bằng hơi nước nóng.Phin lọc thô Kirei (Thời gian sử dụng 12 tháng)'),(4,'Gói kháng khuẩn sinh học','Gói dịch vụ bao gồm Dịch vụ vệ sinh tiêu chuẩn 15 bước - Daikin, có khử khuẩn bằng hơi nước nóng.Phin lọc kháng thể sinh học (Thời gian sử dụng 3 tháng).Phin lọc kháng thể sinh học ngăn ngừa vi khuẩn, nấm mốc và loại bỏ nhiều chủng loại virus cúm: chủng A và B (H1N1, H5N1, H7N9...) - Chưa được kiểm nghiệm hiệu quả với virus Corona'),(5,'gói dịch vụ cơ bản','TEST CHỨC NĂNG'),(6,'gói test','test tạo gói'),(7,'gói mới','dịch vụ'),(8,'gói dịch vụ test api','test api');
/*!40000 ALTER TABLE `goi_dich_vu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lich_su_hoa_don`
--

DROP TABLE IF EXISTS `lich_su_hoa_don`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lich_su_hoa_don` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `ngay_thanh_toan` date DEFAULT NULL,
  `tong_tien` double DEFAULT NULL,
  `thong_tin_dat_lich_id` bigint DEFAULT NULL,
  `trang_thai_thanh_toan` int NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK1304onsn9ru1lkrvffr0e3nxx` (`thong_tin_dat_lich_id`),
  CONSTRAINT `FKlnb80vbr0cp98v7vga1r8t00s` FOREIGN KEY (`thong_tin_dat_lich_id`) REFERENCES `thong_tin_dat_lich` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=52 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lich_su_hoa_don`
--

LOCK TABLES `lich_su_hoa_don` WRITE;
/*!40000 ALTER TABLE `lich_su_hoa_don` DISABLE KEYS */;
INSERT INTO `lich_su_hoa_don` VALUES (21,'2024-08-04',200000,68,1),(23,'2024-08-05',400000,70,1),(24,'2024-08-05',400000,71,1),(25,'2024-08-05',100000,72,1),(26,NULL,200000,73,0),(27,'2024-08-06',400000,74,1),(28,NULL,200000,75,0),(29,NULL,300000,76,0),(30,NULL,200000,77,0),(31,'2024-08-08',300000,78,1),(32,'2024-08-09',400000,79,1),(33,NULL,400000,80,0),(34,'2024-08-09',400000,84,1),(36,NULL,200000,86,0),(38,'2024-08-09',100000,89,1),(39,'2024-08-09',200000,90,1),(40,NULL,400000,91,0),(41,NULL,100000,92,0),(42,'2024-08-10',200000,93,1),(43,NULL,300000,94,0),(44,'2024-08-10',200000,96,1),(45,NULL,400000,97,0),(46,NULL,100000,98,0),(47,NULL,100000,99,0),(48,NULL,200000,101,0),(49,'2024-10-14',200000,103,1),(50,NULL,200000,104,0),(51,NULL,400000,105,0);
/*!40000 ALTER TABLE `lich_su_hoa_don` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_may_lanh`
--

DROP TABLE IF EXISTS `loai_may_lanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_may_lanh` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_may_lanh`
--

LOCK TABLES `loai_may_lanh` WRITE;
/*!40000 ALTER TABLE `loai_may_lanh` DISABLE KEYS */;
INSERT INTO `loai_may_lanh` VALUES (2,'Máy lạnh đứng'),(3,'Máy lạnh trần '),(4,'Máy lạnh âm tường ');
/*!40000 ALTER TABLE `loai_may_lanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhan_xet`
--

DROP TABLE IF EXISTS `nhan_xet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhan_xet` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `comment` varchar(255) DEFAULT NULL,
  `start` int NOT NULL,
  `ma_khach_hang` bigint DEFAULT NULL,
  `ma_goi_dich_vu` bigint DEFAULT NULL,
  `label` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK6idqtxr419ituuv8n5gktfgq3` (`ma_khach_hang`),
  KEY `FKr4jl6fotvnk3xtsoeashdi47v` (`ma_goi_dich_vu`),
  CONSTRAINT `FK6idqtxr419ituuv8n5gktfgq3` FOREIGN KEY (`ma_khach_hang`) REFERENCES `customer` (`id`),
  CONSTRAINT `FKr4jl6fotvnk3xtsoeashdi47v` FOREIGN KEY (`ma_goi_dich_vu`) REFERENCES `goi_dich_vu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhan_xet`
--

LOCK TABLES `nhan_xet` WRITE;
/*!40000 ALTER TABLE `nhan_xet` DISABLE KEYS */;
INSERT INTO `nhan_xet` VALUES (14,'dịch vụ tốt',5,1,2,'tích cực'),(16,'dịch vụ tốt máy lạnh của tôi không còn rò rỉ nước nữa',5,1,2,'tiêu cực'),(17,'dịch vụ tốt máy lạnh của tôi không còn rò rỉ nước nữa',5,1,2,'tiêu cực'),(18,'dịch vụ tốt máy lạnh của tôi không còn rò rỉ nước nữa',5,1,2,'tiêu cực'),(19,'dịch vụ tốt',5,1,2,'tích cực'),(20,'dịch vụ rất tốt',5,1,3,'tích cực'),(22,'dịch vụ bình thường',5,1,3,'trung tính'),(23,'tốt',5,3,2,'tích cực');
/*!40000 ALTER TABLE `nhan_xet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phan_cong`
--

DROP TABLE IF EXISTS `phan_cong`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phan_cong` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `trang_thai` enum('CHO_XAC_NHAN','DANG_THUC_HIEN','DA_DONG_Y','HOAN_THANH','TU_CHOI') DEFAULT NULL,
  `ma_nhan_vien` bigint NOT NULL,
  `ma_dat_lich` bigint NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `UK13bypxl6crmhvnsh6vdkpq0s1` (`ma_dat_lich`,`ma_nhan_vien`),
  KEY `FKlvf5yual4l3mpxy42gxtg5a22` (`ma_nhan_vien`),
  CONSTRAINT `FK7rog53lsxs8d4mf4ew5j7mtan` FOREIGN KEY (`ma_dat_lich`) REFERENCES `thong_tin_dat_lich` (`id`),
  CONSTRAINT `FKlvf5yual4l3mpxy42gxtg5a22` FOREIGN KEY (`ma_nhan_vien`) REFERENCES `employee` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phan_cong`
--

LOCK TABLES `phan_cong` WRITE;
/*!40000 ALTER TABLE `phan_cong` DISABLE KEYS */;
INSERT INTO `phan_cong` VALUES (10,'HOAN_THANH',4,68),(12,'CHO_XAC_NHAN',2,70),(13,'HOAN_THANH',4,70),(14,'HOAN_THANH',4,71),(15,'HOAN_THANH',4,72),(16,'HOAN_THANH',4,74),(17,'HOAN_THANH',4,78),(18,'HOAN_THANH',4,79),(19,'HOAN_THANH',4,84),(21,'CHO_XAC_NHAN',5,86),(22,'HOAN_THANH',4,89),(23,'HOAN_THANH',4,90),(24,'CHO_XAC_NHAN',5,91),(25,'HOAN_THANH',5,93),(26,'HOAN_THANH',5,96),(27,'HOAN_THANH',4,103),(28,'CHO_XAC_NHAN',5,104);
/*!40000 ALTER TABLE `phan_cong` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `role`
--

DROP TABLE IF EXISTS `role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `role` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `role`
--

LOCK TABLES `role` WRITE;
/*!40000 ALTER TABLE `role` DISABLE KEYS */;
INSERT INTO `role` VALUES (1,'ADMIN'),(2,'EMPLOYEE'),(3,'CUSTOMER');
/*!40000 ALTER TABLE `role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `thong_tin_dat_lich`
--

DROP TABLE IF EXISTS `thong_tin_dat_lich`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `thong_tin_dat_lich` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `dia_chi_thuc_hien` varchar(255) DEFAULT NULL,
  `ngay_dat` date DEFAULT NULL,
  `trang_thai_duyet` int NOT NULL,
  `id_khach` bigint DEFAULT NULL,
  `ma_don_gia` bigint DEFAULT NULL,
  `ngay_thuc_hien` date DEFAULT NULL,
  `ma_quan_ly` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_khach_don_gia_ngay` (`id_khach`,`ma_don_gia`,`ngay_thuc_hien`),
  UNIQUE KEY `UKklmpt01kwtghawr8ln7t5t7yf` (`dia_chi_thuc_hien`,`ma_don_gia`,`id_khach`),
  KEY `FK9nrr0g5p96l3ghjbuen0rjbdy` (`ma_don_gia`),
  KEY `FK7od9epgwr8wuhy4l9lcx4wjuh` (`ma_quan_ly`),
  CONSTRAINT `FK125vvd1e7frxfmnepvkp99x3v` FOREIGN KEY (`id_khach`) REFERENCES `customer` (`id`),
  CONSTRAINT `FK7od9epgwr8wuhy4l9lcx4wjuh` FOREIGN KEY (`ma_quan_ly`) REFERENCES `employee` (`id`),
  CONSTRAINT `FK9nrr0g5p96l3ghjbuen0rjbdy` FOREIGN KEY (`ma_don_gia`) REFERENCES `don_gia` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=106 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `thong_tin_dat_lich`
--

LOCK TABLES `thong_tin_dat_lich` WRITE;
/*!40000 ALTER TABLE `thong_tin_dat_lich` DISABLE KEYS */;
INSERT INTO `thong_tin_dat_lich` VALUES (68,'77 man thiện','2024-08-04',2,1,2,'2024-08-05',1),(70,'100 man thiện','2024-08-05',2,1,10,'2024-08-07',1),(71,'quan 9 ','2024-08-05',2,9,9,'2024-08-14',1),(72,'ppp','2024-08-05',2,9,1,'2024-08-07',1),(73,'a','2024-08-05',2,9,6,'2024-08-06',1),(74,'a','2024-08-05',2,9,7,'2024-08-06',1),(75,'test dl','2024-08-08',2,9,6,'2024-08-15',1),(76,'tesy','2024-08-08',2,9,4,'2024-08-15',1),(77,'test ti','2024-08-08',3,9,6,'2024-08-09',1),(78,'tttt','2024-08-08',2,9,4,'2024-08-09',1),(79,'ty','2024-08-08',2,9,7,'2024-08-23',1),(80,'97 man thiện tp hcm','2024-08-08',3,9,8,'2024-08-09',1),(84,'97 man thiện q9 tp hcm thủ đức','2024-08-08',2,9,9,'2024-08-09',1),(85,'test tu choi phan cong','2024-08-08',2,9,10,'2024-08-10',1),(86,'88 man thiện thủ đức','2024-08-08',2,10,2,'2024-08-09',1),(88,'55 man thiện','2024-08-09',3,9,9,'2024-08-10',1),(89,'21 man thiện','2024-08-09',2,9,1,'2024-08-11',1),(90,'33 man thiện','2024-08-09',2,10,2,'2024-08-18',1),(91,'99 man thiện','2024-08-09',2,10,8,'2024-08-10',1),(92,'109 man thiện','2024-08-10',3,10,1,'2024-08-11',1),(93,'110 man thiện','2024-08-10',2,10,2,'2024-08-12',1),(94,'123 man thiện','2024-08-10',3,10,4,'2024-08-11',1),(96,'234 man thiện','2024-08-10',2,10,5,'2024-08-16',1),(97,'111 man thiện','2024-08-10',3,10,9,'2024-08-15',1),(98,'111 mm','2024-08-12',3,10,1,'2024-08-13',1),(99,'222 mm','2024-08-12',3,10,1,'2024-08-14',1),(101,'333 mm','2024-08-12',3,10,2,'2024-08-14',1),(103,'112 man thiện','2024-08-12',2,10,2,'2024-08-15',1),(104,'555 man thiện','2024-08-12',2,10,6,'2024-08-15',1),(105,'222 man thien','2024-08-12',2,10,9,'2024-08-14',1);
/*!40000 ALTER TABLE `thong_tin_dat_lich` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-11-22 20:46:39
