
package zn.gridanimal;

import android.widget.GridView;
import android.widget.ListView;

/**
 * The callback interface used by {@link SwipeDismissGridViewTouchListener} to
 * inform its client about a successful dismissal of one or more list item
 * positions.
 */
public interface GridViewOnDismissCallback {
	/**
	 * Called when the user has indicated they she would like to dismiss one or
	 * more list item positions.
	 * 
	 * @param listView
	 *            The originating {@link ListView}.
	 * @param reverseSortedPositions
	 *            An array of positions to dismiss, sorted in descending order
	 *            for convenience.
	 */
	void onDismiss(GridView listView, int[] reverseSortedPositions);
}