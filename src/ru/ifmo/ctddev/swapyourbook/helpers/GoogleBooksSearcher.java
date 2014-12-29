package ru.ifmo.ctddev.swapyourbook.helpers;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.books.Books;
import com.google.api.services.books.BooksRequestInitializer;
import com.google.api.services.books.model.Volume;
import com.google.api.services.books.model.Volumes;
import ru.ifmo.ctddev.swapyourbook.mybatis.ExtendedBook;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by root on 12/28/14.
 */
public class GoogleBooksSearcher implements MyLoggable{
    /**
     * Be sure to specify the name of your application. If the application name is {@code null} or
     * blank, the application will log a warning. Suggested format is "MyCompany-ProductName/1.0".
     */
    private static final String APPLICATION_NAME = "SwapYourBook";

    private static final NumberFormat CURRENCY_FORMATTER = NumberFormat.getCurrencyInstance();
    private static final NumberFormat PERCENT_FORMATTER = NumberFormat.getPercentInstance();

    static final String API_KEY = "AIzaSyBgVNBOnseCKWhuTPrQMa6wVbmTJ0x6gTg";

    public static String mergeAutors(List<String> authors) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < authors.size(); i++) {
            sb.append(authors.get(i));
            if (i < authors.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static List<ExtendedBook> queryGoogleBooks(String author, String isbn, String title) {
        JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        List<ExtendedBook> books = new ArrayList<>();

        String prefix = null;
        String query = "";
        if (author != null) {
            prefix = "inauthor:";
        } else if (isbn != null) {
            prefix = "isbn:";
        } else if (title != null) {
            prefix = "intitle:";
        }
        if (prefix != null) {
            query = prefix + author;
        }
        logger.warn("Google Books Query is: " + query);

        // Set up Books client.
        try {
            final Books googleBooks = new Books.Builder(GoogleNetHttpTransport.newTrustedTransport(), jsonFactory, null)
                    .setApplicationName(APPLICATION_NAME)
                    .setGoogleClientRequestInitializer(new BooksRequestInitializer(API_KEY))
                    .build();
            // Set query string and filter only Google eBooks.
            Books.Volumes.List volumesList = googleBooks.volumes().list(query);
            volumesList.setFilter("partial").setLangRestrict("ru").setMaxResults(40l);

            // Execute the query.
            Volumes volumes = volumesList.execute();
            // Output results.
            if (volumes != null && volumes.getItems() != null)
                for (Volume volume : volumes.getItems()) {
                    ExtendedBook book = new ExtendedBook();
                    book.setAuthor(mergeAutors(volume.getVolumeInfo().getAuthors()));
                    book.setTitle(volume.getVolumeInfo().getTitle());
                    book.setSmallLink(volume.getVolumeInfo().getImageLinks().getSmall());
                    book.setMediumLink(volume.getVolumeInfo().getImageLinks().getMedium());
                    book.setLargeLink(volume.getVolumeInfo().getPreviewLink());
                    book.setFromGoogle(true);
                    book.setComment(volume.getVolumeInfo().getDescription());
                    books.add(book);
                }
        } catch (GeneralSecurityException | IOException e) {
            logger.error("Books search error: ",e);
        }
        return books;
    }


}
