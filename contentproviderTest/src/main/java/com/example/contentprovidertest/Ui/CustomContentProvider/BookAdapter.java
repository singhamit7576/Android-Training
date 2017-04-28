package com.example.contentprovidertest.Ui.CustomContentProvider;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.contentprovidertest.R;
import java.util.List;
import android.view.LayoutInflater;


public class BookAdapter extends BaseAdapter{
    private List<BookInformation> bookInfoList;
    private Context context;
    private LayoutInflater layoutInflater;

    public BookAdapter(Context context, List<BookInformation> bookInfoList) {
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
        this.bookInfoList = bookInfoList;
    }

    @Override
    public int getCount() {
        return bookInfoList.size();
    }

    @Override
    public BookInformation getItem(int position) {
        return bookInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView     ==  null) {
            convertView  =   layoutInflater.inflate(R.layout.book_item, null);
            viewHolder  =    new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.tvBookTitle.setText(bookInfoList.get(position).getBookTitle());
        viewHolder.tvISBN.setText(bookInfoList.get(position).getIsbn());
        return convertView;
    }


    protected class ViewHolder {
        private TextView tvBookTitle;
        private TextView tvISBN;

        public ViewHolder(View view) {
            tvBookTitle = (TextView) view.findViewById(R.id.tv_Title);
            tvISBN = (TextView) view.findViewById(R.id.tvISBN);
        }
    }
}
