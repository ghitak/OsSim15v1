CREATE TABLE saksaka.`etudiant` (
  `Id_Etudiant` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL,
  `nomprenom_etudiant` varchar(45) NOT NULL,
  PRIMARY KEY (`Id_Etudiant`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`professeur` (
`Id_Professeur` int NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL,
  `nomprenom_professeur` varchar(45),
  PRIMARY KEY (`id_professeur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`exercice_type` (
`id_type` char(1) NOT NULL,
  `label_type` varchar(30) NOT NULL,
  PRIMARY KEY (`id_type`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `exercice_type` VALUES ('e','exercice'),('t','test');
CREATE TABLE saksaka.`module_qr` (
 `id_mod` int(11) NOT NULL AUTO_INCREMENT,
  `label_module` varchar(30) NOT NULL,
  PRIMARY KEY (`id_mod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `module_qr` VALUES (1,'processus'),(2,'memoire');
CREATE TABLE saksaka.`exercice` (
  `id_exercice` int(11) NOT NULL AUTO_INCREMENT,
  `Titre_exo` varchar(30) NOT NULL,
  `exo_type` varchar(1) NOT NULL,
  `isActif` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_exercice`),
  KEY `fk_idx` (`exo_type`),
  CONSTRAINT `FK_TYPE_EXO` FOREIGN KEY (`exo_type`) REFERENCES `exercice_type` (`id_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`question_reponse` (
  `id_qr` int(11) NOT NULL AUTO_INCREMENT,
  `Mod_QR` int(11) NOT NULL,
  `blockOnStep` int(11) NOT NULL,
  `Question` varchar(200) DEFAULT NULL,
  `includeAnswers` tinyint(1) DEFAULT '0',
  `Difficulty` int(11) DEFAULT NULL,
  `answerType` char(1) NOT NULL,
  `title_QR` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_qr`),
  KEY `fk_mod_qr` (`Mod_QR`),
  CONSTRAINT `FK_MOD_QR` FOREIGN KEY (`Mod_QR`) REFERENCES `module_qr` (`id_mod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`qr_answers` (
  `id_qr` int(11) NOT NULL,
  `id_ans` int(11) NOT NULL AUTO_INCREMENT,
  `answer` varchar(200) NOT NULL,
  `isCorrectanswer` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_ans`),
  KEY `fk_qr_ans` (`id_qr`),
  CONSTRAINT `FK_QR_ANS` FOREIGN KEY (`id_qr`) REFERENCES `question_reponse` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`algo` (
  `id_algo` int(11) NOT NULL AUTO_INCREMENT,
  `label_algo` varchar(30) NOT NULL,
  PRIMARY KEY (`id_algo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8; 
CREATE TABLE saksaka.`qr_memory` (
  `id_qr` int(11) NOT NULL,
  `management` varchar(6) NOT NULL,
  `pageSize` int(11) DEFAULT NULL,
  `memorySize` int(11) DEFAULT NULL,
  `soSize` int(11) DEFAULT NULL,
  `policy` varchar(6) NOT NULL,
  PRIMARY KEY (`id_qr`),
  KEY `fk_qr_mem` (`id_qr`),
  CONSTRAINT `FK_QR_MEM` FOREIGN KEY (`id_qr`) REFERENCES `question_reponse` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`qr_mem_pag` (
  `id_qr` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `bid` int(11) NOT NULL,
  `size` int(11) DEFAULT NULL,
  `load` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_qr`,`pid`,`bid`),
  CONSTRAINT `FK_QR_MEM_PAG` FOREIGN KEY (`id_qr`) REFERENCES `qr_memory` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION
  ); 
  
CREATE TABLE saksaka.`qr_param_processus` (
  `id_qr` int(11) NOT NULL,
  `multiprogramming` tinyint(1) DEFAULT '0',
  `Preemptive` tinyint(1) DEFAULT '0',
  `Quantum` int(11) DEFAULT NULL,
  `Var` tinyint(1) DEFAULT '0',
  `Verrou` int(11) DEFAULT NULL,
  `management` varchar(11) NOT NULL,
  PRIMARY KEY (`id_qr`),
  KEY `fk_qr_pro` (`id_qr`),
  KEY `fk_qr_pro_alg` (`management`),
  CONSTRAINT `FK_QR_PRO` FOREIGN KEY (`id_qr`) REFERENCES `question_reponse` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
CREATE TABLE saksaka.`qr_processus` (
  `id_qr` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `p_name` varchar(10) NOT NULL,
  `Prio` int(11) DEFAULT NULL,
  `Submission` int(11) DEFAULT NULL,
  `Periodic` int(11) DEFAULT NULL,
  `Bursts` varchar(20) NOT NULL,
  `Color` int(11) DEFAULT NULL,
  `Variables` varchar(40) DEFAULT NULL,
  `Resources` varchar(40) DEFAULT NULL,
  `Queue_id` char(1) NOT NULL,
  PRIMARY KEY (`id_qr`,`pid`),
  KEY `fk_qr_pproc` (`id_qr`),
  CONSTRAINT `FK_QR_PPRO` FOREIGN KEY (`id_qr`) REFERENCES `qr_param_processus` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
 CREATE TABLE saksaka.`qr_processus_mem` (
  `id_qr` int(11) NOT NULL,
  `pid` int(11) NOT NULL,
  `p_name` varchar(10) NOT NULL,
  `size` int(11) NOT NULL,
  `duration` int(11) DEFAULT NULL,
  `Color` int(11) DEFAULT NULL,
  `quantumOrders` varchar(40) DEFAULT NULL,
  `quantum` int(11) NOT NULL,
  PRIMARY KEY (`id_qr`,`pid`),
  KEY `fk_qr_mproc` (`id_qr`),
  CONSTRAINT `fk_qr_mproc` FOREIGN KEY (`id_qr`) REFERENCES `question_reponse` (`id_qr`) ON DELETE CASCADE ON UPDATE CASCADE
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
CREATE TABLE saksaka.`test_realise` (
  `id_etudiant` int NOT NULL,
  `id_exo` int NOT NULL,
  `date_testpassing` date not null,
  `result` varchar(5),
  PRIMARY KEY (`id_etudiant`,`id_exo`),
  KEY `fk_TR_etud` (`id_etudiant`),
  CONSTRAINT `FK_TR_ETUD` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`id_etudiant`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
ALTER TABLE saksaka.`test_realise`
  add CONSTRAINT `FK_TR_EXO` FOREIGN KEY (`ID_exo`) REFERENCES `exercice` (`id_exercice`) ON DELETE NO ACTION ON UPDATE NO ACTION;
CREATE TABLE saksaka.`qr_exo` (
 `id_etudiant` int(11) NOT NULL,
  `id_exo` int(11) NOT NULL,
  `date_testpassing` date NOT NULL,
  `result` varchar(5) DEFAULT NULL,
  PRIMARY KEY (`id_etudiant`,`id_exo`),
  KEY `fk_TR_etud` (`id_etudiant`),
  KEY `FK_TR_EXO` (`id_exo`),
  CONSTRAINT `FK_TR_ETUD` FOREIGN KEY (`id_etudiant`) REFERENCES `etudiant` (`Id_Etudiant`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_TR_EXO` FOREIGN KEY (`id_exo`) REFERENCES `exercice` (`id_exercice`) ON DELETE NO ACTION ON UPDATE NO ACTION
);  