DROP DOMAIN IF EXISTS patenti CASCADE;
DROP DOMAIN IF EXISTS spe_esp CASCADE;
CREATE DOMAIN patenti AS VARCHAR(4)
	CHECK( VALUE IN ('AM','A1','A2','A','B1','B','BE','C1','C1E','C','CE','D1','D1E','D','DE','KA','KB','CQC','CQCM','CFP','NO'));
CREATE DOMAIN spe_esp AS VARCHAR(20)
	CHECK( VALUE IN ('bagnino', 'barman', 'istruttore di nuoto', 'viticultore', 'floricultore'));

CREATE TABLE lavoratore (
	--dati anagrafici
	id_lavoratore SERIAL, 
	luogo_di_nascita VARCHAR(30) NOT NULL, 
	--potrei anche creare una tabella a parte con luogo di nascita (con un id)
	data_di_nascita DATE NOT NULL,--controllo da svolgere su java
	nazionalità VARCHAR(30) NOT NULL,
	--
	indirizzo VARCHAR(30) DEFAULT '',
	telefono VARCHAR(12) CHECK (telefono SIMILAR TO '\+?[0-9]+')) DEFAULT '',
	email VARCHAR(30) UNIQUE NOT NULL,
	specia_esp spe_esp DEFAULT '',
	-- lo farei separato (+ inserimenti per lavoratore)
	lingue_parlate VARCHAR(20) DEFAULT 'Italiano',
	-- separato (+ inserimenti per lavoratore)
	tipo_patente patenti, --controllo tipo patente con java oppure creo un domain
	automunito BOOLEAN,
	--PRIMARY KEY(nome,cognome, luogo_di_nascita, data_di_nascita, nazionalità);
	PRIMARY KEY(id_lavoratore)
);

CREATE TABLE zona(
	periodi INTERVAL, 
	comuni VARCHAR(30),
	lavoratore SERIAL REFERENCES lavoratore (id_lavoratore)
);

CREATE TABLE persona(
	nome VARCHAR(30) NOT NULL,
	cognome VARCHAR(30) NOT NULL,
	telefono VARCHAR(12) CHECK (telefono SIMILAR TO '\+?[0-9]+') NOT NULL,
	email VARCHAR(30) UNIQUE NOT NULL,
	lavoratore SERIAL REFERENCES lavoratore (id_lavoratore)
);

CREATE TABLE lavoro_svolto(
	periodo INTERVAL,
	nome_azienda VARCHAR(30),
	mansione_svolta VARCHAR(30),
	luogo_di_lavoro VARCHAR(30),
	retri_lorda_giornaliera DECIMAL(8,2),
	lavoratore SERIAL REFERENCES lavoratore (id_lavoratore);
);

--NB: capire il funzionamente di serial con references