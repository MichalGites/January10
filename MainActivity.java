package pl.akademiakodu.january10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.listOfBook)
    ListView listOfBooks;

    // domyślny Adapter
//    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        // domyślny Adapter
//        String[] booksName = {"Alicja", "4 dni", "Java programming", "Junit tests", "Pragmatyczne zastosowanie"};
//        // przekonwerpwanie tablicy na liste - metoda arrays.asList
//        ArrayList<String> list = new ArrayList<String>();
//        list.addAll(Arrays.asList(booksName));
//        // przypisujemy do adaptera wyglad naszego pojedynczego wiersza - później stworzymy wlasny adapter
//        adapter = new ArrayAdapter<String>(this, R.layout.custom_row_book, list);
//        // połącznie listy z adapterem
//        listOfBooks.setAdapter(adapter);

        createCustomList();

    }

    private void createCustomList(){
        List<BookData> booksData = new ArrayList<>();
        booksData.add(new BookData("Oskar", "Java", 99));
        booksData.add(new BookData("Oskar1", "Java1", 199));
        booksData.add(new BookData("Oskar2", "Java2", 299));
        booksData.add(new BookData("Oskar3", "Java3", 399));
        booksData.add(new BookData("Oskar4", "Java4", 499));

        // Przypisanie adaptera

        BooksAdpater booksAdpater = new BooksAdpater(booksData, this);
        listOfBooks.setAdapter(booksAdpater);
    }

}
