package vn.tdx.androidruntimepermissionstutorial;

import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

/**
 * Created by BoChip on 2/21/2016.
 */
public class ContactsAdapter extends CursorAdapter {
    LayoutInflater layoutInflater;

    public ContactsAdapter(Context context, Cursor c) {
        super(context, c, false);
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup viewGroup) {
        return layoutInflater.inflate(android.R.layout.simple_list_item_1, viewGroup, false);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ((TextView) view).setText(getContactName(cursor));
    }

    private String getContactName(Cursor cursor) {
        return cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME_PRIMARY));
    }
}
