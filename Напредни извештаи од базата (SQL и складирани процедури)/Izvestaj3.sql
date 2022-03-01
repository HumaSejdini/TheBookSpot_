select count(p.id_na_pozajmica) as meseceden,
(
                select count(p.id_na_pozajmica) as pozajmici
                
                from pozajmica as p
                
                join chlen as chl on p.id_chovek_prave = chl.id_chovek
                join chovek as ch on chl.id_chovek = ch.id_chovek
                join knigi as k on p.id_na_kniga = k.id_na_kniga
                
                where age(((case when substr(ch.embg,5,1) = '9' then '1' || substr(ch.embg,5,3)
                else '2' || substr(ch.embg,5,3) end) || '-' || substr(ch.embg,3,2) || '-' || substr(ch.embg,1,2))::date) between interval '20 years' and interval '22 years'
                and p.datum_na_zemanje between now() - interval'2 months' and now() - interval '1 month'

) as mesecdva,
(
                select count(p.id_na_pozajmica) as pozajmici
                
                from pozajmica as p
                
                join chlen as chl on p.id_chovek_prave = chl.id_chovek
                join chovek as ch on chl.id_chovek = ch.id_chovek
                join knigi as k on p.id_na_kniga = k.id_na_kniga
                
                where age(((case when substr(ch.embg,5,1) = '9' then '1' || substr(ch.embg,5,3)
                else '2' || substr(ch.embg,5,3) end) || '-' || substr(ch.embg,3,2) || '-' || substr(ch.embg,1,2))::date) between interval '20 years' and interval '22 years'
                and p.datum_na_zemanje between now() - interval'3 months' and now() - interval'2 months'

) as mesectri
from pozajmica as p

join chlen as chl on p.id_chovek_prave = chl.id_chovek
join chovek as ch on chl.id_chovek = ch.id_chovek
join knigi as k on p.id_na_kniga = k.id_na_kniga

where age(((case when substr(ch.embg,5,1) = '9' then '1' || substr(ch.embg,5,3)
else '2' || substr(ch.embg,5,3) end) || '-' || substr(ch.embg,3,2) || '-' || substr(ch.embg,1,2))::date) between interval '20 years' and interval '22 years'
and p.datum_na_zemanje between now() - interval'1 month' and now()
