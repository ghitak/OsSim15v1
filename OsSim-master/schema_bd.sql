CREATE TABLE saksaka.`etudiant` (
`Id_Etudiant` int NOT NULL AUTO_INCREMENT,
  `login` varchar(20) NOT NULL,
  `password` varchar(8) NOT NULL,
  `nomprenom_etudiant` varchar(45) NOT NULL,  
  PRIMARY KEY (`id_Etudiant`)
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
CREATE TABLE saksaka.`module_qr` (
  `id_mod` int NOT NULL AUTO_INCREMENT,
  `label_module` varchar(30) NOT NULL,
  PRIMARY KEY (`id_mod`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`exercice` (
  `id_exercice` int NOT NULL AUTO_INCREMENT,
  `Titre_exo` varchar(30) NOT NULL,
  `exo_type` char(1) NOT NULL,
  `isActif` boolean default false,
  PRIMARY KEY (`id_exercice`),
  KEY `fk_idx` (`exo_type`),
  CONSTRAINT `FK_TYPE_EXO` FOREIGN KEY (`exo_type`) REFERENCES `exercice_type` (`id_type`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`question_reponse` (
  `id_qr` int NOT NULL AUTO_INCREMENT,
  `Mod_QR` int NOT NULL,
   `title_QR` VARCHAR(15) NOT NULL,
  `blockOnStep` int NOT NULL,
  `Question` VARCHAR(200),
  `includeAnswers` boolean default false,
  `Difficulty` int,
  `answerType` char(1) NOT NULL,
  PRIMARY KEY (`id_qr`),
  KEY `fk_mod_qr` (`Mod_QR`),
  CONSTRAINT `FK_MOD_QR` FOREIGN KEY (`Mod_QR`) REFERENCES `module_qr` (`id_mod`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`qr_answers` (
  `id_qr` int NOT NULL,
  `id_ans` int NOT NULL AUTO_INCREMENT,
  `answer` varchar(200) NOT NULL,
  `isCorrectanswer` boolean default false,
  PRIMARY KEY (`id_ans`),
  KEY `fk_qr_ans` (`id_qr`),
  CONSTRAINT `FK_QR_ANS` FOREIGN KEY (`ID_QR`) REFERENCES `question_reponse` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`algo` (
  `id_algo` int NOT NULL AUTO_INCREMENT,
  `label_algo` varchar(30) NOT NULL,
  PRIMARY KEY (`id_algo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`qr_memory` (
  `id_qr` int NOT NULL,
  `management` varchar(6) NOT NULL, 
  `pageSize` int,
  `memorySize` int,
  `soSize` int,
  `policy` int NOT NULL,
  PRIMARY KEY (`id_qr`),
  KEY `fk_qr_mem` (`id_qr`),
  CONSTRAINT `FK_QR_MEM` FOREIGN KEY (`ID_QR`) REFERENCES `question_reponse` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `fk_qr_mem_alg` (`policy`),
  CONSTRAINT `FK_QR_MEM_ALG` FOREIGN KEY (`policy`) REFERENCES `algo` (`id_algo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE saksaka.`qr_mem_pag` (
`id_qr` int NOT NULL,
  `pid` int NOT NULL,
  `bid` int NOT NULL,
  `size` int ,
  `load` boolean default false,
  PRIMARY KEY (`id_qr`,`pid`,`bid`)
  ); 
  ALTER TABLE saksaka.`qr_mem_pag`
  add CONSTRAINT `FK_QR_MEM_PAG` FOREIGN KEY (`ID_QR`) REFERENCES `qr_memory` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION;
CREATE TABLE saksaka.`qr_param_processus` (
  `id_qr` int NOT NULL,
  `multiprogramming` boolean default false,
  `Preemptive` boolean default false,
  `Quantum` int,
  `Var` boolean default false,
  `Verrou` int,
  `management` int NOT NULL,
  PRIMARY KEY (`id_qr`),
  KEY `fk_qr_pro` (`id_qr`),
  CONSTRAINT `FK_QR_PRO` FOREIGN KEY (`ID_QR`) REFERENCES `question_reponse` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  KEY `fk_qr_pro_alg` (`management`),
  CONSTRAINT `FK_QR_PRO_ALG` FOREIGN KEY (`management`) REFERENCES `algo` (`id_algo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
CREATE TABLE saksaka.`qr_processus` (
  `id_qr` int NOT NULL,
  `pid` int NOT NULL,
  `p_name` varchar(10) NOT NULL,
  `Prio` int,
  `Submission` int,
  `Periodic` int,
  `Bursts` int NOT NULL,
  `Color` int,
  `Variables` varchar(40),
  `Resources` varchar(40),
  `Queue_id` char(1) not null,
  PRIMARY KEY (`id_qr`,`pid`),
  KEY `fk_qr_pproc` (`id_qr`),
  CONSTRAINT `FK_QR_PPRO` FOREIGN KEY (`ID_QR`) REFERENCES `qr_param_processus` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION
 ) ENGINE=InnoDB DEFAULT CHARSET=utf8;  
 CREATE TABLE saksaka.`qr_processus_mem` (
  `id_qr` int NOT NULL,
  `pid` int NOT NULL,
  `p_name` varchar(10) NOT NULL,
  `size` int NOT NULL,
  `duration` int,
  `Color` int,
  `quantumOrders` varchar(40),
  `quantum` int NOT NULL,
  PRIMARY KEY (`id_qr`,`pid`),
  KEY `fk_qr_mproc` (`id_qr`),
  CONSTRAINT `FK_QR_MPRO` FOREIGN KEY (`ID_QR`) REFERENCES `qr_param_processus` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION
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
  `id_exo` int NOT NULL,
  `id_qr` int NOT NULL,
  PRIMARY KEY (`id_exo`,`id_qr`),
  KEY `fk_qr_exo` (`id_exo`),
  CONSTRAINT `FK_QR_EXO` FOREIGN KEY (`ID_EXO`) REFERENCES `exercice` (`id_exercice`) ON DELETE NO ACTION ON UPDATE NO ACTION
);  
  ALTER TABLE saksaka.`qr_exo`
  add CONSTRAINT `FK_QR_q` FOREIGN KEY (`ID_QR`) REFERENCES `question_reponse` (`id_qr`) ON DELETE NO ACTION ON UPDATE NO ACTION;
