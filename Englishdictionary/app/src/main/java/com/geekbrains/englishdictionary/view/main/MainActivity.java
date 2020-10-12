package com.geekbrains.englishdictionary.view.main;

import androidx.databinding.DataBindingUtil;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.geekbrains.englishdictionary.R;
import com.geekbrains.englishdictionary.databinding.ActivityMainBinding;
import com.geekbrains.englishdictionary.presenter.MainPresenter;
import com.geekbrains.englishdictionary.view.list.ListActivity;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    private ActivityMainBinding mainBinding;

    @InjectPresenter
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil
                .setContentView(this, R.layout.activity_main);
    }

    public void search(View view){
        String word = mainBinding.newWord.getText().toString();
        if(word.length() > 1){
            mainPresenter.setCurrentWord(word);
            hideKeyboard(this);
            mainBinding.warning.setVisibility(View.GONE);
            mainBinding.textInputLayout.setVisibility(View.GONE);
            mainBinding.progressBar.setVisibility(View.VISIBLE);
        }
        else mainBinding.warning.setVisibility(View.VISIBLE);
    }

    @Override
    public void showResult(){
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}