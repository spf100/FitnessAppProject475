package com.example.fitnessappproject475;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

public class AddEntryActivity extends AppCompatActivity {
    //public static final String EXTRA_ID ="com.example.fitnessappproject475.EXTRA_ID";
    public static final String EXTRA_NAME ="com.example.fitnessappproject475.EXTRA_NAME";
    public static final String EXTRA_GRAMS ="com.example.fitnessappproject475.EXTRA_GRAMS";

    //private EditText editTextId;
    private EditText editTextName;
    private NumberPicker numberPickerGram;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);

        editTextName = findViewById(R.id.edit_text_id);
        editTextName = findViewById(R.id.edit_text_name);
        numberPickerGram = findViewById(R.id.number_picker_gram);
        numberPickerGram.setMinValue(10);
        numberPickerGram.setMaxValue(500);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);
        setTitle("Add Entry");
    }

    private void saveEntry() {
        String name = editTextName.getText().toString();
        //String id = editTextId.getText().toString();
        int grams = numberPickerGram.getValue();

        if(name.trim().isEmpty()) { // ||id.trim().isEmpty()
            Toast.makeText(this, "Insert a food", Toast.LENGTH_SHORT).show();
        }
        Intent data = new Intent();
        //data.putExtra(EXTRA_ID, id);
        data.putExtra(EXTRA_NAME, name);
        data.putExtra(EXTRA_GRAMS, grams);

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_entry_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_entry:
                saveEntry();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}