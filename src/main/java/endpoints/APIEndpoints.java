package endpoints;

import static endpoints.BaseEndpoints.BASE_URL;

public class APIEndpoints {
    //Для получения первых 3х тендеров в состоянии "Открыт"
    public static final String getFirstThreeTenders = BASE_URL+"api/_info.tenderlist_by_set.json";
    //Для получения описания одного из тендеров
    public static final String getTenderAttributes = BASE_URL+"api/_tender.info.json";
    //Для получения информации о компании, реквизиты
    public static final String getCompanyInfo = BASE_URL+"api/_company.info_public.json";
}
