--tabella per i dipendenti
CREATE TABLE dipendenti (
	id_dipendente SERIAL, --non presente nelle indicazioni
	id_anagrafica SERIAL REFERENCES Anagrafica(id_anagrafica),
	login VARCHAR(255) UNIQUE,
	password VARCHAR(255), 
	PRIMARY KEY (id_dipendente)
);

--serial e' equivalente a id integer NOT NULL DEFAULT nextval('table_name_id_seq')

--serial e' equivalente a id integer NOT NULL DEFAULT nextval('table_name_id_seq')