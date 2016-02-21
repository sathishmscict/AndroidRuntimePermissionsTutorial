package vn.tdx.androidruntimepermissionstutorial;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by BoChip on 2/21/2016.
 */
public class ContactsActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String[] PROJECTION = {ContactsContract.Contacts._ID,
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY};

    private static final int CONTACT_LOADER = 100;
    private ContactsAdapter mContactsAdapter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mListView = (ListView) findViewById(R.id.list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getLoaderManager().initLoader(CONTACT_LOADER, null, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getApplicationContext(), ContactsContract.Contacts.CONTENT_URI, PROJECTION,
                null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        mContactsAdapter = new ContactsAdapter(getApplicationContext(), cursor);
        mListView.setAdapter(mContactsAdapter);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
