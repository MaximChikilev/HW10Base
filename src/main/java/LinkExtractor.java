import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LinkExtractor {
    public void getLinksFromHtml(String link) {
        File file = new File("./src/main/resources/Links.txt");
        Document document = null;
        try {
            document = Jsoup.connect(link).get();
        } catch (IOException e) {

        }
        Elements elements = document.select("a");

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
            for (var element : elements) {
                if (element.attr("href").contains("https")) {
                    bufferedWriter.write(element.attr("href"));
                    bufferedWriter.newLine();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
