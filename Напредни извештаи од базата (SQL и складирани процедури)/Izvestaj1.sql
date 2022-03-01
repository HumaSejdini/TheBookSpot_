select mesectri.ime_kategorija, mesectri.pozajmeni_za_prethodni_tri_meseci,
mesecdva.ime_kategorija, mesecdva.pozajmeni_za_prethodni_dva_meseci,
meseceden.ime_kategorija, meseceden.pozajmeni_za_prethoden_mesec 
from 
(
                select kat.ime_kategorija,count(kat.ime_kategorija) as pozajmeni_za_prethoden_mesec
                from pozajmica as p
                join knigi as k on p.id_na_kniga = k.id_na_kniga
                join e_od as e on k.id_na_kniga = e.id_knigi
                join kategorija as kat on e.id_na_kategorija = kat.id_na_kategorija
                where p.datum_na_zemanje between now() - interval'1 months' and now() 
                group by 1
                order by pozajmeni_za_prethoden_mesec desc 
) as meseceden
join 
(
                select kat.ime_kategorija,count(kat.ime_kategorija) as pozajmeni_za_prethodni_dva_meseci
                from pozajmica as p
                join knigi as k on p.id_na_kniga = k.id_na_kniga
                join e_od as e on k.id_na_kniga = e.id_knigi
                join kategorija as kat on e.id_na_kategorija = kat.id_na_kategorija
                where p.datum_na_zemanje between now() - interval'2 months' and now() - interval'1 month' 
                group by 1
                order by pozajmeni_za_prethodni_dva_meseci desc 
) as mesecdva on meseceden.ime_kategorija = mesecdva.ime_kategorija
join 
(
                select kat.ime_kategorija,count(kat.ime_kategorija) as pozajmeni_za_prethodni_tri_meseci
                from pozajmica as p
                join knigi as k on p.id_na_kniga = k.id_na_kniga
                join e_od as e on k.id_na_kniga = e.id_knigi
                join kategorija as kat on e.id_na_kategorija = kat.id_na_kategorija
                where p.datum_na_zemanje between now() - interval'3 months' and now() - interval'2 months' 
                group by 1
                order by pozajmeni_za_prethodni_tri_meseci desc 
) as mesectri on mesecdva.ime_kategorija = mesectri.ime_kategorija;
