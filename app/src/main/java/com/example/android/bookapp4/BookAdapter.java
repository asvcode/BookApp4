package com.example.android.bookapp4;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;


public class BookAdapter extends ArrayAdapter<Book> {


    public BookAdapter(Context context, ArrayList<Book> aBooks) {
        super(context, 0, aBooks);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        final Book book = getItem(position);

        // Check if an existing view is being reused, otherwise inflate the view
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.book_row, parent, false);

            viewHolder.listNumber = (TextView) convertView.findViewById(R.id.circle);
            viewHolder.bookName = (TextView) convertView.findViewById(R.id.book_name);
            viewHolder.authorName = (TextView) convertView.findViewById(R.id.author_name);
            convertView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();

        }

        viewHolder.listNumber.setText("" + position);
        viewHolder.bookName.setText(book.getName());
        viewHolder.authorName.setText(book.getAuthor());
        viewHolder.listNumber.setBackgroundTintList(ColorStateList.valueOf(getBookColor(position)));
        return convertView;
    }

    /**
     * Return a different color for the book number.
     *
     * @param bookColor of the number of the book
     */
    private int getBookColor(int bookColor) {
        int bookColorResourceId;
        int bookFloor = (int) Math.floor(bookColor);
        switch (bookFloor) {
            case 0:
            case 1:
                bookColorResourceId = R.color.book1;
                break;
            case 2:
                bookColorResourceId = R.color.book2;
                break;
            case 3:
                bookColorResourceId = R.color.book3;
                break;
            case 4:
                bookColorResourceId = R.color.book4;
                break;
            case 5:
                bookColorResourceId = R.color.book5;
                break;
            case 6:
                bookColorResourceId = R.color.book6;
                break;
            case 7:
                bookColorResourceId = R.color.book7;
                break;
            case 8:
                bookColorResourceId = R.color.book8;
                break;
            case 9:
                bookColorResourceId = R.color.book9;
                break;
            default:
                bookColorResourceId = R.color.book10;
                break;
        }

        return ContextCompat.getColor(getContext(), bookColorResourceId);
    }

    private static class ViewHolder {
        public TextView bookName;
        public TextView authorName;
        public TextView listNumber;
    }
}
