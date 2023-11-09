
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String link = "https://prog.academy/ua";
        LinkExtractor linkExtractor = new LinkExtractor();
        linkExtractor.getLinksFromHtml(link);
        WebSiteAvailabilityChecker webSiteAvailabilityChecker = new WebSiteAvailabilityChecker();
        webSiteAvailabilityChecker.loadAndSetListForCheck("./src/main/resources/Links.txt");
        Map<String, Boolean> checkReport = webSiteAvailabilityChecker.checkAvailability();
        for (String element:checkReport.keySet()){
            System.out.println(element+" Availability status is : "+checkReport.get(element));
        }

    }

}