package testingSite;

import covidTest.CovidResult;
import covidTest.TestType;

/**
 * Class for TestingSiteType
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see CovidResult
 * @see TestType
 */
public class TestingSiteType {

    private Enum<TestingSiteTypeEnum> tsType;

    /**
     * Constructor for the TestingSiteType
     */
    public TestingSiteType() {
    }

    
    public Enum<TestingSiteTypeEnum> getTSType() {
        return tsType;
    }

    public void setTSType(Enum<TestingSiteTypeEnum> testingSiteType) {
        this.tsType = testingSiteType;
    }
}
