package pl.akademiakodu.january10;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Michał on 2017-01-10.
 */

// Base adapter podstawowy adapter dla Androida

public class BooksAdpater extends BaseAdapter {

    List<BookData> data;
    Context context; // context potrzebny jest zeby dostac sie do inflatera
    LayoutInflater inflater; // wstrzykiwacz danych
    // konstruktor ktory pozwoli na przyjecie listy ksiazek z innej klasy
    public BooksAdpater (List<BookData> dataList, Context con){
        data= (ArrayList) dataList;
        context=con;
        // odwolanie do inflatera - nowsza werjsa ListView to RecycleView - ciekawostka
        // dzieki inflaterowi mozemy wstzrykiwac odpowiednie elementy do naszej listy
        inflater = (LayoutInflater) con.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // wskazuje widgetowi ile elementow w liscie bedzie sie znajdowac - przypisujemy tu wielkosc listy np
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        // zwraca z listy danych pojedyncza wartosc - wiersz
        return data.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        // sterownik maszej listy tak naprawde - np odpowiednie wyswietlanie elementow w zaleznosci od ustawienia scrolla
        // do tego sluzy layout inflater - trzeba utworzyc taki obiekt tutaj - pole klasy
        // getView wykonuje sie za kazdym razem kiedy uzytkownikowi pojawia sie nowy wiersz w ekranie urzadzenia

        // CustomAdapter bez wzorca VieWHolder
//         view = inflater.inflate(R.layout.custom_book_list_row, viewGroup, false);

        // powiazanie textView z kazdym pojedynczym wierszem

        // CustomAdapter bez wzorca VieWHolder
//        TextView textTitle = (TextView) view.findViewById(R.id.textViewTitle);
//        TextView textAuthor = (TextView) view.findViewById(R.id.textViewAuthor);
//        TextView textPages = (TextView) view.findViewById(R.id.textViewPages);

        // ViewHolder ma podobna funkcjonalnosc do singletona
        ViewHolder viewHolder;
        if (view != null){
            viewHolder = (ViewHolder) view.getTag();// dajemy Taga w postaci calej klasy ViewHolder
            // przy pierwszym uruchomieniu znajduje powiązania w klasie ViewHolder i zapisuje w Tagu
            // przy kolejnym uruchomieniu nasz przekonwertowany widok view nie jest nullem i wtedy program
            // od razu znajduje powiązania ponieważ zostaly one zapisane w Tagu razem z klasa ViewHolder
            // dzieki temu program dziala szybciej gdyz przy pojawieniu sie nowego wiersza eliminujemy wyszukiwanie metoda (findViewById)
            // oczywiscie chodzi tu o kolejne uruchomienie bo przy pierwszym przechodzi cala sciezke
        } else{
            view = inflater.inflate(R.layout.custom_book_list_row, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
            Log.e("debug", "To ma być wykonane tylko raz"); // to tylko w celu sprawdzenia w logach czy dziala
        }

        // przypisanie tresci/danych zawartych w naszej liscie do wyzej tworzonych powiazan

        // CustomAdapter bez wzorca VieWHolder
//        textTitle.setText(data.get(i).getTitle());
//        textAuthor.setText((data.get(i).getAuthor()));
//        textPages.setText("Ilość stron: " + data.get(i).getPages());

        viewHolder.textTitle.setText(data.get(i).getTitle());
        viewHolder.textAuthor.setText((data.get(i).getAuthor()));
        viewHolder.textPages.setText("Ilość stron: " + data.get(i).getPages());

        return view;
    }

    class ViewHolder {
        @BindView(R.id.textViewTitle)
        TextView textTitle;
        @BindView(R.id.textViewAuthor)
        TextView textAuthor;
        @BindView(R.id.textViewPages)
        TextView textPages;

        public ViewHolder (View v){
            ButterKnife.bind(this, v);
        }

        // skorzystamy z Tagow przypisywamych do widgetów

    }

}
