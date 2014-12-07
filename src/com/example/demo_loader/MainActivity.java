package com.example.demo_loader;

import java.util.ArrayList;
import java.util.List;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.LoaderManager;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.Loader;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {
    ListView listView;
    LoaderManager manager;
    List<Book> books;
    ArrayAdapter<Book> adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		listView=(ListView) findViewById(R.id.listView);
		manager=getLoaderManager();
		manager.initLoader(0, null, new LoaderCallbacks<Cursor>() {

			@Override
			public Loader<Cursor> onCreateLoader(int id, Bundle args) {
				Uri uri=Uri.parse("com.kaikeba.providers.book/book");
				return new CursorLoader(MainActivity.this,uri,null,null,null,null);
			}

			@Override
			public void onLoadFinished(Loader<Cursor> arg0, Cursor arg1) {
				books=new ArrayList<Book>();
				while(arg1.moveToNext()){
					String id=arg1.getString(arg1.getColumnIndex("id"));
					String name=arg1.getString(arg1.getColumnIndex("name"));
					float price=arg1.getFloat(arg1.getColumnIndex("price"));
					String publisher=arg1.getString(arg1.getColumnIndex("publisher"));
					Book book=new Book(id, name, price, publisher);
					books.add(book);
				}
				if(adapter==null){
					adapter=new ArrayAdapter<Book>
					(MainActivity.this, android.R.layout.simple_list_item_1, 
							android.R.id.text1, books);
				}else{
					adapter.clear();
					adapter.addAll(books);
				}
				adapter.notifyDataSetChanged();
				
			}

			@Override
			public void onLoaderReset(Loader<Cursor> arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
