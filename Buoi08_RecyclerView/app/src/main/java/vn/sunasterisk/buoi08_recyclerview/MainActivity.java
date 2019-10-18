package vn.sunasterisk.buoi08_recyclerview;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements ContactsAdapter.OnItemClickListeners {

    private RecyclerView mRecyclerContacts;
    private ContactsAdapter mContactsAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        registerListeners();
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        mContactsAdapter = new ContactsAdapter(new ArrayList<Contact>());
        mContactsAdapter.setClickListeners(this);

        LinearLayoutManager layoutManager =
                new LinearLayoutManager(this,
                        LinearLayoutManager.VERTICAL,
                        false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);


        mRecyclerContacts.setLayoutManager(layoutManager);
        mRecyclerContacts.setAdapter(mContactsAdapter);
        mContactsAdapter.addContacts(getContacts());
        //mContactsAdapter.notifyDataSetChanged();
    }

    private List<Contact> getContacts() {
        List<Contact> contacts = new ArrayList<>();
        //fake data
        Contact c1 = new Contact(R.drawable.avatar1, "Nguyen Minh Tuan", "0912213960");
        Contact c2 = new Contact(R.drawable.avatar2, "Thai Tuan Hiep", "0912213961");
        Contact c3 = new Contact(R.drawable.avatar3, "Trinh Hoang Nam", "0912213962");
        Contact c4 = new Contact(R.drawable.avatar4, "Le Van Chien", "0912213963");
        Contact c5 = new Contact(R.drawable.avatar5, "Nguyen Van Dung", "0912213964");
        Contact c6 = new Contact(R.drawable.avatar6, "Nguyen Ngoc Ban", "0912213965");
        Contact c7 = new Contact(R.drawable.avatar7, "Nguyen Van Tien", "0912213966");
        Contact c8 = new Contact(R.drawable.avatar8, "Ta Tien Dung", "0912213967");
        Contact c9 = new Contact(R.drawable.avatar9, "Nguyen Duy Tien", "0912213969");
        Contact c10 = new Contact(R.drawable.avatar1, "Dang Duc Cong", "0912213969");
        Contact c11 = new Contact(R.drawable.avatar2, "Nguyen Mau Anh", "0912213969");

        contacts.add(c1);
        contacts.add(c2);
        contacts.add(c3);
        contacts.add(c4);
        contacts.add(c5);
        contacts.add(c6);
        contacts.add(c7);
        contacts.add(c8);
        contacts.add(c9);
        contacts.add(c10);
        contacts.add(c11);

        return contacts;
    }

    private void registerListeners() {

    }

    private void initViews() {
        mRecyclerContacts = findViewById(R.id.recycler_contacts);
    }

    @Override
    public void onItemRemove(final int position) {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do you want to remove this Contact?");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mContactsAdapter.removeContact(position);
                Toast.makeText(MainActivity.this, "Remove at " + position,
                        Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    @Override
    public void onItemClick(Contact contact, int position) {
        Toast.makeText(this,
                "Name is " + contact.getName() + ", Phone : " + contact.getPhone(),
                Toast.LENGTH_SHORT).show();
    }
}
