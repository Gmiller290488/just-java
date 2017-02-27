/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 * <p>
 * package com.example.android.justjava;
 */
package com.example.dell.justjava;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        createOrderSummary(price);
    }

    private String createOrderSummary(int price) {
        CheckBox whippedCream = (CheckBox) findViewById(R.id.add_Cream);
        boolean hasWhippedCream = whippedCream.isChecked();
        if (hasWhippedCream) {
            price += (1 * quantity);
        }
        CheckBox chocolate = (CheckBox) findViewById(R.id.add_Chocolate);
        boolean hasChocolate = chocolate.isChecked();
        if (hasChocolate) {
            price += (1 * quantity);
        }
        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        String addCream = "Add whipped cream? " + hasWhippedCream;
        String summaryMessage = "Name: " + name + "\nAdd whipped cream? " + hasWhippedCream + "\nAdd chocolate? " + hasChocolate + "\nQuantity: " + quantity + "\nTotal: £" + price + "\nThank_you";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
        intent.putExtra(Intent.EXTRA_TEXT, summaryMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
        return summaryMessage;
    }


    private int calculatePrice() {
        int price = 5;
        int total = quantity * price;
        return total;
    }

    /**
     * This method is called when decrement button is clicked.
     */
    public void decrementQuantity(View view) {
        if (quantity == 1) {
            Toast.makeText(this, "You can not have less than 1 coffee!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quantity = quantity - 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method is for increasing the quantity of coffees
     */


    public void incrementQuantity(View view) {
        if (quantity == 99) {
            Toast.makeText(this, "You can not have more than 99 coffees!", Toast.LENGTH_SHORT).show();
            return;
        } else {
            quantity = quantity + 1;
            displayQuantity(quantity);
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuantity(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }


}