package calculators;

import controller.Detail;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AssortmentMassCalculatorTest {

    private Detail detail;
    @Before
    public void setUp() throws Exception {
        detail = new Detail(){
            @Override
            public double getFieldsValue() {
                return 5;
            }

            @Override
            public double getDataBaseValue() {
                return 11;
            }
        };
    }

    @Test
    public void calculationMass() {
        double dataBaseValue = detail.getDataBaseValue();
        double fieldsValue = detail.getFieldsValue();
        assertEquals(dataBaseValue*fieldsValue, 11.0*5.0, 0.1);
    }
}