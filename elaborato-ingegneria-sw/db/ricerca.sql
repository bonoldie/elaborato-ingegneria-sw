

create view dettagli_lavoratori as 
select l2.id_lavoratore , e.esperienze, l.lingue, d.periodo_disponibilita, p.patenti_lavoratore, comuni.comuni_disponibilita  from (
(select * from lavoratore) l2 left join 

(SELECT l.id_lavoratore, string_agg(le.esperienza, ', ') as esperienze
	FROM lavoratore l 
		join lavoratore_esperienza le on l.id_lavoratore = le.id_lavoratore
	group by l.id_lavoratore) as e on e.id_lavoratore = l2.id_lavoratore

	left join 
	
(SELECT l.id_lavoratore, string_agg(li.nome_lingua, ', ') as lingue
	FROM lavoratore l 
		join lavoratore_lingua ll  on l.id_lavoratore = ll.id_lavoratore 
		join  lingua li ON  ll.id_lingua  = li.id_lingua
	group by l.id_lavoratore) as l on l2.id_lavoratore = l.id_lavoratore
	
	left join 
	
(SELECT l.id_lavoratore ,  string_agg( CONCAT(d.data_inizio, CONCAT('|',d.data_fine)), ', ') as periodo_disponibilita
	FROM lavoratore l 
		join disponibilita d ON  d.id_lavoratore = l.id_lavoratore
		group by l.id_lavoratore) as d on d.id_lavoratore  = l2.id_lavoratore
		
	left join 

(SELECT l.id_lavoratore , string_agg(p.nome_patente , ', ') as patenti_lavoratore
	FROM lavoratore l 
		join lavoratore_patente lp on l.id_lavoratore = lp.id_lavoratore
		join patente p on lp.id_patente = p.id_patente
	group by l.id_lavoratore ) as p on p.id_lavoratore  = l2.id_lavoratore
		
	left join 

	
(SELECT l.id_lavoratore, string_agg(d.comune , ', ') as comuni_disponibilita
	FROM lavoratore l 
		join disponibilita d ON  d.id_lavoratore = l.id_lavoratore
	group by l.id_lavoratore) as comuni on comuni.id_lavoratore  = l2.id_lavoratore
);

-- DATA GROUP BY

SELECT l.id_lavoratore, string_agg(le.esperienza, ', ') as esperienze
	FROM lavoratore l 
		join lavoratore_esperienza le on l.id_lavoratore = le.id_lavoratore
	group by l.id_lavoratore;

SELECT l.id_lavoratore, string_agg(li.nome_lingua, ', ') as lingue
	FROM lavoratore l 
		join lavoratore_lingua ll  on l.id_lavoratore = ll.id_lavoratore 
		join  lingua li ON  ll.id_lingua  = li.id_lingua
	group by l.id_lavoratore;

SELECT l.id_lavoratore ,  string_agg( CONCAT(d.data_inizio, CONCAT('|',d.data_fine)), ', ') as periodo_disponibilita
	FROM lavoratore l 
		join disponibilita d ON  d.id_lavoratore = l.id_lavoratore
		group by l.id_lavoratore;
	
SELECT l.id_lavoratore , string_agg(p.nome_patente , ', ') as patenti_lavoratore
	FROM lavoratore l 
		join lavoratore_patente lp on l.id_lavoratore = lp.id_lavoratore
		join patente p on lp.id_patente = p.id_patente
	group by l.id_lavoratore ;
		
SELECT l.id_lavoratore, string_agg(d.comune , ', ') as comuni_disponibilita
	FROM lavoratore l 
		join disponibilita d ON  d.id_lavoratore = l.id_lavoratore
	group by l.id_lavoratore;


-- MEGA DATA SELECT 

(
(
SELECT l.id_lavoratore  
	FROM lavoratore l
		join lavoratore_lingua ll  on l.id_lavoratore = ll.id_lavoratore 
		join  lingua li ON  ll.id_lingua  = li.id_lingua
	-- WHERE conditions

UNION


SELECT l.id_lavoratore
	FROM lavoratore l 
		join lavoratore_esperienza le on l.id_lavoratore = le.id_lavoratore
	-- WHERE conditions
)
UNION
	
SELECT l.id_lavoratore  
	FROM lavoratore l 
		join lavoratore_patente lp on l.id_lavoratore = lp.id_lavoratore
		join patente p on lp.id_patente = p.id_patente
		-- WHERE conditions;
)
UNION 

SELECT l.id_lavoratore  
	FROM lavoratore l 
		join disponibilita d ON  d.id_lavoratore = l.id_lavoratore
		-- WHERE conditions
;
	
