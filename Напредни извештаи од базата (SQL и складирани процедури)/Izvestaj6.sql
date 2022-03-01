select mesectri.ime, mesectri.prezime, meseceden.najavuvanja_vo_prethoden_mesec,
mesecdva.najavuvanja_izmegju_1_2_meseci_nanazad, mesectri.najavuvanja_izmegju_2_3_meseci_nanazad
from 
(
                select ch.ime,ch.prezime,(count(a.log_id)) as najavuvanja_vo_prethoden_mesec
                from authentication as a
                
                join chovek as ch on a.id_chovek = ch.id_chovek
                where a.timestamp_log between now() - interval '1 month' and now()
                
                group by 1,2
                order by najavuvanja_vo_prethoden_mesec desc
) as meseceden
join
(
                select ch.ime,ch.prezime,(count(a.log_id)) as najavuvanja_izmegju_1_2_meseci_nanazad
                from authentication as a
                
                join chovek as ch on a.id_chovek = ch.id_chovek
                where a.timestamp_log between now() - interval '2 months' and now() - interval '1 month'
                
                group by 1,2
                order by najavuvanja_izmegju_1_2_meseci_nanazad desc
) as mesecdva on meseceden.ime = mesecdva.ime and meseceden.prezime = mesecdva.prezime
join
(
                select ch.ime,ch.prezime,case when count(a.log_id) is null then 0 else count(a.log_id) end as najavuvanja_izmegju_2_3_meseci_nanazad
                from authentication as a
                
                join chovek as ch on a.id_chovek = ch.id_chovek
                where a.timestamp_log between now() - interval '3 months' and now() - interval '2 months'
                
                group by 1,2
                order by najavuvanja_izmegju_2_3_meseci_nanazad desc 
