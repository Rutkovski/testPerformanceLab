import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();

        File fileTests = new File(args[0]);
        File fileValues = new File(args[1]);

        try {
            JsonTests tests = mapper.readValue(fileTests, JsonTests.class);
            JsonValues values = mapper.readValue(fileValues, JsonValues.class);
            for (Value value : values.getValues()) {
                searchAndReplace(tests.getTests(), value);
            }
            File fileReport = new File("report.json");
            mapper.writerWithDefaultPrettyPrinter().writeValue(fileReport, tests);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void searchAndReplace(List<Test> allTests, Value value) {
        for (Test test : allTests) {
            if (test.getId() == value.getId()) {
                test.setValue(value.getValue());
                return;
            }
            if (test.getValues() != null) {
                searchAndReplace(test.getValues(), value);
            }
        }
    }

}
