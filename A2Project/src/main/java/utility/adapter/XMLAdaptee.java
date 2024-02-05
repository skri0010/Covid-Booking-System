package utility.adapter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;

import java.io.IOException;

/**
 * Class represent the XMLAdaptee
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see DataAdaptee
 * @see TextAdaptee
 */
public class XMLAdaptee implements DataAdaptee {

    /**
     * Constructor for the XMLAdaptee
     */
    public XMLAdaptee() {
    }

    /**
     * Convert the JSON to XML format
     * For future purpose
     *
     * @param jsonNode JSON
     * @return String
     * @throws JsonProcessingException
     */
    @Override
    public String jsonConverter(JsonNode jsonNode) throws JsonProcessingException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_DECLARATION, true);
        xmlMapper.configure(ToXmlGenerator.Feature.WRITE_XML_1_1, true);
        String xml = xmlMapper.writeValueAsString(jsonNode);
        return xml;
    }

    /**
     * A sample for running this XML Code
     *
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        String Json = "{" +
                "\"bookHomeTesting\":\"" + true + "\"," +
                "\"bookOnSiteTesting\":\"" + false + "\"," +
                "\"hasRATKit\":\"" + true + "\"," +
                "\"URL\":\"" + true + "\"," +
                "\"QRCode\":\"" + true + "\"" +
                "}";
        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree(Json);
        ResponseAdapter responseAdapter = new ResponseAdapter(new XMLAdaptee());
        String resultText = responseAdapter.convertFormat(jsonNode);
        System.out.println(resultText);
    }
}
