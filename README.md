# Тестовое задание- #
## Власов Дмитрий Александрович ##

### Часть 1 (Общая работа с api ) ###
1. Получить список первых 3 тендеров в состоянии открыт для любой компании-организатора <br/>
http://www.tender.pro/api/_company.stat_public.json?_key=1732ede4de680a0c93d81f01d7bac7d1&set_type_id=1&set_id=220714&max_rows=3&open_only=true
2. Для одного из тендеров этого списка получить его описание(атрибуты тендера) <br/>
http://www.tender.pro/api/_tender.info.json?_key=1732ede4de680a0c93d81f01d7bac7d1&id=441286&company_id=220714
3. Для компании-организатора получить ее публичные данные, реквизиты <br/>
http://www.tender.pro/api/_company.info_public.json?id=220714

### Часть 2 (Работа с SQL) ###
В блоке cpm_in_blocks получаем design_id и их СРМ<br/>
В блоке max_cpm_in_blocks получаем макс. значением СРМ design_id<br/>
В последнем блоке получаем итоговые значения путем сочетания 1 и 2 блока<br/>
<br/>
with cpm_in_blocks as ( <br/>
select u.user_id,<br/>
st.site_id,<br/>
sa.site_area_id,<br/>
sdc.design_id,<br/>
sum(sdc.partner_gain)/sum(sdc.view_count)*1000 cpm<br/>
from user1 u,<br/>
site st,<br/>
site_area sa,<br/>
site_area_design_1 sad,<br/>
stat_design_cache sdc<br/>
where u.user_id = st.user_id<br/>
and st.site_id = sa.parent_id<br/>
and sa.site_area_id = sad.site_area_id<br/>
and sad.site_area_design_1_id = sdc.design_id<br/>
group by sdc.design_id<br/>
),<br/>
<br/>
max_cpm_in_blocks as (<br/>
select cib.user_id,<br/>
cib.site_id,<br/>
cib.site_area_id,<br/>
max(cib.cpm) max_cpm<br/>
from cpm_in_blocks cib<br/>
group by cib.site_area_id<br/>
)<br/>
<br/>
select cib.user_id,<br/>
cib.site_id,<br/>
cib.site_area_id,<br/>
cib.design_id,<br/>
round(cib.cpm, 3)<br/>
from cpm_in_blocks cib<br/>
where cib.design_id = (<br/>
select cib2.design_id<br/>
from cpm_in_blocks cib2<br/>
where cib2.user_id = cib.user_id<br/>
and cib2.site_id = cib.site_id<br/>
and cib2.site_area_id = cib.site_area_id<br/>
and cib2.cpm = (<br/>
select mcib.max_cpm<br/>
from max_cpm_in_blocks mcib<br/>
where mcib.user_id = cib2.user_id<br/>
and mcib.site_id = cib2.site_id<br/>
and mcib.site_area_id = cib2.site_area_id<br/>
)<br/>
order by 1 asc<br/>
limit 1<br/>
)<br/>
order by 1 asc;<br/>
### Часть 3 ( Автоматизация тестирования ) ###
Для запуска api тестов необходимо ввести: mvn clean verify -Dtags="api"<br/>
Для запуска ui теста необходимо ввести: mvn clean verify -Dtags="ui" <br/>
Страница с результатами лежит здесь: <br/>
task\target\site\serenity\index.html<br/>
Для UI была взята страница "Закупки и тендеры" и проверена работа фильтра "Тип тендера"<br/>
api автотесты проверяют, что апи возвращает корректную информацию по параметрам, <br/>
в случае первого теста так же проверяется размер вернувшегося массива, а именно 3

### Дополнение ###
При ознакомлении с системой заметил ошибку с локализацей в [этом месте](http://system.help.tender.pro/)<br/>
результаты поиска сопровождатся сообщением "NO RESULTS MATCHING"\"RESULTS MATCHING", хотя вся остальная <br/>
часть сайта на русском языке