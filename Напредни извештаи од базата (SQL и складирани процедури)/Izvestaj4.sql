select k.naslov, avg(ocena) as prosecna_ocena from ocena as o

join knigi as k on o.ocena_id_kniga = k.id_na_kniga
join pozajmica as p on k.id_na_kniga = p.id_na_kniga

group by 1
order by prosecna_ocena desc
