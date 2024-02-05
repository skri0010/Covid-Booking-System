package covidTest;

/**
 * Class for TestTyoe
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see CovidResult
 * @see TestType
 */
public abstract class TestType {
    private Enum<CovidResult> result;

    /**
     * Constructor of the TestType
     *
     * @param result Covid Result
     */
    public TestType(Enum<CovidResult> result) {
        this.result = result;
    }

    public Enum<CovidResult> getResult() {
        return result;
    }

    public void setResult(Enum<CovidResult> result) {
        this.result = result;
    }
}
