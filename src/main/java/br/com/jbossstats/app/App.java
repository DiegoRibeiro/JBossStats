package br.com.jbossstats.app;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.jsoup.select.NodeFilter;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        Document doc = null;
        String tab = "\t";
        try {
            doc = Jsoup.connect("https://secure.tibia.com/community/?subtopic=killstatistics")
                    .data("world", "Secura").post();
            Element table = doc.select("table").get(4);
            Elements rows = table.select("tr");

            for (int i = 1; i < rows.size(); i++) {
                Element row = rows.get(i);
                Elements cols = row.select("td");
                String name = cols.get(0).text();
                String killedPlayersDay = cols.get(1).text();
                String killedByPlayersDay = cols.get(2).text();
                String killedPlayersWeek = cols.get(3).text();
                String killedByPlayersWeek = cols.get(4).text();

                System.out.println(name + tab + killedPlayersDay
                        + tab + killedByPlayersDay + tab
                        + killedPlayersWeek + tab + killedByPlayersWeek);
            }

        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
