package covidTest;

/**
 * Class for RAT
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see CovidResult
 * @see TestType
 */
public class RAT extends TestType {

    /**
     * Constructor for the RAT
     *
     * @param result Covid Result
     */
    public RAT(Enum<CovidResult> result) {
        super(result);
    }

    /**
     * RAT string method
     *
     * @return RAT class name
     */
    @Override
    public String toString() {
        return "RAT";
    }
}
