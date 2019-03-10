package com.example.rxjavademo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView = findViewById(R.id.tvResult);

      Disposable disposable= Observable.just(1, 2, 3, 4, 5)
                .filter(value -> value % 2 == 0)
                .map(value -> value * value)
                .map(value -> "number" + value)
                .map(value -> Integer.parseInt(value))
                .subscribe(newValue -> {
                    String oldValue = textView.getText().toString();
                    textView.setText(oldValue + newValue + "/n");
                }, throwable -> textView.setText(throwable.toString()));
      disposable.dispose(); // this is very important helps the connection beteween observable and observer to be terminated once the output has been achieved



        /*Observable.just(1, 2, 3, 4, 5)
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer integer) throws Exception {
                        return integer %2 == 0;
                    }
                })
                .map(new Function<Integer, Integer>() {
                    @Override
                    public Integer apply(Integer integer) throws Exception {
                        return integer * integer;
                    }
                })

                .map(new Function<Integer, String>() {
                    @Override
                    public String apply(Integer integer) throws Exception {
                        return "number: " + String.valueOf(integer);
                    }
                }).map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) throws Exception {
                return Integer.parseInt(s);
            }
        })




                .subscribe(new Consumer<Integer>() {
                    @Override
                    public void accept(Integer newValue) throws Exception {
                        String oldValue = textView.getText().toString();
                        textView.setText(oldValue + newValue + "/n");
                    }

                    }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        textView.setText(throwable.toString());

                    }



                });
    }
}*/
    }}