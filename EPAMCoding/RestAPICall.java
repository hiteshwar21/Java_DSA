
package EPAMCoding;

import java.net.http.*;
import java.net.URI;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

class Book {
    public String title;
    public String author;
    public double rating;
    public int publishedYear;

    @Override
    public String toString() {
        return "\"" + title + "\" by " + author + " - Rating: " + rating;
    }
}

public class RestAPICall {
    private static final String API_URL = "https://api.example.com/books"; // Placeholder

    public static void main(String[] args) throws IOException, InterruptedException {}}
/*        List<Book> books = fetchBooksFromAPI();
        List<Book> filteredSortedBooks = books.stream()
                .filter(book -> book.publishedYear > 2015 && book.rating >= 4.0)
                .sorted(Comparator.comparingDouble(Book::getRating).reversed())
                .collect(Collectors.toList());

        filteredSortedBooks.forEach(System.out::println);
    }
}

    private static List<Book> fetchBooksFromAPI() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(response.body(), new TypeReference<List<Book>>() {});
    }
}
*/
