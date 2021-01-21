package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

class DetailsMenuList {

    private static final String ASSORTMENT_QUERY = "ProfileName";
    private static final String TYPE_QUERY = "ProfileTypeName";
    private static final String NUMBER_QUERY = "ProfileNumberName";

    // Sql запрос таблицы сортаментов(профилей)
    private static final String SQL_QUERY_PROFILES =
            "select ProfileName from Profiles";

    // Sql запрос таблицы типов профилей сортамента
    private static final String SQL_QUERY_TYPES =
            "select ProfileTypeName from Profiles, ProfileTypes "
                    + "where Profiles.Profile_ID = ProfileTypes.Profile_ID and "
                    + "Profiles.ProfileName = ?";

    // Sql запрос таблицы номеров профилей определенного типа
    private static final String SQL_QUERY_NUMBERS =
            "select ProfileNumberName from "
                    + "Profiles, ProfileTypes, ProfileNumbers "
                    + "where Profiles.Profile_ID = ProfileTypes.Profile_ID and "
                    + "ProfileTypes.ProfileType_ID = ProfileNumbers.ProfileType_ID and "
                    + "Profiles.ProfileName = ? and "
                    + "ProfileTypes.ProfileTypeName = ?";

    private final Data data;

    DetailsMenuList(Data data) {
        this.data = data;
    }

    List<String> receiveAssortmentList() throws SQLException {
        PreparedStatement preparedStatement = data.getPreparedStatement(SQL_QUERY_PROFILES);
        return data.getMenuList(preparedStatement, ASSORTMENT_QUERY);
    }

    List<String> receiveTypeList(String assortment) throws SQLException {
        PreparedStatement preparedStatement = data.getPreparedStatement(SQL_QUERY_TYPES);
        data.initPreparedStatement(preparedStatement, 1, assortment);
        return data.getMenuList(preparedStatement, TYPE_QUERY);
    }

    List<String> receiveNumberList(String assortment, String type) throws SQLException {
        PreparedStatement preparedStatement = data.getPreparedStatement(SQL_QUERY_NUMBERS);
        data.initPreparedStatement(preparedStatement, 1, assortment);
        data.initPreparedStatement(preparedStatement, 2, type);
        return data.getMenuList(preparedStatement, NUMBER_QUERY);
    }
}
