package zn.gridanimal;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;

/**
 * A decorator class that enables decoration of an instance of the BaseAdapter
 * class.
 * 
 * Classes extending this class can override methods and provide extra
 * functionality before or after calling the super method.
 */
public abstract class BaseAdapterGridViewDecorator extends BaseAdapter {

	protected final BaseAdapter mDecoratedBaseAdapter;

	private GridView mGridView;

	public BaseAdapterGridViewDecorator(BaseAdapter baseAdapter) {
		mDecoratedBaseAdapter = baseAdapter;
	}

	public void setGridView(GridView listView) {
		mGridView = listView;

		if (mDecoratedBaseAdapter instanceof BaseAdapterGridViewDecorator) {
			((BaseAdapterGridViewDecorator) mDecoratedBaseAdapter).setGridView(listView);
		}
	}

	public GridView getGridView() {
		return mGridView;
	}

	@Override
	public int getCount() {
		return mDecoratedBaseAdapter.getCount();
	}

	@Override
	public Object getItem(int position) {
		return mDecoratedBaseAdapter.getItem(position);
	}

	@Override
	public long getItemId(int position) {
		return mDecoratedBaseAdapter.getItemId(position);
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		return mDecoratedBaseAdapter.getView(position, convertView, parent);
	}

	@Override
	public boolean areAllItemsEnabled() {
		return mDecoratedBaseAdapter.areAllItemsEnabled();
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return mDecoratedBaseAdapter.getDropDownView(position, convertView, parent);
	}

	@Override
	public int getItemViewType(int position) {
		return mDecoratedBaseAdapter.getItemViewType(position);
	}

	@Override
	public int getViewTypeCount() {
		return mDecoratedBaseAdapter.getViewTypeCount();
	}

	@Override
	public boolean hasStableIds() {
		return mDecoratedBaseAdapter.hasStableIds();
	}

	@Override
	public boolean isEmpty() {
		return mDecoratedBaseAdapter.isEmpty();
	}

	@Override
	public boolean isEnabled(int position) {
		return mDecoratedBaseAdapter.isEnabled(position);
	}

	@Override
	public void notifyDataSetChanged() {
		mDecoratedBaseAdapter.notifyDataSetChanged();
	}

	@Override
	public void notifyDataSetInvalidated() {
		mDecoratedBaseAdapter.notifyDataSetInvalidated();
	}

	@Override
	public void registerDataSetObserver(DataSetObserver observer) {
		mDecoratedBaseAdapter.registerDataSetObserver(observer);
	}

	@Override
	public void unregisterDataSetObserver(DataSetObserver observer) {
		mDecoratedBaseAdapter.unregisterDataSetObserver(observer);
	}

	public BaseAdapter getDecoratedBaseAdapter() {
		return mDecoratedBaseAdapter;
	}
}