package covidTest;

/**
 * Class for PCR
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see CovidResult
 * @see TestType
 */
public class PCR extends TestType {

    /**
     * Constructor for the PCR
     *
     * @param result Covid Result
     */
    public PCR(Enum<CovidResult> result) {
        super(result);
    }

    /**
     * PCR string method
     *
     * @return PCR class name
     */
    @Override
    public String toString() {
        return "PCR";
    }

}
