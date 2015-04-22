
package zn.gridanimal;

import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListView;


/**
 * Adds an option to swipe items in a ListView away. This does nothing more than
 * setting a new SwipeDismissListViewTouchListener to the ListView. You can
 * achieve the same effect by calling listView.setOnTouchListener(new
 * SwipeDismissListViewTouchListener(...)).
 */
public class SwipeDismissGridViewAdapter extends BaseAdapterGridViewDecorator {

	private GridViewOnDismissCallback mCallback;

	public SwipeDismissGridViewAdapter(BaseAdapter baseAdapter, GridViewOnDismissCallback callback) {
		super(baseAdapter);
		mCallback = callback;
	}

	@Override
	public void setGridView(GridView listView) {
		super.setGridView(listView);
		listView.setOnTouchListener(new SwipeDismissGridViewTouchListener(listView, mCallback));
	}
}
