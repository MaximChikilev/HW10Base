import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WebSiteAvailabilityChecker {
    private List<String> listOfLinks;

    public List<String> getListOfLinks() {
        return listOfLinks;
    }
    public WebSiteAvailabilityChecker(List<String> listOfLinks) {
        this.listOfLinks = listOfLinks;
    }

    public WebSiteAvailabilityChecker() {
    }

    public Map<String,Boolean> checkAvailability(){
        Map<String,Boolean> checkReport = new HashMap<>();
        for (var element:listOfLinks){
            Boolean availableStatus = true;
            try {
                URL url = new URL(element);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                if(httpURLConnection.getResponseCode() == -1){
                    availableStatus =false;
                }
            }  catch (IOException e) {

            }
            checkReport.put(element,availableStatus);
        }
        return checkReport;
    }
    public void loadAndSetListForCheck(String fileName){
        listOfLinks = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            while (bufferedReader.ready()){
                listOfLinks.add(bufferedReader.readLine());
            }
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }
}
