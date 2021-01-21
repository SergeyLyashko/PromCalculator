package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
class DetailsValue {

    private static final String SQL_QUERY_VALUE = "select AreaCut_Value from "
            + "Profiles, ProfileTypes, ProfileNumbers, NumberValues "
            + "where Profiles.Profile_ID = ProfileTypes.Profile_ID and "
            + "ProfileTypes.ProfileType_ID = ProfileNumbers.ProfileType_ID and "
            + "ProfileNumbers.ProfileNumber_ID = NumberValues.Number_ID and "
            + "Profiles.ProfileName = ? and "
            + "ProfileTypes.ProfileTypeName = ? and "
            + "ProfileNumbers.ProfileNumberName = ?";

    private static final String VALUE = "AreaCut_Value";
    private final Executor executor;

    DetailsValue(Executor executor) {
        this.executor = executor;
    }

    /**
     * Get detail's value for calculation mass
     * @param assortment assortment detail's name
     * @param type type detail's name
     * @param number number of profile detail's name
     * @return detail's value
     * @throws SQLException
     */
    double getValue(String assortment, String type, String number) throws SQLException {
        PreparedStatement preparedStatement = executor.getPreparedStatement(SQL_QUERY_VALUE);
        preparedStatement.setString(1, assortment);
        preparedStatement.setString(2, type);
        preparedStatement.setString(3, number);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.getDouble(VALUE);
    }
}
