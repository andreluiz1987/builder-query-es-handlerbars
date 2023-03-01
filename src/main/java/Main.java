import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) throws IOException {
    queryMatchSimply();
    queryMatchFilterSimply();
    queryMatchMultiFilters();
  }

  private static void queryMatchMultiFilters() throws IOException {
    var params = new SearchParams();
    params.setSize(10);
    params.setTerm("batman");
    //params.setGenres(List.of("Action", "Adventure"));
    params.setCertificate("AU");
    params.setRating(6.0);

    var instance = new Handlebars();
    instance.registerHelper("list_string_helper", (Helper<List<String>>) (items, options) -> {
      if (items == null || items.isEmpty()) {
        return Collections.emptyList();
      }
      return items.stream().map(it -> "\"" + it + "\"").collect(Collectors.toList());
    });

    var query = instance.compile("query-match-multi-filters")
        .apply(params)
        .replace("@formatter:off", "")
        .replace("@formatter:on", "");
    System.out.println(query);
  }

  private static void queryMatchFilterSimply() throws IOException {
    var params = new SearchParams();
    params.setSize(10);
    params.setTerm("batman");
    params.setGenres(List.of("Action", "Adventure"));

    var instance = new Handlebars();
    instance.registerHelper("list_string_helper", (Helper<List<String>>) (items, options) -> {
      if (items == null || items.isEmpty()) {
        return Collections.emptyList();
      }
      return items.stream().map(it -> "\"" + it + "\"").collect(Collectors.toList());
    });

    var query = instance.compile("query-match-filter-simple")
        .apply(params)
        .replace("@formatter:off", "")
        .replace("@formatter:on", "");

    System.out.println(query);
  }

  private static void queryMatchSimply() throws IOException {
    var params = new SearchParams();
    params.setSize(10);
    params.setTerm("batman");

    var instance = new Handlebars();
    var query = instance.compile("query-match-simple")
        .apply(params)
        .replace("@formatter:off", "")
        .replace("@formatter:on", "");

    System.out.println(query);
  }
}
