package fragchallenge.com.fragchallenge;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {

    public static ArrayList<Person> data;

    @Override
    public void onCreate() {
        super.onCreate();
        data = new ArrayList<>();
        data.add(new Person("Aminullah", "03128136056", "Polo", "Nissan"));
        data.add(new Person("Asad", "03042403415", "E200", "Mercedes"));
        data.add(new Person("Asra", "03343423423", "Almera", "Volkswagen"));
        data.add(new Person("Hafsa", "03128342342", "E180",  "Mercedes"));
        data.add(new Person("Zee", "0312854333", "Polo",  "Mercedes"));
        data.add(new Person("Muzna Darling", "0304276765", "E200", "Volkswagen"));
        data.add(new Person("Asra", "03343423423", "Almera", "Mercedes"));
        data.add(new Person("Hafsa", "03128342342", "E180", "Mercedes"));
        data.add(new Person("Aminullah", "03128136056", "Polo", "Volkswagen"));
        data.add(new Person("Asad", "03042403415", "E200", "Volkswagen"));
        data.add(new Person("Asra", "03343423423", "Almera", "Volkswagen"));
        data.add(new Person("Hafsa", "03128342342", "E180", "Volkswagen"));

    }
}
