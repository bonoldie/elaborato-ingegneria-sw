--DROP DOMAIN IF EXISTS patenti CASCADE;
--DROP DOMAIN IF EXISTS spe_esp CASCADE;
CREATE DOMAIN patenti AS VARCHAR(4)
	CHECK( VALUE IN ('AM','A1','A2','A','B1','B','BE','C1','C1E','C','CE','D1','D1E','D','DE','KA','KB','CQC','CQCM','CFP','NO'));
CREATE DOMAIN spe_esp AS VARCHAR(20)
	CHECK( VALUE IN ('bagnino', 'barman', 'istruttore di nuoto', 'viticultore', 'floricultore'));

CREATE TABLE Anagrafica(
	id_anagrafica SERIAL,
	luogo_di_nascita VARCHAR(30),
	data_di_nascita DATE NOT NULL,
	nazionalita VARCHAR(30) NOT NULL,
	nome VARCHAR(30) NOT NULL,
	cognome VARCHAR(30) NOT NULL,
	telefono VARCHAR(12) CHECK (telefono SIMILAR TO '\+?[0-9]+') DEFAULT '',
	email VARCHAR(30) UNIQUE,
	PRIMARY KEY (id_anagrafica)
);

CREATE TABLE Recapito(
	id_recapito SERIAL,
	nome VARCHAR(30) NOT NULL,
	cognome VARCHAR(30) NOT NULL,
	telefono VARCHAR(12) CHECK (telefono SIMILAR TO '\+?[0-9]+') NOT NULL,
	email VARCHAR(30) UNIQUE NOT NULL,
	PRIMARY KEY (id_recapito)
);

CREATE TABLE Lavoratore (
	id_lavoratore SERIAL, 
	id_anagrafica SERIAL REFERENCES Anagrafica(id_anagrafica),
	id_recapito_urgenza SERIAL REFERENCES Recapito(id_recapito),
	indirizzo VARCHAR(30) DEFAULT '',
	specia_esp spe_esp DEFAULT '',
	automunito BOOLEAN,
	--PRIMARY KEY(nome,cognome, luogo_di_nascita, data_di_nascita, nazionalità);
	PRIMARY KEY(id_lavoratore)
);

CREATE TABLE Disponibilita(
	id_disponibilita SERIAL,
	id_lavoratore SERIAL REFERENCES lavoratore (id_lavoratore),
	data_inizio DATE,
	data_fine DATE, 
	comune VARCHAR(30),
	PRIMARY KEY (id_disponibilita)
);

CREATE TABLE lavoro_svolto(
	id_lavoro_svolto SERIAL,
	id_lavoratore SERIAL REFERENCES lavoratore(id_lavoratore),
	periodo INTERVAL,
	nome_azienda VARCHAR(30),
	mansione_svolta VARCHAR(30),
	luogo_di_lavoro VARCHAR(30),
	retri_lorda_giornaliera DECIMAL(8,2)
);

CREATE TABLE Patente(
	id_patente SERIAL PRIMARY KEY,
	nome_patente patenti
);

CREATE TABLE Lavoratore_Patente(
	id_patente SERIAL REFERENCES Patente(id_patente),
	id_lavoratore SERIAL REFERENCES Lavoratore(id_lavoratore)
);

CREATE TABLE Lingua(
	id_lingua SERIAL PRIMARY KEY,
	nome_lingua VARCHAR(30)
);

CREATE TABLE Lavoratore_Lingua(
	id_lingua SERIAL REFERENCES Lingua(id_lingua),
	id_lavoratore SERIAL REFERENCES Lingua(id_lingua)
);

CREATE TABLE Lavoratore_Esperienza(
	id_lavoratore SERIAL REFERENCES lavoratore(id_lavoratore),
	esperienza spe_esp
);


