package Constants;

import Utils.ConfigurationReader;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class FrameworkConstants {

    private FrameworkConstants () {
    }

    private static final String DEMO_QA_URL = ConfigurationReader.get("URL");
    private static final String Tools_QA_URL = ConfigurationReader.get("toolsQaUrl");
    private static final String Permanent_Address = ConfigurationReader.get("permanentAddress");

    public static String getDemoQAUrl() {
        return DEMO_QA_URL; }
    public static String getToolsQaUrl() {
        return Tools_QA_URL; }
    public static String getPermanentAddress() {
        return Permanent_Address; }



}
