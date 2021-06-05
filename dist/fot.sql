-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: May 18, 2020 at 08:53 PM
-- Server version: 5.7.26
-- PHP Version: 7.2.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fot`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `Admin_Id` varchar(12) NOT NULL,
  `Admin_Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Admin_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ass_marks_c`
--

DROP TABLE IF EXISTS `ass_marks_c`;
CREATE TABLE IF NOT EXISTS `ass_marks_c` (
  `Stu_id` varchar(12) NOT NULL,
  `A1` int(11) NOT NULL,
  `A2` int(11) NOT NULL,
  `A3` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ass_marks_cl`
--

DROP TABLE IF EXISTS `ass_marks_cl`;
CREATE TABLE IF NOT EXISTS `ass_marks_cl` (
  `Stu_id` varchar(12) NOT NULL,
  `A1` int(11) NOT NULL,
  `A2` int(11) NOT NULL,
  `A3` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ass_marks_dbms`
--

DROP TABLE IF EXISTS `ass_marks_dbms`;
CREATE TABLE IF NOT EXISTS `ass_marks_dbms` (
  `Stu_id` varchar(12) NOT NULL,
  `A1` int(11) NOT NULL,
  `A2` int(11) NOT NULL,
  `A3` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `ass_marks_ooad`
--

DROP TABLE IF EXISTS `ass_marks_ooad`;
CREATE TABLE IF NOT EXISTS `ass_marks_ooad` (
  `Stu_id` varchar(12) NOT NULL,
  `A1` int(11) NOT NULL,
  `A2` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `attendence`
--

DROP TABLE IF EXISTS `attendence`;
CREATE TABLE IF NOT EXISTS `attendence` (
  `Att_Index` int(3) NOT NULL,
  `Stu_Id` varchar(12) DEFAULT NULL,
  `Tot_Days` int(3) DEFAULT NULL,
  PRIMARY KEY (`Att_Index`),
  KEY `Stu_Id` (`Stu_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course_c`
--

DROP TABLE IF EXISTS `course_c`;
CREATE TABLE IF NOT EXISTS `course_c` (
  `Lecture_id` int(11) NOT NULL,
  `Lecture_Name` varchar(100) NOT NULL,
  `Lecture_Hours` int(11) NOT NULL,
  `Practical_Hours` int(11) NOT NULL,
  `Resources` longblob NOT NULL,
  `Week_Number` int(11) NOT NULL,
  PRIMARY KEY (`Lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course_cl`
--

DROP TABLE IF EXISTS `course_cl`;
CREATE TABLE IF NOT EXISTS `course_cl` (
  `Lecture_id` int(11) NOT NULL,
  `Lecture_Name` varchar(100) NOT NULL,
  `Lecture_Hours` int(11) NOT NULL,
  `Practical_Hours` int(11) NOT NULL,
  `Resources` longblob NOT NULL,
  `Week_Number` int(11) NOT NULL,
  PRIMARY KEY (`Lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course_dbms`
--

DROP TABLE IF EXISTS `course_dbms`;
CREATE TABLE IF NOT EXISTS `course_dbms` (
  `Lecture_id` int(11) NOT NULL,
  `Lecture_Name` varchar(100) NOT NULL,
  `Lecture_Hours` int(11) NOT NULL,
  `Practical_Hours` int(11) NOT NULL,
  `Resources` longblob NOT NULL,
  `Week_Number` int(11) NOT NULL,
  PRIMARY KEY (`Lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `course_dbms`
--

INSERT INTO `course_dbms` (`Lecture_id`, `Lecture_Name`, `Lecture_Hours`, `Practical_Hours`, `Resources`, `Week_Number`) VALUES
(1, 'kayal', 2, 2, 0x433a5c55736572735c53756a616e5c4465736b746f705c4e616d652e646f6378, 1);

-- --------------------------------------------------------

--
-- Table structure for table `course_java`
--

DROP TABLE IF EXISTS `course_java`;
CREATE TABLE IF NOT EXISTS `course_java` (
  `Lecture_id` int(11) NOT NULL,
  `Lecture_Name` varchar(100) NOT NULL,
  `Lecture_Hours` int(11) NOT NULL,
  `Practical_Hours` int(11) NOT NULL,
  `Resources` longblob NOT NULL,
  `Week_Number` int(11) NOT NULL,
  PRIMARY KEY (`Lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course_ooad`
--

DROP TABLE IF EXISTS `course_ooad`;
CREATE TABLE IF NOT EXISTS `course_ooad` (
  `Lecture_id` int(11) NOT NULL,
  `Lecture_Name` varchar(100) NOT NULL,
  `Lecture_Hours` int(11) NOT NULL,
  `Practical_Hours` int(11) NOT NULL,
  `Resources` longblob NOT NULL,
  `Week_Number` int(11) NOT NULL,
  PRIMARY KEY (`Lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `course_webt`
--

DROP TABLE IF EXISTS `course_webt`;
CREATE TABLE IF NOT EXISTS `course_webt` (
  `Lecture_id` int(11) NOT NULL,
  `Lecture_Name` varchar(100) NOT NULL,
  `Lecture_Hours` int(11) NOT NULL,
  `Practical_Hours` int(11) NOT NULL,
  `Resources` longblob NOT NULL,
  `Week_Number` int(11) NOT NULL,
  PRIMARY KEY (`Lecture_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `dean`
--

DROP TABLE IF EXISTS `dean`;
CREATE TABLE IF NOT EXISTS `dean` (
  `Dean_Id` varchar(12) NOT NULL,
  `Dean_Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Dean_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `Department_Name` varchar(50) NOT NULL,
  `Department_Head` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Department_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_marks_c`
--

DROP TABLE IF EXISTS `final_marks_c`;
CREATE TABLE IF NOT EXISTS `final_marks_c` (
  `Stu_id` varchar(12) NOT NULL,
  `Final_prac_Marks` int(11) NOT NULL,
  `Final_theory_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_marks_cl`
--

DROP TABLE IF EXISTS `final_marks_cl`;
CREATE TABLE IF NOT EXISTS `final_marks_cl` (
  `Stu_id` varchar(12) NOT NULL,
  `Final_prac_Marks` int(11) NOT NULL,
  `Final_theory_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_marks_dbms`
--

DROP TABLE IF EXISTS `final_marks_dbms`;
CREATE TABLE IF NOT EXISTS `final_marks_dbms` (
  `Stu_id` varchar(12) NOT NULL,
  `Final_prac_Marks` int(11) NOT NULL,
  `Final_theory_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_marks_java`
--

DROP TABLE IF EXISTS `final_marks_java`;
CREATE TABLE IF NOT EXISTS `final_marks_java` (
  `Stu_id` varchar(12) NOT NULL,
  `Final_prac_Marks` int(11) NOT NULL,
  `Final_theory_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_marks_ooad`
--

DROP TABLE IF EXISTS `final_marks_ooad`;
CREATE TABLE IF NOT EXISTS `final_marks_ooad` (
  `Stu_id` varchar(12) NOT NULL,
  `Final_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_marks_webt`
--

DROP TABLE IF EXISTS `final_marks_webt`;
CREATE TABLE IF NOT EXISTS `final_marks_webt` (
  `Stu_id` varchar(12) NOT NULL,
  `Final_prac_Marks` int(11) NOT NULL,
  `Final_theory_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_result_c`
--

DROP TABLE IF EXISTS `final_result_c`;
CREATE TABLE IF NOT EXISTS `final_result_c` (
  `Stu_id` varchar(12) NOT NULL,
  `Quiz` int(11) NOT NULL,
  `Assessment` int(11) NOT NULL,
  `FinalMarks` int(11) NOT NULL,
  `Grade` varchar(2) NOT NULL,
  `GPA` float NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_result_cl`
--

DROP TABLE IF EXISTS `final_result_cl`;
CREATE TABLE IF NOT EXISTS `final_result_cl` (
  `Stu_id` varchar(12) NOT NULL,
  `Quiz` int(11) NOT NULL,
  `Assessment` int(11) NOT NULL,
  `FinalMarks` int(11) NOT NULL,
  `Grade` varchar(2) NOT NULL,
  `GPA` float NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_result_dbms`
--

DROP TABLE IF EXISTS `final_result_dbms`;
CREATE TABLE IF NOT EXISTS `final_result_dbms` (
  `Stu_id` varchar(12) NOT NULL,
  `Quiz` int(11) NOT NULL,
  `Assessment` int(11) NOT NULL,
  `FinalMarks` int(11) NOT NULL,
  `Grade` varchar(2) NOT NULL,
  `GPA` float NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_result_java`
--

DROP TABLE IF EXISTS `final_result_java`;
CREATE TABLE IF NOT EXISTS `final_result_java` (
  `Stu_id` varchar(12) NOT NULL,
  `Quiz` int(11) NOT NULL,
  `Mid` int(11) NOT NULL,
  `FinalMarks` int(11) NOT NULL,
  `Grade` varchar(2) NOT NULL,
  `GPA` float NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_result_ooad`
--

DROP TABLE IF EXISTS `final_result_ooad`;
CREATE TABLE IF NOT EXISTS `final_result_ooad` (
  `Stu_id` varchar(12) NOT NULL,
  `Quiz` int(11) NOT NULL,
  `Assessment` int(11) NOT NULL,
  `Mid` int(11) NOT NULL,
  `FinalMarks` int(11) NOT NULL,
  `Grade` varchar(2) NOT NULL,
  `GPA` float NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `final_result_webt`
--

DROP TABLE IF EXISTS `final_result_webt`;
CREATE TABLE IF NOT EXISTS `final_result_webt` (
  `Stu_id` varchar(12) NOT NULL,
  `Quiz` int(11) NOT NULL,
  `Mid` int(11) NOT NULL,
  `FinalMarks` int(11) NOT NULL,
  `Grade` varchar(2) NOT NULL,
  `GPA` float NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `instructors`
--

DROP TABLE IF EXISTS `instructors`;
CREATE TABLE IF NOT EXISTS `instructors` (
  `Instructor_Id` varchar(12) NOT NULL,
  `Instructor_Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Instructor_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `lecturers`
--

DROP TABLE IF EXISTS `lecturers`;
CREATE TABLE IF NOT EXISTS `lecturers` (
  `Lecturer_Id` varchar(12) NOT NULL,
  `Lecturer_Name` varchar(50) DEFAULT NULL,
  `Department_name` varchar(50) DEFAULT NULL,
  `Subject` varchar(50) DEFAULT NULL,
  `Email` varchar(100) NOT NULL,
  `Phone_Number` varchar(12) NOT NULL,
  `Address` varchar(200) NOT NULL,
  `image` longblob NOT NULL,
  PRIMARY KEY (`Lecturer_Id`),
  KEY `Department_name` (`Department_name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medical`
--

DROP TABLE IF EXISTS `medical`;
CREATE TABLE IF NOT EXISTS `medical` (
  `Medical_NO` varchar(4) NOT NULL,
  `Stu_Id` varchar(12) DEFAULT NULL,
  `Type` char(10) DEFAULT NULL,
  `Medical_Date` date DEFAULT NULL,
  `Sub_code` char(8) DEFAULT NULL,
  PRIMARY KEY (`Medical_NO`),
  KEY `Stu_Id` (`Stu_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mid_marks_java`
--

DROP TABLE IF EXISTS `mid_marks_java`;
CREATE TABLE IF NOT EXISTS `mid_marks_java` (
  `Stu_id` varchar(12) NOT NULL,
  `Mid_prac_Marks` int(11) NOT NULL,
  `Mid_theory_marks` int(11) NOT NULL,
  `Mid_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mid_marks_ooad`
--

DROP TABLE IF EXISTS `mid_marks_ooad`;
CREATE TABLE IF NOT EXISTS `mid_marks_ooad` (
  `Stu_id` varchar(12) NOT NULL,
  `Mid_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `mid_marks_webt`
--

DROP TABLE IF EXISTS `mid_marks_webt`;
CREATE TABLE IF NOT EXISTS `mid_marks_webt` (
  `Stu_id` varchar(12) NOT NULL,
  `Mid_prac_Marks` int(11) NOT NULL,
  `Mid_theory_marks` int(11) NOT NULL,
  `Mid_Marks` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `notice`
--

DROP TABLE IF EXISTS `notice`;
CREATE TABLE IF NOT EXISTS `notice` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `Title` varchar(100) NOT NULL,
  `Date` varchar(20) NOT NULL,
  `Notice` longblob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `notice`
--

INSERT INTO `notice` (`id`, `Title`, `Date`, `Notice`) VALUES
(1, 'test', '5/11/20', 0x68656c6c6f20776f726c642e2e2e2e);

-- --------------------------------------------------------

--
-- Table structure for table `prac_attendence`
--

DROP TABLE IF EXISTS `prac_attendence`;
CREATE TABLE IF NOT EXISTS `prac_attendence` (
  `Stu_Id` char(10) DEFAULT NULL,
  `ICT1213_P` int(3) DEFAULT NULL,
  `ICT1232_P` int(3) DEFAULT NULL,
  `ICT1233_P` int(3) DEFAULT NULL,
  `ICT1242_P` int(3) DEFAULT NULL,
  `ICT1243_P` int(3) DEFAULT NULL,
  KEY `Stu_Id` (`Stu_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quiz_marks_c`
--

DROP TABLE IF EXISTS `quiz_marks_c`;
CREATE TABLE IF NOT EXISTS `quiz_marks_c` (
  `Stu_id` varchar(12) NOT NULL,
  `Q1` int(11) NOT NULL,
  `Q2` int(11) NOT NULL,
  `Q3` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quiz_marks_cl`
--

DROP TABLE IF EXISTS `quiz_marks_cl`;
CREATE TABLE IF NOT EXISTS `quiz_marks_cl` (
  `Stu_id` varchar(12) NOT NULL,
  `Q1` int(11) NOT NULL,
  `Q2` int(11) NOT NULL,
  `Q3` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quiz_marks_dbms`
--

DROP TABLE IF EXISTS `quiz_marks_dbms`;
CREATE TABLE IF NOT EXISTS `quiz_marks_dbms` (
  `Stu_id` varchar(12) NOT NULL,
  `Q1` int(11) NOT NULL,
  `Q2` int(11) NOT NULL,
  `Q3` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quiz_marks_java`
--

DROP TABLE IF EXISTS `quiz_marks_java`;
CREATE TABLE IF NOT EXISTS `quiz_marks_java` (
  `Stu_id` varchar(12) NOT NULL,
  `Q1` int(11) NOT NULL,
  `Q2` int(11) NOT NULL,
  `Q3` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quiz_marks_ooad`
--

DROP TABLE IF EXISTS `quiz_marks_ooad`;
CREATE TABLE IF NOT EXISTS `quiz_marks_ooad` (
  `Stu_id` varchar(12) NOT NULL,
  `Q1` int(11) NOT NULL,
  `Q2` int(11) NOT NULL,
  `Q3` int(11) NOT NULL,
  `Q4` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `quiz_marks_webt`
--

DROP TABLE IF EXISTS `quiz_marks_webt`;
CREATE TABLE IF NOT EXISTS `quiz_marks_webt` (
  `Stu_id` varchar(12) NOT NULL,
  `Q1` int(11) NOT NULL,
  `Q2` int(11) NOT NULL,
  `Q3` int(11) NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `Stu_Id` varchar(12) NOT NULL,
  `Stu_Name` varchar(20) DEFAULT NULL,
  `Stu_Address` varchar(50) DEFAULT NULL,
  `Stu_Tel` int(10) DEFAULT NULL,
  `Stu_Gender` char(1) DEFAULT NULL,
  `Department_Name` varchar(50) DEFAULT NULL,
  `Age` int(2) DEFAULT NULL,
  PRIMARY KEY (`Stu_Id`),
  KEY `Department_Name` (`Department_Name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student_gpa`
--

DROP TABLE IF EXISTS `student_gpa`;
CREATE TABLE IF NOT EXISTS `student_gpa` (
  `Stu_id` varchar(12) NOT NULL,
  `ICT1213` float NOT NULL,
  `ICT1223` float NOT NULL,
  `ICT1232` float NOT NULL,
  `ICT1233` float NOT NULL,
  `ICT1242` float NOT NULL,
  `ICT1243` float NOT NULL,
  `TOTAL` float NOT NULL,
  PRIMARY KEY (`Stu_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `subject`
--

DROP TABLE IF EXISTS `subject`;
CREATE TABLE IF NOT EXISTS `subject` (
  `Sub_code` char(8) NOT NULL,
  `Sub_Name` varchar(100) DEFAULT NULL,
  `Lecturer_Id` varchar(12) DEFAULT NULL,
  PRIMARY KEY (`Sub_code`),
  KEY `Lecturer_Id` (`Lecturer_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tec_officer`
--

DROP TABLE IF EXISTS `tec_officer`;
CREATE TABLE IF NOT EXISTS `tec_officer` (
  `Tec_Officer_Id` varchar(12) NOT NULL,
  `Tec_Officer_Name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`Tec_Officer_Id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `theory_attendence`
--

DROP TABLE IF EXISTS `theory_attendence`;
CREATE TABLE IF NOT EXISTS `theory_attendence` (
  `Stu_Id` char(10) DEFAULT NULL,
  `ICT1213_T` int(3) DEFAULT NULL,
  `ICT1223_T` int(3) DEFAULT NULL,
  `ICT1232_T` int(3) DEFAULT NULL,
  `ICT1233_T` int(3) DEFAULT NULL,
  `ICT1242_T` int(3) DEFAULT NULL,
  `ICT1243_T` int(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` varchar(12) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `password`) VALUES
('sujan', '123');

--
-- Constraints for dumped tables
--

--
-- Constraints for table `attendence`
--
ALTER TABLE `attendence`
  ADD CONSTRAINT `Attendence_ibfk_1` FOREIGN KEY (`Stu_Id`) REFERENCES `student` (`Stu_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `lecturers`
--
ALTER TABLE `lecturers`
  ADD CONSTRAINT `Lecturers_ibfk_1` FOREIGN KEY (`Department_name`) REFERENCES `department` (`Department_Name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `medical`
--
ALTER TABLE `medical`
  ADD CONSTRAINT `Medical_ibfk_1` FOREIGN KEY (`Stu_Id`) REFERENCES `student` (`Stu_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `prac_attendence`
--
ALTER TABLE `prac_attendence`
  ADD CONSTRAINT `Prac_Attendence_ibfk_1` FOREIGN KEY (`Stu_Id`) REFERENCES `student` (`Stu_Id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `student`
--
ALTER TABLE `student`
  ADD CONSTRAINT `Student_ibfk_1` FOREIGN KEY (`Department_Name`) REFERENCES `department` (`Department_Name`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `subject`
--
ALTER TABLE `subject`
  ADD CONSTRAINT `Subject_ibfk_1` FOREIGN KEY (`Lecturer_Id`) REFERENCES `lecturers` (`Lecturer_Id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
